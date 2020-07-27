package com.network.good.mapper;

import com.network.api.beans.Skill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SkillDao {
    public Skill selectById(int id);

    public List<Skill> selectAll();

    public List<Skill> selectSkillByPage(@Param("start")int start, @Param("end")int end);

    public void saveSkill(Skill skill);

    public void deleteById(int id);

    public void updateSkill(Skill skill);

    public int getTotalLines();

    public List<Skill> searchByStartDate(@Param("startdate")Date startdate,@Param("start")int start, @Param("end")int end);

    public List<Skill> searchByEndDate(@Param("enddate")Date enddate,@Param("start")int start, @Param("end")int end);

    public List<Skill> searchByDate(@Param("startdate")Date startdate,@Param("enddate")Date enddate,@Param("start")int start, @Param("end")int end);

}
