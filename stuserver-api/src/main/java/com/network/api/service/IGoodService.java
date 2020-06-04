package com.network.api.service;



import com.network.api.beans.Good;


import java.util.Date;
import java.util.List;

public interface IGoodService {
    public Good selectById(int id);
    public List<Good> selectAll();
    public boolean saveGood(Good good);
    public boolean deleteById(int id);
    public boolean updateGood(Good good);
    public int getTotalLines();
    public List<Good> selectGoodsByPage(int start, int end);
    public List<Good> selectGoodByDate(Date startdate, Date enddate, int glistid);
    public List<Good> selectGoodByDateAndTypeidAndPage(Date startdate,Date enddate,int glistid,int start,int end);
    public List<Good> selectGoodByTypeidAndPage(int glistid,int start,int end);
    public List<Good> selectGoodByDateAndPage(Date startdate,Date enddate,int start,int end);

}
