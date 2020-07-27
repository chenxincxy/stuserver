package com.network.good.mapper;

import com.network.api.beans.Logistics;

import java.util.List;

public interface LogisticsDao {
    public Logistics selectById(int id);


    public List<Logistics> selectAll();

    public List<Logistics> selectAllByPage(int start,int end);

    public List<Logistics> searchByLogiId(int id,int start,int end);

    public int getTotalLines();

    public void saveLogistics(Logistics logistics);

    public void deleteById(int id);

    public void updateLogistics(Logistics logistics);
}
