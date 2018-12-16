package com.geo.geomantic.module.pojo;

import org.hibernate.validator.constraints.Length;

import com.geo.geomantic.common.basic.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 订单管理Entity
 * @author zyz
 * @version 2018-12-16
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	private String productId;		// 订单id
	private String orderNum;		// 订单编号
	private String state;		// 0
	
	public Order() {
		super();
	}

	public Order(String id){
		super(id);
	}

	@Length(min=1, max=11, message="订单id长度不能为空且不能超过11个字符")
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	@Length(min=1, max=100, message="订单编号长度不能为空且不能超过100个字符")
	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
	@Length(min=1, max=11, message="0长度不能为空且不能超过11个字符")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}