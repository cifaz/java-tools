package com.cifaz.tools.dto.pager;

import java.io.Serializable;

public class Pager implements Serializable {
    public static final int DEFAULT_PAGE_NUM = 1;
    public static final int DEFAULT_PAGE_SIZE = 20;
    private static final long serialVersionUID = 4401213534492462746L;
    private Integer pageNum = Integer.valueOf(1);
    private Integer pageSize = Integer.valueOf(20);
    private boolean count = false;

    public Pager() {
    }

    public Pager(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Pager(Integer pageNum, Integer pageSize, boolean count) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.count = count;
    }

    public Integer getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum == null) {
            throw new RuntimeException("pageNum is null");
        } else {
            this.pageNum = pageNum;
        }
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            throw new RuntimeException("pageSize is null");
        } else {
            this.pageSize = pageSize;
        }
    }

    public boolean isCount() {
        return this.count;
    }

    public void setCount(boolean count) {
        this.count = count;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Pager{");
        sb.append("pageNum=").append(this.pageNum);
        sb.append(", pageSize=").append(this.pageSize);
        sb.append('}');
        return sb.toString();
    }
}
