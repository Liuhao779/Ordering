package com.dcxt.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yyangcr on 17-10-16.
 */
@Controller
@RequestMapping("/front")
public class FrontMainController {
    @RequestMapping("/mainindex")
    public  String mainIndex(){
        return "/front/index";
    }
}
