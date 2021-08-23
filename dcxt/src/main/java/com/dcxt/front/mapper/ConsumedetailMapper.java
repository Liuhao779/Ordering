package com.dcxt.front.mapper;

import com.dcxt.bean.ConsumedetailBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ConsumedetailMapper {

    public ArrayList<ConsumedetailBean> getByConsumedetail(String  id);
    public boolean addconsumedetaile(ConsumedetailBean consumedetailBean);
}
