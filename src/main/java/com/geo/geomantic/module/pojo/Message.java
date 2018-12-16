package com.geo.geomantic.module.pojo;

import org.hibernate.validator.constraints.Length;

import com.geo.geomantic.common.basic.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 反馈管理Entity
 * @author zyz
 * @version 2018-12-16
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	private String userBy;		// 被留言用户id
	private String message;		// 用户反馈内容
	private String state;		// 激活
	
	public Message() {
		super();
	}

	public Message(String id){
		super(id);
	}

	@Length(min=1, max=11, message="被留言用户id长度不能为空且不能超过11个字符")
	public String getUserBy() {
		return userBy;
	}

	public void setUserBy(String userBy) {
		this.userBy = userBy;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Length(min=0, max=4, message="激活长度不能超过 4个字符")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}