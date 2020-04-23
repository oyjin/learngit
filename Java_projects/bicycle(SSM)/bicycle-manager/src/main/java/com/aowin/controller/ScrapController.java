package com.aowin.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.exception.ServiceException;
import com.aowin.model.Bicycle_info;
import com.aowin.service.ScrapRegistService;
import com.aowin.service.impl.ScrapBicycleServiceImpl;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/main/scrap")
public class ScrapController {

	private Logger logger = Logger.getLogger(MsPhaseController.class);
	
	@Autowired
	private ScrapBicycleServiceImpl scrapBicycleServiceImpl;
	
	@Autowired
	private ScrapRegistService scrapRegistServiceImpl;
	
	/**
	 * 查询所有状态为维修失败的车辆返回到界面
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/select")
	public PageInfo<Bicycle_info> select(@RequestParam(defaultValue = "1") int pageNum){
		return scrapBicycleServiceImpl.select(pageNum);
	}
	
	/**
	 * 报废登记的方法
	 * @param bicycle_id
	 * @return
	 */
	@RequestMapping("/register")
	public String scrapRegist(@RequestParam int bicycle_id) {
		try {
			scrapRegistServiceImpl.scrapRegist(bicycle_id);
			return "success";
		} catch (ServiceException e) {
			return e.getMessage();
		}catch (Exception e) {
			logger.error("服务端异常", e);
			return "服务端异常";
		}
	}
}
