package com.aowin.dom4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;



public class ModifyXml {
	public static void main(String[] args) throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		/**
		   * 修改文本
		   * 方法：Element标签类的setTest("新文本值")方法
         * 1.得到标签对象
         * 2.修改文本
         */
		Document doc = reader.read(new File("src\\com\\aowin\\dom4j\\dom4j.xml"));
		Element age = doc.getRootElement().element("student").element("age");
		Element stuname = doc.getRootElement().element("student").element("stuname");
		System.out.println(age.getName()+": "+age.getText());
		stuname.setText("dabai");
		age.setText("33");
		System.out.println(age.getName()+": "+age.getText()+"\\r\\n"+stuname.getName()+": "+stuname.getText());
		
		//指定文件输出的位置
		FileOutputStream out = new FileOutputStream("src\\dom4j.xml");
		
		// 指定文本的写出的格式：
		OutputFormat format=OutputFormat.createPrettyPrint();	// pretty格式，有空格换行
		format.setEncoding("UTF-8");
		
		//1.创建写出对象
        XMLWriter writer=new XMLWriter(out,format);
        //2.写出Document对象
        writer.write(doc);
        //3.关闭流
        writer.close();
		
	}
}
