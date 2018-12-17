package com.geo.geomantic.module.controller;

import com.geo.geomantic.common.constant.MsgModel;
import com.geo.geomantic.common.constant.ResultStatus;
import com.geo.geomantic.module.pojo.User;
import com.geo.geomantic.module.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zyz
 * @date 2018/12/16
 */
@RestController
@RequestMapping("data")
@Api(value = "UserController", description = "用户接口")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("user")
    @ApiOperation("获取用户详情")
    public MsgModel getUserBy(@RequestParam("id") String id) {
        User user = userService.get(id);
        return MsgModel.ok(user);
    }

    @GetMapping("userPage")
    @ApiOperation("获取用户详情")
    public MsgModel userPage(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        User user = new User();
        user.setPageNo(pageNum);
        user.setPageSize(pageSize);
        user.setOrderBy("a.create_date DESC");
        return MsgModel.ok(userService.findPage(user));
    }

    @GetMapping("one")
    @ApiOperation("方法说明1")
    public MsgModel one(@RequestParam(value = "one", required = false) String one){
            if (StringUtils.isBlank(one)) {
                System.out.println("StringUtils使用");
            } else if ("1".equals(one)) {
                return MsgModel.error(ResultStatus.ONE);
            }else if ("2".equals(one)) {
                return MsgModel.error(ResultStatus.TWO);
            }else {
                return MsgModel.error("自定义信息");
            }
            return MsgModel.ok();
    }

    @PostMapping("queryUser")
    @ApiOperation("根据信息查询用户是否存在")
    public MsgModel queryUser(@RequestParam("phone") String phone) {
        User user = new User();
        user.setPhone(phone);
        user = userService.get(user);
        if (user == null) {
            return MsgModel.error(ResultStatus.USER_EXIS);
        }
        return MsgModel.ok();
    }




}
