package com.aowin.io.zhuan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class Test {

	public static void main(String[] args)throws Exception {
		//将字节流转成字符流
		
		//InputStreamReader   OutputstreamWriter
		
		InputStream inStream = System.in;  //指向控制台的字节流
		
		//转换
		//Reader reader = new InputStreamReader(inStream,"gbk");
//		Reader reader = new InputStreamReader(inStream);
//		
//		//能读一行
//		BufferedReader br = new BufferedReader(reader);
//		String line = br.readLine();
//		System.out.println(line);
//		br.close();
		
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\a.txt")));
		writer.write("aaaaaa");
		writer.newLine();
		writer.write("bbbb");
		writer.flush();
		writer.close();
	}

}
