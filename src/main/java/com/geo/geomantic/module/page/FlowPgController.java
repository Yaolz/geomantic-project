package com.geo.geomantic.module.page;

import com.geo.geomantic.common.basic.BaseController;
import com.geo.geomantic.module.pojo.Flow;
import com.geo.geomantic.module.service.FlowService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 流水管理Controller
 * @author zyz
 * @version 2018-12-22
 */
@Controller
@RequestMapping("/page/flow")
public class FlowPgController  extends BaseController {

	@Autowired
	private FlowService flowService;

	 @RequestMapping(value = {"", "list"})
    public String userList(Flow flow, Model model) {
        PageInfo<Flow> page = flowService.findPage(flow);
        model.addAttribute("page", page);
        model.addAttribute("flow", flow);
        return "home/flow/flowList";
    }

	@RequestMapping("form")
	public String form(Flow flow, Model model) {
		if (StringUtils.isNotBlank(flow.getId())){
			flow = flowService.get(flow.getId());
		}
		model.addAttribute("flow", flow);
		return "home/flow/flowForm";
	}

	@RequestMapping("save")
	public String save(Flow flow, Model model, RedirectAttributes redirectAttributes) {
		flow.setCreateBy(getUserInfo().getId());
		flow.setUpdateBy(getUserInfo().getId());
		flowService.save(flow);
		redirectAttributes.addFlashAttribute("msg", "保存流水成功！");
		return "redirect:/page/flow/?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(Flow flow, RedirectAttributes redirectAttributes) {
		flowService.delete(flow);
		redirectAttributes.addFlashAttribute("msg", "删除流水成功！");
		return "redirect:/page/flow/?repage";
	}
	
}