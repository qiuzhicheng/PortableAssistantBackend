package com.codejstudio.service.dao;  
  
  
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codejstudio.service.dto.UserDTO;
  
/**
 * 功能概要：User的DAO类   
 * @author codejstudio
 * @2016年11月18日
 */
@Repository
public interface UserDao {  
    /**
     * 查询 用户根据id
     * @param userId
     * @return
     */
    public UserDTO selectUserById(String u_mobile);  
  
}  