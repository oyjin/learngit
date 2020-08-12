package com.oyj.task1;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DbUtil {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载成功");
		} catch (ClassNotFoundException e) {
			System.out.println("加载失败");
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws Exception {
		DocumentBuilderFactory facory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = facory.newDocumentBuilder();
		Document doc = builder.parse(new File("src\\com\\oyj\\task1\\config.xml"));
		
		//直接获取指定标记的元素
		NodeList uList = doc.getElementsByTagName("url");
		Element u = (Element) uList.item(0);
		NodeList usList=doc.getElementsByTagName("user");
		Element us=(Element) usList.item(0);
		NodeList psList=doc.getElementsByTagName("password");
		Element ps=(Element) psList.item(0);
		
		//获得数据库连接
		Connection con=null;
		try {
			con=DriverManager.getConnection(u.getTextContent(),us.getTextContent(),ps.getTextContent());
			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			System.out.println("获得连接失败");
			e.printStackTrace();
		}
		return con;
	}

}
