package com.network.api.service;

import com.network.api.beans.Logistics;

import java.util.List;

public interface ILogisticsService {
    public Logistics selectById(int id);

    public Logistics selectByName(String name);

    public List<Logistics> selectAll();

    public void saveType(Logistics logistics);

    public void deleteById(int id);

    public void updateType(Logistics logistics);
}
