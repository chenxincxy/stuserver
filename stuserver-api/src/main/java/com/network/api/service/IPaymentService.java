package com.network.api.service;

import com.network.api.beans.Payment;

import java.util.List;

public interface IPaymentService {
    public Payment selectById(int id);

    public Payment selectByName(String name);

    public List<Payment> selectAll();

    public void saveType(Payment payment);

    public void deleteById(int id);

    public void updateType(Payment payment);
}
