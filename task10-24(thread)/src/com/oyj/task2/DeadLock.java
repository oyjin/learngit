package com.oyj.task2;

public class DeadLock {

	public static void main(String[] args) {
		Object obj1=new Object();
		Object obj2=new Object();
		
		T1 t1=new T1(obj1, obj2);
		T2 t2=new T2(obj1, obj2);
		t1.start();
		t2.start();
	}

}

class T1 extends Thread{
	private Object obj1;
	private Object obj2;
	public T1(Object obj1,Object obj2) {
		this.obj1=obj1;
		this.obj2=obj2;
	}
	@Override
	public void run() {
		synchronized (obj1) {
			System.out.println("t1获取obj1,执行任务");
			synchronized (obj2) {
				System.out.println("t1获取obj2,执行任务");
			}
		}
		
	}
	
}

class T2 extends Thread{
	private Object obj1;
	private Object obj2;
	public T2(Object obj1,Object obj2) {
		this.obj1=obj1;
		this.obj2=obj2;
	}
	@Override
	public void run() {
		synchronized (obj2) {
			System.out.println("t2获取obj2,执行任务");
			synchronized (obj1) {
				System.out.println("t2获取obj1,执行任务");
			}
		}
		
	}
	
}