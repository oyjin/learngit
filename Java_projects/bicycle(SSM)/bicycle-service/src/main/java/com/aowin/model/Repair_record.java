package com.aowin.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Repair_record {
	private Integer record_id;
	private Integer bicycle_id;
	
	@NotEmpty
	private String repair_type;
	
	@NotEmpty
	private String repair_part;
	
	@NotEmpty
	private String repair_result;
	
//	//修理费用为整数，或者保留两位小数
//	@Pattern(regexp = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){2})?$")
	private Double fee;
	
	//修理人为2-10位汉字
	@Pattern(regexp = "^[\u4e00-\u9fa5]{2,10}$")
	@NotEmpty
	private String repairer;
	
	@NotEmpty
	private String repair_date;
	private String remark;
	private Integer user_id;
	private String operator_time;
	public Integer getRecord_id() {
		return record_id;
	}
	public void setRecord_id(Integer record_id) {
		this.record_id = record_id;
	}
	public Integer getBicycle_id() {
		return bicycle_id;
	}
	public void setBicycle_id(Integer bicycle_id) {
		this.bicycle_id = bicycle_id;
	}
	public String getRepair_type() {
		return repair_type;
	}
	public void setRepair_type(String repair_type) {
		this.repair_type = repair_type;
	}
	public String getRepair_part() {
		return repair_part;
	}
	public void setRepair_part(String repair_part) {
		this.repair_part = repair_part;
	}
	public String getRepair_result() {
		return repair_result;
	}
	public void setRepair_result(String repair_result) {
		this.repair_result = repair_result;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	
	public String getRepairer() {
		return repairer;
	}
	public void setRepairer(String repairer) {
		this.repairer = repairer;
	}
	public String getRepair_date() {
		return repair_date;
	}
	public void setRepair_date(String repair_date) {
		this.repair_date = repair_date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getOperator_time() {
		return operator_time;
	}
	public void setOperator_time(String operator_time) {
		this.operator_time = operator_time;
	}
	
	

}
