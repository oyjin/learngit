package com.aowin.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.model.User;
import com.aowin.model.User2;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
public class TestVueController {
	
	@RequestMapping("/user/select")
	public List<User> select(@RequestParam Map<String, String> map){
		System.out.println(map);
		
		List<User> users = new ArrayList<User>();
		users.add(new User(1, "qq", "34324"));
		users.add(new User(1, "qq", "34324"));
		users.add(new User(1, "qq", "34324"));
		users.add(new User(1, "qq", "34324"));
		
		return users;
	}

	
		
	
	// @RequestBody 用于接收客户端请求头为Content-Type: application/json;charset=UTF-8
	@RequestMapping(value="user/save",method = {RequestMethod.POST})
	public String receiveUser( @RequestBody User2 user /* ,HttpServletRequest request */) {
		
		
		
//		try {
//			ServletInputStream in = request.getInputStream();
//			
//			BufferedReader br = new BufferedReader(new InputStreamReader(in));
//			String line = null;
//			StringBuilder params = new StringBuilder();
//			while((line = br.readLine()) != null) {
//				params.append(line);
//			}
//			System.out.println(params);
//		
//			ObjectMapper mapper = new ObjectMapper();
//			User2 user = mapper.readValue(params.toString(), User2.class);
//			
//			System.out.println(user);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(user);
		return "ok";
	}
}
