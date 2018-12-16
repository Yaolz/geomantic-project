package com.geo.geomantic.module.controller;

import com.geo.geomantic.common.constant.MsgModel;
import com.geo.geomantic.module.pojo.User;
import com.geo.geomantic.module.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyz
 * @date 2018/12/16
 */
@RestController
@RequestMapping("data")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user")
    @ApiOperation("获取用户详情")
    public MsgModel getUserBy(@RequestParam("id") String id) {
        User user = userService.get(id);
        return MsgModel.ok(user);
    }

}
