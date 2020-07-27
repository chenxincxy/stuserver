package com.network.good.serviceImpl;

import com.network.api.beans.SLevel;
import com.network.good.service.ISLevelService;
import com.network.good.mapper.SLevelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SLevelServiceImpl implements ISLevelService {
    @Autowired
    SLevelDao sLevelDao;
    @Override
    public SLevel selectById(int id) {
        return sLevelDao.selectById(id);
    }

    @Override
    public SLevel selectByName(String name) {
        return sLevelDao.selectByName(name);
    }

    @Override
    public List<SLevel> selectAll() {
        return sLevelDao.selectAll();
    }
}
