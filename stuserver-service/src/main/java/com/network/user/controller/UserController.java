package com.network.user.controller;

import com.network.api.beans.TUser;
import com.network.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password) {
        TUser test = userService.login(username, password);
        System.out.println(test);
        if (null != test) {
            return "登录成功！";
        }
        return "登录失败！";

    }

}
