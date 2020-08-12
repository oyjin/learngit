package com.mywork.task4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test1 {
public static void main(String[] args) throws IOException, ClassNotFoundException {
	Member me=new Member();
	me.setAddress("杭州");
	me.setPassword("a1234");
	me.setSex("男");
	me.setUsername("吴彦祖");
	//序列化对象
	ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src\\a.txt"));
	out.writeObject(me);
	out.flush();
	out.close();
}
}
