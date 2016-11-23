package com.codejstudio.service.dao;  
  
  
import com.codejstudio.service.dto.UserDTO;
  
/**
 * 功能概要：User的DAO类   
 * @author codejstudio
 * @2016年11月18日
 */
public interface UserDao {  
    /**
     * 查询 用户根据id
     * @param userId
     * @return
     */
    public UserDTO selectUserById(String u_mobile);  
  
}  