package com.aowin.controller;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.dao.SyuserMapper;
import com.aowin.model.Syuser;

@RestController
public class GetCodeController {
	
	@Autowired
	private StringRedisTemplate stringRedisTemlate;
	
	@Autowired
	private SyuserMapper syuserMapper;
	
	@RequestMapping(value="/sendCode",produces = "text/plain;charset=utf-8")
	public String sendCode(String mobilePhone) {
		//验证该手机号是否有对应的用户存在
		Syuser syuser = syuserMapper.phoneLogin(mobilePhone);
		if (syuser!=null) {
			Random r = new Random();
			int i=r.nextInt(8999)+1000;
			String authCode = String.valueOf(i);
			try {
				stringRedisTemlate.opsForValue().set(mobilePhone, authCode, 60, TimeUnit.SECONDS);
				return authCode;
			} catch (Exception e) {
				return "fail";
			}
			
		}
		return "用户不存在";
	}

}
