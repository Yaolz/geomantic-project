package com.geo.geomantic.module.controller;

import com.geo.geomantic.common.constant.MsgModel;
import com.geo.geomantic.common.constant.ResultStatus;
import com.geo.geomantic.common.utils.SecretUtils;
import com.geo.geomantic.module.pojo.User;
import com.geo.geomantic.module.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
    public MsgModel userPage(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) {
        User user = new User();
        user.setPageNo(pageNo);
        user.setPageSize(pageSize);
        user.setOrderBy("a.create_date DESC");
        PageInfo<User> date = userService.findPage(user);
        return new MsgModel("0000","查询成功！",date.getList(),date.getTotal());
    }

    @PostMapping("update")
    @ApiOperation("根据用户id更新用户信息")
    public MsgModel update(@RequestBody User user){
        if(user.getSex()=="1"){
            user.setHeadphoto("/images/heading/girl.png");
        }
        userService.save(user);
        return MsgModel.ok();
    }

    @PostMapping("queryUser")
    @ApiOperation("根据信息查询用户是否存在")
    public MsgModel queryUser(@RequestParam("phone") String phone) {
        User user = new User();
        user.setPhone(phone);
        user = userService.get(user);
        if (user != null) {
            return MsgModel.error(ResultStatus.USER_EXIS);
        }
        return MsgModel.ok();
    }

    @PostMapping("updState")
    @ApiOperation("根据id冻结、激活用户")
    public MsgModel updStateById(@RequestParam("id")String id,@RequestParam("state")String state){
        User user = new User();
        user.setId(id);
        user.setState(state);
        userService.save(user);
        return MsgModel.ok();
    }

}
