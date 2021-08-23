package com.dcxt.front.controller;

import com.dcxt.backstage.service.CommentService;
import com.dcxt.bean.CommentBean;
import com.dcxt.bean.UserBean;
import com.dcxt.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by yyangcr on 17-11-11.
 */
@Controller

public class CommentController {
    @Autowired
    private CommentService commentservice;
    @RequestMapping("/commentindex")
    public String commentindex(Model model){
        ArrayList<CommentBean> commentBeans = commentservice.getallcommentBean();
        model.addAttribute("commentBeans",commentBeans);
        return "/front/commentlist";
    }
    @RequestMapping("addcomment")
    public String addcomment(){

        return "/front/addcomment";
    }
    @RequestMapping("addcommentcommit")
    public String addcommentcommit(HttpSession session, CommentBean commentBean){
        UserBean user = (UserBean) session.getAttribute("user");
        commentBean.setNick(user.getUname());
        commentservice.addupdae(commentBean);
        return "forward:/commentindex";
    }
}

