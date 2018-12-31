package com.geo.geomantic.module.pojo;

import org.hibernate.validator.constraints.Length;

import com.geo.geomantic.common.basic.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 商品管理Entity
 * @author zyz
 * @version 2018-12-16
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	private String photo;		// 图片
	private String photoes;		// 结束图，逗号分割
	private String name;		// 商品昵称
	private String price;		// 商品价格
	private String description;		// description
	private String buyNum;		// 已购人数
	private String pageView;		// 浏览量
	private String stackSize;		// 库存量
	private String state;		// 激活

	private String startCreateDate;
	private String endCreateDate;

	public Product() {
		super();
	}

	public Product(String id){
		super(id);
	}

	@Length(min=1, max=60, message="图片长度不能为空且不能超过60个字符")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getPhotoes() {
		return photoes;
	}

	public void setPhotoes(String photoes) {
		this.photoes = photoes;
	}
	
	@Length(min=1, max=100, message="商品昵称长度不能为空且不能超过100个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Length(min=0, max=11, message="已购人数长度不能超过 11个字符")
	public String getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(String buyNum) {
		this.buyNum = buyNum;
	}
	
	@Length(min=0, max=11, message="浏览量长度不能超过 11个字符")
	public String getPageView() {
		return pageView;
	}

	public void setPageView(String pageView) {
		this.pageView = pageView;
	}
	
	@Length(min=0, max=11, message="库存量长度不能超过 11个字符")
	public String getStackSize() {
		return stackSize;
	}

	public void setStackSize(String stackSize) {
		this.stackSize = stackSize;
	}
	
	@Length(min=0, max=4, message="激活长度不能超过 4个字符")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStartCreateDate() {
		return startCreateDate;
	}

	public void setStartCreateDate(String startCreateDate) {
		this.startCreateDate = startCreateDate;
	}

	public String getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(String endCreateDate) {
		this.endCreateDate = endCreateDate;
	}


}