package com.aowin.io.object;

import java.io.Serializable;

public class Student implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sno;
	private String name;
	
	//transient:表示这个字段的数据不能序列化，像密码
	private transient int age;
	private String sex;
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
	
}
