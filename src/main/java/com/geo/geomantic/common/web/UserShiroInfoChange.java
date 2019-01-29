package com.geo.geomantic.common.web;

import com.geo.geomantic.module.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * @author zyz
 * @date 2019/1/29
 */
public class UserShiroInfoChange {

    public static void updateUser(User user) {
        Subject subject = SecurityUtils.getSubject();
        User userInfo = (User) subject.getPrincipal();
        if (userInfo == null) {
            return;
        }
//          给shiro的信息重新赋值
        userInfo.setPhone(user.getPhone());
        userInfo.setNickName(user.getNickName());
        userInfo.setHeadphoto(user.getHeadphoto());
        userInfo.setSex(user.getSex());
        userInfo.setAutograph(user.getAutograph());
        userInfo.setState(user.getState());
        userInfo.setAddressCode(user.getAddressCode());
        userInfo.setAddress(user.getAddress());
//        更新shiro的用户信息
        PrincipalCollection principalCollection = subject.getPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        PrincipalCollection newPrincipalCollection =
                new SimplePrincipalCollection(userInfo, realmName);
        subject.runAs(newPrincipalCollection);
    }

}
