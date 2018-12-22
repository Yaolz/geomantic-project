package com.geo.geomantic.module.page;

import com.geo.geomantic.module.pojo.User;
import com.geo.geomantic.module.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yao on 2018/12/21.
 */
@Controller
@RequestMapping("/page/user")
public class UserPgController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"", "list"})
    public String userList(User user, Model model) {
        PageInfo<User> page = userService.findPage(user);
        model.addAttribute("page", page);
        model.addAttribute("user", user);
        return "home/user/userList";
    }

    @RequestMapping("form")
    public String form(User user, Model model) {
        if (StringUtils.isNotBlank(user.getId())) {
            user = userService.get(user.getId());
        }
        model.addAttribute("user", user);
        return "home/user/userForm";
    }

    @RequestMapping("save")
    public String save(User user) {
        user.setCreateBy("1");
        user.setUpdateBy("1");
        userService.save(user);
        return "redirect:/page/user";
    }

}
