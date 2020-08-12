package com.aowin.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomReader {
	public static void main(String[] args) throws Exception{
		//采用dom形式解析xml文件得内容
		
		DocumentBuilderFactory facory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = facory.newDocumentBuilder();
		Document doc = builder.parse(new File("src\\com\\aowin\\dom\\dom.xml"));
	
		//获取子节点
		Node node = doc.getFirstChild();  //获取根节点===students
		Element root = (Element) node;
		
		//获取子节点得集合：包括元素Element和空白部分Text
		NodeList nodeList = root.getChildNodes();  //获取student
		System.out.println(nodeList.getLength());  //2
		
		for(int i=0;i<nodeList.getLength();i++) {
			Node stu = nodeList.item(i);  //student
			NodeList stuNodes = stu.getChildNodes();
			for(int j=0;j<stuNodes.getLength();j++) {
				Node n = stuNodes.item(j);
				//System.out.println(n.getNodeName()+"="+n.getTextContent());
			}
		}
		
		
		//直接获取指定标记得元素
		NodeList eList = doc.getElementsByTagName("stuname");
		for(int i=0;i<eList.getLength();i++) {
			Element e = (Element) eList.item(i);
			//System.out.println(e.getTextContent());
		}
	}

}
