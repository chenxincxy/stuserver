package com.network.good.serviceImpl;


import com.network.api.beans.Good;
import com.network.api.service.IGoodService;
import com.network.good.mapper.GoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodServiceImpl implements IGoodService {

    @Autowired
    GoodDao goodDao;

    @Override
    public Good selectById(int id) {
        return goodDao.selectById(id);
    }

    @Override
    public List<Good> selectAll() {
        return  goodDao.selectAll();
    }

    @Override
    public boolean saveGood(Good good) {
        if(goodDao.selectById(good.getId())==null){
            goodDao.saveGood(good);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        if(goodDao.selectById(id)!=null){
            goodDao.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean updateGood(Good good) {
        if(goodDao.selectById(good.getId())!=null){
            goodDao.updateGood(good);
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public int getTotalLines() {
        return goodDao.getTotalLines();
    }

    @Override
    public List<Good> selectGoodsByPage(int start, int end) {
        List<Good> goods=goodDao.selectGoodsByPage(start,end);
        return goods;
    }

    @Override
    public List<Good> selectGoodByDate(Date startdate, Date enddate, int glistid) {
        List<Good> goods=goodDao.selectGoodByDate(startdate,enddate,glistid);
        return goods;
    }
    @Override
    public List<Good> selectGoodByDateAndTypeidAndPage(Date startdate, Date enddate, int glistid, int start, int end) {
        List<Good> goods=goodDao.selectGoodByDateAndTypeidAndPage(startdate,enddate,glistid,start,end);
        return goods;
    }

    @Override
    public List<Good> selectGoodByTypeidAndPage(int glistid, int start, int end) {
        List<Good> goods=goodDao.selectGoodByTypeidAndPage(glistid,start,end);
        return goods;
    }

    @Override
    public List<Good> selectGoodByDateAndPage(Date startdate, Date enddate, int start, int end) {
        List<Good> goods=goodDao.selectGoodByDateAndPage(startdate,enddate,start,end);
        return goods;
    }



}
