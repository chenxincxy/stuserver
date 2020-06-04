package com.network.good.mapper;

import com.network.api.beans.Payment;

import java.util.List;

public interface PaymentDao {
    public Payment selectById(int id);

    public Payment selectByName(String name);

    public List<Payment> selectAll();

    public void saveType(Payment payment);

    public void deleteById(int id);

    public void updateType(Payment payment);
}
