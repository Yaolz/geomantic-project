package com.geo.geomantic.module.pojo;

import org.hibernate.validator.constraints.Length;

import com.geo.geomantic.common.basic.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 个人信息Entity
 * @author zyz
 * @version 2018-12-16
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuperMsg extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	private String photo;		// 个人图片
	private String realName;		// 真实姓名
	private String description;		// 简介
	private String startCreateDate;
	private String endCreateDate;

	public SuperMsg() {
		super();
	}

	public SuperMsg(String id){
		super(id);
	}

	@Length(min=1, max=60, message="个人图片长度不能为空且不能超过60个字符")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Length(min=1, max=60, message="真实姓名长度不能为空且不能超过60个字符")
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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