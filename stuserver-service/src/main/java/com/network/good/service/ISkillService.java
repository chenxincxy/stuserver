package com.network.good.service;

import com.network.api.beans.Skill;

import java.util.Date;
import java.util.List;

public interface ISkillService {
    public Skill selectById(int id);

    public List<Skill> selectAll();

    public void saveSkill(Skill skill);

    public List<Skill> selectSkillByPage(int start, int end);

    public void deleteById(int id);

    public void updateSkill(Skill skill);

    public int getTotalLines();

    public List<Skill> searchSkill(int id, Date startdate, Date enddate,int startline,int endline);

}
