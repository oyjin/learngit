package com.aowin.io.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class File_1 {

	public static void main(String[] args)throws Exception {
		//参数：操作的文件：
		//路径：
		//绝对路径 ：从盘符开始 
		//相对路径 :相对于项目的顶层目录
		//File file = new File("D:\\class\\se1907\\a.txt");
		//File file = new File("a.txt");
		File file = new File("src\\com\\aowin\\io\\file\\a.txt");
		//System.out.println(file.exists());  //文件是否存在
//		if(!file.exists()) {
//			//如果文件不存在，创建文件
//			file.createNewFile();
//		}
		
		System.out.println(file.length());  //文件长度
		System.out.println(file.getAbsolutePath());  //绝对路径
		System.out.println(file.getPath());  //相对路径
		System.out.println(file.getParent());
		System.out.println(file.isFile());  //true
		System.out.println(file.isDirectory());  //false
		System.out.println(file.lastModified()); //最后一次修改的时间
		
		Date date = new Date(1571708270311L);
		//时间格式化
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		System.out.println(format.format(date));
		//Calendar  日历来处理时间
		
		
		
		
	}

}
