package com.aowin.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.exception.ServiceException;
import com.aowin.service.FixOutService;

@RestController
public class RepairOutController {

	private Logger logger = Logger.getLogger(RepairOutController.class);
	
	@Autowired
	private FixOutService fixOutServiceImpl;
	
	//维修调出
		@RequestMapping(value="/fixOut",produces = "text/plain;charset=utf-8")
		public String fixOut(@RequestParam Map<String, String> map) {
			String card_code = map.get("card_code");
			String pi = map.get("pile_id");
			String bi = map.get("bicycle_id");
			Integer pile_id = Integer.valueOf(pi);
			Integer bicycle_id = Integer.valueOf(bi);
			try {
				fixOutServiceImpl.fixOut(card_code, pile_id, bicycle_id);
				return "操作成功";
			} catch (ServiceException e) {
				return e.getMessage();
			}catch (Exception e) {
				logger.error("服务端异常", e);
				return "服务端 异常";
			}
		}
	
}
