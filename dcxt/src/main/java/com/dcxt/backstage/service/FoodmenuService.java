package com.dcxt.backstage.service;

import com.dcxt.bean.FoodmenuBean;
import com.dcxt.backstage.mapper.FoodmenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by wx on 17-10-13.
 * 菜单service
 */
@Service
public class FoodmenuService {
    @Autowired
    private  FoodmenuMapper mapper;
    public ArrayList<FoodmenuBean> getfoodAll(){
        return mapper.getfoodAll();
    }
    public boolean addfood(FoodmenuBean foodmenuBean){
            return mapper.addfood(foodmenuBean);
    }
    public FoodmenuBean getbyid(int id){
        return mapper.getbyid(id);
    }
    public ArrayList<FoodmenuBean> getbyclassinfo(int id){
        return mapper.getbyclassinfo(id);
    }
    public boolean updatefoodmenu(FoodmenuBean foodmenuBean){
        return mapper.updatefoodmenu(foodmenuBean);
    }
    public boolean delectfoodmenu(int id){
        return mapper.delectfoodmenu(id);
    }
}
