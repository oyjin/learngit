package com.aowin.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomWriter {

	public static void main(String[] args)throws Exception {
		//采用dom形式生成xml文件
		//Document==>DocumentBuilder==>DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();  //创建一个新得document
		
		//区分节点和元素
		
		//给doc增加元素
		Element root = doc.createElement("students");  //参数是标记名字
		doc.appendChild(root);
		
		//给root增加子元素
		Element stu1 = doc.createElement("student");  //参数是标记名字
		root.appendChild(stu1);
		
		Element stu2 = doc.createElement("student");  //参数是标记名字
		root.appendChild(stu2);
		
		//给元素增加属性
		stu1.setAttribute("id", "1");
		
		//给stu1增加子元素
		Element stuno = doc.createElement("stuno");
		Element stuname = doc.createElement("stuname");
		Element age = doc.createElement("age");
		
		stu1.appendChild(stuno);  //增加子元素
		stu1.appendChild(stuname);
		stu1.appendChild(age);
		
		//给元素增加内容（起始标记和结束标记之间得内容）
		stuno.setTextContent("1001");
		stuname.setTextContent("xiaoming");
		age.setTextContent("20");
		
		
		//写入xml文件
		TransformerFactory factory2 = TransformerFactory.newInstance();
		Transformer trans = factory2.newTransformer();
		
		//可以指定输出属性
//		trans.setOutputProperty(OutputKeys.ENCODING, "gbk");
//		trans.setOutputProperty(OutputKeys.INDENT,"yes");
		
		Source source = new DOMSource(doc);
		File f = new File("src/com/aowin/dom/dom.xml");
		Result result = new StreamResult(f);
		trans.transform(source, result);
		
	}

}
