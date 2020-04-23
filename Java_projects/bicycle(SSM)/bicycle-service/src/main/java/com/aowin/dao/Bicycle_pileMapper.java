package com.aowin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aowin.model.Bicycle_pile;

public interface Bicycle_pileMapper {
	
	/**
	 * 查询车桩
	 * @param station_id
	 * @return
	 */
	public List<Bicycle_pile> selectpile(int station_id);

	/**
	 * 查询所有状态为2：无车的车桩
	 * @return
	 */
	public List<Bicycle_pile> showPile();
	
	/**
	 * 修改维修调出的车桩状态
	 * @param pile_id
	 * @return
	 */
	public int updatePile(Integer pile_id);
	
	/**
	 * 维修调入的车桩状态改为1：有车，并设置车辆id
	 * @param bicycle_id
	 * @param pile_id
	 * @return
	 */
	public int updateFixedPile(@Param("bicycle_id") Integer bicycle_id,@Param("pile_id") Integer pile_id);
	
	/**
	 * 根据车点id查询所有车桩id
	 * @param station_id
	 * @return
	 */
	public List<Integer> selAllPile(Integer station_id);
}
