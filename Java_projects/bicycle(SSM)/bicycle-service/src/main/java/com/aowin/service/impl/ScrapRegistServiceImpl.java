package com.aowin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.Bicycle_dealMapper;
import com.aowin.dao.Bicycle_infoMapper;
import com.aowin.dao.Repair_recordMapper;
import com.aowin.exception.ServiceException;
import com.aowin.service.ScrapRegistService;
import com.aowin.util.DateUtil;

@Service
public class ScrapRegistServiceImpl implements ScrapRegistService{
	
	@Autowired
	private Bicycle_infoMapper bicycle_infoMapper;
	
	@Autowired
	private Bicycle_dealMapper bicycle_dealMapper;
	
	@Autowired
	private Repair_recordMapper repair_recordMapper;

	@Transactional
	@Override
	public void scrapRegist(Integer bicycle_id) {
		// 1.修改车辆状态为（9：报废）
		Integer status = 9;
		int i = bicycle_infoMapper.updateStatus(bicycle_id, status);
		if(i != 1) {
			throw new ServiceException("车辆状态修改失败");
		}
		
		//2.填写车辆业务流水，业务类型为（9：报废）关联的业务记录id填写车辆维修信息id，业务名称填写（报废）是否发生费用为（0：未发生）费用金额填写0
		
		//2.1查询车辆维修信息id
		Integer record_id = repair_recordMapper.selRecordId(bicycle_id);
		
		//2.2 获取业务发生时间
		String create_time = DateUtil.currentTime();
		
		//2.3 写业务流水
		int n = bicycle_dealMapper.addScrapReal(bicycle_id, create_time, record_id);
		if(n != 1) {
			throw new ServiceException("业务流水新增失败");
		}
	}

	
}
