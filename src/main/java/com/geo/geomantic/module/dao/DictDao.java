package com.geo.geomantic.module.dao;

import com.geo.geomantic.common.basic.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.geo.geomantic.module.pojo.Dict;


/**
 * 字典管理DAO接口
 * @author zyz
 * @version 2019-01-07
 */
@Mapper
@Repository
public interface DictDao extends BaseDao<Dict> {
	
}