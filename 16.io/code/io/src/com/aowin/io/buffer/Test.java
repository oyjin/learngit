package com.aowin.io.buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Test {

	public static void main(String[] args)throws Exception {
		//�л����������������
		//BufferedInputStream   BufferedOutputStream
		//BufferedReader   BufferedWriter
//		
//		BufferedWriter writer = new BufferedWriter(new FileWriter("src\\a.txt"));
//		//BufferedWriter writer = new BufferedWriter(new FileWriter("src\\a.txt",true));
//		writer.write("hello world");
//		writer.newLine();  //��ӻ��з�
//		writer.write("�ڶ��е�����");
//		writer.flush();
//		writer.close();
		
		
		//BufferedReader�������ж�ȡ
		BufferedReader reader = new BufferedReader(new FileReader("src\\a.txt"));
		String line = reader.readLine();
		while(line != null) {
			System.out.println(line);
			line = reader.readLine();
		}
		reader.close();
	}

}
