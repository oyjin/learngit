package com.oyj.task2;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class Dom4jReader {
	public static void main(String[] args) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("src\\com\\aowin\\dom4j\\dom4j.xml"));
	}
}
