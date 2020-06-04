package com.network.good.controller;


import com.network.api.beans.GOrder;
import com.network.api.beans.GOrderstatus;
import com.network.api.beans.Logistics;
import com.network.api.beans.Payment;

import com.network.api.service.IGOrderService;
import com.network.api.service.IGOrderstatusService;
import com.network.api.service.ILogisticsService;
import com.network.api.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GOrderController {
    @Autowired
    IGOrderService igOrderService;
    @Autowired
    IPaymentService iPaymentService;
    @Autowired
    ILogisticsService iLogisticsService;
    @Autowired
    IGOrderstatusService igOrderstatusService;

    @ResponseBody
    @RequestMapping("/GOrderlist")
    public Map<String,Object> goodlist(@RequestParam (value="page") String page, @RequestParam(value="limit") String limit){   //商品列表页面
        Map<String, Object> map = new HashMap<String, Object>();
        //当前页
        int current = Integer.parseInt(page);
        //每页的数量
        int size = Integer.parseInt(limit);
        int start=(current-1)*size;
        int count=igOrderService.getTotalLines();
        List<GOrder> orders = igOrderService.selectOrdersByPage(start,size);

        if (orders!= null) {
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", count);
            map.put("data", orders);
            System.out.println(map);
            return map;
        }
        return null;
    }
    @ResponseBody
    @RequestMapping("/saveGOrder")
    public void saveGorder(GOrder gOrder){
        igOrderService.saveGOrder(gOrder);

    }

    @ResponseBody
    @RequestMapping("/deleteGOrderById")
    //删除商品
    public void deleteById(@RequestParam("id") int id){
        igOrderService.deleteById(id);
        System.out.println("我正在删除");
        return ;
    }
    //支付方式列表
    @ResponseBody
    @RequestMapping("/Paymentlist")
    public Map<String,Object> paymentlist(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Payment> payments = iPaymentService.selectAll();
        if(payments!=null){
            map.put("data",payments);
            System.out.println(map);
            return map;
        }
        return null;
    }

    //订单状态列表
    @ResponseBody
    @RequestMapping("/GOrderstatuslist")
    public Map<String,Object> typelist(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<GOrderstatus> gOrderstatuses = igOrderstatusService.selectAll();
        if(gOrderstatuses!=null){
            map.put("data",gOrderstatuses);
            System.out.println(map);
            return map;
        }
        return null;
    }




}
