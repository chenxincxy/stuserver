package com.network.api.service;

import com.network.api.beans.GOrderstatus;

import java.util.List;

public interface IGOrderstatusService {
    public GOrderstatus selectById(int id);

    public GOrderstatus selectByName(String name);

    public List<GOrderstatus> selectAll();

    public void saveType(GOrderstatus gOrderstatus);

    public void deleteById(int id);

    public void updateType(GOrderstatus gOrderstatus);
}
