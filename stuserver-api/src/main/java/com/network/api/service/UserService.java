package com.network.api.service;

import com.network.api.beans.TUser;

public interface UserService {
    TUser login(String username,String password);
}
