package com.aowin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aowin.constants.PageConfig;
import com.aowin.dao.Bicycle_infoMapper;
import com.aowin.model.Bicycle_info;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ScrapBicycleServiceImpl {

	@Autowired
	private Bicycle_infoMapper bicycleMapper;
	
	/**
	 * 分页查询所有状态为维修调出的车辆
	 * @param pageNum
	 * @return
	 */
	public PageInfo<Bicycle_info> select(int pageNum){
		PageHelper.startPage(pageNum, PageConfig.PAGE_SIZE);

		List<Bicycle_info> bic = bicycleMapper.selScrap();
		
		return new PageInfo<Bicycle_info>(bic);
	}
}
