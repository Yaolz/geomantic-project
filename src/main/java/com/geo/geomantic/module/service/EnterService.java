package com.geo.geomantic.module.service;

import com.geo.geomantic.module.pojo.Enter;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by yao on 2019/1/18.
 */
public interface EnterService {

    Enter get(String id);

    Enter get(Enter dict);

    List<Enter> findList(Enter dict);

    PageInfo<Enter> findPage(Enter dict);

    void save(Enter dict);

    void delete(Enter dict);
}
