package com.geo.geomantic.module.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yao on 2018/12/18.
 */
@Controller
@RequestMapping("/page")
public class MenuPgController {

    @RequestMapping("/menu")
    public String menu(){
        return "menu";
    }
}
