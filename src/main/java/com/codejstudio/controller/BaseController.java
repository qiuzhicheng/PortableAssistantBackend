package com.codejstudio.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

public class BaseController {
	Logger log = LoggerFactory.getLogger(BaseController.class);
    /** 
     * 异常页面控制  @ExceptionHandler
     *  当这个Controller中任何一个方法发生异常，一定会被这个方法拦截到。(所以其他controller必须继承我)
     *  然后，输出日志。封装Map并返回，页面上得到status为false。就这么简单
     * @param runtimeException 
     * @return 
     */  
	@ExceptionHandler
    public String expHander(HttpServletRequest request, Exception ex, HttpServletResponse response) {
    		System.out.println("------------------------bug的集中处理------------------------------");
    	return null;
    } 
}
