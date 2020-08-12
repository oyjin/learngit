package com.aowin.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class FileIO {

	public static void main(String[] args) throws Exception{
		//将程序的数据输出到文件中：
		//文件输出流  FileOutputStream   FileWriter
		//将文件的数据读取到程序中：
		//文件输入流：FileInputStream    FileReader
		
		
//		FileOutputStream outStream = new FileOutputStream("src\\a.txt");
//		outStream.write(50);
//		outStream.write('a');
//		outStream.flush();  //刷新：
//		outStream.close();
		
//		File file = new File("src\\a.txt");
//		FileInputStream inStream = new FileInputStream(file);
//		int b = inStream.read();
//		inStream.close();
//		System.out.println(b);  //50
//		System.out.println((char)b);  //2
		
		//使用字符流
		//FileWriter fw = new FileWriter("src\\a.txt"); //覆盖内容
//		FileWriter fw = new FileWriter("src\\a.txt",true);  //追加内容
//		fw.write("hello w orld");
//		fw.flush();
//		fw.close();
		
//		FileReader reader = new FileReader("src\\a.txt");
//		int b = reader.read();
//		while(b != -1) {  //只要没有读到文件的结尾
//			System.out.print((char)b);
//			b = reader.read();  //继续向下读
//		}
//		reader.close();
		
//		FileReader reader = new FileReader("src\\a.txt");
//		char[] buf = new char[50];  //缓存
//		reader.read(buf);
//		reader.close();
//		
//		String str = new String(buf);
//		System.out.println(str);
		
		//练习：文件复制
	}

}
