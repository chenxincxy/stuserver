package com.network.good.service;

import com.network.api.beans.User;
import com.network.good.dto.UpdatePassw;
import com.network.good.dto.UpdateRes;

import java.util.List;

public interface IUserService {
    public User selectById(int id);

    public User selectByName(String name);

    public boolean deleteById(int id);
    public User searchById(int id,int start,int end);

    public int getTotalLines();

    public List<User> selectAll();

    public List<User> selectUsersBypage(int start,int end);

    public boolean updateUser(User user);

    public int verifyUser(User user);

    public User message(int id);

    public UpdateRes updateUserpassw(UpdatePassw updatePassw);
}
