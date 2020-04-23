package com.aowin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.Bicycle_dealMapper;
import com.aowin.dao.Bicycle_deployMapper;
import com.aowin.dao.Bicycle_infoMapper;
import com.aowin.dao.Bicycle_pileMapper;
import com.aowin.dao.CardMapper;
import com.aowin.exception.ServiceException;
import com.aowin.service.FixOutService;
import com.aowin.util.DateUtil;

@Service
public class FixOutServiceImpl implements FixOutService{

	@Autowired
	private CardMapper cardMapper;
	
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
	public void fixOut(String card_code, Integer pile_id, Integer bicycle_id) {

		//1.判断卡类型是否为维修调度卡 （card表）
		Integer type = cardMapper.selCardType(card_code);
		if(type != 5) {
			throw new ServiceException("请使用维修调度卡！"); 
		}
		Integer card_id=cardMapper.selCardId(card_code);
		//2.在bicycle_info表中将被选中的车辆的车辆状态改成5，将所在车桩的id清空
		int up=bicycle_infoMapper.updateInfo(bicycle_id);
		if(up != 1) {
			throw new ServiceException("车辆状态修改失败！");
		}
		
		//3.bicycle_pile中将所在车桩的状态改成2，将所存车辆id清空
		int upp = bicycle_pileMapper.updatePile(pile_id);
		if(upp != 1) {
			throw new ServiceException("车桩状态修改失败！");
		}
		
		//4.记录车辆调配明细，记录车辆id，调出车桩id，调出卡号等信息，调出原因填写（6：维修调出）
		String from_time = DateUtil.currentTime();	//获取当前时间作为调出时间
		int addDeploy = bicycle_deployMapper.insertDeploy(card_id, bicycle_id, pile_id,from_time);
		if(addDeploy != 1) {
			throw new ServiceException("车辆调配明细新增失败！");
		}
		int record_id=bicycle_deployMapper.selDeployId(bicycle_id, from_time);	//查询调配明细id
		
		//5.记录车辆业务流水，业务类型为（6：维修调出），关联的业务记录id填写车辆调配明细id，业务名称填写(维修调出)，是否发生费用为（0：未发生），费用金额填0
		int n=bicycle_dealMapper.addDeal(from_time, record_id, card_id, pile_id, bicycle_id);
		if(n != 1) {
			throw new ServiceException("车辆业务流水新增失败！");
		}
	}

}
