package com.codejstudio.dao;  
  
  
import com.codejstudio.dto.UserDTO;
  
/**
 * 功能概要：User的DAO类   
 * @author codejstudio
 * @2016年11月18日
 */
public interface UserDao {  
   
    /**
     * 用户注册
     * @param user
     * @return
     */
    public void  register(UserDTO user); 
  
}  