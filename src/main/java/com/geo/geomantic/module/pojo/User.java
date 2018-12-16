package com.geo.geomantic.module.pojo;

import org.hibernate.validator.constraints.Length;

import com.geo.geomantic.common.basic.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 用户管理Entity
 * @author zyz
 * @version 2018-12-16
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	private String nickName;		// ??
	private String phone;		// ???
	private String password;		// ??
	private String sex;		// ??
	private String headphoto;		// ??
	private String autograph;		// ????
	private String address;		// address
	private String addressCode;		// address_code
	private String state;		// ??
	
	public User() {
		super();
	}

	public User(String id){
		super(id);
	}

	@Length(min=1, max=120, message="??长度不能为空且不能超过120个字符")
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@Length(min=1, max=11, message="???长度不能为空且不能超过11个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=1, max=100, message="??长度不能为空且不能超过100个字符")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=1, max=20, message="??长度不能为空且不能超过20个字符")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=1, max=100, message="??长度不能为空且不能超过100个字符")
	public String getHeadphoto() {
		return headphoto;
	}

	public void setHeadphoto(String headphoto) {
		this.headphoto = headphoto;
	}
	
	@Length(min=0, max=500, message="????长度不能超过 500个字符")
	public String getAutograph() {
		return autograph;
	}

	public void setAutograph(String autograph) {
		this.autograph = autograph;
	}
	
	@Length(min=0, max=255, message="address长度不能超过 255个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=100, message="address_code长度不能超过 100个字符")
	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	
	@Length(min=1, max=4, message="??长度不能为空且不能超过4个字符")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}