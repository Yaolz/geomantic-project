package com.geo.geomantic.module.page;

import com.geo.geomantic.common.basic.BaseController;
import com.geo.geomantic.module.pojo.News;
import com.geo.geomantic.module.service.NewsService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 咨询管理Controller
 * @author zyzz
 * @version 2018-12-22
 */
@Controller
@RequestMapping("/page/news")
public class NewsPgController  extends BaseController {

	@Autowired
	private NewsService newsService;

	 @RequestMapping(value = {"", "list"})
    public String userList(News news, Model model) {
        PageInfo<News> page = newsService.findPage(news);
        model.addAttribute("page", page);
        model.addAttribute("news", news);
        return "home/news/newsList";
    }

	@RequestMapping("form")
	public String form(News news, Model model) {
		if (StringUtils.isNotBlank(news.getId())){
			news = newsService.get(news.getId());
		}
		model.addAttribute("news", news);
		return "home/news/newsForm";
	}

	@RequestMapping("save")
	public String save(News news, Model model, RedirectAttributes redirectAttributes) {
		news.setCreateBy(getUserInfo().getId());
		news.setUpdateBy(getUserInfo().getId());
		newsService.save(news);
		redirectAttributes.addFlashAttribute("msg", "保存咨询管理成功！");
		return "redirect:/page/news/?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(News news, RedirectAttributes redirectAttributes) {
		newsService.delete(news);
		redirectAttributes.addFlashAttribute("msg", "删除咨询管理成功！");
		return "redirect:/page/news/?repage";
	}
	
}