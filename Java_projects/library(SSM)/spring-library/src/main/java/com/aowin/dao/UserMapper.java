package com.aowin.dao;

import org.apache.ibatis.annotations.Param;

import com.aowin.model.User;

public interface UserMapper {
	/**
	 * 登录查询功能
	 * @param username
	 * @param password
	 * @return 返回一个对象时，必须要保证 查询结果最多只有一条结果
	 */
	public User login(@Param("username") String username,@Param("password") String password);
}
