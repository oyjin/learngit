package com.aowin.model;

public class Usage_rate {

	private Double lend;
	private Double repay;
	private Double enter;
	private Double export;
	public Double getLend() {
		return lend;
	}
	public void setLend(Double lend) {
		this.lend = lend;
	}
	public Double getRepay() {
		return repay;
	}
	public void setRepay(Double repay) {
		this.repay = repay;
	}
	public Double getEnter() {
		return enter;
	}
	public void setEnter(Double enter) {
		this.enter = enter;
	}
	public Double getExport() {
		return export;
	}
	public void setExport(Double export) {
		this.export = export;
	}
	
	public Usage_rate(Double lend, Double repay, Double enter, Double export) {
		super();
		this.lend = lend;
		this.repay = repay;
		this.enter = enter;
		this.export = export;
	}
	public Usage_rate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
