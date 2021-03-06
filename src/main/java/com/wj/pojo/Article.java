package com.wj.pojo;

import java.util.Date;

public class Article {
    private Integer fid;

    private String titles;

    private String fcontent;

    private String photo;

    private String bname;

    private Date time;

    private Integer userid;

    private String username;

    private Integer status;
    private String sum;

    private String userphoto;
    public void setSum(String sum){
        this.sum=sum;
    }
    public String getSum(){
        return sum;
    }
    public void setUserphoto(String userphoto){
        this.userphoto=userphoto;
    }
    public String getUserphoto(){
        return userphoto;
    }
    public Article() {
        super();
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
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
    public Article(Article2 article2,String photo) {
        super();
        this.fid = article2.getFid();
        this.titles = article2.getTitles();
        this.fcontent = article2.getFcontent();
        this.bname = article2.getBname();
        this.time = article2.getTime();
        this.userid = article2.getUserid();
        this.username = article2.getUsername();
        this.status = article2.getStatus();
        this.photo = photo;
    }
}