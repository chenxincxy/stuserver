package com.network.good.serviceImpl;

import com.network.StuserverServiceApplication;
import com.network.api.beans.GOrder;
import com.network.good.service.IGOrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)

@SpringBootTest(classes = StuserverServiceApplication.class)

class GOrderServiceImplTest {
    @Autowired
    IGOrderService igOrderService;
    @Test
    public void testSave(){
        GOrder gOrder=new GOrder();
        gOrder.setGdid(39);
        gOrder.setUsername("dasdasda");
        gOrder.setUserphone("12345678910");
        gOrder.setUseraddress("银滩");
        gOrder.setOrderstatus("已取消");
        gOrder.setPaymentstatus("货到付款");
       igOrderService.saveGOrder(gOrder);


    }
 @Test
    public void testSelectOne(){
       GOrder order= igOrderService.selectById(1);
       System.out.println(order);
 }
    @Test
    public void testSelectAll(){
        igOrderService.selectAll();
    }

    @Test
    public void testUpdate(){
        GOrder order=igOrderService.selectById(7);
        order.setUsername("李青桐");
        order.setUserphone("15577931180");



    }
}