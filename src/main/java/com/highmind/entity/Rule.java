package com.highmind.entity;

import java.util.List;

public class Rule {
    private Long id;

    private Long domainid;

    private String rulename;

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

    public String getRulename() {
        return rulename;
    }

    public void setRulename(String rulename) {
        this.rulename = rulename == null ? null : rulename.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    // 这个角色下所有的雇员
    private List<RuleEmployee> RuleEmployees;
    
    public List<RuleEmployee> getRuleEmployees() {
        return RuleEmployees;
    }

    public void setRuleEmployees(List<RuleEmployee> ruleEmployees) {
        RuleEmployees = ruleEmployees;
    }

    
    // 角色下对应的权限
    private List<Permission> permissions;
    

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}