package com.network.good.serviceImpl;


import com.network.api.beans.Type;
import com.network.good.service.ITypeService;
import com.network.good.mapper.TypeDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements ITypeService {
    @Autowired
    TypeDao typeDao;

    @Override
    public Type selectById(int id) {
        return typeDao.selectById(id);
    }

    @Override
    public Type selectByName(@Param("name") String name) {
        return typeDao.selectByName(name);
    }

    @Override
    public List<Type> selectAll() {
        return typeDao.selectAll();
    }

    @Override
    public boolean saveType(Type type) {
        if(typeDao.selectById(type.getId())==null){
            typeDao.saveType(type);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        if(typeDao.selectById(id)!=null){
            typeDao.deleteById(id);
        }
        return false;
    }

    @Override
    public boolean updateType(Type type) {
        if(typeDao.selectById(type.getId())!=null){
            typeDao.updateType(type);
        }
        return false;
    }
}
