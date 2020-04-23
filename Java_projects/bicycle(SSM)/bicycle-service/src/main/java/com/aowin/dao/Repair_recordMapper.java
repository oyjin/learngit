package com.aowin.dao;

import org.apache.ibatis.annotations.Param;

import com.aowin.model.Repair_record;

public interface Repair_recordMapper {
	
	/**
	 * 新增一条修理记录
	 * @param repair_record
	 * @return
	 */
	public int addRepairRecord(Repair_record repair_record);
	
	/**
	 * 根据车辆id和维修日期查询修理记录id;
	 * @param bicycle_id
	 * @param repair_date
	 * @return
	 */
	public int selRepairId(@Param("bicycle_id") Integer bicycle_id,@Param("repair_date") String repair_date);
	
	/**
	 * 根据车辆id查询维修记录id（进行报废登记）
	 * @param bicycle_id
	 * @return
	 */
	public Integer selRecordId(Integer bicycle_id);

}
