package com.aowin.io.buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Test {

	public static void main(String[] args)throws Exception {
		//有缓冲区的输入输出流
		//BufferedInputStream   BufferedOutputStream
		//BufferedReader   BufferedWriter
//		
//		BufferedWriter writer = new BufferedWriter(new FileWriter("src\\a.txt"));
//		//BufferedWriter writer = new BufferedWriter(new FileWriter("src\\a.txt",true));
//		writer.write("hello world");
//		writer.newLine();  //添加换行符
//		writer.write("第二行的内容");
//		writer.flush();
//		writer.close();
		
		
		//BufferedReader可以整行读取
		BufferedReader reader = new BufferedReader(new FileReader("src\\a.txt"));
		String line = reader.readLine();
		while(line != null) {
			System.out.println(line);
			line = reader.readLine();
		}
		reader.close();
	}

}
