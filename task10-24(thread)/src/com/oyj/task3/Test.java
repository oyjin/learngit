package com.oyj.task3;

public class Test {
public static void main(String[] args) {
	T1 t1=new T1();
	show(t1);
	show(t1);
}

public static void show(T1 t) {
	t.start();
}
}

class T1 extends Thread{

	@Override
	public void run() {
		System.out.println("t1线程被调用");
	}
	
}
