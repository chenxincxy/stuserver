package com.network.good.service;

import com.network.api.beans.SLevel;

import java.util.List;

public interface ISLevelService {
    public SLevel selectById(int id);

    public SLevel selectByName(String name);

    public List<SLevel> selectAll();
}
