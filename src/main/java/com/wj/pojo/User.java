package com.wj.pojo;

import java.util.Date;

public class User {
    private Integer userid;

    private String name;

    private Integer age;

    private String sex;

    private String password;

    private String email;

    private String family;

    private String intro;

    private Date time;

    private String userphoto;

    private int attcount;
    public User() {
      super();
   }

    public User(Integer userid, String name, Integer age, String sex, String password, String email, String family,
                String intro, Date time) {
       super();
        this.userid = userid;
       this.name = name;
        this.age = age;
        this.sex = sex;
        this.password = password;
        this.email = email;
        this.family = family;
        this.intro = intro;
        this.time = time;
    }


    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family == null ? null : family.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    public void setAttcount(int attcount){this.attcount=attcount;}
    public int getAttcount(){return attcount;}
}