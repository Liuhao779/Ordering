package com.dcxt.backstage.service;

import com.dcxt.bean.UserBean;
import com.dcxt.backstage.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    public LoginMapper usermapper;
    public UserBean getbyUser(UserBean user){
        return usermapper.getbyUser(user);
    }
}
