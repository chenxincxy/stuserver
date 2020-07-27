package com.network.good.serviceImpl;

import com.network.api.beans.Skill;
import com.network.good.service.ISkillService;
import com.network.good.mapper.SkillDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class SkillServiceImpl implements ISkillService {
    @Autowired
    SkillDao skillDao;

    @Override
    public Skill selectById(int id) {
        return skillDao.selectById(id);
    }

    @Override
    public List<Skill> selectAll() {
        return skillDao.selectAll();
    }

    @Override
    public void saveSkill(Skill skill) {
       skillDao.saveSkill(skill);
    }

    @Override
    public List<Skill> selectSkillByPage(int start, int end) {
        return skillDao.selectSkillByPage(start,end);
    }

    @Override
    public void deleteById(int id) {
        skillDao.deleteById(id);
    }

    @Override
    public void updateSkill(Skill skill) {
        skillDao.updateSkill(skill);
    }

    @Override
    public int getTotalLines() {
        return skillDao.getTotalLines();
    }

    @Override
    public List<Skill> searchSkill(int id, Date startdate, Date enddate, int start, int end) {
        List<Skill> skills=new ArrayList<>();
        if(id!=0){
            Skill skill= skillDao.selectById(id);
            skills.add(skill);
            return skills;
        }
        else {
            if(startdate!=null&&enddate!=null){
                skills=skillDao.searchByDate(startdate,enddate,start,end);
                return skills;
            }
            else if(startdate!=null){
                skills=skillDao.searchByStartDate(startdate,start,end);
                return skills;
            }
            else{
                System.out.println("end被调用-----------------");
                skills=skillDao.searchByEndDate(enddate,start,end);
                System.out.println(skills);
                return skills;
            }
        }
    }

}
