package com.dcxt.backstage.service;

import com.dcxt.bean.TableBean;
import com.dcxt.backstage.mapper.TableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by yyangcr on 17-10-11.
 */
@Service
public class TableService {
    @Autowired
    private TableMapper mapper;
    public ArrayList<TableBean> alltable(){
        return mapper.alltable();
    }
    public TableBean getbyid(int id ){
        return mapper.getbyid(id);
    }
    public boolean updatetable(TableBean tableBean){
        return mapper.updatetable(tableBean);
    }
    public boolean addtable(TableBean tableBean){
        return mapper.addtable(tableBean);
    }
    public boolean delecttable(int id){
       return  mapper.delecttable(id);
    }

}
