package com.dcxt.backstage.mapper;

import com.dcxt.bean.TableBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * Created by yyangcr on 17-10-11.
 */
@Mapper
public interface TableMapper {
    public ArrayList<TableBean> alltable();
    public TableBean getbyid(int id );
    public boolean updatetable(TableBean tableBean);
    public boolean addtable(TableBean tableBean);
    public boolean delecttable(int id);
}
