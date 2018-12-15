package com.geo.geomantic.module.service.Impl;

import com.geo.geomantic.module.dao.DemoDao;
import com.geo.geomantic.module.pojo.Demo;
import com.geo.geomantic.module.service.BaseService;
import com.geo.geomantic.module.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @author zyz
 * @date 2018/12/15
 */
@Service
public class DemoServiceImpl extends BaseService<DemoDao, Demo> implements DemoService {


    @Override
    public String testBy() {
        return "成功了";
    }
}
