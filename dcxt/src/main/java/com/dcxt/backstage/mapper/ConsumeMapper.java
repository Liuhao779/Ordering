package com.dcxt.backstage.mapper;

import com.dcxt.bean.ConsumeBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
@Mapper
public interface ConsumeMapper {
    //获取所有的订单
    public ArrayList<ConsumeBean>  getallConsumes();
    //判断是否结算
    public ArrayList<ConsumeBean>  getisaccount(int id);
    //获取id一个订单
    public ConsumeBean getbyid(int id);
    //获取consumptionnum 或者unameaccount一个订单
    public ConsumeBean getbyConsumes(ConsumeBean consumeBean);
    //更改订单
    public boolean updateconsume(ConsumeBean consumeBean);
    //添加订单
    public boolean addupdae(ConsumeBean consumeBean);
}
