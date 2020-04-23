package com.aowin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.dao.UserMapper;
import com.aowin.model.User;

@RestController
public class CreateCodeController {
	
	@Autowired
	private UserMapper userMapper;

	@RequestMapping(value="user/createCode")
	public String createCode(HttpSession session) {
		User u = (User)session.getAttribute("user");
		if(u==null) {
			return "请先登录";
		}
		Integer userid = u.getUserid();
		int i = userMapper.isSubmitted(userid);
		if(i != 1) {
			return "请先提交表单";
		}
		return "ok";
	}
}
