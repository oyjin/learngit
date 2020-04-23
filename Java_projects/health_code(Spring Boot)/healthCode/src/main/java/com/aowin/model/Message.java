package com.aowin.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Message {
	private Integer userid;
	@NotEmpty
	private String name;
	@Pattern(regexp = "(\\d{15})|(^\\d{18})|(^\\d{17}(\\d|X|x))")
	@NotEmpty
	private String card;
	@Pattern(regexp = "1[35-8]\\d{9}")
	@NotEmpty
	private String mobile;
	
	private Integer address;
	private String ptime;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getAddress() {
		return address;
	}
	public void setAddress(Integer address) {
		this.address = address;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	
}
