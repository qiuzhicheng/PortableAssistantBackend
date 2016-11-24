package com.codejstudio.service.impl;  
  
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.codejstudio.service.dao.UserDao;
import com.codejstudio.service.dto.UserDTO;
import com.codejstudio.service.util.ResultFilter;
import com.codejstudio.service.UserService;
  

  
/**
 * 功能概要：UserService实现类  
 * @author codejstudio
 * @2016年11月18日
 */
@Service  
public class UserServiceImpl implements UserService{  
      
    @Resource  
    private UserDao userDao;  
    public UserDTO selectUserByMobile(UserDTO userDTO) {
        return userDao.selectUserByMobile(userDTO);  
          
    } 
	public UserDTO selectUserById(String u_mobile) {
        return userDao.selectUserById(u_mobile);  
          
    }   
    @Override
	public boolean UpdateUserNameByMobile(Map map) {
		
		return userDao.UpdateUserNameByMobile(map);
	}  
    
    @Override
    public boolean UpdateUserPasswordByMobile(Map map) {
    	return userDao.UpdateUserPasswordByMobile(map);
    	
    }

	public UserDTO selectUser(UserDTO loginUerDTO) {
		return userDao.selectUser(loginUerDTO);
	}
	 public void register(UserDTO user) {
         userDao.register(user);  
          
    } 
    public int selectUser(String u_mobile){
    	 return userDao.selectUser(u_mobile);
    }
}  

