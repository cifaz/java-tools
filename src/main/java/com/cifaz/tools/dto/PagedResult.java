package com.cifaz.tools.dto;

import java.util.List;

public class PagedResult<E> extends Result<List<E>> {
    private static final long serialVersionUID = 4167302597691171878L;
    private boolean countTotal = false;
    private boolean fetchAll = false;
    private Integer total;
    private Integer totalPage;
    private int currentPage;
    private int pageSize;

    public PagedResult() {
    }

    public void setCountTotal(boolean countTotal) {
        this.countTotal = countTotal;
    }

    public void setFetchAll(boolean fetchAll) {
        this.fetchAll = fetchAll;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public static void main(String[] args) {
        PagedResult pagedResult = new PagedResult();
    }

    public boolean isCountTotal() {
        return this.countTotal;
    }

    public Integer getTotal() {
        return this.total;
    }

    public Integer getTotalPage() {
        return this.totalPage;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PagedResult");
        builder.append("[");
        builder.append("countTotal=").append(this.countTotal).append(",");
        builder.append("fetchAll=").append(this.fetchAll).append(",");
        builder.append("total=").append(this.total).append(",");
        builder.append("totalPage=").append(this.totalPage).append(",");
        builder.append("currentPage=").append(this.currentPage).append(",");
        builder.append("pageSize=").append(this.pageSize);
        builder.append("]");
        return builder.toString();
    }

    public static class Builder<E> {
        private PagedResult<E> pagedResult;

        public static <E> PagedResult.Builder<E> from(PagedRequest<E> request) {
            PagedResult.Builder<E> builder = new PagedResult.Builder();
            int currentPage = request.getCurrentPage();
            int pageSize = request.getPageSize();
            if (currentPage <= 0) {
                currentPage = 1;
            }

            if (pageSize <= 0) {
                pageSize = 20;
            }

            builder.pageSize(pageSize).currentPage(currentPage);
            builder.countTotal(request.isCountTotal());
            builder.fetchAll(request.isFetchAll());
            return builder;
        }

        public Builder() {
            this.pagedResult = new PagedResult();
        }

        public Builder(int currentPage) {
            if (currentPage < 1) {
                throw new RuntimeException("currentPage error:" + currentPage);
            } else {
                this.pagedResult = new PagedResult();
                this.pagedResult.currentPage = currentPage;
            }
        }

        public Builder(int currentPage, int pageSize) {
            if (currentPage < 1) {
                throw new RuntimeException("currentPage error:" + currentPage);
            } else if (pageSize < 1) {
                throw new RuntimeException("pageSize error:" + pageSize);
            } else {
                this.pagedResult = new PagedResult();
                this.pagedResult.currentPage = currentPage;
                this.pagedResult.pageSize = pageSize;
            }
        }

        public PagedResult.Builder<E> total(int total) {
            if (total < 0) {
                throw new RuntimeException("total error:" + total);
            } else {
                this.pagedResult.total = total;
                return this;
            }
        }

        public PagedResult.Builder<E> currentPage(int currentPage) {
            if (currentPage < 1) {
                throw new RuntimeException("currentPage error:" + currentPage);
            } else {
                this.pagedResult.currentPage = currentPage;
                return this;
            }
        }

        public PagedResult.Builder<E> pageSize(int pageSize) {
            if (pageSize < 1) {
                throw new RuntimeException("pageSize error:" + pageSize);
            } else {
                this.pagedResult.pageSize = pageSize;
                return this;
            }
        }

        public PagedResult.Builder<E> countTotal(boolean countTotal) {
            this.pagedResult.countTotal = countTotal;
            return this;
        }

        public PagedResult.Builder<E> fetchAll(boolean fetchAll) {
            this.pagedResult.fetchAll = fetchAll;
            return this;
        }

        public PagedResult.Builder<E> data(List<E> data) {
            this.pagedResult.data(data);
            return this;
        }

        public PagedResult.Builder<E> code(String code) {
            this.pagedResult.code(code);
            return this;
        }

        public PagedResult.Builder<E> description(String description) {
            this.pagedResult.description(description);
            return this;
        }

        public PagedResult.Builder<E> sid(String sid) {
            this.pagedResult.sid(sid);
            return this;
        }

        public PagedResult<E> buildForFailed(String description) {
            this.pagedResult.currentPage = 0;
            this.pagedResult.totalPage = Integer.valueOf(0);
            this.pagedResult.total = Integer.valueOf(0);
            this.pagedResult.pageSize = 0;
            this.pagedResult.fail("ERROR", description);
            return this.pagedResult;
        }

        public PagedResult<E> buildForFailed(String code, String description) {
            this.pagedResult.currentPage = 0;
            this.pagedResult.totalPage = Integer.valueOf(0);
            this.pagedResult.total = Integer.valueOf(0);
            this.pagedResult.pageSize = 0;
            this.pagedResult.fail(code, description);
            return this.pagedResult;
        }

        public PagedResult<E> buildForSuccess(List<E> data) {
            this.pagedResult.data(data);
            return this.buildForSuccess();
        }

        public PagedResult<E> buildForSuccess() {
            this.pagedResult.setSuccess(true);
            if (this.pagedResult.getData() == null) {
                throw new RuntimeException("pagedResult's data list is null, if you means not found, you should return empty list instead.");
            } else if (this.pagedResult.fetchAll) {
                this.pagedResult.currentPage = 1;
                this.pagedResult.totalPage = Integer.valueOf(1);
                this.pagedResult.total = ((List) this.pagedResult.getData()).size();
                this.pagedResult.pageSize = this.pagedResult.total.intValue();
                return this.pagedResult;
            } else {
                if (this.pagedResult.countTotal || this.pagedResult.total != null) {
                    this.pagedResult.totalPage = this.computeTotalPage(this.pagedResult.total, this.pagedResult.pageSize);
                }

                return this.pagedResult;
            }
        }

        private Integer computeTotalPage(Integer total, int pageSize) {
            if (total != null && total.intValue() >= 0) {
                if (pageSize <= 0) {
                    throw new RuntimeException("pageSize error:" + pageSize);
                } else {
                    int tmp = total.intValue() / pageSize;
                    if (total.intValue() % pageSize != 0) {
                        ++tmp;
                    }

                    return tmp;
                }
            } else {
                throw new RuntimeException("total count illegal:" + total);
            }
        }
    }
}
