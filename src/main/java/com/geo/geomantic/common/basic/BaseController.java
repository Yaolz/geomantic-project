package com.geo.geomantic.common.basic;

import com.geo.geomantic.module.pojo.User;
import com.geo.geomantic.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * @author zyz
 * @date 2018/12/22
 */
public abstract class BaseController {

    @Autowired
    protected UserService userService;

    private  HttpSession session;

    /**
     * 获取用户信息，未写完
     * @return
     */
    public User getUserInfo() {
        User user = userService.get(User.IS_ADMIN);
        return user;
    }

}
