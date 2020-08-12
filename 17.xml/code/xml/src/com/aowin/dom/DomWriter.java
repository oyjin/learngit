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
		//����dom��ʽ����xml�ļ�
		//Document==>DocumentBuilder==>DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();  //����һ���µ�document
		
		//���ֽڵ��Ԫ��
		
		//��doc����Ԫ��
		Element root = doc.createElement("students");  //�����Ǳ������
		doc.appendChild(root);
		
		//��root������Ԫ��
		Element stu1 = doc.createElement("student");  //�����Ǳ������
		root.appendChild(stu1);
		
		Element stu2 = doc.createElement("student");  //�����Ǳ������
		root.appendChild(stu2);
		
		//��Ԫ����������
		stu1.setAttribute("id", "1");
		
		//��stu1������Ԫ��
		Element stuno = doc.createElement("stuno");
		Element stuname = doc.createElement("stuname");
		Element age = doc.createElement("age");
		
		stu1.appendChild(stuno);  //������Ԫ��
		stu1.appendChild(stuname);
		stu1.appendChild(age);
		
		//��Ԫ���������ݣ���ʼ��Ǻͽ������֮������ݣ�
		stuno.setTextContent("1001");
		stuname.setTextContent("xiaoming");
		age.setTextContent("20");
		
		
		//д��xml�ļ�
		TransformerFactory factory2 = TransformerFactory.newInstance();
		Transformer trans = factory2.newTransformer();
		
		//����ָ���������
//		trans.setOutputProperty(OutputKeys.ENCODING, "gbk");
//		trans.setOutputProperty(OutputKeys.INDENT,"yes");
		
		Source source = new DOMSource(doc);
		File f = new File("src/com/aowin/dom/dom.xml");
		Result result = new StreamResult(f);
		trans.transform(source, result);
		
	}

}
