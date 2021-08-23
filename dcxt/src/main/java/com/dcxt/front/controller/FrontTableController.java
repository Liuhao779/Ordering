package com.dcxt.front.controller;

import com.dcxt.bean.TableBean;
import com.dcxt.bean.UserBean;
import com.dcxt.front.service.FrontCheckTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by yyangcr on 17-10-16.
 */
@Controller
@RequestMapping("/front")
public class FrontTableController {
@Autowired
    private FrontCheckTableService frontCheckTableService;
@RequestMapping("/tableinfoindex")
    public String tableindex(Model model){
    TableBean tableBean = new TableBean();
    tableBean.setState(0);
    ArrayList<TableBean> tableBeans = frontCheckTableService.getByTableinfo(tableBean);
    model.addAttribute("tablebeans",tableBeans);
    return "/front/tablelist";
    }
    @RequestMapping("/mytable")
    public String mytable(Model model, HttpServletRequest request){
        TableBean tableBean = new TableBean();
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");
        tableBean.setState(1);
        tableBean.setUid(user.getId());
        ArrayList<TableBean> tableBeans = frontCheckTableService.getByTableinfo(tableBean);
        System.out.println(tableBeans.size());
        model.addAttribute("tablebeans",tableBeans);
        return "/front/mytable";
    }


}
