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
		//���ֽ���ת���ַ���
		
		//InputStreamReader   OutputstreamWriter
		
		InputStream inStream = System.in;  //ָ�����̨���ֽ���
		
		//ת��
		//Reader reader = new InputStreamReader(inStream,"gbk");
//		Reader reader = new InputStreamReader(inStream);
//		
//		//�ܶ�һ��
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
