package com.highmind.entity;

public class Spot {
    private Long id;

    private Integer domainid;

    private String spotname;

    private String spotremark;

    private Boolean limited;

    private Integer qty;

    private Integer autoleavetime;

    private Boolean autoleave;

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

    public String getSpotname() {
        return spotname;
    }

    public void setSpotname(String spotname) {
        this.spotname = spotname == null ? null : spotname.trim();
    }

    public String getSpotremark() {
        return spotremark;
    }

    public void setSpotremark(String spotremark) {
        this.spotremark = spotremark == null ? null : spotremark.trim();
    }

    public Boolean getLimited() {
        return limited;
    }

    public void setLimited(Boolean limited) {
        this.limited = limited;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getAutoleavetime() {
        return autoleavetime;
    }

    public void setAutoleavetime(Integer autoleavetime) {
        this.autoleavetime = autoleavetime;
    }

    public Boolean getAutoleave() {
        return autoleave;
    }

    public void setAutoleave(Boolean autoleave) {
        this.autoleave = autoleave;
    }
}