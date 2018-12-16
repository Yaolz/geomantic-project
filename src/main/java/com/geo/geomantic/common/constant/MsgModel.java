package com.geo.geomantic.common.constant;

/**
 * 返回信息类
 * @author zyz
 * @date 2018/12/16
 */
public class MsgModel {

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回结果描述
     */
    private Object msg;

    /**
     * 返回内容
     */
    private Object body;

    public MsgModel() {

    }


    public MsgModel(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.body = "";
    }

    public MsgModel(String code, String msg, Object responsebody) {
        this.code = code;
        this.msg = msg;
        this.body = responsebody;
    }

    public MsgModel(ResultStatus status) {
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.body = "";
    }

    public MsgModel(ResultStatus status, Object responsebody) {
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.body = responsebody;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
