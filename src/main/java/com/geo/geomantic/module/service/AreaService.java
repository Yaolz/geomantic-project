package com.geo.geomantic.module.service;

import java.util.List;

import com.geo.geomantic.module.pojo.Area;
import com.github.pagehelper.PageInfo;

/**
 * 区域管理Service
 * @author zyz
 * @version 2018-12-18
 */
public interface AreaService {

	Area get(String id);

    Area get(Area area);

    List<Area> findList(Area area);

    PageInfo<Area> findPage(Area area);

    void save(Area area);

    void delete(Area area);
		
}