package com.aowin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String username = request.getParameter("username");
		// 创建一个视图和模型的对象  并且指定视图路径
		ModelAndView mav = new ModelAndView("/hello.jsp");
		mav.addObject("username", username);//保存模型数据
		return mav;
	}

}
