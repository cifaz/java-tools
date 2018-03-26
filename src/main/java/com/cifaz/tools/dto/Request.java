package com.cifaz.tools.dto;


public class Request<T> extends BaseRequest {
    private T data;
    private String sid;

    @Override
    public String getSid() {
        return sid;
    }

    @Override
    public void setSid(String sid) {
        this.sid = sid;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
