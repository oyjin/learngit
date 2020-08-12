package com.mywork.task3;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
public static void main(String[] args) throws IOException {
	FileWriter fw = new FileWriter("src\\com\\mywork\\task3\\data.txt");
	fw.write("3.1415926");
	fw.flush();
	fw.close();
	FileReader reader = new FileReader("src\\com\\mywork\\task3\\data.txt");
	char[] buf = new char[50];
	reader.read(buf);
	reader.close();
	String str = new String(buf);
	double pi=Double.parseDouble(str);
	System.out.println(pi);
}
}
