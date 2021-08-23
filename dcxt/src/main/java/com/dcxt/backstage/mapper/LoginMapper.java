package com.dcxt.backstage.mapper;

import com.dcxt.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
public UserBean getbyUser(UserBean user);

}
