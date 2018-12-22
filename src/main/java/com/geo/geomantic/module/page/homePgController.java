package com.geo.geomantic.module.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yao on 2018/12/22.
 */
@Controller
@RequestMapping("/page")
public class homePgController {

    @RequestMapping("/home/main")
    public String main(){
        return "home/main";
    }
}
