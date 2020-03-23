package com.network.user.serviceImpl;

import com.network.api.beans.TUser;
import com.network.api.service.UserService;
import com.network.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public TUser login(String username, String password) {
        return userMapper.login(username, password);
    }
}
