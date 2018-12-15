package com.geo.geomantic.module.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zyz
 * @date 2018/9/14
 */
@Controller
public class IndexController {


    @RequestMapping("")
    public String index() {
        return "index";
    }

}
