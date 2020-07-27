package com.network.good.serviceImpl;

import com.network.api.beans.SkillType;
import com.network.good.service.ISkillTypeService;
import com.network.good.mapper.SkillTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SkillTypeServiceImpl implements ISkillTypeService {
    @Autowired
    SkillTypeDao skillTypeDao;
    @Override
    public SkillType selectById(int id) {
        return skillTypeDao.selectById(id);
    }

    @Override
    public SkillType selectByName(String name) {
        return skillTypeDao.selectByName(name);
    }

    @Override
    public List<SkillType> selectAll() {
        return skillTypeDao.selectAll();
    }

    @Override
    public void saveSkillType(SkillType type) {
         skillTypeDao.saveSkillType(type);
    }

    @Override
    public void deleteById(int id) {
        skillTypeDao.deleteById(id);
    }

    @Override
    public void updateSkillType(SkillType type) {
        skillTypeDao.updateSkillType(type);
    }
}
