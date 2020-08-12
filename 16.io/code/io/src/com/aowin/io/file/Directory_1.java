package com.aowin.io.file;

import java.io.File;
import java.io.FileFilter;

public class Directory_1 {
	public static void main(String[] args) throws Exception{
		//File既可以表示文件，也可以表示目录
		//File file = new File("src\\com\\aowin\\io\\file");
		File file = new File("src\\d");
		//System.out.println(file.exists());
//		if(!file.exists()) {
//			//目录不存在，创建目录
//			//file.mkdir();  //单层目录
//			file.mkdirs();    //级联目录，上层不存在的话也创建出来
//		}
		
		//System.out.println(file.length());
		
		String[] namearr = file.list();  //目录中文件的名字
		File[] filearr = file.listFiles();  //目录中的文件
		
		//System.out.println(namearr.length);
		//System.out.println(filearr.length);
		
		//使用文件过滤器选择需要的文件
		File[] filearr2 = file.listFiles(new MyFilter());
		System.out.println(filearr2.length);
		
		System.out.println(file.delete());  //删除文件
		//file.deleteOnExit();  //虚拟机终止时删除文件
		
	}

}

class MyFilter implements FileFilter{

	//返回true表示这个文件经过验证
	public boolean accept(File pathname) {
		//return true;
		//选择java源文件（名字以.java作为后缀）
		if(pathname.getName().endsWith(".java")) {
			return true;
		}
		return false;
	}
	
}
