package com.codejstudio.service;  
  
import com.codejstudio.service.dto.UserDTO;
  
  
/** 
 * 功能概要：UserService接口类 
 *  
 * @author linbingwen 
 * @since  2015年9月28日  
 */  
public interface UserService {  
	/**
	 * 用户登录验证   根据手机号和密码
	 * @param loginUerDTO
	 * @return
	 */
	public UserDTO selectUser(UserDTO loginUerDTO);  
  
} 