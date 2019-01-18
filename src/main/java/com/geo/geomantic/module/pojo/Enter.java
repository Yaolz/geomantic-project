package com.geo.geomantic.module.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.geo.geomantic.common.basic.BaseEntity;

/**
 * 用户入驻Entity
 * Created by yao on 2019/1/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Enter  extends BaseEntity{

    private static final long serialVersionUID = 1L;
    private String realName;    //真实姓名
    private String cardNo;         //身份证号
    private String cardHead;        //身份证头像面
    private String cardNational;    //身份证国徽面
    private String job;                      //工作
    private String  state;                  //状态
    private String introduce;           //介绍

    private String nickName;		// 昵称
    private String phone;		// 手机号
    private String sex;		// 性别
    private String headphoto;		// 头像
    private String autograph;		// 个性签名
    private String address;		// 地址

    private String startCreateDate;
    private String endCreateDate;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardHead() {
        return cardHead;
    }

    public void setCardHead(String cardHead) {
        this.cardHead = cardHead;
    }

    public String getCardNational() {
        return cardNational;
    }

    public void setCardNational(String cardNational) {
        this.cardNational = cardNational;
    }

    public String getJod() {
        return job;
    }

    public void setJod(String job) {
        this.job = job;
    }

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadphoto() {
        return headphoto;
    }

    public void setHeadphoto(String headphoto) {
        this.headphoto = headphoto;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
