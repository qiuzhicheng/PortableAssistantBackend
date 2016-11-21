package com.codejstudio.controller;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codejstudio.domain.User;
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
      
    @RequestMapping("/")    
    public ModelAndView getIndex(){      
        ModelAndView mav = new ModelAndView("index");   
        User user = userService.selectUserById(2);  
        mav.addObject("user", user);   
        return mav;    
    }  
    @RequestMapping("/hello.action")    
    public String hello(){      
       
        return "hello";    
    } 
}  