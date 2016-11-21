package com.codejstudio.dao;  
  
  
import com.codejstudio.domain.User;
  
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
    public User selectUserById(Integer userId);  
  
}  