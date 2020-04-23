package com.aowin.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.model.User;
import com.aowin.service.LoginService;

@RestController
public class UserController {
	
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private LoginService loginServiceImpl;
	
	/**
	 * 登录校验的方法
	 */
	@RequestMapping(value="user/login",method = {RequestMethod.POST},produces = "text/plain;charset=utf-8")
	public String userLogin(@RequestBody User user,HttpSession session) {
		String username = user.getUsername();
		String password = user.getPassword();
		try {
			Object obj=loginServiceImpl.checkLogin(username, password);
			if(obj==null) {
				return "用户不存在";
			}else {
				User u=(User)obj;
				session.setAttribute("user",u);
				return "ok";
			}
		} catch (Exception e) {
			logger.error("服务端异常", e);
			return "服务端异常";
		}
		
	}
	
	
	
}
