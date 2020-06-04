package com.network.good.serviceImpl;

import com.network.api.beans.Logistics;
import com.network.api.service.ILogisticsService;
import com.network.good.mapper.LogisticsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogisticsServiceImpl implements ILogisticsService {
    @Autowired
    LogisticsDao logisticsDao;
    @Override
    public Logistics selectById(int id) {
        return logisticsDao.selectById(id);
    }

    @Override
    public Logistics selectByName(String name) {
        return logisticsDao.selectByName(name);
    }

    @Override
    public List<Logistics> selectAll() {
        return logisticsDao.selectAll();
    }

    @Override
    public void saveType(Logistics logistics) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void updateType(Logistics logistics) {

    }
}
