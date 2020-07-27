package com.network.good.controller;

import com.network.api.beans.Good;
import com.network.api.beans.Type;
import com.network.good.service.IGoodService;


import com.network.good.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodController {

    @Autowired
    IGoodService iGoodService;
    @Autowired
    ITypeService iTypeService;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @ResponseBody
    @RequestMapping("/typelist")
    public Map<String,Object> typelist(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Type> goodtypes = iTypeService.selectAll();
        if(goodtypes!=null){
            map.put("data",goodtypes);
            return map;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/goodlist")
    public Map<String,Object> goodlist(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Good> goods = iGoodService.selectAll();
        if(goods!=null){
            map.put("data",goods);
            return map;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/goodlistBypage")
    public Map<String,Object> goodlistBpyage(@RequestParam (value="page") String page, @RequestParam (value="limit") String limit){   //商品列表页面
        Map<String, Object> map = new HashMap<String, Object>();
        //当前页
        int current = Integer.parseInt(page);
        //每页的数量
        int size = Integer.parseInt(limit);
        int start=(current-1)*size;
        int count=iGoodService.getTotalLines();
        List<Good> goods = iGoodService.selectGoodsByPage(start,size);
        if (goods != null) {
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", count);
            map.put("data", goods);
            return map;
        }
        return null;
    }


    @ResponseBody
    @RequestMapping("/searchGoodsByAll")
    public Map<String, Object> searchGoodsByAll(@RequestParam("start") Date start,@RequestParam("end") Date end,@RequestParam("typeid")Integer typeid, @RequestParam (value="page") String page, @RequestParam (value="limit") String limit){   //商品列表页面
        Map<String, Object> map = new HashMap<String, Object>();
        //当前页

        int current = Integer.parseInt(page);
        //每页的数量
        int size = Integer.parseInt(limit);
        int startline=(current-1)*size;

        List<Good> goods=iGoodService.selectGoodByDateAndTypeidAndPage(start,end,typeid,startline,size);
        int count=goods.size();
        if (goods != null) {
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", count);
            map.put("data", goods);
            return map;
        }
        return null;
    }
    @ResponseBody
    @RequestMapping("/searchGoodsByDate")
    public Map<String, Object> searchGoodsByyDate(@RequestParam("start") Date start,@RequestParam("end") Date end, @RequestParam (value="page") String page, @RequestParam (value="limit") String limit){   //商品列表页面
        Map<String, Object> map = new HashMap<String, Object>();
        //当前页

        int current = Integer.parseInt(page);
        //每页的数量
        int size = Integer.parseInt(limit);
        int startline=(current-1)*size;
        List<Good> goods=iGoodService.selectGoodByDateAndPage(start,end,startline,size);
        int count=goods.size();
        if (goods != null) {
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", count);
            map.put("data", goods);
            return map;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/searchGoodsByTypeid")
    public Map<String, Object> searchGoodsByTypeid(@RequestParam("typeid")Integer glistid, @RequestParam (value="page") String page, @RequestParam (value="limit") String limit){   //商品列表页面
        Map<String, Object> map = new HashMap<String, Object>();
        //当前页

        int current = Integer.parseInt(page);
        //每页的数量
        int size = Integer.parseInt(limit);
        int startline=(current-1)*size;
        System.out.println("name:"+glistid+"  startline:"+startline+"  size:"+size);
        List<Good> goods=iGoodService.selectGoodByTypeidAndPage(glistid,startline,size);
        int count=goods.size();
        if (goods != null) {
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", count);
            map.put("data", goods);
            return map;
        }
        return null;
    }


    //add商品
    @ResponseBody
    @RequestMapping("/saveGood")
    public void saveGood(@RequestBody Good good){   //商品列表页面

        List<Type> types=iTypeService.selectAll();
        iGoodService.saveGood(good);
        return ;
    }


    //删除商品
    @ResponseBody
    @RequestMapping("/deleteById")
    public void deleteById(@RequestParam("id") int id){
        iGoodService.deleteById(id);
        return ;
    }


    //进入商品更改页
    @RequestMapping("/product-view")
    public String Goodview(@RequestParam("id") int id,Model model){
        Map<String,Object> map=new HashMap<String, Object>();
        Good good= iGoodService.selectById(id);
        if (good != null) {
            map.put("data", good);
            model.addAttribute("good",good);
        }
        return "product-view";
    }


    //更改商品信息
    @ResponseBody
    @RequestMapping("updateGood")
    public void updateGood(@RequestBody Good good){
        iGoodService.updateGood(good);
    }
}