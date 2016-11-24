package com.codejstudio.service.controller;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codejstudio.common.safe.ResponseJSON;
import com.codejstudio.service.dto.UserDTO;
import com.codejstudio.common.exception.ParamException;
import com.codejstudio.common.safe.ResponseJSON;
import com.codejstudio.common.validator.ValidatorUtils;
import com.codejstudio.service.UserService;
import com.codejstudio.service.dto.UserDTO;

  
/**
 * 功能概要：UserController 
 * @author codejstudio
 * @2016年11月18日
 */
@Controller
@RequestMapping("/user")
public class UserController {  
    
	@Resource  
    private UserService userService;  
	
	/** 
	 * 修改用户名 
	 * @param ResponseJSON rj 给定json数据 
	 * @return ResponseJSON resultRj 
	 */
       
	@RequestMapping(value="/updateUsername",method = RequestMethod.POST) 
    @ResponseBody
    public ResponseJSON UpdateUserName(@RequestBody ResponseJSON rj, HttpServletRequest req, HttpServletResponse resp,HttpSession session) throws ServletException, IOException{
//		UserDTO user =(UserDTO) session.getAttribute("Mobile");
    	ResponseJSON resultRj=new ResponseJSON();
    	Map map=new HashMap();
    	String status;
        
    	map.put("u_mobile",rj.getString("u_mobile") );
    	map.put("u_username",rj.getString("u_username") );
    	
        if(userService.UpdateUserNameByMobile(map)){
        	status="1";
//        	user.setU_username(rj.getString("u_username"));
//        	session.setAttribute("user", user);
        	resultRj.put("status", status);
        	
        }else
        {
        	status="0";
        	resultRj.put("status", status);
        }
        return rj;
            
    } 
	
	/** 
	 * 修改密码 
	 * @param ResponseJSON rj 给定json数据 
	 * @return ResponseJSON resultRj 
	 */
	 @RequestMapping(value="/updatePassword",method = RequestMethod.POST)
	 @ResponseBody
    public ResponseJSON UpdateUserPassword(@RequestBody ResponseJSON rj, HttpServletRequest req, HttpServletResponse resp,HttpSession session) throws ServletException, IOException{
//		UserDTO loginUser =(UserDTO) session.getAttribute(rj.getString("u_mobile"));
    	UserDTO resultUser = new UserDTO();
    	ResponseJSON resultRj=new ResponseJSON();
    	Map map=new HashMap();
    	String status;
        
    	map.put("u_mobile", rj.getString("u_mobile"));
    	map.put("newPassword", rj.getString("newPassword"));
    	
    	if(rj.getString("oldPassword").equals("codejstudio"))
        {
    		if(userService.UpdateUserPasswordByMobile(map)){
    			status="1";
//            	loginUser.setU_password(rj.getString("newPassword"));
//            	session.setAttribute("user", loginUser);
            	resultRj.put("status", status);
    		}
    		else {
    			status="0";
            	resultRj.put("status", status);
			}
        }
    	else
        {
        	status="0";
        	resultRj.put("status", status);
        }
    	
        return resultRj;
	}

		
		
	
	
    
      
    /**
     * 用户登录
     * @param loginUerDTO
     * @param req
     * @param session
     * @return ResponseJSON
     * @throws ParamException 
     */
    @RequestMapping(value="/login",method = RequestMethod.POST) 
    @ResponseBody//在SpringMVC中可以在Controller的某个方法上加@ResponseBody注解，表示该方法的返回结果直接写入HTTP response body中。
    public ResponseJSON login(@RequestBody UserDTO loginUerDTO, HttpServletRequest req, HttpSession session) throws ParamException{
        //用户的登录校验       
        if (!ValidatorUtils.isMobile(loginUerDTO.getU_mobile()) || ValidatorUtils.isEmptyString(loginUerDTO.getU_password())) {
            throw new ParamException();
        }
        /*//加密密码
        loginUerDTO.setPassword(SafeUtils.encodePass(loginUerDTO.getPassword()));*/
        //数据库登录验证   调用service
        UserDTO dbUerDTO =  userService.selectUser(loginUerDTO);
        ResponseJSON json = new ResponseJSON();
        if(dbUerDTO==null){//输入密码或者手机号有误
        	json.put("status", 0);
        	json.put("remark", "输入手机号或者密码有误");
        }
        else{//验证成功
        	/* // object对象转为json
            json = ResponseJSON.toResponseJSON(dbUerDTO);*/
        	//将用户信息存入Session
        	req.getSession().setAttribute(dbUerDTO.getU_mobile(), dbUerDTO);
        	//返回给客户端登录信息
        	json.put("status", 1);
        	json.put("u_mobile", dbUerDTO.getU_mobile());
        	json.put("u_username", dbUerDTO.getU_username());
        }
        return json; 
    }
}  