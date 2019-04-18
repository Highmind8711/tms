package com.highmind.entity;

import java.util.List;

public class Department {
    private Long id;

    private Long domainid;

    private Long ml_parent;

    private String name;

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

    public Long getMl_parent() {
        return ml_parent;
    }

    public void setMl_parent(Long ml_parent) {
        this.ml_parent = ml_parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    //该部门下的所有雇员
    private List<Employee> employees;
    
    public List<Employee> getEmployees() {
        return employees;
    }
    
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
    private List<Department> children;
    
    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }
    
}