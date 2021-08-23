package com.dcxt.front.controller;

import com.dcxt.backstage.service.ClassinfoService;
import com.dcxt.backstage.service.FoodmenuService;
import com.dcxt.backstage.service.TableService;
import com.dcxt.bean.ClassinfoBean;
import com.dcxt.bean.FoodmenuBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by yyangcr on 17-10-17.
 */
@Controller
@RequestMapping("/front")
public class FrontFoodController {
    @Autowired
    private FoodmenuService foodmenuService;
    @Autowired
    private ClassinfoService classinfoService;
    @Autowired
    private TableService tableService;
    private ArrayList<ClassinfoBean> classinfo;

    @RequestMapping("selectclass")
    public String findclass(Model model,HttpServletRequest request){
        String tablebean = request.getParameter("tablebean");
        classinfo = classinfoService.getClassinfo();
        System.out.println("sss1");
        model.addAttribute("foodclass", classinfo);
        model.addAttribute("tablebean",tablebean);
        return "/front/demo";
    }
    @RequestMapping("findfoods")
    @ResponseBody
    public  ArrayList<FoodmenuBean>  foodall(Model model, HttpServletRequest request){
        String id = request.getParameter("id");
        int i = Integer.parseInt(id);

        ArrayList<FoodmenuBean> foods = foodmenuService.getbyclassinfo(i);
        System.out.println("sss1"+i);
        return foods;
    }
}
