package com.education.exception;

/**
 * 微信登录 App对应secret没有找到异常
 * @author lss
 * @since 2020/3/27
 */
public class WeChatException extends Exception {

    public WeChatException(String msg) {
        super(msg);
    }


}
