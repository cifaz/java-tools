package com.cifaz.tools.dto;

public class PagedRequest<E> extends BaseRequest {
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int DEFAULT_CURRENT_PAGE = 1;
    private static final long serialVersionUID = -5015930163121891051L;
    private int currentPage = 1;
    private int pageSize = 20;
    private boolean fetchAll = false;
    private boolean countTotal = false;

    public PagedRequest() {
    }

    public void setPageParam(int currentPage, int pageSize, boolean fetchAll, boolean countTotal) {
        this.setCurrentPage(currentPage);
        this.setPageSize(pageSize);
        this.fetchAll = fetchAll;
        this.countTotal = countTotal;
    }

    public void setPageParam(int currentPage, int pageSize) {
        this.setPageParam(currentPage, pageSize, false, false);
    }

    public void setPageParam(int currentPage, int pageSize, boolean countTotal) {
        this.setPageParam(currentPage, pageSize, false, countTotal);
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = this.resolveCurrentPage(currentPage);
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = this.resolvePageSize(pageSize);
    }

    public boolean isFetchAll() {
        return this.fetchAll;
    }

    public void setFetchAll(boolean fetchAll) {
        this.fetchAll = fetchAll;
    }

    public boolean isCountTotal() {
        return this.countTotal;
    }

    public void setCountTotal(boolean countTotal) {
        this.countTotal = countTotal;
    }

    public int resolvePageSize(int pageSize) {
        if (pageSize <= 0) {
            pageSize = 20;
        }

        return pageSize;
    }

    public int resolveCurrentPage(int currentPage) {
        if (currentPage <= 0) {
            currentPage = 1;
        }

        return currentPage;
    }

    public int getMySQLOffset() {
        return (this.currentPage - 1) * this.pageSize;
    }
}
