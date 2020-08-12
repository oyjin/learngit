package com.oyj.task1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomWriter {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		
		Element root = doc.createElement("databases"); 
		doc.appendChild(root);
		Element data = doc.createElement("database");
		root.appendChild(data);
		
		Element ur = doc.createElement("url");
		Element us = doc.createElement("user");
		Element ps = doc.createElement("password");
		data.appendChild(ur);
		data.appendChild(us);
		data.appendChild(ps);
		
		ur.setTextContent("jdbc:mysql://localhost:3306/mytest");
		us.setTextContent("root");
		ps.setTextContent("38324");
		
		TransformerFactory factory2 = TransformerFactory.newInstance();
		Transformer trans = factory2.newTransformer();
		
		Source source = new DOMSource(doc);
		File f = new File("src/com/oyj/task1/config.xml");
		Result result = new StreamResult(f);
		trans.transform(source, result);
	}

}
