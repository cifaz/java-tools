package com.cifaz.tools.dto;

public class Result<T> extends BaseResult {
    private static final long serialVersionUID = 3484073710784416152L;
    private T data;

    public Result() {
    }

    public static <T> Result<T> create() {
        Result<T> result = new Result();
        result.setSuccess(false);
        return result;
    }

    public Result<T> success() {
        this.success(null);
        return this;
    }

    public Result<T> success(T data) {
        this.setSuccess(true);
        this.data = data;
        return this;
    }

    public Result<T> fail(String code, String description) {
        this.setSuccess(false);
        this.setCode(code);
        this.setDescription(description);
        return this;
    }

    public Result<T> fail(String code) {
        this.fail(code, null);
        return this;
    }

    public Result<T> code(String code) {
        this.setCode(code);
        return this;
    }

    public Result<T> description(String description) {
        this.setDescription(description);
        return this;
    }

    public Result<T> sid(String sid) {
        this.setSid(sid);
        return this;
    }

    public Result<T> data(T data) {
        this.data = data;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
