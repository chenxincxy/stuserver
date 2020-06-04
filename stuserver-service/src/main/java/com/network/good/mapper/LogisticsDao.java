package com.network.good.mapper;

import com.network.api.beans.Logistics;

import java.util.List;

public interface LogisticsDao {
    public Logistics selectById(int id);

    public Logistics selectByName(String name);

    public List<Logistics> selectAll();

    public void saveLogistics(Logistics logistics);

    public void deleteById(int id);

    public void updateLogistics(Logistics logistics);
}
