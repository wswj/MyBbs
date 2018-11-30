package com.wj.pojo;

import java.util.Date;

public class Article2 {
    private Integer fid;

    private String titles;

    private String fcontent;

    private String bname;

    private Date time;

    private Integer userid;

    private String username;

    private Integer status;

    public Article2() {
        super();
    }

    public Article2(Integer fid, String titles, String fcontent, String bname,Date time, Integer userid,
                    String username, Integer status) {
        super();
        this.fid = fid;
        this.titles = titles;
        this.fcontent = fcontent;
        this.bname = bname;
        this.time = time;
        this.userid = userid;
        this.username = username;
        this.status = status;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles == null ? null : titles.trim();
    }

    public String getFcontent() {
        return fcontent;
    }

    public void setFcontent(String fcontent) {
        this.fcontent = fcontent == null ? null : fcontent.trim();
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
