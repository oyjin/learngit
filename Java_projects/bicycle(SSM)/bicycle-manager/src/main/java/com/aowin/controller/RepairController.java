package com.aowin.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.exception.ServiceException;
import com.aowin.model.Bicycle_info;
import com.aowin.model.Repair_record;
import com.aowin.service.impl.RepairRegistServiceImpl;
import com.aowin.service.impl.RepairSelectServiceImpl;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/main/repair")
public class RepairController {
	
	private Logger logger = Logger.getLogger(MsPhaseController.class);
	
	@Autowired
	private RepairSelectServiceImpl repairSelectServiceImpl;
	
	@Autowired
	private RepairRegistServiceImpl repairRegistServiceImpl;
	
	/**
	 * 查询所有状态为维修调出的车辆返回到界面
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/select")
	public PageInfo<Bicycle_info> select(@RequestParam(defaultValue = "1") int pageNum){
		return repairSelectServiceImpl.select(pageNum);
	}
	
	/**
	 * 维修登记操作
	 * @param repair
	 * @param br
	 * @return
	 */
	@RequestMapping(value = "/register",produces = "text/plain;charset=utf-8")
	public String repaiRegist(@Validated Repair_record repair,BindingResult br) {
		if(br.hasErrors()) {
			return "fail";
		}
		try {
			repairRegistServiceImpl.repairRegist(repair);
			return "success";
		} catch (ServiceException e) {
			return e.getMessage();
		}catch (Exception e) {
			logger.error("服务端异常", e);
			return "服务端 异常";
		}
	}
	
	
}
