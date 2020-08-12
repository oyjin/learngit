package com.mywork.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

public class Test {

	public static void main(String[] args) throws IOException {
//		File file = new File("src\\task1\\file.txt");
//		if(!file.exists()) {
//			file.createNewFile();
//		}
		InputStream inStream = System.in;
		Reader reader = new InputStreamReader(inStream,"gbk");
		BufferedReader br = new BufferedReader(reader);
		String line = br.readLine();
		String s=line.toUpperCase();
		System.out.println(s);
		char [] ch=s.toCharArray();
		OutputStream output = new FileOutputStream("src\\com\\mywork\\task1\\file.txt");
		for(int i=0;i<ch.length;i++) {
			if(ch[i]!='#') {
				output.write(ch[i]);
			}else
				break;
		}
		output.close();
		br.close();
	}

}
