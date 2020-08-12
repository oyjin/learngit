package com.aowin.io.object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args)throws Exception {
		Student stu = new Student();
		stu.setAge(20);
		stu.setName("xiaohei");
		stu.setSno("1002");
		
		//将对象保存到文件
//		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src\\a.txt"));
//		out.writeObject(stu);
//		out.flush();
//		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("src\\a.txt"));
		Object obj = in.readObject();  //新的对象
		if(obj instanceof Student) {
			Student s = (Student) obj;
			System.out.println(s);
			System.out.println(s ==stu);  //false
		}
		in.close();
	}

}
