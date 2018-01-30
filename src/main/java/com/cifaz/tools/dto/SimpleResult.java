package com.cifaz.tools.dto;

public class SimpleResult extends BaseResult {
    private static final long serialVersionUID = -1309602212702750542L;

    public SimpleResult() {
    }

    public static SimpleResult create() {
        SimpleResult result = new SimpleResult();
        result.setSuccess(false);
        return result;
    }

    public SimpleResult success() {
        this.setSuccess(true);
        return this;
    }

    public SimpleResult fail(String code, String description) {
        this.setSuccess(false);
        this.setCode(code);
        this.setDescription(description);
        return this;
    }

    public SimpleResult fail(BaseResult baseResult) {
        this.setSuccess(false);
        this.setCode(baseResult.getCode());
        this.setDescription(baseResult.getDescription());
        return this;
    }

    public SimpleResult fail(String code) {
        this.fail(code, (String)null);
        return this;
    }

    public SimpleResult code(String code) {
        this.setCode(code);
        return this;
    }

    public SimpleResult description(String description) {
        this.setDescription(description);
        return this;
    }

    public SimpleResult sid(String sid) {
        this.setSid(sid);
        return this;
    }
}
