package com.network.good.serviceImpl;

import com.network.api.beans.Payment;
import com.network.good.service.IPaymentService;
import com.network.good.mapper.PaymentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    PaymentDao paymentDao;
    @Override
    public Payment selectById(int id) {
        return paymentDao.selectById(id);
    }

    @Override
    public Payment selectByName(String name) {
        return paymentDao.selectByName(name);
    }

    @Override
    public List<Payment> selectAll() {
        return paymentDao.selectAll();
    }

    @Override
    public void saveType(Payment payment) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void updateType(Payment payment) {

    }
}
