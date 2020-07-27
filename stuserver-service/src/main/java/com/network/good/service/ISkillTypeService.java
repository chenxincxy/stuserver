package com.network.good.service;

import com.network.api.beans.SkillType;

import java.util.List;

public interface ISkillTypeService {
    public SkillType selectById(int id);

    public SkillType selectByName(String name);

    public List<SkillType> selectAll();

    public void saveSkillType(SkillType type);

    public void deleteById(int id);

    public void updateSkillType(SkillType type);
}
