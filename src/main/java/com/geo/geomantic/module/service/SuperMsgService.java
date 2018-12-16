package com.geo.geomantic.module.service;

import java.util.List;

import com.geo.geomantic.module.pojo.SuperMsg;
import com.github.pagehelper.PageInfo;

/**
 * 个人信息Service
 * @author zyz
 * @version 2018-12-16
 */
public interface SuperMsgService {

	SuperMsg get(String id);

    SuperMsg get(SuperMsg superMsg);

    List<SuperMsg> findList(SuperMsg superMsg);

    PageInfo<SuperMsg> findPage(SuperMsg superMsg);

    void save(SuperMsg superMsg);

    void delete(SuperMsg superMsg);
		
}