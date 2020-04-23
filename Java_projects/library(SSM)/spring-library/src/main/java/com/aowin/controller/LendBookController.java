package com.aowin.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.exception.ServiceException;
import com.aowin.model.User;
import com.aowin.service.LendBookService;

@RestController
public class LendBookController {
	private Logger logger = Logger.getLogger(LendBookController.class);
	
	@Autowired
	private LendBookService lendBookServiceImpl;
	
	@RequestMapping(value="/lendBook",produces = "text/plain;charset=utf-8")
	public String lendBook(@RequestParam Map<String, String> map,HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(user==null) {
			return "请先登录";
		}
		int userid = user.getUserid();
		int bookid=Integer.parseInt(map.get("bookid"));
		try {
			lendBookServiceImpl.lendBook(userid, bookid);
			return "租书成功";
		} catch (ServiceException e) {
			return e.getMessage();
		}catch (Exception e) {
			logger.error("服务端异常", e);
			return "服务端 异常";
		}
	}
}
