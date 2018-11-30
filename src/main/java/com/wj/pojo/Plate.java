package com.wj.pojo;

import java.util.Date;

public class Plate {
    private static final long serialVersionUID = 1L;
    private Integer bid;

    private String bname;

    private Date btime;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public Date getBtime() {
        return btime;
    }

    public void setBtime(Date btime) {
        this.btime = btime;
    }
}