package com.geo.geomantic.module.controller;

import com.geo.geomantic.common.config.Global;
import com.geo.geomantic.common.utils.DateUtils;
import com.geo.geomantic.common.utils.FileUtils;
import com.geo.geomantic.common.utils.SecretUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zyz
 * @date 2018/12/18
 */
@RestController
@RequestMapping("util")
public class UploadController {

    @ResponseBody
    @PostMapping("fileUpload")
    public String analyzeXml(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        StringBuilder retur = new StringBuilder("");
        // boolean result = true;// 导入标志
        if (!file.isEmpty()) {
            // 判断是否为空

                // 上传
                try {
//                   拼接文件内容，不推荐使用文件原来名称
                    String fileName = SecretUtils.entryptPassword(file.getOriginalFilename()) + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

                    String leftPath = Global.getUserfilesBaseDir(request);
                    String rightPath = Global.USERFILES_BASE_URL + DateUtils.getDate("yyyyMMdd") + File.separator;
                    // 上传文件路径
                    String path = leftPath + rightPath;
                    // 存数据库的路径
                    String dbPath = rightPath + fileName;
                    String realDbPath = FileUtils.path(dbPath);
                    if (realDbPath.lastIndexOf("/") != -1) {
                        realDbPath = realDbPath.substring(0, realDbPath.lastIndexOf("/"));
                    }

                    // 没有目录创建目录
                    String realPath = FileUtils.path(path);
                    FileUtils.createDirectory(realPath);

                    File tmp = new File(realPath + fileName);

                    FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(tmp));
                    // file.transferTo(tmp);

                    retur.append(realDbPath);
                } catch (IOException e) {
                    e.printStackTrace();
                    retur.append("文件上传出错！");
                } finally {

                }

        } else {
            retur.append("空");
        }
        /*
         * if (result) { retur.append("成功！"); } else { retur.append("失败！"); }
         */
        return retur.toString();
    }

}
