package com.geo.geomantic.module.dao;

import com.geo.geomantic.common.basic.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.geo.geomantic.module.pojo.Task;


/**
 * 测算管理DAO接口
 * @author zyz
 * @version 2018-12-16
 */
@Mapper
@Repository
public interface TaskDao extends BaseDao<Task> {
	
}