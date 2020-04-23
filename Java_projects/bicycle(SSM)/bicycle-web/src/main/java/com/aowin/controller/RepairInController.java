package com.aowin.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.dao.Bicycle_infoMapper;
import com.aowin.exception.ServiceException;
import com.aowin.model.Bicycle_info;
import com.aowin.service.FixInService;

@RestController
public class RepairInController {

	private Logger logger = Logger.getLogger(RepairInController.class);
	
	@Autowired
	private Bicycle_infoMapper bicycle_infoMapper;
	
	@Autowired
	private FixInService fixInServiceImpl;
	
	/**
	 * 查询所有状态为维修成功的车辆并返回
	 * @return
	 */
	@RequestMapping("/success")
	public List<Bicycle_info> fixed(){
		return bicycle_infoMapper.selFixed();
	}
	
	/**
	 * 维修调入操作
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/repairIn",produces = "text/plain;charset=utf-8")
	public String repairIn(@RequestParam Map<String, String> map) {
		Integer bicycle_id = Integer.valueOf(map.get("bicycle_id"));
		Integer pile_id = Integer.valueOf(map.get("pile_id"));
		try {
			fixInServiceImpl.fixIn(pile_id, bicycle_id);
			return "success";
		} catch (ServiceException e) {
			return e.getMessage();
		}catch (Exception e) {
			logger.error("服务端异常", e);
			return "服务端异常";
		}
	}
}
