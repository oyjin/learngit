package com.aowin.dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jReader {
	public static void main(String[] args) throws Exception{
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("src\\com\\aowin\\dom4j\\dom4j.xml"));
		//获取根元素
		Element root = doc.getRootElement();
		//System.out.println(root.getName());
		List<Element> eList = root.elements();
		for(Element e:eList) {
			//System.out.println(e.getName());
			Iterator<Element> it = e.elementIterator();
			while(it.hasNext()) {
				Element s = it.next();
				//System.out.println(s.getName()+"=" + s.getText());
			}
		}
		
		//指定元素==>获取直接子元素
		//List<Element> stuList = root.elements("student");
		List<Element> stuList = root.elements("stuname");
		System.out.println(stuList.size());
	}

}
