package com.aowin.io.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class File_1 {

	public static void main(String[] args)throws Exception {
		//�������������ļ���
		//·����
		//����·�� �����̷���ʼ 
		//���·�� :�������Ŀ�Ķ���Ŀ¼
		//File file = new File("D:\\class\\se1907\\a.txt");
		//File file = new File("a.txt");
		File file = new File("src\\com\\aowin\\io\\file\\a.txt");
		//System.out.println(file.exists());  //�ļ��Ƿ����
//		if(!file.exists()) {
//			//����ļ������ڣ������ļ�
//			file.createNewFile();
//		}
		
		System.out.println(file.length());  //�ļ�����
		System.out.println(file.getAbsolutePath());  //����·��
		System.out.println(file.getPath());  //���·��
		System.out.println(file.getParent());
		System.out.println(file.isFile());  //true
		System.out.println(file.isDirectory());  //false
		System.out.println(file.lastModified()); //���һ���޸ĵ�ʱ��
		
		Date date = new Date(1571708270311L);
		//ʱ���ʽ��
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		System.out.println(format.format(date));
		//Calendar  ����������ʱ��
		
		
		
		
	}

}
