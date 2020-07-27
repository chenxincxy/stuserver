package com.network.good.serviceImpl;

import com.network.api.beans.GLevel;
import com.network.good.service.IGLevelService;
import com.network.good.mapper.GLevelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GLevelServiceImpl implements IGLevelService {
    @Autowired
    GLevelDao gLevelDao;
    @Override
    public GLevel selectById(int id) {
        return gLevelDao.selectById(id);
    }

    @Override
    public GLevel selectByName(String name) {
        return gLevelDao.selectByName(name);
    }

    @Override
    public List<GLevel> selectAll() {
        return gLevelDao.selectAll();
    }
}
