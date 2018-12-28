package com.geo.geomantic.module.page;

import com.geo.geomantic.common.constant.Constants;
import com.geo.geomantic.common.constant.TreeModel;
import com.geo.geomantic.module.pojo.Menu;
import com.geo.geomantic.module.service.MenuService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @date 2018/9/14
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("")
    public String page() {
        return "minpage/compass";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("home")
    public String home(Model model) {
        Menu menu = new Menu();
        menu.setIsShow(Constants.YES);
//        先把所有未隐藏的菜单查出
        List<Menu> menus = menuService.findList(menu);
//        组装成树结构的集合
        List<TreeModel<Menu>> menuTree = Lists.newArrayList();
        if (menus != null) {
            for (Menu menuData : menus) {
//                第一层必须父id为0
                if (Menu.PARENT_ID.equals(menuData.getParentId())) {
                    TreeModel<Menu> node = new TreeModel<>();
                    node.setNode(menuData);
//                    插入下一层菜单：当前菜单数据，全部菜单数据
                    node.setChildren(childMenu(node, menus));
                    menuTree.add(node);
                }
            }
        }
        model.addAttribute("menuTree", menuTree);
        return "home/home";
    }

    private List<TreeModel<Menu>> childMenu(TreeModel<Menu> parent, List<Menu> menuList) {
//        做法基本与上一致
        List<TreeModel<Menu>> children = Lists.newArrayList();
        if (!menuList.isEmpty()) {
            for (Menu menu : menuList) {
//                寻找出父级菜单ID与parent菜单ID相同的菜单
                if (menu.getParentId().equals(parent.getNode().getId())) {
//                    这里暂时只做两层菜单，如果以后做四级五级等等，则在此递归......
                    TreeModel<Menu> node = new TreeModel<>();
                    node.setNode(menu);
//                    这里暂时不做递归，因为菜单只有两层
//                    node.setChildren(childMenu(node, menuList));
                    // 加入子节点
                    children.add(node);
                }
            }
        }
        return children;
    }

}
