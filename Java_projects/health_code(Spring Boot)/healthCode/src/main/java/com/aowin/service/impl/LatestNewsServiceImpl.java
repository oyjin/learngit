package com.aowin.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aowin.constants.PageConfig;
import com.aowin.model.Data;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class LatestNewsServiceImpl{
	public PageInfo<Data> getNews(int pageNum, String t, CloseableHttpResponse Response) throws ClientProtocolException, IOException {
		// 获取http客户端
		CloseableHttpClient client = HttpClients.createDefault();
		// 通过httpget方式来实现我们的get请求
		HttpGet httpGet = new HttpGet("https://file1.dxycdn.com/2020/0130/492/3393874921745912795-115.json?"+"t="+t);
		// 通过client调用execute方法，得到我们的执行结果就是一个response，所有的数据都封装在response里面了
		Response = client.execute(httpGet);
		// HttpEntity
		// 是一个中间的桥梁，在httpClient里面，是连接我们的请求与响应的一个中间桥梁，所有的请求参数都是通过HttpEntity携带过去的
		// 所有的响应的数据，也全部都是封装在HttpEntity里面
		HttpEntity entity = Response.getEntity();
		// 通过EntityUtils 来将我们的数据转换成字符串
		String str = EntityUtils.toString(entity, "UTF-8");
		// EntityUtils.toString(entity)
		//System.out.println(str);
		JSONObject json = JSONObject.parseObject(str);
		JSONArray jsonArray = JSONArray.parseArray(json.getString("data"));
		//System.out.println(jsonArray);
		String jsonStr = JSONObject.toJSONString(jsonArray);
		List<Data> list=new ArrayList<Data>();
		list = JSONObject.parseArray(jsonStr, Data.class);
		System.out.println(list.get(1).getSummary());
		Response.close();
		//开启分页
		PageHelper.startPage(pageNum, PageConfig.PAGE_SIZE);
		return new PageInfo<Data>(list);
	}

}
