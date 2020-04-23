package com.aowin.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.exception.ServiceException;
import com.aowin.model.Message;
import com.aowin.model.User;
import com.aowin.service.SubmitService;

@RestController
public class SubmitController {

	private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private SubmitService submitServiceImpl;
	
	@RequestMapping(value="user/submit",produces = "text/plain;charset=utf-8")
	public String messageSubmit(@Validated Message message,BindingResult br,HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(user==null) {
			return "请先登录";
		}
		if(br.hasErrors()) {
			return "fail";
		}
		Integer userid = user.getUserid();
		String name = message.getName();
		String card =message.getCard();
		String mobile = message.getMobile();
		Integer address = message.getAddress();
		try {
			submitServiceImpl.submitMessage(userid, name, card, mobile, address);
			return "提交成功";
		} catch (ServiceException e) {
			return e.getMessage();
		}catch (Exception e) {
			logger.error("服务端异常", e);
			return "服务端 异常";
		}
	}
}
