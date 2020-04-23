package com.aowin.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.dao.BookMapper;
import com.aowin.model.Book;

@RestController
public class BookController {
	private Logger logger = Logger.getLogger(BookController.class);
	@Autowired
	private BookMapper bookMapper;
	/**
	 * 查询所有可借阅图书并返回
	 * @return
	 */
	@RequestMapping(value="book/select")
	public List<Book> loanableBook(){
		List<Book> books = new ArrayList<>();
		books = bookMapper.selectBook();
		return books;
	}
}
