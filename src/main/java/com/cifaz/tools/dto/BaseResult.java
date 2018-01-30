package com.cifaz.tools.dto;

import java.io.Serializable;

public class BaseResult implements Serializable {

    private static final long serialVersionUID = 1615521882414192670L;
    private String sid;
    private boolean success;
    private String code;
    private String description;

    public BaseResult() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
