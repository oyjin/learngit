package com.aowin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.BookMapper;
import com.aowin.exception.ServiceException;
import com.aowin.service.LendBookService;
import com.aowin.util.DateUtil;

@Service
public class LendBookServiceImpl implements LendBookService{

	@Autowired
	private BookMapper bookMapper;
	
	@Override
	@Transactional
	public void lendBook(int userid, int bookid) {
		//1.查看用户是否有逾期未还的图书
		int i = bookMapper.isTimeOut(userid);
		if(i != 0) {
			throw new ServiceException("您有超期图书，请先归还！");
		}
		//2.查询用户借阅数是否小于5
		int j = bookMapper.lendCount(userid);
		if(j>=5) {
			throw new ServiceException("最多可借阅5本书！");
		}
		//3.修改图书状态
		int n = bookMapper.lendBook(bookid);
		if(n != 1) {
			throw new ServiceException("租书失败，请稍后再试");
		}
		//4.添加借阅记录
		String lendtime = DateUtil.currentTime();
		int m = bookMapper.addBookRecord(userid, bookid, lendtime);
		if(m != 1) {
			throw new ServiceException("租书记录添加失败");
		}
	}

}
