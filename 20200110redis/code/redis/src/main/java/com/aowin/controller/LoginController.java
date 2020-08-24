package com.aowin.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@Autowired
	private StringRedisTemplate stringRedisTemlate;
	
	@RequestMapping("/sendCode")
	public String sendCode(String phone) {
		stringRedisTemlate.opsForValue().set(phone, "121212112", 10, TimeUnit.MINUTES);
		
		
		return "ok";
	}

}
