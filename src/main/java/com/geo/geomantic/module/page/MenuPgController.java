package com.geo.geomantic.module.page;

import com.geo.geomantic.common.basic.BaseController;
import com.geo.geomantic.common.constant.ConstantEnum;
import com.geo.geomantic.common.constant.RedisUtil;
import com.geo.geomantic.module.pojo.Menu;
import com.geo.geomantic.module.pojo.User;
import com.geo.geomantic.module.service.MenuService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yao on 2018/12/18.
 */
@Controller
@RequestMapping("/page/menu")
public class MenuPgController extends BaseController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = {"", "list"})
    public String list() {
        return "home/menu/menuList";
    }

    @RequestMapping("menu")
    public String menu() {
        return "home/menu/menu";
    }

    @RequestMapping("save")
    public String save(Menu menu, Model model, RedirectAttributes redirectAttributes) {
//      更改菜单，把redis菜单结构清空清空
        redisUtil.del(ConstantEnum.REDIS_MENU.getKey());
        menu.setCreateBy(getUserInfo().getId());
        menu.setUpdateBy(getUserInfo().getId());
        menuService.save(menu);
        redirectAttributes.addFlashAttribute("msg", "保存菜单成功！");
        return "redirect:/page/menu";
    }

    @RequestMapping("form")
    public String form(Menu menu, Model model) {
//        查询菜单信息
        if (StringUtils.isNotBlank(menu.getId())){
            menu = menuService.get(menu.getId());
        }
//        父级菜单列表，父级菜单以选的形式展示
        List<Menu> menuList = Lists.newArrayList();
//        父级菜单查询
        Menu menuQuery = new Menu();
        if (StringUtils.isBlank(menu.getParentId()) || Menu.PARENT_ID.equals(menu.getParentId())) {
            menuQuery.setId(Menu.PARENT_ID);
            menuQuery.setName("一级菜单");
            menuList.add(menuQuery);
        } else {
//            这里条件给的不严谨，后期修改
            menuQuery.setParentId(Menu.PARENT_ID);
            menuList = menuService.findList(menuQuery);
        }
        model.addAttribute("menu", menu);
        model.addAttribute("menuList", menuList);
        return "home/menu/menuForm";
    }
}
