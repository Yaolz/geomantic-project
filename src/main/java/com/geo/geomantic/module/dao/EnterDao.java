package com.geo.geomantic.module.dao;

import com.geo.geomantic.common.basic.BaseDao;
import com.geo.geomantic.module.pojo.Enter;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by yao on 2019/1/18.
 */
@Mapper
@Repository
public interface EnterDao extends BaseDao<Enter> {
}
