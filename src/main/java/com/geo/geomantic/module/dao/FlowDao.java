package com.geo.geomantic.module.dao;

import com.geo.geomantic.common.basic.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.geo.geomantic.module.pojo.Flow;


/**
 * 流水管理DAO接口
 * @author zyz
 * @version 2018-12-18
 */
@Mapper
@Repository
public interface FlowDao extends BaseDao<Flow> {
	
}