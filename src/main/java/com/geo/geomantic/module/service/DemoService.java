package com.geo.geomantic.module.service;

import com.geo.geomantic.module.pojo.Demo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zyz
 * @date 2018/12/15
 */
@Service
public interface DemoService {

    Demo get(String id);

    Demo get(Demo entity);

    List<Demo> findList(Demo entity);

    PageInfo<Demo> findPage(Demo entity);

    void save(Demo entity);

    void delete(Demo entity);

    String testBy();

}
