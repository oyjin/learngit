package com.aowin.service;

public interface SubmitService {
	/**
	 * 健康信息上报
	 * @param userid
	 * @param name
	 * @param card
	 * @param mobile
	 * @param address
	 */
	public void submitMessage(int userid,String name,String card,String mobile,int address);
}
