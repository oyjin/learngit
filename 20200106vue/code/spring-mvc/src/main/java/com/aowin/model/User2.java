package com.aowin.model;

import java.util.Arrays;
import java.util.List;

public class User2 {
	
	private String username;
	private Integer sex;
	private Integer[] hobby;
	
	private List<Address> address;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer[] getHobby() {
		return hobby;
	}

	public void setHobby(Integer[] hobby) {
		this.hobby = hobby;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User2 [username=" + username + ", sex=" + sex + ", hobby=" + Arrays.toString(hobby) + ", address="
				+ address + "]";
	}
	
	
	

}
