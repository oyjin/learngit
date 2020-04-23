package com.aowin.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.dao.UserMapper;
import com.aowin.model.User;

@RestController
public class IndexController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value="user/index")
	public String showIndex(HttpServletRequest request,HttpSession session) {
		//获取客户端 的 cookie(随着请求提交过来)
		Cookie[] cs=request.getCookies();
		String username=null;
		String password=null;
		for(Cookie c:cs) {
			String name = c.getName();//获得cookie数据名
			if(name.equals("username")) {
				username=c.getValue();
			}
			if(name.equals("password")) {
				password=c.getValue();
			}
		}
		if(username!=null && password!=null) {
			User u = userMapper.login(username, password);
			session.setAttribute("user", u);
			return username;
		}else {
			return "fail";
		}
	}
}
