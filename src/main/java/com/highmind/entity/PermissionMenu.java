package com.highmind.entity;

public class PermissionMenu {
    private Long id;

    private Long domainid;

    private Long pemission_id;

    private Long menu_id;

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

    public Long getPemission_id() {
        return pemission_id;
    }

    public void setPemission_id(Long pemission_id) {
        this.pemission_id = pemission_id;
    }

    public Long getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Long menu_id) {
        this.menu_id = menu_id;
    }
    
    private Permission permission;
    private Menu menu;
    
    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}