package com.network.api.service;

import com.network.api.beans.GOrder;
import com.network.api.beans.Good;

import java.util.List;

public interface IGOrderService {
    public GOrder selectById(int id);


    public List<GOrder> selectAll();

    public boolean saveGOrder(GOrder order);

    public boolean deleteById(int id);

    public boolean updateGOrder(GOrder order);

    public List<GOrder> selectOrdersByPage(int start,int end);

    public int getTotalLines();

}
