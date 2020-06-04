package com.network.api.beans;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String password;
    private String address;
    private String phone;
    private Date birthday;
    private String status;
    private String picture;
    private String school;
    private String major;
    private int slevelid;
    private int glevelid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSlevelid() {
        return slevelid;
    }

    public void setSlevelid(int slevelid) {
        this.slevelid = slevelid;
    }

    public int getGlevelid() {
        return glevelid;
    }

    public void setGlevelid(int glevelid) {
        this.glevelid = glevelid;
    }
}
