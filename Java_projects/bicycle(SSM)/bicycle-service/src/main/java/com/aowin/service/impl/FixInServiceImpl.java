package com.aowin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.Bicycle_dealMapper;
import com.aowin.dao.Bicycle_deployMapper;
import com.aowin.dao.Bicycle_infoMapper;
import com.aowin.dao.Bicycle_pileMapper;
import com.aowin.exception.ServiceException;
import com.aowin.service.FixInService;
import com.aowin.util.DateUtil;

@Service
public class FixInServiceImpl implements FixInService{
	
	@Autowired
	private Bicycle_infoMapper bicycle_infoMapper; 
	
	@Autowired
	private Bicycle_pileMapper bicycle_pileMapper;
	
	@Autowired
	private Bicycle_deployMapper bicycle_deployMapper;
	
	@Autowired
	private Bicycle_dealMapper bicycle_dealMapper;

	@Transactional
	@Override
	public void fixIn(Integer pile_id, Integer bicycle_id) {
		// 1.车辆状态表中将状态改为在桩，并填入桩号
		int i = bicycle_infoMapper.fixIn(bicycle_id, pile_id);
		if(i != 1) {
			throw new ServiceException("车辆状态修改失败！");
		}
		
		//2.车桩表中状态改为有车，并填入车辆id
		int j = bicycle_pileMapper.updateFixedPile(bicycle_id, pile_id);
		if(j != 1) {
			throw new ServiceException("车辆状态修改失败！");
		}
		
		//3.增加维修调入的调配明细
		String to_time = DateUtil.currentTime();	//获取当前时间作为调入时间
		Integer deploy_id = bicycle_deployMapper.selFixDeployId(bicycle_id);	//查询维修调出时的明细记录id
			//明细表中填入调入信息
		int m = bicycle_deployMapper.setDeploy(deploy_id, pile_id, to_time);
		if(m != 1) {
			throw new ServiceException("维修明细填入失败！");
		}
		
		//4.写车辆业务流水
		int n = bicycle_dealMapper.addFixin(deploy_id, bicycle_id, pile_id, to_time);
		if(n != 1) {
			throw new ServiceException("维修明细填入失败！");
		}
		
	}

}
