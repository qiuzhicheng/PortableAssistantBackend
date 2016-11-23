package com.codejstudio.service.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.codejstudio.service.dto.UserDTO;
import com.codejstudio.service.UserService;

  
/**
 * 功能概要：UserController 
 * @author codejstudio
 * @2016年11月18日
 */
@Controller  
public class UserController {  
    @Resource  
    private UserService userService;  
      
    @RequestMapping("/modelandview")    
    public ModelAndView getIndex(){      
        ModelAndView mav = new ModelAndView("index");   
        UserDTO user = userService.selectUserById("2");  
        mav.addObject("user", user);   
        return mav;    
    }  
    @RequestMapping("/")    
    public String hello(){      
       
        return "index";    
    } 
    /**
     * 用户注册
     * @param jo
     * @param req
     * @param session
     * @return
     */
    @RequestMapping(value="/register",method = RequestMethod.POST) 
    @ResponseBody//在SpringMVC中可以在Controller的某个方法上加@ResponseBody注解，表示该方法的返回结果直接写入HTTP response body中。
    public String register(@RequestBody /*JSONObject*/ UserDTO jo, HttpServletRequest req, HttpSession session){
       System.out.println("-----------userDTO-------------------------------------------------------------");

     /*   UserDTO user = new UserDTO();
        user.setU_mobile(jo.getString("mobile")); 
        user.setU_username(jo.getString("username")); 
        user.setU_password(jo.getString("password"));
        user.setCreate_time(new Date());
        user.setModify_time(new Date());
        System.out.println(jo.getString("mobile"));*/
        //调用service
        //userService.register(userDTO);
		return "hello"; 
    }
}  