package com.dcxt.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yyangcr on 17-10-15.
 */
@Controller
public class MobileLoginController {
    @RequestMapping("/moblielogin")
    public String loginindex(){
        return "/mobiles/login";
    }
}
