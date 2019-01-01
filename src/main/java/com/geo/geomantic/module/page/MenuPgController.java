package com.geo.geomantic.module.page;

import com.geo.geomantic.module.pojo.Menu;
import com.geo.geomantic.module.pojo.User;
import com.geo.geomantic.module.service.MenuService;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/page/menu")
public class MenuPgController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = {"", "list"})
    public String list() {
        return "home/menu/menuList";
    }

    @RequestMapping("menu")
    public String menu() {
        return "home/menu/menu";
    }

    @RequestMapping("save")
    public String save(Menu menu, HttpSession session, Model model) {
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            menu.setCreateBy(user.getId());
            menu.setUpdateBy(user.getId());
        }
        menuService.save(menu);
        model.addAttribute("msg", "添加成功！");
        return "home/menu/addMenu";
    }

    @RequestMapping("form")
    public String form(Menu menu, Model model) {
        String option = menu.getOption();
        if (StringUtils.isNotBlank(menu.getId())){
            menu = menuService.get(menu.getId());
        }
        menu.setOption(option);
        model.addAttribute("menu", menu);
        return "home/menu/menuForm";
    }
}
