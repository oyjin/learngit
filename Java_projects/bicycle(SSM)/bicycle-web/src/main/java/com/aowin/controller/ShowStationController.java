package com.aowin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.model.Bicycle_pile;
import com.aowin.model.Bicycle_station;
import com.aowin.service.impl.BicyclePileServiceImpl;
import com.github.pagehelper.PageInfo;

@RestController
public class ShowStationController {

	
	@Autowired
	private BicyclePileServiceImpl bicyclePileServiceImpl;
	
	//车点查询
		@RequestMapping("/showStation")
		public PageInfo<Bicycle_station> select(@RequestParam(defaultValue = "1") int pageNum,Bicycle_station bicycle_station){
			return bicyclePileServiceImpl.select(pageNum, bicycle_station);
		}

		//车桩查询
		@RequestMapping("/showPile")
		public List<Bicycle_pile> selectpile(@RequestParam int station_id){
			return bicyclePileServiceImpl.selectpile(station_id);
		}
}
