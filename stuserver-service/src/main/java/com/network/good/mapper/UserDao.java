package com.network.good.mapper;

import com.network.api.beans.User;

import java.util.List;

public interface UserDao {
    public User selectById(int id);

    public User selectByName(String name);

    public boolean deleteById(int id);

    public List<User> selectAll();


}
