package com.mywork.task5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("src\\com\\mywork\\task5\\bird.jpg");
		FileOutputStream fos=new FileOutputStream("src\\bird.jpg");
		byte[] bt=new byte[1024];
		while(fis.read(bt)!=-1) {
			fos.write(bt);
		}
	}

}
