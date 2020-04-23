package com.aowin.model;

public class BookRecord {
	private Integer recordid;
	private Integer userid;
	private Integer bookid;
	private String lendtime;
	private String returntime;
	private String expiretime;
	private String remaintime;
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
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getLendtime() {
		return lendtime;
	}
	public void setLendtime(String lendtime) {
		this.lendtime = lendtime;
	}
	public String getReturntime() {
		return returntime;
	}
	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}
	public String getExpiretime() {
		return expiretime;
	}
	public void setExpiretime(String expiretime) {
		this.expiretime = expiretime;
	}
	public String getRemaintime() {
		return remaintime;
	}
	public void setRemaintime(String remaintime) {
		this.remaintime = remaintime;
	}
	
}
