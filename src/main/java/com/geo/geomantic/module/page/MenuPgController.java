package com.geo.geomantic.module.page;

import com.geo.geomantic.module.pojo.Menu;
import com.geo.geomantic.module.pojo.User;
import com.geo.geomantic.module.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by yao on 2018/12/18.
 */
@Controller
@RequestMapping("/page")
public class MenuPgController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("menu")
    public String menu(){
        return "home/menu/menu";
    }

    @RequestMapping("menu/save")
    public String save(Menu menu, HttpSession session, Model model){
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            menu.setCreateBy(user.getId());
            menu.setUpdateBy(user.getId());
        }
        menuService.save(menu);
        model.addAttribute("msg", "添加成功！");
        return "home/menu/menu";
    }

    @RequestMapping("menu/updatePg")
    public String updatePg(@RequestParam("id") String id,Model model){
        model.addAttribute("menu",menuService.get(id));
        return "home/menu/update";
    }
    @RequestMapping("menu/update")
    public String update(Menu  menu ,Model model){
        menuService.save(menu);
        model.addAttribute("msg","修改成功！");
        return "home/menu/update";
    }
}
