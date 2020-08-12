package com.mywork.task4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test2 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//读取序列化的对象
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("src\\a.txt"));
		Object obj = in.readObject();
		if(obj instanceof Member) {
			Member m = (Member) obj;
			System.out.println(m);
		}
		in.close();

	}

}
