package com.dcxt.backstage.service;

import com.dcxt.bean.ClassinfoBean;
import com.dcxt.backstage.mapper.ClassinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by yyangcr on 17-10-13.
 */
@Service
public class ClassinfoService {
    @Autowired
    private ClassinfoMapper mapper;
    public ArrayList<ClassinfoBean> getClassinfo(){
        return mapper.getClassinfo();

    }
    public ClassinfoBean getbyid(int id){
        return mapper.getbyid(id);
    }
    public boolean updateclass(ClassinfoBean classinfobean){
        return mapper.updateclass(classinfobean);
    }
    public boolean addclassinfo(ClassinfoBean classinfoBean){
       return  mapper.addclassinfo(classinfoBean);
    }
    public boolean delectclassinfo(int id){
        return mapper.delectclassinfo(id);
    }
}
