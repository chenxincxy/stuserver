package com.network.good.serviceImpl;

import com.network.api.beans.GOrder;
import com.network.api.beans.Good;
import com.network.api.beans.Logistics;
import com.network.api.beans.User;
import com.network.api.service.IGOrderService;
import com.network.good.mapper.GOrderDao;
import com.network.good.mapper.GoodDao;
import com.network.good.mapper.LogisticsDao;
import com.network.good.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
        if(gOrderDao.selectById(order.getId())==null){
            //插入订单详情表
            int userid=3;//之后会从前台接到要更改这里
            int providerid=1; //根据其它接口传过来，之后要改
            order.setProviderid(providerid);
            order.setConsumerid(userid);
            int goodid=order.getGdid();
            String logisticsName=order.getLogistics();
            Logistics logistics =logisticsDao.selectByName(logisticsName);
            Good good=goodDao.selectById(goodid);
            BigDecimal fee=logistics.getFee();
            BigDecimal goodfee=good.getPrice();
            BigDecimal total=fee.add(goodfee);//订单总金额
            order.setTotal(total);
            gOrderDao.saveGOrder(order);

            //插入物流明细表
            logistics.setReceivername(order.getUsername());
            logistics.setReceiverPhone(order.getUserphone());
            logistics.setReceiverAddress(order.getUseraddress());
            logisticsDao.saveLogistics(logistics);

            return true;
        }
         return false;
    }

    @Override
    public boolean deleteById(int id) {
        if(gOrderDao.selectById(id)!=null){
            gOrderDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateGOrder(GOrder order) {
        if(gOrderDao.selectById(order.getId())!=null){
            gOrderDao.updateGOrder(order);
            return true;
        }
        return false;
    }

    @Override
    public List<GOrder> selectOrdersByPage(int start, int end) {
       List<GOrder> orders= gOrderDao.selectOrdersByPage(start,end);
        return orders;
    }

    @Override
    public int getTotalLines() {
        return gOrderDao.getTotalLines();
    }
}
