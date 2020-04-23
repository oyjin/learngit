package com.aowin.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnBookController {
	
	@RequestMapping(value="/returnBook",produces = "text/plain;charset=utf-8")
	public String returnBook(@RequestParam(value="bookids[]") Integer[] bookids) {
		for (Integer integer : bookids) {
			System.out.println(integer.intValue());
		}

		return "ok";
	}
}
