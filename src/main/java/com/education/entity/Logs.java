package com.education.entity;

public class Logs extends BaseEntity {

    private String userId;

    private String action;

    private String method;

    private String parameter;

    private String log_time;

    private String src_ip;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getLog_time() {
        return log_time;
    }

    public void setLog_time(String log_time) {
        this.log_time = log_time;
    }

    public String getSrc_ip() {
        return src_ip;
    }

    public void setSrc_ip(String src_ip) {
        this.src_ip = src_ip;
    }


    public Logs() {
    }

    public Logs(String userId, String action, String method, String parameter, String log_time, String src_ip) {
        this.userId = userId;
        this.action = action;
        this.method = method;
        this.parameter = parameter;
        this.log_time = log_time;
        this.src_ip = src_ip;
    }
}
