package com.geo.geomantic.module.pojo;

import org.hibernate.validator.constraints.Length;

import com.geo.geomantic.common.basic.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 收货地址Entity
 * @author zyz
 * @version 2018-12-16
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserSite extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	private String address;		// 地址1
	private String isSite;		// 是否默认地址
	private String addressCode;		// 地址1

	public UserSite() {
		super();
	}

	public UserSite(String id){
		super(id);
	}

	@Length(min=0, max=255, message="地址1长度不能超过 255个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=4, message="是否默认地址长度不能超过 4个字符")
	public String getIsSite() {
		return isSite;
	}

	public void setIsSite(String isSite) {
		this.isSite = isSite;
	}
	
	@Length(min=0, max=255, message="地址1长度不能超过 255个字符")
	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}

}