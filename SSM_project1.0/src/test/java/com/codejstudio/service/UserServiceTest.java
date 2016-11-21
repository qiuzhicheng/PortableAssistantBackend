package com.codejstudio.service;  
  
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.codejstudio.baseTest.SpringTestCase;
import com.codejstudio.domain.User;
  
 
  
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
    public void selectUserByIdTest(){  
        User user = userService.selectUserById(3);
        System.out.println(user);
        logger.debug("查找结果" + user);  
    }  
      
  
}  