package com.aowin.dao;

import org.apache.ibatis.annotations.Param;

public interface Bicycle_deployMapper {

	/**
	 * 根据车辆id和调出时间查询明细id
	 * @param bicycle_id
	 * @param from_time
	 * @return
	 */
	public int selDeployId(@Param("bicycle_id") Integer bicycle_id,@Param("from_time") String from_time);
	
	/**
	 * 新增维修调出的车辆调配明细
	 * @param card_code
	 * @param bicycle_id
	 * @param pile_id
	 * @return
	 */
	public int insertDeploy(@Param("card_id") int card_id,@Param("bicycle_id") Integer bicycle_id,@Param("pile_id") Integer pile_id,@Param("from_time") String from_time);
	
	/**
	 * 根据车辆id查询调配明细记录id（准备进行维修调入）
	 * @param bicycle_id
	 * @return
	 */
	public Integer selFixDeployId(Integer bicycle_id);
	
	
	/**
	 * 车辆维修调入时，调配明细表中填入调入时间，调入车桩，调入原因等
	 * @param pile_id
	 * @param to_time
	 * @return
	 */
	public int setDeploy(@Param("deploy_id") Integer deploy_id,@Param("pile_id") Integer pile_id,@Param("to_time") String to_time);
	
}
