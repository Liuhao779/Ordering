package com.dcxt.front.mapper;

import com.dcxt.bean.TableBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface FrontCheckTableMapper {
    public ArrayList<TableBean> getByTableinfo(TableBean tableBean);
}
