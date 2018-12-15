package com.geo.geomantic.module.dao;

import com.geo.geomantic.module.pojo.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zyz
 * @date 2018/9/14
 */
@Mapper
@Repository
public interface DemoDao extends BaseDao<Demo> {
}
