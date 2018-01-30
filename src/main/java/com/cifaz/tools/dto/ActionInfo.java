package com.cifaz.tools.dto;

import java.io.Serializable;

public class ActionInfo implements Serializable {
    private Integer fromProduction;
    private Integer sourceSite;
    private Byte phoneType;
    private String sourceIp;
    private Integer operRole;
    private String systemTrigger;
    private Integer userId;
    private String nickname;

    public ActionInfo() {
    }

    public Integer getFromProduction() {
        return this.fromProduction;
    }

    public void setFromProduction(Integer fromProduction) {
        this.fromProduction = fromProduction;
    }

    public Integer getSourceSite() {
        return this.sourceSite;
    }

    public void setSourceSite(Integer sourceSite) {
        this.sourceSite = sourceSite;
    }

    public Byte getPhoneType() {
        return this.phoneType;
    }

    public void setPhoneType(Byte phoneType) {
        this.phoneType = phoneType;
    }

    public String getSourceIp() {
        return this.sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public Integer getOperRole() {
        return this.operRole;
    }

    public void setOperRole(Integer operRole) {
        this.operRole = operRole;
    }

    public String getSystemTrigger() {
        return this.systemTrigger;
    }

    public void setSystemTrigger(String systemTrigger) {
        this.systemTrigger = systemTrigger;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
