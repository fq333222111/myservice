package com.myservice.model;

import java.util.Date;

public class SysDictionary {
    private String guid;

    private String name;

    private String code;

    private String value;

    private String parentId;

    private String isHasChird;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String vaild;

    private String descContent;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getIsHasChird() {
        return isHasChird;
    }

    public void setIsHasChird(String isHasChird) {
        this.isHasChird = isHasChird == null ? null : isHasChird.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getVaild() {
        return vaild;
    }

    public void setVaild(String vaild) {
        this.vaild = vaild == null ? null : vaild.trim();
    }

    public String getDescContent() {
        return descContent;
    }

    public void setDescContent(String descContent) {
        this.descContent = descContent == null ? null : descContent.trim();
    }
}