package com.provider.demo.entity;

import java.util.Set;

public class Minister {
    private Integer mid;
    private String mname;

    public Integer getMid() {
        return mid;
    }
    public void setMid(Integer mid) {
        this.mid = mid;
    }
    public String getMname() {
        return mname;
    }
    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }
}