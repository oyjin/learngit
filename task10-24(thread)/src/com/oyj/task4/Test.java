package com.oyj.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class Test {
public static void main(String[] args) {
	T1 t1=new T1();
	T2 t2=new T2();
	t2.setT(t1);
	t1.start();
	t2.start();
}
}

class T1 extends Thread{

	@Override
	public void run() {
		System.out.println("犇");
	}
	
}

class T2 extends Thread{
	private Thread t;
	
	public void setT(Thread t) {
		this.t = t;
	}
	@Override
	public void run() {
		try {
			t.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		InputStream inStream = System.in;
		System.out.println("请输入第一个线程给出的汉字：");
		try {
			Reader reader = new InputStreamReader(inStream);
			BufferedReader br = new BufferedReader(reader);
			String line = br.readLine();
			System.out.println("您输入的是："+line);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}