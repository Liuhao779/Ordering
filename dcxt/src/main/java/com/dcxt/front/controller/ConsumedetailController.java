package com.dcxt.front.controller;

import com.dcxt.backstage.service.ConsumeService;
import com.dcxt.bean.ConsumeBean;
import com.dcxt.bean.ConsumedetailBean;
import com.dcxt.front.service.ConsumedetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ConsumedetailController {
    @Autowired
    private ConsumedetailService consumedetailService;
    @Autowired
    private ConsumeService consumeService;
    @RequestMapping("front/menu")
    public String myconsumedetail(Model model, HttpServletRequest request){
        String tablebean =null;
        String id = request.getParameter("id");
        System.out.println(id+"idssss");
        if(id!=null){
            System.out.println("=============");
            ConsumeBean getbyid = consumeService.getbyid(Integer.parseInt(id));
            tablebean = getbyid.getConsumptionnum();
        }else{
           tablebean =  request.getParameter("tablebean");
        }
        System.out.println(tablebean);
        double sum =0;
        int quantity=0;
        ArrayList<ConsumedetailBean> Consumedetails = consumedetailService.getByConsumedetail(tablebean);
        System.out.println(Consumedetails.size());
        model.addAttribute("Consumedetails",Consumedetails);
        for(ConsumedetailBean bean :Consumedetails){

            sum +=bean.getPrice()*bean.getQuantity();
            quantity+=bean.getQuantity();

        }

        Map map = new HashMap();
        map.put("totalprice",sum);
        map.put("quantity",quantity);
        model.addAttribute("map",map);
        return "/front/menu";
    }
}

