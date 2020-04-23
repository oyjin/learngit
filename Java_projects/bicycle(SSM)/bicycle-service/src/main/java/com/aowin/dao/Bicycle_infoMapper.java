package com.aowin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aowin.model.Bicycle_info;

public interface Bicycle_infoMapper {

	/**
	 * 查询所有状态为 5：维修调出 的车辆
	 * @return
	 */
	public List<Bicycle_info> selInfo();
	
	
	/**
	 * 查询所有状态为7：维修成功的车辆
	 * @return
	 */
	public List<Bicycle_info> selFixed();
	
	/**
	 * 查询所有状态为8：维修失败的车辆
	 * @return
	 */
	public List<Bicycle_info> selScrap();
	
	/**
	 * 修改维修调出的车辆状态
	 * @param bicycle_id
	 * @return
	 */
	public int updateInfo(Integer bicycle_id);
	
	/**
	 * 根据维修结果修改车辆状态
	 * @param bicycle_id
	 * @param status
	 * @return
	 */
	public int updateStatus(@Param("bicycle_id") Integer bicycle_id,@Param("status") Integer status);
	
	/**
	 * 维修调入的车辆状态修改为3：在桩，并修改所在车桩
	 * @param pile_id
	 * @return
	 */
	public int fixIn(@Param("bicycle_id") Integer bicycle_id,@Param("pile_id") Integer pile_id);
	
}
