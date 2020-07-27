package com.network.good.mapper;

import com.network.api.beans.SLevel;

import java.util.List;

public interface SLevelDao {
    public SLevel selectById(int id);

    public SLevel selectByName(String name);

    public List<SLevel> selectAll();
}
