package com.network.good.mapper;


import com.network.api.beans.Good;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface GoodDao {
    public Good selectById(int id);

    public List<Good> selectAll();

    public void saveGood(Good good);

    public void deleteById(int id);

    public void updateGood(Good good);

    public int getTotalLines();

    public List<Good> selectGoodsByPage(@Param("start") int start, @Param("end") int end);

    public List<Good> selectGoodByDate(@Param("startdate") Date startdate, @Param("enddate") Date enddate, @Param("glistid") int glistid);
    public List<Good> selectGoodByDateAndTypeidAndPage(@Param("startdate") Date startdate, @Param("enddate")Date enddate, @Param("glistid") int glistid, @Param("start")int start, @Param("end") int end);

    public List<Good> selectGoodByTypeidAndPage(@Param("glistid") int glistid,@Param("start")int start,@Param("end") int end);

    public List<Good> selectGoodByDateAndPage(@Param("startdate") Date startdate,@Param("enddate")Date enddate,@Param("start")int start,@Param("end") int end);

}
