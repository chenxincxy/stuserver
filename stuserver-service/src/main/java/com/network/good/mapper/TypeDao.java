package com.network.good.mapper;



import com.network.api.beans.Type;

import java.util.List;

public interface TypeDao {

    public Type selectById(int id);

    public Type selectByName(String name);

    public List<Type> selectAll();

    public void saveType(Type type);

    public void deleteById(int id);

    public void updateType(Type type);

}
