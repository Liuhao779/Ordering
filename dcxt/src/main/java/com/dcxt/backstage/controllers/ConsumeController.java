package com.dcxt.backstage.controllers;


import com.dcxt.backstage.service.ConsumeService;
import com.dcxt.backstage.service.TableService;
import com.dcxt.bean.ConsumeBean;
import com.dcxt.bean.ConsumedetailBean;
import com.dcxt.bean.TableBean;
import com.dcxt.front.service.ConsumedetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ConsumeController {
    @Autowired
    private ConsumeService consumeService;
    @Autowired
    private TableService tableService;
    @Autowired
    private ConsumedetailService consumedetailService;
    @RequestMapping("/catconsume")
    public String catconsume(Model model){

        ArrayList<ConsumeBean> consumeBeans = consumeService.getisaccount(1);

        model.addAttribute("consumeBeans",consumeBeans);
        return "/page/manageconsume";
    }
    @RequestMapping("/Checkout")
    public String Checkout(Model model){

        ArrayList<ConsumeBean> consumeBeans = consumeService.getisaccount(0);

        model.addAttribute("consumeBeans",consumeBeans);
        return "/page/checkoutconsume";
    }
    @RequestMapping("/catconsumeinfo")
    public String  catconsumeinfo(Model model, HttpServletRequest request){
        System.out.println("结账==");
        String id = request.getParameter("id");
        ConsumeBean consumeBean = consumeService.getbyid(Integer.parseInt(id));

        Map map = new HashMap();
        String tablebean = null;
        System.out.println(id+"idssss");
        if(id!=null){
            System.out.println("=============");
            ConsumeBean getbyid = consumeService.getbyid(Integer.parseInt(id));
            tablebean = getbyid.getConsumptionnum();
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
        map.put("totalprice",sum);
        map.put("times",consumeBean.getCreatetime());
        map.put("num",consumeBean.getConsumptionnum());
        map.put("unameaccount",consumeBean.getUnameaccount());
        map.put("quantity",quantity);

        TableBean tableBean = new TableBean();
        tableBean.setId(consumeBean.getTid());
        tableBean.setUid(0);
        tableBean.setConsumenum("");
        tableBean.setState(0);
        boolean updatetable = tableService.updatetable(tableBean);
        if(updatetable){
            consumeBean.setTotal(sum);
            consumeBean.setIsaccount(1);
            boolean updateconsume = consumeService.updateconsume(consumeBean);
            System.out.println("结账成功");
        }
        model.addAttribute("Consumedetails",Consumedetails);
        model.addAttribute("map",map);
        return "/page/printconsume";

    }
}
