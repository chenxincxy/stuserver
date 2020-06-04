package com.network.good.controller;

import com.network.api.beans.Logistics;
import com.network.api.service.ILogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LogisticsController {
    @Autowired
    ILogisticsService iLogisticsService;

    //物流选择列表
    @ResponseBody
    @RequestMapping("/Logisticslist")
    public Map<String,Object> Logistcislist(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Logistics> logistics = iLogisticsService.selectAll();
        if(logistics!=null){
            map.put("data",logistics);
            System.out.println(map);
            return map;
        }
        return null;
    }
}
