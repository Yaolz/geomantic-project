package com.geo.geomantic.module.controller;

import com.geo.geomantic.common.constant.BaseModel;
import com.geo.geomantic.common.constant.MsgModel;
import com.geo.geomantic.common.constant.ResultStatus;
import com.geo.geomantic.common.utils.SecretUtils;
import com.geo.geomantic.module.pojo.User;
import com.geo.geomantic.module.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by yao on 2018/12/17.
 */
@RestController
@RequestMapping("/ajax")
@Api(value = "LoginController", description = "用户注册登录")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    @ApiOperation("用户登录")
    public MsgModel login (@RequestParam("phone") String phone, @RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(phone, password.toCharArray(), false, null);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return MsgModel.error("该用户不存在");
        } catch (IncorrectCredentialsException e) {
            return MsgModel.error("用户名/密码错误");
        } catch (AuthenticationException e) {
            return MsgModel.error("该用户已被冻结");
        }
        return MsgModel.ok();
    }


    @PostMapping("register")
    @ApiOperation("用户注册")
    public MsgModel register(@RequestParam("nick_name") String nick_name,@RequestParam("phone") String phone, @RequestParam("password") String password,@RequestParam("codeMsg") String codeMsg) {
        User user1 = new User();
        user1.setPhone(phone);
        user1 = userService.get(user1);
        if (user1 != null) {
            return MsgModel.error(ResultStatus.USER_EXIS);
        }
        User user = new User();
        user.setPhone(phone);
//        密码加密
        user.setPassword(SecretUtils.entryptPassword(password));
        userService.save(user);
        return MsgModel.ok();
    }

}
