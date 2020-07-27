package com.network.good.controller;

import com.network.api.beans.Logistics;
import com.network.good.service.ILogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Map<String,Object> Logisticslist(@RequestParam(value="page") String page, @RequestParam(value="limit") String limit){   //商品列表页面
        Map<String, Object> map = new HashMap<String, Object>();
        //当前页
        int current = Integer.parseInt(page);
        //每页的数量
        int size = Integer.parseInt(limit);
        int start=(current-1)*size;
        int count=iLogisticsService.getTotalLines();
        List<Logistics> logistics = iLogisticsService.selectAllByPage(start,size);

        if (logistics!= null) {
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", count);
            map.put("data", logistics);
            return map;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/deleteLogisticsById")
    //删除商品
    public void deleteById(@RequestParam("id") int id){
        iLogisticsService.deleteById(id);
        return ;
    }

    @ResponseBody
    @RequestMapping("/saveLogistics")
    public void saveGorder(@RequestBody Logistics logistics){ //这里的这个注解！！
        iLogisticsService.saveLogistics(logistics);

    }
    //进入商品更改页
    @RequestMapping("/logistics-view")
    public String LogisticsView(@RequestParam("id") int id, Model model){
        Map<String,Object> map=new HashMap<String, Object>();
        Logistics logistics= iLogisticsService.selectById(id);
        if (logistics != null) {
            map.put("data", logistics);
            model.addAttribute("logistics",logistics);
        }
        return "logistics-view";
    }
    @ResponseBody
    @RequestMapping("/updateLogistics")
    public void updateLogistics(@RequestBody Logistics logistics){ //这里的这个注解！！
        iLogisticsService.updateLogistics(logistics);
    }
    @ResponseBody
    @RequestMapping("/searchLogi")
    public Map<String,Object> searchLogi(@RequestParam("id") int id, @RequestParam (value="page") String page, @RequestParam(value="limit") String limit){
        Map<String, Object> map = new HashMap<String, Object>();
        //当前页
        int current = Integer.parseInt(page);
        //每页的数量
        int size = Integer.parseInt(limit);
        int startline=(current-1)*size;
        int count=iLogisticsService.getTotalLines();
        List<Logistics> logistics=iLogisticsService.searchByLogiId(id,startline,size);
        if (logistics!= null) {
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", count);
            map.put("data", logistics);
            return map;
        }
        return null;
    }
}
