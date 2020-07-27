package com.network.good.serviceImpl;

import com.network.api.beans.GOrder;
import com.network.api.beans.Logistics;
import com.network.good.service.ILogisticsService;
import com.network.good.mapper.GOrderDao;
import com.network.good.mapper.LogisticsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LogisticsServiceImpl implements ILogisticsService {

    @Autowired
    GOrderDao gOrderDao;
    @Autowired
    LogisticsDao logisticsDao;

    @Override
    public Logistics selectById(int id) {
        return logisticsDao.selectById(id);
    }

    @Override
    public List<Logistics> selectAll() {
        return logisticsDao.selectAll();
    }

    @Override
    public List<Logistics> selectAllByPage(int start, int end) {
        return logisticsDao.selectAllByPage(start, end);
    }

    @Override
    public List<Logistics> searchByLogiId(int id, int start, int end) {
        return logisticsDao.searchByLogiId(id,start,end);
    }

    @Override
    public int getTotalLines() {
        return logisticsDao.getTotalLines();
    }

    @Override
    public boolean saveLogistics(Logistics logistics) {
        int orderid=logistics.getGorderid();
        GOrder gOrder=gOrderDao.selectById(orderid);
        BigDecimal fee=logistics.getFee();
        BigDecimal total=fee.add(gOrder.getTotal());
        gOrder.setTotal(total);
        gOrder.setShipstatus("已发货");
        logistics.setgOrder(gOrder);
        gOrderDao.updateByLogi(gOrder);
        logisticsDao.saveLogistics(logistics);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        if(logisticsDao.selectById(id)!=null) {
            logisticsDao.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public boolean updateLogistics(Logistics logistics) {
        int id=logistics.getId();
        int gorderid=logistics.getGorderid();
        GOrder gOrder=gOrderDao.selectById(gorderid);
        Logistics logistics1=logisticsDao.selectById(id);
        if(logistics1!=null) {
            BigDecimal oldfee=logistics1.getFee();
            BigDecimal newfee=logistics.getFee();
            if(!oldfee.equals(newfee)){
                BigDecimal oldtotal=gOrder.getTotal();
                BigDecimal sourcetotal=oldtotal.subtract(oldfee);
                BigDecimal total=newfee.add(sourcetotal);
                gOrder.setTotal(total);
                gOrder.setShipstatus("已发货");
                gOrderDao.updateByLogi(gOrder);
            }
            logisticsDao.updateLogistics(logistics);
            return true;
        }
        return false;
    }
}
