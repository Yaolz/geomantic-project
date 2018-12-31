package com.geo.geomantic.module.pojo;

import org.hibernate.validator.constraints.Length;

import com.geo.geomantic.common.basic.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 测算管理Entity
 * @author zyz
 * @version 2018-12-16
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Task extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	private String photo;		// 图片
	private String taskName;		// 测算昵称
	private String description;		// 简介
	private String price;		// 价格
	private String useNum;		// 已测算人数
	private String pageView;		// 浏览量
	private String state;		// 激活
	private String startCreateDate;
	private String endCreateDate;

	public Task() {
		super();
	}

	public Task(String id){
		super(id);
	}

	@Length(min=1, max=60, message="图片长度不能为空且不能超过60个字符")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Length(min=1, max=120, message="测算昵称长度不能为空且不能超过120个字符")
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	@Length(min=0, max=11, message="已测算人数长度不能超过 11个字符")
	public String getUseNum() {
		return useNum;
	}

	public void setUseNum(String useNum) {
		this.useNum = useNum;
	}
	
	@Length(min=0, max=11, message="浏览量长度不能超过 11个字符")
	public String getPageView() {
		return pageView;
	}

	public void setPageView(String pageView) {
		this.pageView = pageView;
	}
	
	@Length(min=1, max=4, message="激活长度不能为空且不能超过4个字符")
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