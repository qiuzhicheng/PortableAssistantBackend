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
public interface UserDao extends BaseDAO{  
    /**
     * 查询 用户根据id
     * @param userId
     * @return
     */
	public UserDTO selectUserByMobile(UserDTO userDTO);
	 /** 
	 * 修改用户名
	 * @param  Map map 
	 * @return  boolean
	 */
    public boolean UpdateUserNameByMobile(Map map);
    /** 
	 * 修改密码
	 * @param  Map map 
	 * @return  boolean
	 */
    public boolean UpdateUserPasswordByMobile(Map map);
 
    
	/**
	 * 根据手机号，密码查询用户信息
	 * @param loginUerDTO
	 * @return
	 */
	public UserDTO selectUser(UserDTO loginUerDTO);  
	 /**
     * 查询 用户根据id
     * @param u_mobile
     * @return
     */
    public UserDTO selectUserById(String u_mobile); 
    /**
     * 注册 用户
     * @param user
     * @return
     */
    public void register(UserDTO user);
    /**
     * 查询是否已存在用户
     * @param u_mobile
     * @return
     */
    public int selectUser(String u_mobile);
  
}  