package com.education.constants;


/**
 * @author lss
 * @since 2020-03-22
 */
public class ResultMsg {
    private int errorCode;
    private String msg;
    private Object data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultMsg() {
    }

    public ResultMsg(int errorCode, String msg, Object data) {
        this.errorCode = errorCode;
        this.msg = msg;
        this.data = data;
    }

    public void setErrorMsg(ResultErrorMsg errorMsg) {
        setErrorCode(errorMsg.getCode());
        setMsg(errorMsg.getDesc());
    }

}
