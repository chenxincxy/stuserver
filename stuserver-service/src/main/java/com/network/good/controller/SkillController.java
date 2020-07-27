package com.network.good.controller;

import com.network.api.beans.Skill;
import com.network.api.beans.SkillType;
import com.network.good.service.ISkillService;
import com.network.good.service.ISkillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class SkillController {

    @Autowired
    ISkillService iSkillService;
    @Autowired
    ISkillTypeService iSkillTypeService;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @ResponseBody
    @RequestMapping("/SkilllistByPage")
    public Map<String,Object> SkilllistBypage(@RequestParam(value="page") String page, @RequestParam(value="limit") String limit){   //商品列表页面
        Map<String, Object> map = new HashMap<String, Object>();
        //当前页
        int current = Integer.parseInt(page);
        //每页的数量
        int size = Integer.parseInt(limit);
        int start=(current-1)*size;
        int count=iSkillService.getTotalLines();
        List<Skill> skills = iSkillService.selectSkillByPage(start,size);

        if (skills!= null) {
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", count);
            map.put("data", skills);
            return map;
        }
        return null;
    }



    @ResponseBody
    @RequestMapping("/saveSkill")
    public void saveSkill(@RequestBody Skill skill){ //这里的这个注解！！
        iSkillService.saveSkill(skill);

    }


    @ResponseBody
    @RequestMapping("/searchSkill")
    public Map<String,Object> searchSkills(@RequestParam("id") int id,@RequestParam("start") Date start, @RequestParam("end") Date end,@RequestParam (value="page") String page, @RequestParam(value="limit") String limit){
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("来search了-----");
        System.out.println("start:"+start+"-----------id:"+id+"-------end:"+end);

        //当前页
        int current = Integer.parseInt(page);
        //每页的数量
        int size = Integer.parseInt(limit);
        int startline=(current-1)*size;
        int count=iSkillService.getTotalLines();
        List<Skill> skills=iSkillService.searchSkill(id,start,end,startline,size);
        if (skills!= null) {
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", count);
            map.put("data", skills);
            return map;
        }
        return null;
    }
    @ResponseBody
    @RequestMapping("/deleteSkillById")
    //删除商品
    public void deleteById(@RequestParam("id") int id){
        iSkillService.deleteById(id);
        return ;
    }
    //进入商品更改页
    @RequestMapping("/skill-view")
    public String Skillview(@RequestParam("id") int id, Model model){
        Map<String,Object> map=new HashMap<String, Object>();

        Skill skill= iSkillService.selectById(id);
        if (skill != null) {
            map.put("data", skill);
            model.addAttribute("skill",skill);
        }
        return "skill-view";
    }
    //技能分类列表
    @ResponseBody
    @RequestMapping("/SkillTypelist")
    public Map<String,Object> SkillTypelist(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<SkillType> skillTypes = iSkillTypeService.selectAll();
        if(skillTypes!=null){
            map.put("data",skillTypes);
            return map;
        }
        return null;
    }



    //更改商品信息
    @ResponseBody
    @RequestMapping("/updateSkill")
    public void updateSkill(@RequestBody Skill skill){
        iSkillService.updateSkill(skill);
    }


}
