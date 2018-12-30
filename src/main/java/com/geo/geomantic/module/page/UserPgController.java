package com.geo.geomantic.module.page;

import com.geo.geomantic.common.basic.BaseController;
import com.geo.geomantic.common.utils.SecretUtils;
import com.geo.geomantic.module.pojo.User;
import com.geo.geomantic.module.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by yao on 2018/12/21.
 */
@Controller
@RequestMapping("/page/user")
public class UserPgController extends BaseController{

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
    public String save(User user, Model model, RedirectAttributes redirectAttributes) {
        if (StringUtils.isNotBlank(user.getPassword())) {
//        密码加密
            user.setPassword(SecretUtils.entryptPassword(user.getPassword()));
        }
        if (StringUtils.isBlank(user.getId())) {
            User userQuery = new User();
            userQuery.setPhone(user.getPhone());
            Object object = userService.get(userQuery);
            if (object != null) {
                model.addAttribute("msg", "手机号已经存在");
                return form(user, model);
            }
        }
        user.setCreateBy(getUserInfo().getId());
        user.setUpdateBy(getUserInfo().getId());
        redirectAttributes.addFlashAttribute("msg", "保存成功！");
        userService.save(user);
        return "redirect:/page/user";
    }

}
