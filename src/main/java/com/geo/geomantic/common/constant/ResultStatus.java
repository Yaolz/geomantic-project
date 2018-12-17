package com.geo.geomantic.common.constant;

/**
 * 信息说明类
 * @author zyz
 * @date 2018/12/16
 */
public enum  ResultStatus {

    SUCCESS("0000", "成功"),
    ONE("0001", "错误一"),
    TWO("0001", "错误二"),
    THREE("0001", "错误三"),

    USER_NOT_EXIS("1000","用户不存在"),
    USER_EXIS("1001","用户已存在"),

    SYSTEM_ERROR("9999","系统错误！");


    /**
     * 返回码
     */
    private String code;

    /**
     * 返回结果描述
     */
    private String msg;

    ResultStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
