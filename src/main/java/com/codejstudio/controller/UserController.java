package com.codejstudio.controller;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.codejstudio.common.safe.ResponseJSON;
import com.codejstudio.dto.UserDTO;
import com.codejstudio.service.UserService;

  
/**
 * 功能概要：UserController --用户控制器
 * @author codejstudio
 * @2016年11月18日
 */
@Controller  
@RequestMapping("/user")
public class UserController /*extends BaseController*/ {  
    @Resource  
    private UserService userService;  
      
    /**
     * 测试
     * @return
     */
    @RequestMapping("/")    
    public String test(){      
        return "index";    
    } 
    /**
     * 用户注册
     * @param jo
     * @param req
     * @param session
     * @return
     */
    @RequestMapping("/register") 
    @ResponseBody//在SpringMVC中可以在Controller的某个方法上加@ResponseBody注解，表示该方法的返回结果直接写入HTTP response body中。
    public String register(@RequestBody JSONObject jo, HttpServletRequest req, HttpSession session){
       System.out.println("-----------userDTO-------------------------------------------------------------");

        UserDTO user = new UserDTO();
        user.setU_mobile(jo.getString("mobile")); 
        user.setU_username(jo.getString("username")); 
        user.setU_password(jo.getString("password"));
        user.setCreate_time(new Date());
        user.setModify_time(new Date());
        System.out.println(jo.getString("mobile"));
        //调用service
        //userService.register(userDTO);
		return "hello"; 
    }
    @RequestMapping("/hello.action")    
    public String hello(){      
        throw new RuntimeException("出错了！");   
        //return "hello";    
    } 
}  