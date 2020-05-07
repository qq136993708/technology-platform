package com.pcitc.ssosync.entity;


import java.io.Serializable;

/**
 * 用户实体
 *
 * @author ty
 */

public class User implements Serializable {
	private static final long serialVersionUID = 6146287389577060547L;

	/**
	 * 统一身份账号
	 */
	private String userId;


	/**
	 * 姓名
	 */
	private String userName;

	/**
	 * AD账号
	 */
	private String adAccount;

	/**
	 * 电话号码
	 */
	private String phoneNum;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 部门id
	 */
	private String orgId;


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserId() {
		return userId;
	}

	public String getAdAccount() {
		return adAccount;
	}

	public void setAdAccount(String adAccount) {
		this.adAccount = adAccount;
	}




	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
}

