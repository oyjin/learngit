package com.aowin.dao;

import java.util.List;

import com.aowin.model.Bicycle_station;

public interface Bicycle_stationMapper {
	
	/**
	 * 查询车点
	 * @param bis
	 * @return
	 */
	public List<Bicycle_station> select(Bicycle_station bis);

}
