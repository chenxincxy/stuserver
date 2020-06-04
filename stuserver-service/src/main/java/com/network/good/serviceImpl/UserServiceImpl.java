package com.network.good.serviceImpl;

import com.network.api.beans.User;
import com.network.api.service.IUserService;
import com.network.good.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserDao userDao;
    @Override
    public User selectById(int id) {
        return userDao.selectById(id);
    }

    @Override
    public User selectByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public boolean deleteById(int id) {
        if(userDao.selectById(id)!=null){
            userDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }
}
