package com.geo.geomantic.module.pojo;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.geo.geomantic.common.basic.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 订单管理Entity
 * @author zyz
 * @version 2018-12-18
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	private String orderId;		// 主键
	private String productId;		// 订单id
	private String orderNo;		// 订单号
	private String orderMoney;		// 订单金额
	private String orderintegration;		// 抵扣积分
	private String integrationAmount;		// 订单积分金额
	private String state;		// 0
	private String freight;		// 运费
	private String orderCountMoney;		// 总金额
	private String dealState;		// 订单状态
	private String buyerRemark;		// 买家留言
	private String dealpayType;		// 交易类型,微信支付宝等
	private String receiverAddress;		// 收货地址
	private String receiverMobile;		// 收货人手机号
	private String receiverName;		// 收货人姓名
	private String receiverPhone;		// 收货人电话号码
	private String receiverPostcode;		// 收货人邮编
	private String buyerName;		// 买家名称
	private String buyUserid;		// 买家Id
	private Date createTime;		// 下单时间
	private Date payTime;		// 付款时间
	private Date recvfeeTime;		// 收款时间
	private String recvUsername;		// 收款人
	private String freightCompany;		// 快递公司
	private String freightNumber;		// 运费单号
	private String expressCode;		// 快递公司编号
	private String channelBalance;		// 渠道金额
	private String returnBalance;		// 退款金额
	private String startCreateDate;
	private String endCreateDate;

	public Order() {
		super();
	}

	public Order(String orderId){
		super(orderId);
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	@Length(min=1, max=11, message="订单id长度不能为空且不能超过11个字符")
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	@Length(min=1, max=50, message="订单号长度不能为空且不能超过50个字符")
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(String orderMoney) {
		this.orderMoney = orderMoney;
	}
	
	public String getOrderintegration() {
		return orderintegration;
	}

	public void setOrderintegration(String orderintegration) {
		this.orderintegration = orderintegration;
	}
	
	public String getIntegrationAmount() {
		return integrationAmount;
	}

	public void setIntegrationAmount(String integrationAmount) {
		this.integrationAmount = integrationAmount;
	}
	
	@Length(min=1, max=11, message="0长度不能为空且不能超过11个字符")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}
	
	public String getOrderCountMoney() {
		return orderCountMoney;
	}

	public void setOrderCountMoney(String orderCountMoney) {
		this.orderCountMoney = orderCountMoney;
	}
	
	@Length(min=0, max=2, message="订单状态长度不能超过 2个字符")
	public String getDealState() {
		return dealState;
	}

	public void setDealState(String dealState) {
		this.dealState = dealState;
	}
	
	@Length(min=0, max=255, message="买家留言长度不能超过 255个字符")
	public String getBuyerRemark() {
		return buyerRemark;
	}

	public void setBuyerRemark(String buyerRemark) {
		this.buyerRemark = buyerRemark;
	}
	
	@Length(min=0, max=1, message="交易类型,微信支付宝等长度不能超过 1个字符")
	public String getDealpayType() {
		return dealpayType;
	}

	public void setDealpayType(String dealpayType) {
		this.dealpayType = dealpayType;
	}
	
	@Length(min=0, max=255, message="收货地址长度不能超过 255个字符")
	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	
	@Length(min=0, max=50, message="收货人手机号长度不能超过 50个字符")
	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	
	@Length(min=0, max=50, message="收货人姓名长度不能超过 50个字符")
	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	
	@Length(min=0, max=50, message="收货人电话号码长度不能超过 50个字符")
	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	
	@Length(min=0, max=255, message="收货人邮编长度不能超过 255个字符")
	public String getReceiverPostcode() {
		return receiverPostcode;
	}

	public void setReceiverPostcode(String receiverPostcode) {
		this.receiverPostcode = receiverPostcode;
	}
	
	@Length(min=0, max=64, message="买家名称长度不能超过 64个字符")
	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	
	@Length(min=0, max=11, message="买家Id长度不能超过 11个字符")
	public String getBuyUserid() {
		return buyUserid;
	}

	public void setBuyUserid(String buyUserid) {
		this.buyUserid = buyUserid;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRecvfeeTime() {
		return recvfeeTime;
	}

	public void setRecvfeeTime(Date recvfeeTime) {
		this.recvfeeTime = recvfeeTime;
	}
	
	@Length(min=0, max=64, message="收款人长度不能超过 64个字符")
	public String getRecvUsername() {
		return recvUsername;
	}

	public void setRecvUsername(String recvUsername) {
		this.recvUsername = recvUsername;
	}
	
	@Length(min=0, max=50, message="快递公司长度不能超过 50个字符")
	public String getFreightCompany() {
		return freightCompany;
	}

	public void setFreightCompany(String freightCompany) {
		this.freightCompany = freightCompany;
	}
	
	@Length(min=0, max=50, message="运费单号长度不能超过 50个字符")
	public String getFreightNumber() {
		return freightNumber;
	}

	public void setFreightNumber(String freightNumber) {
		this.freightNumber = freightNumber;
	}
	
	@Length(min=0, max=50, message="快递公司编号长度不能超过 50个字符")
	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}
	
	public String getChannelBalance() {
		return channelBalance;
	}

	public void setChannelBalance(String channelBalance) {
		this.channelBalance = channelBalance;
	}
	
	public String getReturnBalance() {
		return returnBalance;
	}

	public void setReturnBalance(String returnBalance) {
		this.returnBalance = returnBalance;
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