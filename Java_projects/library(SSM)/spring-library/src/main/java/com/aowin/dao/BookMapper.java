package com.aowin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aowin.model.Book;
import com.aowin.model.BookRecord;

public interface BookMapper {
	/**
	 * 查询状态为在馆的图书列表
	 * @return
	 */
	public List<Book> selectBook();
	
	/**
	 * 查询用户是否有逾期未还的图书
	 * @param userid
	 * @return
	 */
	public int isTimeOut(int userid);
	
	/**
	 * 查询用户已借的图书数量
	 * @param userid
	 * @return
	 */
	public int lendCount(int userid);
	
	/**
	 * 修改图书状态为借出
	 * @param bookid
	 * @return
	 */
	public int lendBook(int bookid);
	
	/**
	 * 新增一条借阅记录
	 * @param userid
	 * @param bookid
	 * @return
	 */
	public int addBookRecord(@Param("userid") int userid,@Param("bookid") int bookid,@Param("lendtime") String lendtime);
	
	/**
	 * 查询用户的借阅记录
	 * @param userid
	 * @return
	 */
	public List<BookRecord> selectRecords(@Param("userid") int userid);
}
