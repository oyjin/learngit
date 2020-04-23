package com.aowin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.Bicycle_dealMapper;
import com.aowin.dao.Bicycle_infoMapper;
import com.aowin.dao.Repair_recordMapper;
import com.aowin.exception.ServiceException;
import com.aowin.model.Repair_record;
import com.aowin.util.DateUtil;

@Service
public class RepairRegistServiceImpl {
	
	@Autowired
	private Repair_recordMapper repair_recordMapper;
	
	@Autowired
	private Bicycle_dealMapper bicycle_dealMapper;
	
	@Autowired
	private Bicycle_infoMapper bicycle_infoMapper;
	
	@Transactional
	public void repairRegist(Repair_record repair_record) {
		
		//1.写修理记录
		int i = repair_recordMapper.addRepairRecord(repair_record);
		if(i != 1) {
			throw new ServiceException("维修记录新增失败");
		}
		
		//2.写车辆业务流水
		String create_time = DateUtil.currentTime();	//获取当前时间作为流水表发生时间
		Integer bicycle_id = repair_record.getBicycle_id();  //获取维修的车辆id
		String repair_date = repair_record.getRepair_date();	//获取车辆修理日期
		Integer record_id = repair_recordMapper.selRepairId(bicycle_id, repair_date);	//获取维修记录id
		Double chg_money = repair_record.getFee();
		int n = bicycle_dealMapper.addRepairDeal(create_time, record_id, bicycle_id, chg_money);
		if(n != 1) {
			throw new ServiceException("车辆业务流水新增失败！");
		}
		
		//3.车辆状态改为7.维修成功 或8.维修失败
		String result =repair_record.getRepair_result();
		Integer status = null;	//根据修理结果获得当前车辆状态
		if("1".equals(result)) {
			status = 7;
		}else if("2".equals(result)) {
			status = 8;
		}
		int k = bicycle_infoMapper.updateStatus(bicycle_id, status);
		if(k != 1) {
			throw new ServiceException("车辆状态修改失败！");
		}
	}

}
