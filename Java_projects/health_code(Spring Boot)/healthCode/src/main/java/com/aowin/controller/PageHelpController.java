package com.aowin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.model.User;
import com.aowin.service.impl.IndexServiceImpl;
import com.github.pagehelper.PageInfo;

@RestController
public class PageHelpController {
	
	@Autowired
	private IndexServiceImpl indexServiceImpl;
	
	@RequestMapping("user/admin")
	public PageInfo<User> select(@RequestParam(defaultValue = "1") int pageNum,User user){
		return indexServiceImpl.select(pageNum, user);
		
	}

}
