package com.aowin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aowin.constants.PageConfig;
import com.aowin.dao.UserMapper;
import com.aowin.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class IndexServiceImpl {

	@Autowired
	private UserMapper usermapper;
	
	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param user
	 * @return
	 */
	public PageInfo<User> select(int pageNum,User user){
		PageHelper.startPage(pageNum, PageConfig.PAGE_SIZE);
		List<User> li = usermapper.select(user);
		return new PageInfo<User>(li);
	}
}
