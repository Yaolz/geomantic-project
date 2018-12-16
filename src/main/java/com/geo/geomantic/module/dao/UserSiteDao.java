package com.geo.geomantic.module.dao;

import com.geo.geomantic.common.basic.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.geo.geomantic.module.pojo.UserSite;


/**
 * 收货地址DAO接口
 * @author zyz
 * @version 2018-12-16
 */
@Mapper
@Repository
public interface UserSiteDao extends BaseDao<UserSite> {
	
}