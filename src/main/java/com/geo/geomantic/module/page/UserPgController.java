package com.geo.geomantic.module.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yao on 2018/12/21.
 */
@Controller
@RequestMapping("/page")
public class UserPgController {

        @RequestMapping("user")
        public String user(){
        return "user/user";
    }

}
