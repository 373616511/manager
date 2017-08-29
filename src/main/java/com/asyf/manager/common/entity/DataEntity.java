package com.asyf.manager.common.entity;

import java.io.Serializable;
import java.util.Date;

public class DataEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    public static final String DEL_FLAG_AUDIT = "2";
    private String id;
    private Date createDate;
    private Date updateDate;
    private String delFlag;
    private Page<T> page;

    public DataEntity() {
        this.delFlag = DEL_FLAG_NORMAL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Page<T> getPage() {
        if (page == null) {
            page = new Page<T>();
        }
        return page;
    }

    public Page<T> setPage(Page<T> page) {
        this.page = page;
        return page;
    }
}
