package com.network.good.mapper;

import com.network.api.beans.GOrderstatus;

import java.util.List;

public interface GOrderstatusDao {
    public GOrderstatus selectById(int id);

    public GOrderstatus selectByName(String name);

    public List<GOrderstatus> selectAll();

    public void saveType(GOrderstatus gOrderstatus);

    public void deleteById(int id);

    public void updateType(GOrderstatus gOrderstatus);
}
