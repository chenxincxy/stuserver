package com.network.good.mapper;

import com.network.api.beans.GOrder;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface GOrderDao {
    public GOrder selectById(int id);

    public List<GOrder> selectAll();

    public boolean saveGOrder(GOrder order);

    public boolean deleteById(int id);

    public boolean updateGOrder(GOrder order);

    public void updateByLogi(GOrder order);

    public List<GOrder> selectOrdersByPage(@Param("start")int start, @Param("end")int end);

    public int getTotalLines();

    public List<GOrder> searchByStartDate(@Param("startdate")Date startdate,@Param("start")int start, @Param("end")int end);

    public List<GOrder> searchByEndDate(@Param("enddate")Date enddate,@Param("start")int start, @Param("end")int end);

    public List<GOrder> searchByDate(@Param("startdate")Date startdate,@Param("enddate")Date enddate,@Param("start")int start, @Param("end")int end);



}

