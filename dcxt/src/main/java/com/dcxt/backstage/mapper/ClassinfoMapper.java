package com.dcxt.backstage.mapper;

import com.dcxt.bean.ClassinfoBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;


@Mapper
public interface ClassinfoMapper {
    public ArrayList<ClassinfoBean> getClassinfo();
    public ClassinfoBean getbyid(int id);
    public boolean updateclass(ClassinfoBean classinfobean);
    public boolean addclassinfo(ClassinfoBean classinfoBean);
    public boolean delectclassinfo(int id);
}
