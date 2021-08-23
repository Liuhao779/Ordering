package com.dcxt.backstage.controllers;

import com.dcxt.bean.ClassinfoBean;
import com.dcxt.bean.FoodmenuBean;
import com.dcxt.backstage.service.ClassinfoService;
import com.dcxt.backstage.service.FoodmenuService;
import com.dcxt.utils.ImageUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Controller
public class FoodmenuController {
    @Autowired
    private FoodmenuService foodmenuservice;
    @Autowired
    private ClassinfoService classinfoService;
    @RequestMapping("/foodmenuindex")
    public String foodmenuindex(Model model){
        ArrayList<FoodmenuBean> foods = foodmenuservice.getfoodAll();
        model.addAttribute("foods",foods);
        return "/page/foodmenuinfo";
    }
    //跳转到分类页
    @RequestMapping("/classinfoindex")
    public String classinfoindex(Model model ){
        ArrayList<ClassinfoBean> classinfos = classinfoService.getClassinfo();
        model.addAttribute("classinfo",classinfos);
        return "/page/classinfo";
    }
    @RequestMapping("/addfood")
    public String addfood(Model model){
        ArrayList<ClassinfoBean> classinfos = classinfoService.getClassinfo();
        model.addAttribute("classinfos",classinfos);
        return "/page/addfood";

    }
    @RequestMapping("/getclassinfojson")
    @ResponseBody
    public ArrayList<ClassinfoBean>  getclassinfojson(){
        ArrayList<ClassinfoBean> classinfos = classinfoService.getClassinfo();
        System.out.println(classinfos.get(0));
        return classinfos;
    }
    @RequestMapping("updatefoodmennu")
    public String updatefoodmenu(Model model ,HttpServletRequest request){
        String id = request.getParameter("foodid");
        System.out.println(id+"id");
        FoodmenuBean food = foodmenuservice.getbyid(Integer.parseInt(id));

        ArrayList<ClassinfoBean> classinfos = classinfoService.getClassinfo();
        model.addAttribute("classinfos",classinfos);
        model.addAttribute("food",food);
        return "/page/updatefood";

    }
    @RequestMapping("/commitfood")
    public String commitfood(FoodmenuBean foodmenuBean){
        System.out.println(foodmenuBean);
        if(foodmenuBean.getId()==0){
            foodmenuservice.addfood(foodmenuBean);
        }else{
            boolean updatefoodmenu = foodmenuservice.updatefoodmenu(foodmenuBean);
        }

        return "redirect:/foodmenuindex";
    }
    @RequestMapping("delectfoodmenu")
    public String delectfoodmenu(HttpServletRequest request){
        String id = request.getParameter("id");
        boolean delectfoodmenu = foodmenuservice.delectfoodmenu(Integer.parseInt(id));

        return "redirect:/foodmenuindex";
    }
    //处理图片上传
    @ResponseBody
    @RequestMapping("/updateimage")
        public Map uploadImage(MultipartFile file, HttpSession session, Model model){
        Map map = new HashMap();
        try {
            if (file != null) {
                String errorLine = "";
                //获取输入流
                InputStream is = file.getInputStream();
                //获取绝对路径
                ServletContext sc=session.getServletContext();
                String rootPath=sc.getRealPath("/");
                String savaDir=rootPath+"uploads/";
                System.out.println(savaDir);
                String uploadfile = ImageUpdate.uploadfile(file, savaDir);
                map.put("msg","上传成功");
                map.put("file","/uploads/"+uploadfile);
            }else {
                map.put("msg","没有上传文件");
            }
        }catch (IOException e){
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }
    /*===================下面是分类页面的管理==================*/
    @RequestMapping("/addclassinfo")
    public  String addclassinfo(){

        return "/page/addclassinfo";
    }
    @RequestMapping("commitclassinfo")
    public String commitClassinfo(ClassinfoBean classinfoBean){
        System.out.println(classinfoBean.getId());
        if(classinfoBean.getId()!=0){
            classinfoService.updateclass(classinfoBean);
        }else{
            boolean addclassinfo = classinfoService.addclassinfo(classinfoBean);
        }

        return "redirect:/classinfoindex";
    }
    @RequestMapping("/updateclassinfo")
    public  String updateclassinfo(Model model, HttpServletRequest request){
        String id = request.getParameter("id");
        ClassinfoBean classinfo = classinfoService.getbyid(Integer.parseInt(id));
        model.addAttribute("classinfo",classinfo);
        return "/page/updateclassinfo";
    }
    @RequestMapping("delectclassinfo")
    public String delectclassinfo(HttpServletRequest request){
        String id = request.getParameter("id");
        boolean delectclassinfo = classinfoService.delectclassinfo(Integer.parseInt(id));
        return "redirect:/classinfoindex";


    }
}
