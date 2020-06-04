package com.network.api.service;

import com.network.api.beans.User;

import java.util.List;

public interface IUserService {
    public User selectById(int id);

    public User selectByName(String name);

    public boolean deleteById(int id);

    public List<User> selectAll();
}
