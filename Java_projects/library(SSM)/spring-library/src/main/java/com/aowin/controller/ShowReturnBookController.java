package com.aowin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.dao.BookMapper;
import com.aowin.model.BookRecord;
import com.aowin.model.User;

@RestController
public class ShowReturnBookController {

	private Logger logger = Logger.getLogger(ShowReturnBookController.class);
	@Autowired
	private BookMapper bookMapper;
	
	@RequestMapping(value="book/return")
	public List<BookRecord> selectBookRecord(HttpSession session){
		List<BookRecord> bookRecords = new ArrayList<BookRecord>();
		User user = (User)session.getAttribute("user");
		bookRecords = bookMapper.selectRecords(user.getUserid());
		List<BookRecord> body = new ArrayList<BookRecord>();
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(BookRecord bok:bookRecords) {
			try {
				Long l = 0L;
				Date date1= format.parse(bok.getLendtime());
				long ts1 = date1.getTime();
				Date date2= format.parse(bok.getExpiretime());
				long ts2 = date2.getTime();
				l = (ts2 - ts1) / (1000 * 60 * 60 * 24);
				String remaintime = String.valueOf(l);
				bok.setRemaintime(remaintime);
				body.add(bok);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return body;
	}
}
