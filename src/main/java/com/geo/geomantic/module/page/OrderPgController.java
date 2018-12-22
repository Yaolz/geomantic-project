package com.geo.geomantic.module.page;

import com.geo.geomantic.common.basic.BaseController;
import com.geo.geomantic.module.pojo.Order;
import com.geo.geomantic.module.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 订单管理Controller
 * @author zyz
 * @version 2018-12-22
 */
@Controller
@RequestMapping("/page/order")
public class OrderPgController  extends BaseController {

	@Autowired
	private OrderService orderService;

	 @RequestMapping(value = {"", "list"})
    public String userList(Order order, Model model) {
        PageInfo<Order> page = orderService.findPage(order);
        model.addAttribute("page", page);
        model.addAttribute("order", order);
        return "home/order/orderList";
    }

	@RequestMapping("form")
	public String form(Order order, Model model) {
		if (StringUtils.isNotBlank(order.getId())){
			order = orderService.get(order.getId());
		}
		model.addAttribute("order", order);
		return "home/order/orderForm";
	}

	@RequestMapping("save")
	public String save(Order order, Model model, RedirectAttributes redirectAttributes) {
		order.setCreateBy(getUserInfo().getId());
		order.setUpdateBy(getUserInfo().getId());
		orderService.save(order);
		redirectAttributes.addFlashAttribute("msg", "保存订单管理成功！");
		return "redirect:/page/order/?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(Order order, RedirectAttributes redirectAttributes) {
		orderService.delete(order);
		redirectAttributes.addFlashAttribute("msg", "删除订单管理成功！");
		return "redirect:/page/order/?repage";
	}
	
}