package com.asyf.manager.common.entity;

import org.apache.poi.ss.formula.functions.T;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class Page<T> {
    private String total;
    private String limit;
    private String offset;
    private String order;
    private String sort;
    private List<T> rows = new ArrayList<T>();

    public Page() {
    }

    public Page(HttpServletRequest request) {
        limit = (String) request.getParameter("limit");
        offset = (String) request.getParameter("offset");
        sort = (String) request.getParameter("sort");
        order = (String) request.getParameter("order");
    }

    ;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getLimit() {
        return limit;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

}
