package com.network.good.controller;

import com.network.api.beans.User;
import com.network.good.service.IUserService;
import com.network.good.dto.LoginRes;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    @Autowired
    IUserService userService;

    @ResponseBody
    @RequestMapping("/loginUser")
    public LoginRes loginUser(@RequestBody User user, HttpSession session){
        int res= userService.verifyUser(user);
        LoginRes result=new LoginRes(res);
        if(result.isSuccess()){
            String name=user.getName();
            User user1=userService.selectByName(name);
            session.setAttribute("user",user1);
        }
        return result;
    }

    @RequestMapping("message.html")
    public String message(){
        return "message.html";
    }

    }



