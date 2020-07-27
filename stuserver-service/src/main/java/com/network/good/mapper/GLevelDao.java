package com.network.good.mapper;

import com.network.api.beans.GLevel;

import java.util.List;

public interface GLevelDao {
    public GLevel selectById(int id);

    public GLevel selectByName(String name);

    public List<GLevel> selectAll();
}
