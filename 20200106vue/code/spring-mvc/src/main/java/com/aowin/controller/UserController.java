package com.aowin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aowin.model.User;

@Controller
public class UserController {
	
	// 1. 定义一个普通方法 方法的参数用于接收客户端请求过来的参数 默认请求参数的名字和方法的参数的名字相同
	// 相应 使用ModelAndView 既包含数据又包含视图路径
	
//	@RequestMapping("/login") // 配置方法的请求路径
//	public ModelAndView login(String username,String password) {
//		System.out.println("username="+username+",password="+password);
//		ModelAndView mav = new ModelAndView("/user.jsp");
//		mav.addObject("username", username);
//		return mav;
//	}
	
	
	
	
	//2 . 返回值直接写String 把视图路径返回 模型数据保存在Model的参数中 
	// 使用session/request/application对象 参数里添加即可
	@RequestMapping("/login")
	public String login(String username,String password, Model model,HttpSession session) {
		System.out.println("username="+username+",password="+password);
		model.addAttribute("username", username);
		session.setAttribute("username", username);
		return "/user.jsp";
	}
	
	
	// 3. 使用对象接收客户端参数  
	// http://localhost:8080/spring-mvc/loginUser?username=lisi&password=1233435&userId=1212
	@RequestMapping("/loginUser")
	public String login(User user,Model model,HttpSession session) {
		//System.out.println(session.getAttribute("username"));
		System.out.println(user);
		model.addAttribute("user", user);
		return "/user.jsp";
	}
	
	// 4. 使用map接收客户端参数
	@RequestMapping("/loginMap")
	//// http://localhost:8080/spring-mvc/loginUser?username=lisi&password=1233435&userId=1212
	public String login(@RequestParam Map<String,Object> user,Model model) {
		System.out.println(user);
		model.addAttribute("user", user);
		return "/user.jsp";
	}
	
	// 5. @RequestParam 添加在方法的参数前 用来约束请求参数的
	// name属性 指定客户端发送的参数的名字 例如值为abc时，程序会将客户端发送来的名字叫做abc的参数的值保存在指定的参数中
	// defaultValue 默认值属性 客户端不传值时 默认为指定的值
	// 默认是必须参数 要求客户端一定要传入该参数
	// 基本数据类型声明的参数，客户端必须要 传值的
	// http://localhost:8080/spring-mvc/testParam?pageNum=2&abc=zhangsan
	@RequestMapping("/testParam")
	public String testParam(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(name = "abc") String name) {
		System.out.println(pageNum+","+name);
		return "/user.jsp";
	}
	
	// 6. 设置处理的请求方法 
	// @RequestMapping 添加method属性
	@RequestMapping(value = "/testMethod",method = {RequestMethod.POST})
	public String testMethod() {
		return "/user.jsp";
	}
	
	
	// 7.1 响应跳转方式
	@RequestMapping("/testResp")
	public String testResp() {
//		return "/user.jsp"; // 服务端跳转
		return "redirect:/user.jsp"; // 客户端跳转
	}
	
	// 7.2 直接响应内容  有中文时需要设置响应头 设置编码
	@RequestMapping(value="/testRespText",produces = {"text/plain;charset=utf-8"})
	@ResponseBody
	public String testRespText() {
		return "你好, world"; 
	}
	
	// 7.3 直接响应对象 会转换成json字符串返回  （导入jackson的依赖，ioc配置文件中添加注解驱动）
	@RequestMapping(value="/testRespJson",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public List<User> select(){
		List<User> users = new ArrayList<User>();
		users.add(new User(1, "qq", "34324"));
		users.add(new User(1, "qq", "34324"));
		users.add(new User(1, "qq", "34324"));
		users.add(new User(1, "qq", "34324"));
		return users;
	}
	
	
	
	
	
	
	
	
	
	
	

}
