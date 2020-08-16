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
		   * �޸��ı�
		   * ������Element��ǩ���setTest("���ı�ֵ")����
         * 1.�õ���ǩ����
         * 2.�޸��ı�
         */
		Document doc = reader.read(new File("src\\com\\aowin\\dom4j\\dom4j.xml"));
		Element age = doc.getRootElement().element("student").element("age");
		Element stuname = doc.getRootElement().element("student").element("stuname");
		System.out.println(age.getName()+": "+age.getText());
		stuname.setText("dabai");
		age.setText("33");
		System.out.println(age.getName()+": "+age.getText()+"\\r\\n"+stuname.getName()+": "+stuname.getText());
		
		//ָ���ļ������λ��
		FileOutputStream out = new FileOutputStream("src\\dom4j.xml");
		
		// ָ���ı���д���ĸ�ʽ��
		OutputFormat format=OutputFormat.createPrettyPrint();	// pretty��ʽ���пո���
		format.setEncoding("UTF-8");
		
		//1.����д������
        XMLWriter writer=new XMLWriter(out,format);
        //2.д��Document����
        writer.write(doc);
        //3.�ر���
        writer.close();
		
	}
}
