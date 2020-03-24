package com.education.constants;

/**
 * @author lss
 * @since 2020-03-22
 */
public enum ResultErrorMsg {

    /**
     * 操作成功
     */
    OK(0, "操作成功"),

    /**
     * 系统内部错误
     */
    INNER_ERROR(2, "系统内部错误"),


    /**
     * 登录参数、密码问题
     */
    //部分或全部参数为空
    PARAM_IS_NULL(5, "请求参数为空或部分为空"),

    PARAM_WRONG(7, "参数格式错误"),

    SAVE_USER_ERROR(9, "存储用户信息失败"),

    PWD_INCORRECT(11, "密码错误");

    private int code;

    private String desc;

    ResultErrorMsg(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
