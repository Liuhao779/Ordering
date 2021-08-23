package com.dcxt.backstage.service;


import com.dcxt.backstage.mapper.ConsumeMapper;
import com.dcxt.bean.ConsumeBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ConsumeService {
    @Autowired
   private ConsumeMapper consumeMapper;
    //获取所有的订单
    public ArrayList<ConsumeBean> getallConsumes(){
        return consumeMapper.getallConsumes();
    }
    public ArrayList<ConsumeBean>  getisaccount(int id){
        return consumeMapper.getisaccount(id);
    }
    //获取id一个订单
    public ConsumeBean getbyid(int id){
        return consumeMapper.getbyid(id);
    }
    //获取consumptionnum 或者unameaccount一个订单
    public ConsumeBean getbyConsumes(ConsumeBean consumeBean){
        return consumeMapper.getbyConsumes(consumeBean);
    }
    //更改订单
    public boolean updateconsume(ConsumeBean consumeBean){
        return consumeMapper.updateconsume(consumeBean);
    }
    //添加订单
    public boolean addupdae(ConsumeBean consumeBean){
        return consumeMapper.addupdae(consumeBean);
    }
}
