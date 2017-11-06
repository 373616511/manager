package com.asyf.manager.modules.sys.entity;

import com.asyf.manager.common.entity.DataEntity;
import org.apache.ibatis.type.Alias;

import java.util.List;

public class Menu extends DataEntity<Menu> {

    private String parentId;

    private String parentIds;

    private String name;

    private Long sort;

    private String href;

    private String target;

    private String icon;

    private String isShow;

    private String permission;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "parentId='" + parentId + '\'' +
                ", parentIds='" + parentIds + '\'' +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", href='" + href + '\'' +
                ", target='" + target + '\'' +
                ", icon='" + icon + '\'' +
                ", isShow='" + isShow + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }

    public static void sortList(List<Menu> list, List<Menu> sourceList, String parentId) {
        //遍历寻找子节点
        for (int i = 0; i < sourceList.size(); i++) {
            Menu m = sourceList.get(i);
            if (m != null && m.getId() != null && m.getParentId() != null && m.getParentId().equals(parentId)) {
                list.add(m);
                sortList(list, sourceList, m.getId());
            }
        }
    }

}