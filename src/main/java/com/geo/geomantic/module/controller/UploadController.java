package com.geo.geomantic.module.controller;

import com.geo.geomantic.common.config.Global;
import com.geo.geomantic.common.constant.MsgModel;
import com.geo.geomantic.common.constant.ResultStatus;
import com.geo.geomantic.common.utils.DateUtils;
import com.geo.geomantic.common.utils.FileUtils;
import com.geo.geomantic.common.utils.SecretUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "文件上传", description = "文件上传")
public class UploadController {

    @PostMapping("fileUpload")
    @ApiOperation("上传文件接口")
    public MsgModel analyzeXml(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        StringBuilder retur = new StringBuilder("");
        if (!file.isEmpty()) {
                // 上传
                try {
//                   拼接文件内容，不推荐使用文件原来名称，重置文件名
                    String fileName = SecretUtils.entryptPassword(file.getOriginalFilename()) + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//                    文件放置的基本目录
                    String basedirPath = Global.getUserfilesBaseDir(request);
//                    文件存放的详细路径，也是访问路径
                    String visitPath = Global.USERFILES_BASE_URL + DateUtils.getDate("yyyyMMdd") + File.separator;
                    // 上传文件路径
                    String path = basedirPath + visitPath;
                    // 存数据库的路径
                    String dbPath = visitPath + fileName;
//                    将目录格式化
                    String realDbPath = FileUtils.path(dbPath);
                    if (realDbPath.lastIndexOf("/") != -1) {
                        realDbPath = realDbPath.substring(0, realDbPath.lastIndexOf("/"));
                    }
                    // 没有目录创建目录
                    String realPath = FileUtils.path(path);
                    FileUtils.createDirectory(realPath);
                    File tmp = new File(realPath + fileName);
                    FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(tmp));
                    retur.append(realDbPath);
                } catch (IOException e) {
                    e.printStackTrace();
                    retur.append("文件上传出错！");
                    return new MsgModel(ResultStatus.FILE_FAIL, retur.toString());
                } finally {
                }
        } else {
            retur.append("空");
        }
        return new MsgModel(ResultStatus.FILE_SUCCESS, retur.toString());
    }

}
