package com.aowin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aowin.model.Message;
import com.aowin.model.User;

@Mapper
public interface UserMapper {
	/**
	 * 登录查询功能
	 * @param username
	 * @param password
	 * @return 返回一个对象时，必须要保证 查询结果最多只有一条结果
	 */
	public User login(@Param("username") String username,@Param("password") String password);
	
	/**
	 * 查询用户是否已经提交过表单
	 * @param userid
	 * @return
	 */
	public int isSubmitted(int userid);
	
	/**
	 * 新增一条用户信息
	 * @param userid
	 * @param name
	 * @param card
	 * @param mobile
	 * @param address
	 * @param ptime
	 * @return
	 */
	public int addRecord(@Param("userid") int userid,@Param("name") String name,@Param("card") String card,@Param("mobile") String mobile,@Param("address") int address,@Param("ptime") String ptime);
	
	//根据用户ID查询表单信息
	public Message selMessage(int userid);
	
	//新用户注册
	public int userRegist(@Param("username") String username,@Param("password") String password);
	
	/**
	 * 按条件查询用户信息
	 * @param user
	 * @return
	 */
	public List<User> select(User user);
	
	/**
	 * 新增一位用户
	 * @param user
	 * @return
	 */
	public int insert(User user);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public int update(User user);
	
	/**
	 * 删除一位用户
	 * @param userid
	 * @return
	 */
	public int delete(int userid);
	
	/**
	 * 查询用户权限
	 * @param userid
	 * @return
	 */
	public int selRole(int userid);
}
