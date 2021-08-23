package com.dcxt.front.service;

import com.dcxt.bean.ConsumedetailBean;
import com.dcxt.front.mapper.ConsumedetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ConsumedetailService {
    @Autowired
    public ConsumedetailMapper consumedetailMapper;
    public ArrayList<ConsumedetailBean> getByConsumedetail(String id){
        return consumedetailMapper.getByConsumedetail(id);
    }
    public boolean addconsumedetaile(ConsumedetailBean consumedetailBean){
        return consumedetailMapper.addconsumedetaile(consumedetailBean);
    }
}
