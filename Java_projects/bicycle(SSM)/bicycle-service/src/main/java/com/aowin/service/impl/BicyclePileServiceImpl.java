package com.aowin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aowin.constants.PageConfig;
import com.aowin.dao.Bicycle_pileMapper;
import com.aowin.dao.Bicycle_stationMapper;
import com.aowin.model.Bicycle_pile;
import com.aowin.model.Bicycle_station;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BicyclePileServiceImpl {
	
	@Autowired
	private Bicycle_stationMapper bicycle_stationMapper;
	
	@Autowired
	private Bicycle_pileMapper bicycle_pileMapper;
	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param msPhase
	 * @return
	 */
	public PageInfo<Bicycle_station> select(int pageNum,Bicycle_station bicycle_station){
		PageHelper.startPage(pageNum, PageConfig.PAGE_SIZE);
		List<Bicycle_station> ls = bicycle_stationMapper.select(bicycle_station);
		
		return new PageInfo<Bicycle_station>(ls);
	}
	
	/**
	 * 查询车桩返回
	 * @param station_id
	 * @return
	 */
	public List<Bicycle_pile> selectpile(int station_id){
		return bicycle_pileMapper.selectpile(station_id);
	}

}
