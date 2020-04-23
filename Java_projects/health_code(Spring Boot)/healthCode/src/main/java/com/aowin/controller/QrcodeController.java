package com.aowin.controller;

import java.io.OutputStream;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aowin.dao.UserMapper;
import com.aowin.model.Message;
import com.aowin.model.User;
import com.aowin.util.QRCodeUtil0;
import com.aowin.util.QRCodeUtil1;

/**
 * 二维码生成类
 */
@Controller
public class QrcodeController {
	
	@Autowired
	private UserMapper userMapper;
 
    @RequestMapping("/createQrCode")
    public void createQrCode(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
        StringBuffer url = request.getRequestURL();
        User u = (User)session.getAttribute("user");
        int userid= u.getUserid();
        Message me = userMapper.selMessage(userid);
        int address = me.getAddress();
        String s = "是";
        if(address==0) 	s = "否";
        String name = me.getName();
        String card = me.getCard();
        String mobile = me.getMobile();
        String content="{'姓名':"+name+",'身份证号':"+card+",'手机号码':"+mobile+",'是否来自湖北地区':"+s+"}";
        String ptime = me.getPtime();
        //获取表单提交日期与当前日期间隔
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");     
        LocalDate date1 = LocalDate.parse(ptime, fmt);
        LocalDate date2 = LocalDate.now();
        Period period = Period.between(date1, date2);
        int btw = period.getDays();
        //用户来自湖北且时间未满14天,显示红码
        if(address==1 && btw<14) {
            try {
                OutputStream os = response.getOutputStream();
                //从配置文件读取需要生成二维码的连接
//                String requestUrl = GraphUtils.getProperties("requestUrl");
                //requestUrl:需要生成二维码的连接，logoPath：内嵌图片的路径，os：响应输出流，needCompress:是否压缩内嵌的图片
                QRCodeUtil1.encode(content, "/resources/images/1.png", os, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {	//非湖北地区或已超过14天显示绿码
            try {
                OutputStream os = response.getOutputStream();
                //从配置文件读取需要生成二维码的连接
//                String requestUrl = GraphUtils.getProperties("requestUrl");
                //requestUrl:需要生成二维码的连接，logoPath：内嵌图片的路径，os：响应输出流，needCompress:是否压缩内嵌的图片
                QRCodeUtil0.encode(content, "/resources/images/1.png", os, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
