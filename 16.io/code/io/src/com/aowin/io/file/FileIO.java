package com.aowin.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class FileIO {

	public static void main(String[] args) throws Exception{
		//�����������������ļ��У�
		//�ļ������  FileOutputStream   FileWriter
		//���ļ������ݶ�ȡ�������У�
		//�ļ���������FileInputStream    FileReader
		
		
//		FileOutputStream outStream = new FileOutputStream("src\\a.txt");
//		outStream.write(50);
//		outStream.write('a');
//		outStream.flush();  //ˢ�£�
//		outStream.close();
		
//		File file = new File("src\\a.txt");
//		FileInputStream inStream = new FileInputStream(file);
//		int b = inStream.read();
//		inStream.close();
//		System.out.println(b);  //50
//		System.out.println((char)b);  //2
		
		//ʹ���ַ���
		//FileWriter fw = new FileWriter("src\\a.txt"); //��������
//		FileWriter fw = new FileWriter("src\\a.txt",true);  //׷������
//		fw.write("hello w orld");
//		fw.flush();
//		fw.close();
		
//		FileReader reader = new FileReader("src\\a.txt");
//		int b = reader.read();
//		while(b != -1) {  //ֻҪû�ж����ļ��Ľ�β
//			System.out.print((char)b);
//			b = reader.read();  //�������¶�
//		}
//		reader.close();
		
//		FileReader reader = new FileReader("src\\a.txt");
//		char[] buf = new char[50];  //����
//		reader.read(buf);
//		reader.close();
//		
//		String str = new String(buf);
//		System.out.println(str);
		
		//��ϰ���ļ�����
	}

}
