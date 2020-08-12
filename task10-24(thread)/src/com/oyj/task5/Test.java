package com.oyj.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Random;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		Object obj=new Object();
		T1 t1=new T1(obj);
		t1.start();
		T2 t2=new T2(obj);
		t2.start();
		
	}

}
class T1 extends Thread{
	private Object obj;
	static boolean b=true;
	public T1(Object obj) {
		this.obj = obj;
	}
	@Override
	public void run() {
		synchronized (obj) {
			Random r = new Random();
	        int i = r.nextInt(100);
	        System.out.println("随机数已生成");
	        try {
				obj.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	        while(true) {
	        	try {
	        		if(T2.num>i){
		        		System.out.println("猜大了");
		        		obj.notify();
		        		obj.wait();
		        	}else if(T2.num<i) {
		        		System.out.println("猜小了");
		        		obj.notify();
		        		obj.wait();
		        	}else if(T2.num==i) {
		        		System.out.println("猜对了");
		        		b=false;
		        		break;
		        	}
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
		}
	}
}

class T2 extends Thread{
	private Object obj;
	
	public T2(Object obj) {
		this.obj = obj;
	}
	static int num;
	
	@Override
	public void run() {
		synchronized (obj) {
			while(T1.b) {
				try {
					System.out.print("输入你猜的数：");
					InputStream inStream = System.in;
					Reader reader = new InputStreamReader(inStream);
					BufferedReader br = new BufferedReader(reader);
					String line = br.readLine();
					T2.num=Integer.parseInt(line);
					obj.notify();
					obj.wait(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		}
	}

}