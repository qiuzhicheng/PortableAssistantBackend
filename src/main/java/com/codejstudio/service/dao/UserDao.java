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
public interface UserDao extends BaseDAO {  
    
	/**
	 * 根据手机号，密码查询用户信息
	 * @param loginUerDTO
	 * @return
	 */
	public UserDTO selectUser(UserDTO loginUerDTO);  
  
}  