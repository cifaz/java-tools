package com.cifaz.tools.dto.pager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PagerData<T> extends Pager implements Serializable {
    private static final long serialVersionUID = -2064694687134679279L;
    private Integer pages;
    private Integer total;
    private List<T> dataList = new ArrayList();

    public PagerData() {
    }

    public static <T> PagerData<T> create(Class<T> cls) {
        PagerData<T> pagerData = new PagerData();
        return pagerData;
    }

    public static <T> PagerData<T> create() {
        PagerData<T> pagerData = new PagerData();
        return pagerData;
    }

    public Integer getTotal() {
        return this.total;
    }

    public PagerData<T> setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public List<T> getDataList() {
        return this.dataList;
    }

    public PagerData<T> setDataList(List<T> dataList) {
        this.dataList = dataList;
        return this;
    }

    public PagerData<T> addData(T data) {
        this.dataList.add(data);
        return this;
    }

    public T getData(int index) {
        return this.dataList == null ? null : this.dataList.get(index);
    }

    public Integer getPages() {
        return this.pages;
    }

    public PagerData<T> setPages(Integer pages) {
        this.pages = pages;
        return this;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("PagerData{");
        sb.append("pages=").append(this.pages);
        sb.append(", total=").append(this.total);
        sb.append(", dataList=").append(this.dataList);
        sb.append('}');
        return sb.toString();
    }
}
