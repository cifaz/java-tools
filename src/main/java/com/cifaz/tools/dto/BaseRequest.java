package com.cifaz.tools.dto;

import java.io.Serializable;

public class BaseRequest implements Serializable {

    private static final long serialVersionUID = 7343365715966201102L;
    private String sid;

    public BaseRequest() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
