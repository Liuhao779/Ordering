package com.dcxt.backstage.controllers;

import com.dcxt.backstage.service.CommentService;
import com.dcxt.bean.CommentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;


@Controller
@RequestMapping("/back")
public class backCommentController {
    @Autowired
    private CommentService commentservice;
    @RequestMapping("/commentlist")
    public  String commentlist(Model model){
        ArrayList<CommentBean> commentBeans = commentservice.getallcommentBean();
        model.addAttribute("comments",commentBeans);
        return "/page/commentlists";
    }
}
