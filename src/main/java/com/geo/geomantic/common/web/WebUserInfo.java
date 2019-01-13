package com.geo.geomantic.common.web;

import com.geo.geomantic.module.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.subject.Subject;

/**
 * @author zyz
 * @date 2019/1/13
 */
public class WebUserInfo {

    /**
     * 获取当前登录的用户信息，未登录则返回null
     * @return
     */
    public User getUserInfo() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        return user;
    }

}
