package com.aowin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface Bicycle_dealMapper {

	/**
	 * 新增维修调出的业务流水
	 * @param creat_time
	 * @param record_id
	 * @param card_id
	 * @param pile_id
	 * @param bicycle_id
	 * @return
	 */
	public int addDeal(@Param("create_time")String create_time,@Param("record_id") int record_id,@Param("card_id") Integer card_id,@Param("pile_id") Integer pile_id,@Param("bicycle_id") Integer bicycle_id);
	
	
	/**
	 * 新增车辆维修的业务流水
	 * @param create_time
	 * @param record_id
	 * @param bicycle_id
	 * @param fee
	 * @return
	 */
	public int addRepairDeal(@Param("create_time")String create_time,@Param("record_id") int record_id,@Param("bicycle_id") Integer bicycle_id,@Param("chg_money") Double chg_money);
	
	/**
	 * 新增车辆维修调入的业务流水
	 * @param record_id
	 * @param bicycle_id
	 * @param pile_id
	 * @return
	 */
	public int addFixin(@Param("record_id") Integer record_id,@Param("bicycle_id") Integer bicycle_id,@Param("pile_id") Integer pile_id,@Param("create_time") String create_time);
	
	/**
	 * 新增车辆报废的业务流水
	 * @param bicycle_id
	 * @param create_time
	 * @param record_id
	 * @return
	 */
	public int addScrapReal(@Param("bicycle_id") Integer bicycle_id,@Param("create_time") String create_time,@Param("record_id") Integer record_id);
	
	/**
	 * 查询车点的日均借出量
	 * @param piles_id
	 * @return
	 */
	public Double selLend(List<Integer> piles_id);
	
	/**
	 * 查询车点的日均还入量
	 * @param piles_id
	 * @return
	 */
	public Double selRepay(List<Integer> piles_id);
	
	/**
	 * 查询车点的日均调入量
	 * @param piles_id
	 * @return
	 */
	public Double selEnter(List<Integer> piles_id);
	
	
	/**
	 * 查询车点的日均调出量
	 * @param piles_id
	 * @return
	 */
	public Double selExport(List<Integer> piles_id);
	
}
