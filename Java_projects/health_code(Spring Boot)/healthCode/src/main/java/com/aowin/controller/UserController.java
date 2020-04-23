package com.aowin.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.dao.UserMapper;
import com.aowin.model.User;
import com.aowin.service.LoginService;

@RestController
public class UserController {
	
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private LoginService loginServiceImpl;
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 登录校验的方法
	 */
	@RequestMapping(value="user/login",method = {RequestMethod.POST},produces = "text/plain;charset=utf-8")
	public String userLogin(@RequestBody User user,HttpServletResponse response) {
		String username = user.getUsername();
		String password = user.getPassword();
		try {
			Object obj=loginServiceImpl.checkLogin(username, password);
			if(obj==null) {
				return "用户不存在";
			}else {
				User u=(User)obj;
				//将用户登录信息保存在cookie
				Cookie cusername = new Cookie("username",username);
				Cookie cpass = new Cookie("password",password);
				//设置cookie有效期 setMaxAge() 以 s为单位 
				cusername.setMaxAge(7*24*60*60);
				cpass.setMaxAge(7*24*60*60);
					
				response.addCookie(cusername);
				response.addCookie(cpass);
				return "ok";
			}
		} catch (Exception e) {
			logger.error("服务端异常", e);
			return "服务端异常";
		}
		
	}
	
	/**
	 * 用户注册的方法
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value="user/regist",method = {RequestMethod.POST},produces = "text/plain;charset=utf-8")
	public String register(@RequestBody User user,HttpServletResponse response) {
		String username = user.getUsername();
		String password = user.getPassword();
		int i = userMapper.userRegist(username, password);
		if(i == 1) {
			//清除原有的cookie
//			Cookie us=new Cookie("username",null);
//			us.setMaxAge(0);
//			us.setPath("/");
//			response.addCookie(us);
//			Cookie ps=new Cookie("password",null);
//			ps.setMaxAge(0);
//			ps.setPath("/");
//			response.addCookie(ps);
			//将用户登录信息保存在cookie
			Cookie cusername = new Cookie("username",username);
			Cookie cpass = new Cookie("password",password);
			//设置cookie有效期 setMaxAge() 以 s为单位 
			cusername.setMaxAge(7*24*60*60);
			cpass.setMaxAge(7*24*60*60);
				
			response.addCookie(cusername);
			response.addCookie(cpass);
			return "ok";
		}
		return "";
	}
	
	@RequestMapping(value="user/insert")
	public String insertUser(User user) {
		try {
			userMapper.insert(user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("服务端异常", e);
			return "error";
		}
		return "success";
	}
	
	@RequestMapping(value="user/update")
	public String updateUser(User user) {
		try {
			userMapper.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("服务端异常", e);
			return "error";
		}
		return "success";
	}
	
	@RequestMapping(value="user/delete")
	public String deleteUser(int userid) {
		try {
			userMapper.delete(userid);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("服务端异常", e);
			return "error";
		}
		return "success";
	}
	
	@RequestMapping(value="user/selRole")
	public String selRole(HttpSession session) {
		try {
			Object obj = session.getAttribute("user");
			User u=(User)obj;
			int userid = u.getUserid();
			int i=userMapper.selRole(userid);
			if(i == 1) {
				return "ok";
			}else {
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("服务端异常", e);
			return "error";
		}
	}
}
