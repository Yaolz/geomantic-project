package com.geo.geomantic.module.pojo;

import org.hibernate.validator.constraints.Length;

import com.geo.geomantic.common.basic.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 流水管理Entity
 * @author zyz
 * @version 2018-12-18
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Flow extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	private String productId;		// 商品ID
	private String orderNo;		// 本系统订单号
	private String transactionNo;		// 交易流水号(微信或支付宝)
	private String way;		// 支付方式
	private String status;		// 状态(完成，退款)
	private String money;		// 交易金额

	private String startCreateDate;
	private String endCreateDate;


	public Flow() {
		super();
	}

	public Flow(String id){
		super(id);
	}

	@Length(min=0, max=10, message="商品ID长度不能超过 10个字符")
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	@Length(min=0, max=50, message="本系统订单号长度不能超过 50个字符")
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	@Length(min=0, max=50, message="交易流水号(微信或支付宝)长度不能超过 50个字符")
	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	
	@Length(min=0, max=50, message="支付方式长度不能超过 50个字符")
	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}
	
	@Length(min=0, max=50, message="状态(完成，退款)长度不能超过 50个字符")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
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