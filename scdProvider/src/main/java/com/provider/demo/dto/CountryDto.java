package com.provider.demo.dto;

import com.provider.demo.entity.Minister;

import java.util.Set;

public class CountryDto {
    private Integer cid;
    private String cname;
    //关联属性
    private Set<Minister> ministers;

    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public Set<Minister> getMinisters() {
        return ministers;
    }
    public void setMinisters(Set<Minister> ministers) {
        this.ministers = ministers;
    }
}
