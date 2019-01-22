package com.geo.geomantic.module.controller;

import com.geo.geomantic.common.constant.BaseModel;
import com.geo.geomantic.common.constant.MsgModel;
import com.geo.geomantic.common.constant.RedisEnum;
import com.geo.geomantic.common.utils.RedisUtil;
import com.geo.geomantic.module.pojo.Menu;
import com.geo.geomantic.module.pojo.User;
import com.geo.geomantic.module.service.MenuService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by yao on 2018/12/18.
 */
@RestController
@RequestMapping("data/menu")
@Api(value = "MenuController", description = "系统菜单添加、查询、更新、冻结")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("list")
    @ApiOperation("菜单列表")
    public BaseModel list() {
        Menu menu = new Menu();
        menu.setOrderBy("a.parent_Id, a.sort");
        return new BaseModel("0","ok", menuService.findList(menu));
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation("菜单添加")
    public MsgModel add(@RequestBody Menu menu, HttpSession session) {
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            menu.setCreateBy(user.getId());
            menu.setUpdateBy(user.getId());
        }
        menuService.save(menu);
        return MsgModel.ok();
    }

    @PostMapping("update")
    @ApiOperation("菜单修改信息")
    public MsgModel update(@RequestBody Menu menu) {
        menuService.save(menu);
        return MsgModel.ok();
    }


    @GetMapping("get" )
    @ApiOperation("获取菜单数据")
    @ResponseBody
    public MsgModel getDate(Menu menu,HttpSession session){
//        if (session.getAttribute("user") != null) {
//            User user = (User) session.getAttribute("user");
//        }
        PageInfo<Menu> menuDate=menuService.findPage(menu);
        return new MsgModel("0000", "查询成功！", menuDate.getList(), menuDate.getTotal());
    }
    
    @PostMapping("sortUp")
    @ApiOperation("菜单排序操作")
    public MsgModel sortUp(Menu menu){
        if (menu!=null){
            menuService.save(menu);
        }
        redisUtil.del(RedisEnum.REDIS_MENU.getKey());
        return MsgModel.ok();
    }
}
