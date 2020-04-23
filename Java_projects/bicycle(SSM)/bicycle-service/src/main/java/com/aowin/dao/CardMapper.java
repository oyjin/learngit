package com.aowin.dao;

public interface CardMapper {

	/**
	 * 查询卡的类型
	 * @param card_code
	 * @return
	 */
	public Integer selCardType(String card_code);
	
	/**
	 * 根据卡号查询卡id
	 * @param card_code
	 * @return
	 */
	public Integer selCardId(String card_code);
	
}
