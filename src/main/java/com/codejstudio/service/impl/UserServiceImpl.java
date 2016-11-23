package com.codejstudio.service.impl;  
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejstudio.service.dao.UserDao;
import com.codejstudio.service.dto.UserDTO;
import com.codejstudio.service.UserService;
  

  
/**
 * 功能概要：UserService实现类  
 * @author codejstudio
 * @2016年11月18日
 */
@Service  
public class UserServiceImpl implements UserService{  
    @Autowired  
    private UserDao userDao;  
    public UserDTO selectUserById(String u_mobile) {
        return userDao.selectUserById(u_mobile);  
          
    }  
  
}  

