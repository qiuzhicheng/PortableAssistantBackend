package com.codejstudio.service;  
  
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.codejstudio.baseTest.SpringTestCase;
  
 
  
/** 
 * 功能概要：UserService单元测试 
 *  
 * @author linbingwen 
 * @since  2015年9月28日  
 */  
public class UserServiceTest extends SpringTestCase {  
    @Autowired  
    private UserService userService;  
    Logger logger = Logger.getLogger(UserServiceTest.class);  
     
    @Test
    public void hello (){
    	System.out.println("000000000000000000000000000000000000000000");
    }
    
      
  
}  