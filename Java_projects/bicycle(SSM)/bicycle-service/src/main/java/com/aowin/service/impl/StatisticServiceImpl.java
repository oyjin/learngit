package com.aowin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.aowin.dao.Bicycle_dealMapper;
import com.aowin.dao.Bicycle_pileMapper;
import com.aowin.model.Usage_rate;

@Service
public class StatisticServiceImpl {

	@Autowired
	private Bicycle_pileMapper bicycle_pileMapper;
	
	@Autowired
	private Bicycle_dealMapper bicycle_dealMapper;
	
	/**
	 * 车点使用率统计的方法
	 * @param station_id
	 * @return
	 */
	public Usage_rate selRate(@RequestParam int station_id) {
		//1.查询该车点所有车桩id
		List<Integer> piles_id = bicycle_pileMapper.selAllPile(station_id);
		
		//2.查询该车点的各种日均量
		double lend = bicycle_dealMapper.selLend(piles_id);
		double repay = bicycle_dealMapper.selRepay(piles_id);
		double enter = bicycle_dealMapper.selEnter(piles_id);
		double export = bicycle_dealMapper.selExport(piles_id);
		
		return new Usage_rate(lend, repay, enter, export);
	}
}
