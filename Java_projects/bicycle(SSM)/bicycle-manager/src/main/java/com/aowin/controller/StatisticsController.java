package com.aowin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.model.Usage_rate;
import com.aowin.service.impl.StatisticServiceImpl;

@RestController
@RequestMapping("/main/statistic")
public class StatisticsController {

	
	@Autowired
	private StatisticServiceImpl statisticServiceImpl;
	
	/**
	 * 车点使用率统计的方法
	 * @param station_id
	 * @return
	 */
	@RequestMapping(value="/select",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public Usage_rate selRate(@RequestParam int station_id) {
		
		return statisticServiceImpl.selRate(station_id);
		
	}
}
