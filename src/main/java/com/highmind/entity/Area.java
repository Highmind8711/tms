package com.highmind.entity;

public class Area {
    private Long id;

    private Integer domainid;

    private String areaname;

    private String arearemark;

    private Integer serial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDomainid() {
        return domainid;
    }

    public void setDomainid(Integer domainid) {
        this.domainid = domainid;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
    }

    public String getArearemark() {
        return arearemark;
    }

    public void setArearemark(String arearemark) {
        this.arearemark = arearemark == null ? null : arearemark.trim();
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }
}