package com.dcxt.backstage.controllers;

import com.dcxt.bean.TableBean;
import com.dcxt.backstage.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@Controller
public class TatlbController{
    @Autowired
    private TableService service;
    @RequestMapping("/table/index")
    public String index(Model model){
        ArrayList<TableBean> tables = service.alltable();
        model.addAttribute("tables",tables);
        return "/page/tableinfo";
    }
    @RequestMapping("/addtable")
    public String addtable(){
        return "/page/addtable";
    }
    @RequestMapping("/updatetable")
    public String updatetable(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        TableBean table = service.getbyid(Integer.parseInt(id));
            model.addAttribute("table",table);
            return "/page/updatetable";

    }
    @RequestMapping("/committable")
    public String commitfood(TableBean tableBean){
        System.out.println(tableBean);
        if(tableBean.getId()==0){
            service.addtable(tableBean);
        }else{
            boolean updatefoodmenu = service.updatetable(tableBean);
        }

        return "redirect:/table/index";
    }

    @RequestMapping("/delecttable")
    public String delecttable(HttpServletRequest request){
        String id = request.getParameter("id");

        int i = Integer.parseInt(id);
        System.out.println("delect"+i);
        boolean delecttable = service.delecttable(i);
        return "redirect:/table/index";
    }

}
