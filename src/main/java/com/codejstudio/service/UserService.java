package com.codejstudio.service;  
  
import java.util.Map;

import com.codejstudio.common.safe.ResponseJSON;
import com.codejstudio.service.dto.UserDTO;
  
  
/** 
 * 功能概要：UserService接口类 
 *  
 * @author linbingwen 
 * @since  2015年9月28日  
 */  
public interface UserService {  
	 public UserDTO selectUserByMobile(UserDTO userDTO); 
	 
	 /** 
		 * 通过u_mobile修改用户名 
		 * @param  Map map 接收放在map中的数据
		 * @return  boolean
		 */
	 public boolean UpdateUserNameByMobile(Map map); 
	 
	 /** 
		 * 通过u_mobile修改密码 
		 * @param  Map map 接收放在map中的数据
		 * @return  boolean
		 */
	 public boolean UpdateUserPasswordByMobile(Map map); 
	 
	/**
	 * 用户登录验证   根据手机号和密码
	 * @param loginUerDTO
	 * @return
	 */
	public UserDTO selectUser(UserDTO loginUerDTO);  
  
} 