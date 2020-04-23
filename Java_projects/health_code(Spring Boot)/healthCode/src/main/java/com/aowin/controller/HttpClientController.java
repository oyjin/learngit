package com.aowin.controller;


import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.model.Data;
import com.aowin.service.impl.LatestNewsServiceImpl;
import com.github.pagehelper.PageInfo;


@RestController
public class HttpClientController {
	
	@Autowired
	private LatestNewsServiceImpl latestNewsServiceImpl;
	
	@RequestMapping(value="user/progress")
	public PageInfo<Data> HttpClientGet(@RequestParam(defaultValue = "1") int pageNum){
		//要传递的参数
		long t1=System.currentTimeMillis();
		String t = String.valueOf(t1/60);
		CloseableHttpResponse Response=null;
		try {
			return latestNewsServiceImpl.getNews(pageNum, t, Response);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
