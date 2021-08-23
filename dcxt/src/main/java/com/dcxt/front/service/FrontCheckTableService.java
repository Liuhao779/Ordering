package com.dcxt.front.service;

import com.dcxt.bean.TableBean;
import com.dcxt.front.mapper.FrontCheckTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by yyangcr on 17-10-16.
 */
@Service
public class FrontCheckTableService {
    @Autowired
    public FrontCheckTableMapper checkTableMapper;
    public ArrayList<TableBean> getByTableinfo(TableBean tableBean ){
        return checkTableMapper.getByTableinfo(tableBean);
    }
}
