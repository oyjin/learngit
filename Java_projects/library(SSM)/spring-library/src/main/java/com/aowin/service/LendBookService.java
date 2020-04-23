package com.aowin.service;

public interface LendBookService {
	/**
	 * 租书
	 * @param username 用户名
	 * @param bookid 图书id
	 */
	public void lendBook(int userid,int bookid);
}
