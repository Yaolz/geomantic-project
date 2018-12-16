package com.geo.geomantic.module.service;

import java.util.List;

import com.geo.geomantic.module.pojo.UserSite;
import com.github.pagehelper.PageInfo;

/**
 * 收货地址Service
 * @author zyz
 * @version 2018-12-16
 */
public interface UserSiteService {

	UserSite get(String id);

    UserSite get(UserSite userSite);

    List<UserSite> findList(UserSite userSite);

    PageInfo<UserSite> findPage(UserSite userSite);

    void save(UserSite userSite);

    void delete(UserSite userSite);
		
}