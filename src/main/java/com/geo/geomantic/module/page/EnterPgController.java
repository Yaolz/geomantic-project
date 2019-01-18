package com.geo.geomantic.module.page;

import com.geo.geomantic.common.basic.BaseController;
import com.geo.geomantic.common.constant.MsgModel;
import com.geo.geomantic.module.pojo.Enter;
import com.geo.geomantic.module.service.EnterService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yao on 2019/1/18.
 */
@Controller
@RequestMapping("/page/enter")
public class EnterPgController extends BaseController{

    @Autowired
    private EnterService enterService;

    @RequestMapping(value = {"", "list"})
    public String list(Enter enter,Model model){
        PageInfo<Enter> page = enterService.findPage(enter);
        model.addAttribute("page", page);
        model.addAttribute("enter", enter);
        return "home/enter/enterList";
    }

}
