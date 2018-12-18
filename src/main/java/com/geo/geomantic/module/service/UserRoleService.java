package com.geo.geomantic.module.service;

import java.util.List;

import com.geo.geomantic.module.pojo.UserRole;
import com.github.pagehelper.PageInfo;

/**
 * 用户角色Service
 * @author zyz
 * @version 2018-12-18
 */
public interface UserRoleService {

	UserRole get(String id);

    UserRole get(UserRole userRole);

    List<UserRole> findList(UserRole userRole);

    PageInfo<UserRole> findPage(UserRole userRole);

    void save(UserRole userRole);

    void delete(UserRole userRole);
		
}