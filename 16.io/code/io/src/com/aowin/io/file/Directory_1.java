package com.aowin.io.file;

import java.io.File;
import java.io.FileFilter;

public class Directory_1 {
	public static void main(String[] args) throws Exception{
		//File�ȿ��Ա�ʾ�ļ���Ҳ���Ա�ʾĿ¼
		//File file = new File("src\\com\\aowin\\io\\file");
		File file = new File("src\\d");
		//System.out.println(file.exists());
//		if(!file.exists()) {
//			//Ŀ¼�����ڣ�����Ŀ¼
//			//file.mkdir();  //����Ŀ¼
//			file.mkdirs();    //����Ŀ¼���ϲ㲻���ڵĻ�Ҳ��������
//		}
		
		//System.out.println(file.length());
		
		String[] namearr = file.list();  //Ŀ¼���ļ�������
		File[] filearr = file.listFiles();  //Ŀ¼�е��ļ�
		
		//System.out.println(namearr.length);
		//System.out.println(filearr.length);
		
		//ʹ���ļ�������ѡ����Ҫ���ļ�
		File[] filearr2 = file.listFiles(new MyFilter());
		System.out.println(filearr2.length);
		
		System.out.println(file.delete());  //ɾ���ļ�
		//file.deleteOnExit();  //�������ֹʱɾ���ļ�
		
	}

}

class MyFilter implements FileFilter{

	//����true��ʾ����ļ�������֤
	public boolean accept(File pathname) {
		//return true;
		//ѡ��javaԴ�ļ���������.java��Ϊ��׺��
		if(pathname.getName().endsWith(".java")) {
			return true;
		}
		return false;
	}
	
}
