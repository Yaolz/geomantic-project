package com.geo.geomantic.module.service.Impl;

import com.geo.geomantic.module.dao.UserDao;
import com.geo.geomantic.module.pojo.User;
import com.geo.geomantic.common.basic.BaseService;
import com.geo.geomantic.module.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户管理ServiceImpl
 * @author zyz
 * @version 2018-12-16
 */
@Service
public class UserServiceImpl extends BaseService<UserDao, User> implements UserService{


    @Override
    public String getId() {
        return "1";
    }
}