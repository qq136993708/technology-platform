package com.pcitc.ssosync.service;

import com.pcitc.ssosync.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理Service
 *
 * @author ty
 */
public interface UserService {

	/**
	 * 添加用户
	 * @param user
	 */
	public void add(User user, String roleId) throws Exception;

	/**
	 * 提取用户
	 * @param adAccount
	 * @return
	 */
	User load(String adAccount);


	/**
	 * 提取用户(模拟登录用)
	 * @param userName,password
	 * @return
	 */
	public User load(String userName,String password) throws Exception;
	
	/**
	 * 用户列表
	 * @return
	 */
	List<User> query();

	/**
	 * 获取审批人
	 * @return
	 */
	List<User> queryApprover(Map param);



}
