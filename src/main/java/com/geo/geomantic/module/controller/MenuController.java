package com.geo.geomantic.module.controller;

import com.geo.geomantic.common.constant.MsgModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yao on 2018/12/18.
 */
@RestController
@RequestMapping("data")
@Api(value = "MenuController", description = "系统菜单添加、查询、更新、冻结")
public class MenuController {

    @GetMapping("/menu/add")
    @ApiOperation("菜单添加")
    public MsgModel  add(){
        return MsgModel.ok();
    }
}
