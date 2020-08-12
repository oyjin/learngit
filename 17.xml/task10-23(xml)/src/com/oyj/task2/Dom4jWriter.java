package com.oyj.task2;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Dom4jWriter {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= null;
		Statement s=null;
		ResultSet rs=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root", "38324");
			System.out.println("连接成功");
			String sql="select * from students";
			s=con.createStatement();
			rs=s.executeQuery(sql);
			
			//将结果集中的内容写入Xml文件
			Document doc = DocumentHelper.createDocument();
			Element root = doc.addElement("students");
			while(rs.next()) {
				Element stu1 = root.addElement("student");
				Element stuid = stu1.addElement("id");
				int id=rs.getInt("id");
				stuid.setText(String.valueOf(id));
				Element stuname = stu1.addElement("name");
				stuname.setText(rs.getString("name"));
				Element stuscore = stu1.addElement("score");
				double score=rs.getDouble("score");
				stuscore.setText(String.valueOf(score));
			}
			//格式化输出
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setIndent(true);
			
			FileWriter fw = new FileWriter("src\\com\\oyj\\task2\\dom4jJDBC.xml");
			XMLWriter xw = new XMLWriter(fw,format);
			xw.write(doc);
			xw.flush();
			xw.close();
		} catch (SQLException e) {
			System.out.println("连接失败");
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(s!=null) {
					s.close();
				}
				if(con!=null) {
					con.close();
				}
				System.out.println("资源已经断开");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
