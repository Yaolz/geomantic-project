package com.geo.geomantic.common.constant;

/**
 * 信息说明类
 * @author zyz
 * @date 2018/12/16
 */
public enum  ResultStatus {

    SUCCESS("0000", "成功"),

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
