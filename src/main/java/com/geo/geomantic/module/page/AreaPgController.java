package com.geo.geomantic.module.page;

import com.geo.geomantic.common.basic.BaseController;
import com.geo.geomantic.module.pojo.Area;
import com.geo.geomantic.module.service.AreaService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 区域管理Controller
 * @author zyz
 * @version 2018-12-22
 */
@Controller
@RequestMapping("/page/area")
public class AreaPgController  extends BaseController {

	@Autowired
	private AreaService areaService;

	 @RequestMapping(value = {"", "list"})
    public String userList(Area area, Model model) {
        PageInfo<Area> page = areaService.findPage(area);
        model.addAttribute("page", page);
        model.addAttribute("area", area);
        return "home/area/areaList";
    }

	@RequestMapping("form")
	public String form(Area area, Model model) {
		if (StringUtils.isNotBlank(area.getId())){
			area = areaService.get(area.getId());
		}
		model.addAttribute("area", area);
		return "home/area/areaForm";
	}

	@RequestMapping("save")
	public String save(Area area, Model model, RedirectAttributes redirectAttributes) {
		area.setCreateBy(getUserInfo().getId());
		area.setUpdateBy(getUserInfo().getId());
		areaService.save(area);
		redirectAttributes.addFlashAttribute("msg", "保存区域管理成功！");
		return "redirect:/page/area/?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(Area area, RedirectAttributes redirectAttributes) {
		areaService.delete(area);
		redirectAttributes.addFlashAttribute("msg", "删除区域管理成功！");
		return "redirect:/page/area/?repage";
	}
	
}