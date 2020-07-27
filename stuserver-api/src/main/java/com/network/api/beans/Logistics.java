package com.network.api.beans;

import java.math.BigDecimal;
import java.util.Date;

public class Logistics {
    private int id;
    private String name;
    private BigDecimal fee;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private String remarks;
    private Date Deliverytime;
    private int gorderid;
    private GOrder gOrder;

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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public int getGorderid() {
        return gorderid;
    }

    public void setGorderid(int gorderid) {
        this.gorderid = gorderid;
    }

    public GOrder getgOrder() {
        return gOrder;
    }

    public void setgOrder(GOrder gOrder) {
        this.gOrder = gOrder;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getDeliverytime() {
        return Deliverytime;
    }

    public void setDeliverytime(Date Deliverytime) {
        Deliverytime = Deliverytime;
    }

    @Override
    public String toString() {
        return "Logistics{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fee=" + fee +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", remarks='" + remarks + '\'' +
                ", Deliverytime=" + Deliverytime +
                ", gorderid=" + gorderid +
                ", gOrder=" + gOrder +
                '}';
    }
}
