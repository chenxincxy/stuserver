package com.network.good.service;

import com.network.api.beans.GLevel;

import java.util.List;

public interface IGLevelService {
    public GLevel selectById(int id);

    public GLevel selectByName(String name);

    public List<GLevel> selectAll();
}
