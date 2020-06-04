package com.network.good.controller;

import com.network.api.beans.User;
import com.network.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    IUserService iUserService;
    @ResponseBody
    @RequestMapping("/Userlist")
    public Map<String,Object> goodlist(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<User> users = iUserService.selectAll();
        if(users!=null){
            map.put("data",users);
            System.out.println(map);
            return map;
        }
        return null;
    }
}
