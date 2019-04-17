package com.highmind.entity;

import java.util.List;

public class Menu {
    private Long id;

    private Long domainid;

    private String name;

    private String url;
    
    private Long parent_id;
    
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }
    
    //子菜单
    private List<Menu> children;
    
    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

}