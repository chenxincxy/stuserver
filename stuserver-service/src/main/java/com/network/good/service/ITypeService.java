package com.network.good.service;



import com.network.api.beans.Type;

import java.util.List;

public interface ITypeService {
    public Type selectById(int id);

    public Type selectByName(String name);

    public List<Type> selectAll();

    public boolean saveType(Type type);

    public boolean deleteById(int id);

    public boolean updateType(Type type);
}
