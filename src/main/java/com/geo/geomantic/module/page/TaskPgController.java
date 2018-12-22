package com.geo.geomantic.module.page;

import com.geo.geomantic.common.basic.BaseController;
import com.geo.geomantic.module.pojo.Task;
import com.geo.geomantic.module.service.TaskService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 测算管理Controller
 * @author zyz
 * @version 2018-12-22
 */
@Controller
@RequestMapping("/page/task")
public class TaskPgController  extends BaseController {

	@Autowired
	private TaskService taskService;

	 @RequestMapping(value = {"", "list"})
    public String userList(Task task, Model model) {
        PageInfo<Task> page = taskService.findPage(task);
        model.addAttribute("page", page);
        model.addAttribute("task", task);
        return "home/task/taskList";
    }

	@RequestMapping("form")
	public String form(Task task, Model model) {
		if (StringUtils.isNotBlank(task.getId())){
			task = taskService.get(task.getId());
		}
		model.addAttribute("task", task);
		return "home/task/taskForm";
	}

	@RequestMapping("save")
	public String save(Task task, Model model, RedirectAttributes redirectAttributes) {
		task.setCreateBy(getUserInfo().getId());
		task.setUpdateBy(getUserInfo().getId());
		taskService.save(task);
		redirectAttributes.addFlashAttribute("msg", "保存测算成功！");
		return "redirect:/page/task/?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(Task task, RedirectAttributes redirectAttributes) {
		taskService.delete(task);
		redirectAttributes.addFlashAttribute("msg", "删除测算成功！");
		return "redirect:/page/task/?repage";
	}
	
}