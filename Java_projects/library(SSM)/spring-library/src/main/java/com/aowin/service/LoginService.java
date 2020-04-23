package com.aowin.service;

public interface LoginService {
	/**
	 * 登录校验
	 * @param username
	 * @param password
	 * @return
	 */
	public Object checkLogin(String username,String password);
	
}
