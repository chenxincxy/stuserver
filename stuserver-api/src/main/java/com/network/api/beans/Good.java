package com.network.api.beans;

import java.math.BigDecimal;
import java.util.Date;

public class Good {
    private int id;
    private int glistid;
    private String name;
    private BigDecimal price;
    private int providerid;
    private String description;
    private Date shelfdate;
    private String picture;
    private Type type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGlistid() {
        return glistid;
    }

    public void setGlistid(int glistid) {
        this.glistid = glistid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getProviderid() {
        return providerid;
    }

    public void setProviderid(int providerid) {
        this.providerid = providerid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getShelfdate() {
        return shelfdate;
    }

    public void setShelfdate(Date shelfdate) {
        this.shelfdate = shelfdate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", glistid=" + glistid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", providerid=" + providerid +
                ", description='" + description + '\'' +
                ", shelfdate=" + shelfdate +
                ", picture='" + picture + '\'' +
                ", type=" + type +
                '}';
    }
}
