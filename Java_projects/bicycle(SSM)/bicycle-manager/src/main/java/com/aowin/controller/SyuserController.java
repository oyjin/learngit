package com.aowin.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.dao.SyuserMapper;
import com.aowin.model.Syuser;
import com.aowin.service.SyuserService;

@RestController
public class SyuserController {
	@Autowired
	private SyuserService syuserServiceImpl;
	
	@Autowired
	private StringRedisTemplate stringRedisTemlate;
	
	@Autowired
	private SyuserMapper syuserMapper;
	
	@RequestMapping("/login")
	public Syuser login(@Validated Syuser syuser,BindingResult br, HttpSession session) {
		//如果验证不合法 直接返回
		if(br.hasErrors()) {
			return null;
		}
		
		Syuser user = syuserServiceImpl.login(syuser);
		if(user != null) {
			session.setAttribute("syuser", user);
		}
		return user;
	}
	
	@RequestMapping("/phoneLogin")
	public Syuser phoneLogin(@RequestBody Syuser syuser, HttpSession session) {
		String mobilePhone = syuser.getMobilePhone();
		String authCode = syuser.getAuthCode();
		String code = stringRedisTemlate.opsForValue().get(mobilePhone);
		if(authCode.equals(code)) {
			Syuser user = syuserMapper.phoneLogin(mobilePhone);
			session.setAttribute("syuser", user);
			return user;
		}
		return null;
	}

}
