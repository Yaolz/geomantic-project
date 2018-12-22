package com.geo.geomantic.module.page;

import com.geo.geomantic.common.basic.BaseController;
import com.geo.geomantic.module.pojo.SuperMsg;
import com.geo.geomantic.module.service.SuperMsgService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 个人信息Controller
 * @author zyz
 * @version 2018-12-22
 */
@Controller
@RequestMapping("/page/superMsg")
public class SuperMsgPgController  extends BaseController {

	@Autowired
	private SuperMsgService superMsgService;

	 @RequestMapping(value = {"", "list"})
    public String userList(SuperMsg superMsg, Model model) {
        PageInfo<SuperMsg> page = superMsgService.findPage(superMsg);
        model.addAttribute("page", page);
        model.addAttribute("superMsg", superMsg);
        return "home/superMsg/superMsgList";
    }

	@RequestMapping("form")
	public String form(SuperMsg superMsg, Model model) {
		if (StringUtils.isNotBlank(superMsg.getId())){
			superMsg = superMsgService.get(superMsg.getId());
		}
		model.addAttribute("superMsg", superMsg);
		return "home/superMsg/superMsgForm";
	}

	@RequestMapping("save")
	public String save(SuperMsg superMsg, Model model, RedirectAttributes redirectAttributes) {
		superMsg.setCreateBy(getUserInfo().getId());
		superMsg.setUpdateBy(getUserInfo().getId());
		superMsgService.save(superMsg);
		redirectAttributes.addFlashAttribute("msg", "保存个人信息成功！");
		return "redirect:/page/superMsg/?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(SuperMsg superMsg, RedirectAttributes redirectAttributes) {
		superMsgService.delete(superMsg);
		redirectAttributes.addFlashAttribute("msg", "删除个人信息成功！");
		return "redirect:/page/superMsg/?repage";
	}
	
}