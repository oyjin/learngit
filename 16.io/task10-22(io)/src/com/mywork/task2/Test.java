package com.mywork.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Test {

	public static void main(String[] args) throws IOException {
		InputStream inStream = System.in;
		Reader reader = new InputStreamReader(inStream);
		BufferedReader br = new BufferedReader(reader);
		String link = br.readLine();
		File file=new File(link);
		System.out.println(file.length()); 
		System.out.println(file.getAbsolutePath());  
		System.out.println(file.getPath());  
		System.out.println(file.getParent());
		System.out.println(file.isFile()); 
		System.out.println(file.isDirectory());
		System.out.println(file.lastModified()); 
		inStream.close();
		reader.close();
		br.close();
	}

}
