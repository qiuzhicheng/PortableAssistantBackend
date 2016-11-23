package com.codejstudio.service;  
  
import com.codejstudio.service.dto.UserDTO;
  
  
/** 
 * 功能概要：UserService接口类 
 *  
 * @author linbingwen 
 * @since  2015年9月28日  
 */  
public interface UserService {  
    public UserDTO selectUserById(String u_mobile);  
  
} 