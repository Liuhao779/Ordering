package com.dcxt.backstage.mapper;

import com.dcxt.bean.FoodmenuBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * Created by yyangcr on 17-10-13.
 */
@Mapper
public interface FoodmenuMapper {
    public ArrayList<FoodmenuBean> getfoodAll();
    public FoodmenuBean getbyid(int id);
    public ArrayList<FoodmenuBean> getbyclassinfo(int id);
    public boolean addfood(FoodmenuBean foodmenuBean);
    public boolean updatefoodmenu(FoodmenuBean foodmenuBean);
    public boolean delectfoodmenu(int id);
}
