package com.network.good.serviceImpl;

import com.network.api.beans.GOrder;
import com.network.api.beans.Good;
import com.network.good.service.IGOrderService;
import com.network.good.mapper.GOrderDao;
import com.network.good.mapper.GoodDao;
import com.network.good.mapper.LogisticsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GOrderServiceImpl implements IGOrderService {

    @Autowired

    GOrderDao gOrderDao;

    @Autowired
    LogisticsDao logisticsDao;

    @Autowired
    GoodDao goodDao;


    @Override
    public GOrder selectById(int id) {
        return gOrderDao.selectById(id);
    }

    @Override
    public List<GOrder> selectAll() {
        return gOrderDao.selectAll();
    }

    @Override
    public boolean saveGOrder(GOrder order) {
        //我现在的问题！插入成功才能生成订单编号，否则订单编号为0
        //插入订单详情表
        int userid = 3;//之后会从前台接到要更改这里
        int providerid = 1; //根据其它接口传过来，之后要改
        order.setProviderid(providerid);
        order.setShipstatus("未发货");

        order.setConsumerid(userid);
        int goodid = order.getGdid();
        System.out.println(goodid);
        Good good = goodDao.selectById(goodid);
        BigDecimal goodfee = good.getPrice();
        order.setTotal(goodfee);
        gOrderDao.saveGOrder(order);

        return true;

    }

    @Override
    public boolean deleteById(int id) {
        if (gOrderDao.selectById(id) != null) {
            gOrderDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateGOrder(GOrder order) {

        gOrderDao.updateGOrder(order);
        return true;
    }

    @Override
    public void updateByLogi(GOrder order) {
        gOrderDao.updateByLogi(order);
    }

    @Override
    public List<GOrder> selectOrdersByPage(int start, int end) {
        List<GOrder> orders = gOrderDao.selectOrdersByPage(start, end);
        return orders;
    }

    @Override
    public int getTotalLines() {
        return gOrderDao.getTotalLines();
    }

    @Override
    public List<GOrder> searchGOrder(int id, Date startdate, Date enddate,int start,int end) {
        List<GOrder> gOrders=new ArrayList<>();
        if(id!=0){
           GOrder gOrder= gOrderDao.selectById(id);
           gOrders.add(gOrder);
           return gOrders;
        }
        else {
            if(startdate!=null&&enddate!=null){
                gOrders=gOrderDao.searchByDate(startdate,enddate,start,end);
                return gOrders;
            }
            else if(startdate!=null){
                gOrders=gOrderDao.searchByStartDate(startdate,start,end);
                return gOrders;
            }
            else{
                System.out.println("end被调用-----------------");
                gOrders=gOrderDao.searchByEndDate(enddate,start,end);
                System.out.println(gOrders);
                return gOrders;
            }
        }

    }


}
