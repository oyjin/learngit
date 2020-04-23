package com.aowin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.UserMapper;
import com.aowin.model.User;
import com.aowin.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
//	@Transactional
	public Object checkLogin(String username, String password) {
		User user = userMapper.login(username, password);
		if(user==null) {
			return null;
		}else {
			return user;
		}
		
	}

}
