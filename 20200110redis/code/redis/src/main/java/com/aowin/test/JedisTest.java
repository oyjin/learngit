package com.aowin.test;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class JedisTest {
	
	public static void main(String[] args) {
		// 创建redis的客户端连接对象
		Jedis client = new Jedis("localhost", 6379);
		try {
			
			// 设置密码
			client.auth("123456");
			
			// 发送指令
			// String 
			// 新增 key
			client.set("name", "lisi");
			String name = client.get("name"); // 查询
			
			// 设置key的有效期
			client.expire("name", 10);
			System.out.println(name);
			
			// hash
			Map<String, String> hash = new HashMap<String, String>();
			hash.put("name", "wangwu");
			hash.put("age", "21");
			client.hmset("User:wangwu", hash);
			
			System.out.println(client.hgetAll("User:wangwu"));
		}finally {
			
			client.close();
		}
		
		
		
		
		
	}

}
