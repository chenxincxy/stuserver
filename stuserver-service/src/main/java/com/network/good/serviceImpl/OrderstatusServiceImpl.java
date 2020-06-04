package com.network.good.serviceImpl;

import com.network.api.beans.GOrderstatus;
import com.network.api.service.IGOrderstatusService;
import com.network.good.mapper.GOrderstatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderstatusServiceImpl implements IGOrderstatusService {

    @Autowired
    GOrderstatusDao gOrderstatusDao;

    @Override
    public GOrderstatus selectById(int id) {
        return gOrderstatusDao.selectById(id);
    }

    @Override
    public GOrderstatus selectByName(String name) {
        return gOrderstatusDao.selectByName(name);
    }

    @Override
    public List<GOrderstatus> selectAll() {
        return gOrderstatusDao.selectAll();
    }

    @Override
    public void saveType(GOrderstatus gOrderstatus) {


    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void updateType(GOrderstatus gOrderstatus) {

    }
}
