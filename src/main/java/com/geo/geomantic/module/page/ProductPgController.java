package com.geo.geomantic.module.page;

import com.geo.geomantic.common.basic.BaseController;
import com.geo.geomantic.module.pojo.Product;
import com.geo.geomantic.module.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 商品管理Controller
 * @author zyz
 * @version 2018-12-22
 */
@Controller
@RequestMapping("/page/product")
public class ProductPgController  extends BaseController {

	@Autowired
	private ProductService productService;

	 @RequestMapping(value = {"", "list"})
    public String userList(Product product, Model model) {
        PageInfo<Product> page = productService.findPage(product);
        model.addAttribute("page", page);
        model.addAttribute("product", product);
        return "home/product/productList";
    }

	@RequestMapping("form")
	public String form(Product product, Model model) {
		if (StringUtils.isNotBlank(product.getId())){
			product = productService.get(product.getId());
		}
		model.addAttribute("product", product);
		return "home/product/productForm";
	}

	@RequestMapping("save")
	public String save(Product product, Model model, RedirectAttributes redirectAttributes) {
		product.setCreateBy(getUserInfo().getId());
		product.setUpdateBy(getUserInfo().getId());
		productService.save(product);
		redirectAttributes.addFlashAttribute("msg", "保存商品成功！");
		return "redirect:/page/product/?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(Product product, RedirectAttributes redirectAttributes) {
		productService.delete(product);
		redirectAttributes.addFlashAttribute("msg", "删除商品成功！");
		return "redirect:/page/product/?repage";
	}
	
}