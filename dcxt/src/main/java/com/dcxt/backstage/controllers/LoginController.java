package com.dcxt.backstage.controllers;

import com.dcxt.bean.UserBean;
import com.dcxt.backstage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/ht")
    public String login(){
        return "/page/login";
    }
    @RequestMapping("info")
    public String info(){
        return "/page/info";
    }
    @RequestMapping("/checklogin")
    public String checklogin(HttpServletRequest request,UserBean userBean, HttpSession session, Model model){
        System.out.println(userBean.getUname());
        String mobile = request.getParameter("mobile");
        if(userBean.getUname()==null){
            return "/page/login";
        }
        UserBean userBean1 = loginService.getbyUser(userBean);
        System.out.println(userBean1==null);
        if(userBean1==null){
            model.addAttribute("message","用户名或者密码错误");
            System.out.println(mobile);
            if("mobile".equals(mobile)){
                return "/mobiles/login";
            }
            return "/page/login";
        }
        session.setAttribute("user",userBean1);

        if (userBean1.getType()==1){
            return "/page/manage";
        }else {
            //“用户界面逻辑”
            model.addAttribute("userbean",userBean1);
            return "/front/index";
        }



    }
}
