package com.network.good.service;

import com.network.api.beans.Logistics;

import java.util.List;

public interface ILogisticsService {
    public Logistics selectById(int id);

    public List<Logistics> selectAll();

    public List<Logistics> selectAllByPage(int start,int end);
    public List<Logistics> searchByLogiId(int id,int start,int end);
    public int getTotalLines();
    public boolean saveLogistics(Logistics logistics);

    public boolean deleteById(int id);

    public boolean updateLogistics(Logistics logistics);
}
