package com.network.api.beans;

import java.math.BigDecimal;
import java.util.Date;

public class GOrder {
    private int id;  //订单编号
    private BigDecimal total;
    private int providerid;
    private int consumerid;
    private Date gddate; //下单时间
    private int gdid;//商品id
    private String orderstatus; //订单状态
    private String paymentstatus;//支付状态
    private String shipstatus;//发货状态
    private String username;
    private String userphone;
    private String useraddress;
    private User user;
    private Good good;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getProviderid() {
        return providerid;
    }

    public void setProviderid(int providerid) {
        this.providerid = providerid;
    }

    public int getConsumerid() {
        return consumerid;
    }

    public void setConsumerid(int consumerid) {
        this.consumerid = consumerid;
    }

    public Date getGddate() {
        return gddate;
    }

    public void setGddate(Date gddate) {
        this.gddate = gddate;
    }


    public int getGdid() {
        return gdid;
    }

    public void setGdid(int gdid) {
        this.gdid = gdid;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public String getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(String paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public String getShipstatus() {
        return shipstatus;
    }

    public void setShipstatus(String shipstatus) {
        this.shipstatus = shipstatus;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    @Override
    public String toString() {
        return "GOrder{" +
                "id=" + id +
                ", total=" + total +
                ", providerid=" + providerid +
                ", consumerid=" + consumerid +
                ", gddate=" + gddate +
                ", gdid=" + gdid +
                ", orderstatus='" + orderstatus + '\'' +
                ", paymentstatus='" + paymentstatus + '\'' +
                ", shipstatus='" + shipstatus + '\'' +
                ", username='" + username + '\'' +
                ", userphone='" + userphone + '\'' +
                ", useraddress='" + useraddress + '\'' +
                ", user=" + user +
                ", good=" + good +
                '}';
    }
}
