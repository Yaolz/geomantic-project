package com.geo.geomantic.module.service;

import java.util.List;

import com.geo.geomantic.module.pojo.Flow;
import com.github.pagehelper.PageInfo;

/**
 * 流水管理Service
 * @author zyz
 * @version 2018-12-18
 */
public interface FlowService {

	Flow get(String id);

    Flow get(Flow flow);

    List<Flow> findList(Flow flow);

    PageInfo<Flow> findPage(Flow flow);

    void save(Flow flow);

    void delete(Flow flow);
		
}