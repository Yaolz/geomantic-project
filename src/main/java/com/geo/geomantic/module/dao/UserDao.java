package com.geo.geomantic.module.dao;

import com.geo.geomantic.common.basic.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.geo.geomantic.module.pojo.User;


/**
 * 用户管理DAO接口
 * @author zyz
 * @version 2018-12-16
 */
@Mapper
@Repository
public interface UserDao extends BaseDao<User> {

    int updStateById(@Param("id") String id, @Param("state") String state);

}