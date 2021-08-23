package com.dcxt.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yyangcr on 17-11-8.
 */
@Controller
public class MoblieControllers {
    @RequestMapping("/")
    public String login(){
        return "mobiles/login";
    }
}
