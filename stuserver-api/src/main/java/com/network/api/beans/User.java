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
    private String IDcard;
    private String email;
    private String slevelName;
    private String glevelName;

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



    public String getSlevelName() {
        return slevelName;
    }

    public void setSlevelName(String slevelName) {
        this.slevelName = slevelName;
    }

    public String getGlevelName() {
        return glevelName;
    }

    public void setGlevelName(String glevelName) {
        this.glevelName = glevelName;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", status='" + status + '\'' +
                ", picture='" + picture + '\'' +
                ", school='" + school + '\'' +
                ", major='" + major + '\'' +
                ", IDcar='" + IDcard + '\'' +
                ", email='" + email + '\'' +
                ", slevelName='" + slevelName + '\'' +
                ", glevelName='" + glevelName + '\'' +
                '}';
    }
}
