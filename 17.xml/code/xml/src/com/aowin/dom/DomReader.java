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
		//����dom��ʽ����xml�ļ�������
		
		DocumentBuilderFactory facory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = facory.newDocumentBuilder();
		Document doc = builder.parse(new File("src\\com\\aowin\\dom\\dom.xml"));
	
		//��ȡ�ӽڵ�
		Node node = doc.getFirstChild();  //��ȡ���ڵ�===students
		Element root = (Element) node;
		
		//��ȡ�ӽڵ�ü��ϣ�����Ԫ��Element�Ϳհײ���Text
		NodeList nodeList = root.getChildNodes();  //��ȡstudent
		System.out.println(nodeList.getLength());  //2
		
		for(int i=0;i<nodeList.getLength();i++) {
			Node stu = nodeList.item(i);  //student
			NodeList stuNodes = stu.getChildNodes();
			for(int j=0;j<stuNodes.getLength();j++) {
				Node n = stuNodes.item(j);
				//System.out.println(n.getNodeName()+"="+n.getTextContent());
			}
		}
		
		
		//ֱ�ӻ�ȡָ����ǵ�Ԫ��
		NodeList eList = doc.getElementsByTagName("stuname");
		for(int i=0;i<eList.getLength();i++) {
			Element e = (Element) eList.item(i);
			//System.out.println(e.getTextContent());
		}
	}

}
