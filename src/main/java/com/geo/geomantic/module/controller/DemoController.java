package com.geo.geomantic.module.controller;

import com.geo.geomantic.module.pojo.Demo;
import com.geo.geomantic.module.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyz
 * @date 2018/12/15
 */
@RestController
@RequestMapping("data")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("test")
    public Demo testA() {
        Demo demo = new Demo();
        demo.setName(demoService.testBy());
        return demo;
    }

}
