package com.highmind.entity;


public class Operation {
    private Long id;

    private Long domainid;

    private String name;

    private String botton_id;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDomainid() {
        return domainid;
    }

    public void setDomainid(Long domainid) {
        this.domainid = domainid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBotton_id() {
        return botton_id;
    }

    public void setBotton_id(String botton_id) {
        this.botton_id = botton_id == null ? null : botton_id.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    

    //权限
    private Permission permission;
    
    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}