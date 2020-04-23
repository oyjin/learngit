package com.aowin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aowin.dao.UserMapper;
import com.aowin.exception.ServiceException;
import com.aowin.service.SubmitService;
import com.aowin.util.DateUtil;

@Service
public class SubmitServiceImpl implements SubmitService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void submitMessage(int userid, String name, String card, String mobile, int address) {
		// 1.查看用户是否已经提交过表单
		int i = userMapper.isSubmitted(userid);
		if(i != 0) {
			throw new ServiceException("您已提交过表单，请勿重复提交！");
		}
		// 2.新增一条用户信息
		String ptime = DateUtil.currentDate();
		int m = userMapper.addRecord(userid, name, card, mobile, address, ptime);
		if(m != 1) {
			throw new ServiceException("信息提交失败");
		}
	}

}
