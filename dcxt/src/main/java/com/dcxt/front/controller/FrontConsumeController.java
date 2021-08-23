package com.dcxt.front.controller;


import com.alibaba.fastjson.JSON;
import com.dcxt.backstage.service.ConsumeService;
import com.dcxt.backstage.service.FoodmenuService;
import com.dcxt.backstage.service.TableService;
import com.dcxt.bean.*;
import com.dcxt.front.service.ConsumedetailService;
import com.dcxt.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/front")
public class FrontConsumeController {
    @Autowired
    private ConsumeService consumeService;
    @Autowired
    private TableService tableService;
    @Autowired
    private FoodmenuService foodmenuService;
    @Autowired
    private ConsumedetailService consumedetailService;
    @RequestMapping("/addconsume")
    public String addconsume(HttpServletRequest request,RedirectAttributes attributes){
        String id = request.getParameter("id");
        TableBean tableBean = tableService.getbyid(Integer.parseInt(id));
        ConsumeBean consumeBean= new ConsumeBean();

        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");
        //生成消费单号
        String uuid = Utils.uuid();
        consumeBean.setConsumptionnum(uuid);
        consumeBean.setUnameaccount(user.getUname());
        //设置桌号
        consumeBean.setUnameaccount(user.getUname());
        consumeBean.setTablenum(tableBean.getTablenum());
        consumeBean.setTid(tableBean.getId());
        System.out.println("=========");
        boolean addupdae = consumeService.addupdae(consumeBean);
        System.out.println("========="+addupdae);
        if(addupdae){
            tableBean.setState(1);
            tableBean.setUid(user.getId());
            tableBean.setConsumenum(uuid);
            tableService.updatetable(tableBean);
            return "redirect:/front/mytable";
        }else{
                attributes.addFlashAttribute("message","开桌失败");
            return "redirect:/front/tableinfoindex";
        }

    }
    //创建订单详情
    @RequestMapping(value="/addcomnedetail",method = RequestMethod.POST)
    @ResponseBody
    public void addcomnedetail(@RequestParam Map<String,String> map){
        String totalprice =  map.get("totalprice");
        String mess =  map.get("mess");
        System.out.println(mess);
        String mymap = map.get("mymap");
        Map<String,Integer> foods = (Map) JSON.parse(mymap);
        for(Map.Entry<String, Integer> entry:foods.entrySet()){
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            int i = Integer.parseInt(entry.getKey());
            System.out.println(i);
            FoodmenuBean food = foodmenuService.getbyid(i);
            ConsumedetailBean consumedetailBean = new ConsumedetailBean();
            consumedetailBean.setCunid(mess);
            consumedetailBean.setFoodname(food.getFoodname());
            consumedetailBean.setPrice(food.getPrice());
            consumedetailBean.setQuantity(entry.getValue());
            boolean addconsumedetaile = consumedetailService.addconsumedetaile(consumedetailBean);
            System.out.println(addconsumedetaile);
        }

    /*    Map s = (Map) map.get("mymap");*/


    }
}
