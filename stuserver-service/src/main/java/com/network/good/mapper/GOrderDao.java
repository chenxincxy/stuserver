package com.network.good.mapper;

import com.network.api.beans.GOrder;

import java.util.List;

public interface GOrderDao {
    public GOrder selectById(int id);


    public List<GOrder> selectAll();

    public boolean saveGOrder(GOrder order);

    public boolean deleteById(int id);

    public boolean updateGOrder(GOrder order);

    public List<GOrder> selectOrdersByPage(int start,int end);

    public int getTotalLines();
}
