package com.aowin.model;

public class AccountRecord {
	private Integer recordid;
	private Integer userid;
	private double money;
	private String changetime;
	private Integer type;
	public Integer getRecordid() {
		return recordid;
	}
	public void setRecordid(Integer recordid) {
		this.recordid = recordid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getChangetime() {
		return changetime;
	}
	public void setChangetime(String changetime) {
		this.changetime = changetime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
}
