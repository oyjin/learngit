package com.aowin.dom4j;

import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Dom4jWriter {

	public static void main(String[] args) throws Exception{
		//创建document
		Document doc = DocumentHelper.createDocument();
		
		//添加元素
		Element root = doc.addElement("students");
		
		//给root增加元素
		Element stu1 = root.addElement("student");
		
		Element stuno = stu1.addElement("stuno");
		stuno.setText("1001");
		Element stuname = stu1.addElement("stuname");
		stuname.setText("xiaoming");
		Element age = stu1.addElement("age");
		age.setText("20");
		
		
		
		//将document写入xml文件
//		FileWriter fw = new FileWriter("src\\com\\aowin\\dom4j\\dom4j.xml");
//		doc.write(fw);
//		fw.flush();
//		fw.close();
		
		//格式化输出
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setIndent(true);
		
		FileWriter fw = new FileWriter("src\\com\\aowin\\dom4j\\dom4j.xml");
		XMLWriter xw = new XMLWriter(fw,format);
		xw.write(doc);
		xw.flush();
		xw.close();
	}

}
