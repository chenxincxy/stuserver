package com.network.api.beans;

import java.math.BigDecimal;
import java.util.Date;

public class Skill {
    private int id;
    private int slistid;
    private String name;
    private String description;
    private BigDecimal price;
    private int providerid;
    private Date shelfdate;
    private int favorablenumber;
    private int purchasenumber;
    private String picture;
    private SkillType skillType;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSlistid() {
        return slistid;
    }

    public void setSlistid(int slistid) {
        this.slistid = slistid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getShelfdate() {
        return shelfdate;
    }

    public void setShelfdate(Date shelfdate) {
        this.shelfdate = shelfdate;
    }

    public int getFavorablenumber() {
        return favorablenumber;
    }

    public void setFavorablenumber(int favorablenumber) {
        this.favorablenumber = favorablenumber;
    }

    public int getPurchasenumber() {
        return purchasenumber;
    }

    public void setPurchasenumber(int purchasenumber) {
        this.purchasenumber = purchasenumber;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", slistid=" + slistid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", providerid=" + providerid +
                ", shelfdate=" + shelfdate +
                ", favorablenumber=" + favorablenumber +
                ", purchasenumber=" + purchasenumber +
                ", picture='" + picture + '\'' +
                '}';
    }
}
