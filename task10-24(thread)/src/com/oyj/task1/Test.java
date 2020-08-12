package com.oyj.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) throws IOException {
		Stu1 s1=new Stu1();
		Stu2 s2=new Stu2();
		Stu3 s3=new Stu3();
		
		s1.start();
		s2.start();
		s3.start();
	}

}

class Stu1 extends Thread{

	@Override
	public void run() {
		System.out.println("1号学生跑完了");
	}
	
}
class Stu2 extends Thread{

	@Override
	public void run() {
		System.out.println("2号学生跑完了");
	}
	
}
class Stu3 extends Thread{

	@Override
	public void run() {
		System.out.println("3号学生跑完了");
	}
	
}