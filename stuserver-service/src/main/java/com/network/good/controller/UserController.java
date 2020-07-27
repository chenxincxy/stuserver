package com.network.good.controller;

import com.network.api.beans.GLevel;
import com.network.api.beans.SLevel;
import com.network.api.beans.User;
import com.network.good.dto.UpdatePassw;
import com.network.good.dto.UpdateRes;
import com.network.good.service.IGLevelService;
import com.network.good.service.ISLevelService;
import com.network.good.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    IUserService iUserService;
    @Autowired
    IGLevelService igLevelService;
    @Autowired
    ISLevelService isLevelService;

    @ResponseBody
    @RequestMapping("/Userlist")
    public Map<String, Object> Userlist() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<User> users = iUserService.selectAll();
        if (users != null) {
            map.put("data", users);
            System.out.println(map);
            return map;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/UserlistByPage")
    public Map<String, Object> UserlistBypage(@RequestParam(value = "page") String page, @RequestParam(value = "limit") String limit) {   //商品列表页面
        Map<String, Object> map = new HashMap<String, Object>();
        //当前页
        int current = Integer.parseInt(page);
        //每页的数量
        int size = Integer.parseInt(limit);
        int start = (current - 1) * size;
        int count = iUserService.getTotalLines();
        List<User> users = iUserService.selectUsersBypage(start, size);

        if (users != null) {
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", count);
            map.put("data", users);
            return map;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/SLevellist")
    public Map<String, Object> SLevellis() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<SLevel> sLevels = isLevelService.selectAll();
        if (sLevels != null) {
            map.put("data", sLevels);
            return map;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/GLevellist")
    public Map<String, Object> GLevellist() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<GLevel> gLevels = igLevelService.selectAll();
        if (gLevels != null) {
            map.put("data", gLevels);
            return map;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/deleteUserById")
    //删除商品
    public void deleteById(@RequestParam("id") int id) {
        iUserService.deleteById(id);
        return;
    }

    //更改商品信息
    @ResponseBody
    @RequestMapping("/updateUser")
    public void updateGood(@RequestBody User user) {
        System.out.println(user);
        iUserService.updateUser(user);
    }

    //进入商品更改页
    @RequestMapping("/member-view")
    public String LogisticsView(@RequestParam("id") int id, Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = iUserService.selectById(id);
        if (user != null) {
            map.put("data", user);
            model.addAttribute("user", user);
        }
        return "member-view";
    }

    @ResponseBody
    @RequestMapping("/searchUser")
    public Map<String, Object> searchLogi(@RequestParam("id") int id, @RequestParam(value = "page") String page, @RequestParam(value = "limit") String limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("来search了-----");

        //当前页
        int current = Integer.parseInt(page);
        //每页的数量
        int size = Integer.parseInt(limit);
        int startline = (current - 1) * size;
        int count = iUserService.getTotalLines();
        User user = iUserService.searchById(id, startline, size);
        List<User> data = new ArrayList<>();
        data.add(user);
        if (data != null) {
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", count);
            map.put("data", data);
            return map;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/updatePassword")
    public UpdateRes updatePassword(@RequestBody UpdatePassw updatePassw) {
        UpdateRes updateRes = iUserService.updateUserpassw(updatePassw);
        return updateRes;
    }


    @RequestMapping("/member-password.html")

        public String userpassword () {
            return "member-password.html";
        }

}