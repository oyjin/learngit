package com.aowin.model;

public class Address {
	
	private String name;
	private String phone;
	private String addr;
	
	@Override
	public String toString() {
		return "Address [name=" + name + ", phone=" + phone + ", addr=" + addr + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
	

}
