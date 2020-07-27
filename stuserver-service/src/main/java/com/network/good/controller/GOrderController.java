package com.network.good.controller;


import com.network.api.beans.GOrder;
import com.network.api.beans.GOrderstatus;
import com.network.api.beans.Payment;

import com.network.good.service.IGOrderService;
import com.network.good.service.IGOrderstatusService;
import com.network.good.service.ILogisticsService;
import com.network.good.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

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

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @ResponseBody
    @RequestMapping("/GOrderlist")
    public Map<String,Object> gorderlistBypage(@RequestParam (value="page") String page, @RequestParam(value="limit") String limit){   //商品列表页面
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
            return map;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/GodersAll")
    public Map<String,Object> gorderlist(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<GOrder> goods = igOrderService.selectAll();
        if(goods!=null){
            map.put("data",goods);
            return map;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/saveGOrder")
    public void saveGorder(@RequestBody GOrder gOrder){ //这里的这个注解！！
        igOrderService.saveGOrder(gOrder);

    }

    @ResponseBody
    @RequestMapping("/selectById")
    public Map<String,Object> selectById(@RequestParam("id") int id,@RequestParam (value="page") String page, @RequestParam(value="limit") String limit){
        Map<String, Object> map = new HashMap<String, Object>();
        GOrder gOrder=igOrderService.selectById(id);
        List<GOrder> orders =  new ArrayList<>();
        orders.add(gOrder);
        int count=igOrderService.getTotalLines();
        if (orders!= null) {
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", count);
            map.put("data", orders);
            return map;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/search")
    public Map<String,Object> searchGOrders(@RequestParam("id") int id,@RequestParam("start") Date start, @RequestParam("end") Date end,@RequestParam (value="page") String page, @RequestParam(value="limit") String limit){
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("来search了-----");
        System.out.println("start:"+start+"-----------id:"+id+"-------end:"+end);

        //当前页
        int current = Integer.parseInt(page);
        //每页的数量
        int size = Integer.parseInt(limit);
        int startline=(current-1)*size;
        int count=igOrderService.getTotalLines();
        List<GOrder> gOrders=igOrderService.searchGOrder(id,start,end,startline,size);
        if (gOrders!= null) {
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", count);
            map.put("data", gOrders);
            return map;
        }
        return null;
    }
    @ResponseBody
    @RequestMapping("/deleteGOrderById")
    //删除商品
    public void deleteById(@RequestParam("id") int id){
        igOrderService.deleteById(id);
        return ;
    }
    //进入商品更改页
    @RequestMapping("/order-view")
    public String GOrderview(@RequestParam("id") int id, Model model){
        Map<String,Object> map=new HashMap<String, Object>();
        GOrder gOrder= igOrderService.selectById(id);
        if (gOrder != null) {
            map.put("data", gOrder);
            model.addAttribute("order",gOrder);
        }
        return "order-view";
    }
    //支付方式列表
    @ResponseBody
    @RequestMapping("/Paymentlist")
    public Map<String,Object> paymentlist(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Payment> payments = iPaymentService.selectAll();
        if(payments!=null){
            map.put("data",payments);
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
            return map;
        }
        return null;
    }

    //更改商品信息
    @ResponseBody
    @RequestMapping("/updateGOrder")
    public void updateGood(@RequestBody GOrder order){
        igOrderService.updateGOrder(order);
    }


}
