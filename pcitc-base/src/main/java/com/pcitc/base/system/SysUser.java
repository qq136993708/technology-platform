package com.pcitc.base.system;

import java.util.ArrayList;
import java.util.List;

public class SysUser {
	private String userId;

	private String userName;

	private String userPassword;

	private String userDisp;

	private String userKind;

	private String userFlag;

	private String userUnit;

	private String userPost;

	private String userRole;

	private Integer userOrder;

	private String userMail;

	private String userMobile;

	private String userPhone;

	private String userSign;

	private String userCreateTime;

	private Integer userLevel;

	private Integer userDelflag;

	private String userRelation;

	private String userExtend;

	private String userComment;

	private Integer isDomain;

	private Integer loginErrorNumber;

	private String loginCheckCode;

	private String userConfig1;

	private String userConfig2;

	private String userConfig3;

	private String userConfig4;
	
	// 用户拥有多少角色
	private List<String> roles = new ArrayList<String>();

	// 拥有多少功能
	private List<SysFunction> funList = new ArrayList<SysFunction>();

	private List<SysCollect> scList = new ArrayList<SysCollect>();

	private String unitName;
	private String unitCode;
	private String unitId;
	private String unitPath;

	// 本人管理哪些院所
	private String manageInstituteCode;

	// 本人管理哪些部门
	private String manageUnitCode;
	private String manageUnitId;

	private List<String> instituteCodes;
	private List<String> instituteNames;

	public String getUnitPath() {
		return unitPath;
	}

	public void setUnitPath(String unitPath) {
		this.unitPath = unitPath;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<SysFunction> getFunList() {
		return funList;
	}

	public void setFunList(List<SysFunction> funList) {
		this.funList = funList;
	}

	public List<SysCollect> getScList() {
		return scList;
	}

	public void setScList(List<SysCollect> scList) {
		this.scList = scList;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getManageInstituteCode() {
		return manageInstituteCode;
	}

	public void setManageInstituteCode(String manageInstituteCode) {
		this.manageInstituteCode = manageInstituteCode;
	}

	public String getManageUnitCode() {
		return manageUnitCode;
	}

	public void setManageUnitCode(String manageUnitCode) {
		this.manageUnitCode = manageUnitCode;
	}

	public String getManageUnitId() {
		return manageUnitId;
	}

	public void setManageUnitId(String manageUnitId) {
		this.manageUnitId = manageUnitId;
	}

	public List<String> getInstituteCodes() {
		return instituteCodes;
	}

	public void setInstituteCodes(List<String> instituteCodes) {
		this.instituteCodes = instituteCodes;
	}

	public List<String> getInstituteNames() {
		return instituteNames;
	}

	public void setInstituteNames(List<String> instituteNames) {
		this.instituteNames = instituteNames;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserDisp() {
		return userDisp;
	}

	public void setUserDisp(String userDisp) {
		this.userDisp = userDisp;
	}

	public String getUserKind() {
		return userKind;
	}

	public void setUserKind(String userKind) {
		this.userKind = userKind;
	}

	public String getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}

	public String getUserUnit() {
		return userUnit;
	}

	public void setUserUnit(String userUnit) {
		this.userUnit = userUnit;
	}

	public String getUserPost() {
		return userPost;
	}

	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Integer getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(Integer userOrder) {
		this.userOrder = userOrder;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserSign() {
		return userSign;
	}

	public void setUserSign(String userSign) {
		this.userSign = userSign;
	}

	public String getUserCreateTime() {
		return userCreateTime;
	}

	public void setUserCreateTime(String userCreateTime) {
		this.userCreateTime = userCreateTime;
	}

	public Integer getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public Integer getUserDelflag() {
		return userDelflag;
	}

	public void setUserDelflag(Integer userDelflag) {
		this.userDelflag = userDelflag;
	}

	public String getUserRelation() {
		return userRelation;
	}

	public void setUserRelation(String userRelation) {
		this.userRelation = userRelation;
	}

	public String getUserExtend() {
		return userExtend;
	}

	public void setUserExtend(String userExtend) {
		this.userExtend = userExtend;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public Integer getIsDomain() {
		return isDomain;
	}

	public void setIsDomain(Integer isDomain) {
		this.isDomain = isDomain;
	}

	public Integer getLoginErrorNumber() {
		return loginErrorNumber;
	}

	public void setLoginErrorNumber(Integer loginErrorNumber) {
		this.loginErrorNumber = loginErrorNumber;
	}

	public String getLoginCheckCode() {
		return loginCheckCode;
	}

	public void setLoginCheckCode(String loginCheckCode) {
		this.loginCheckCode = loginCheckCode;
	}

	public String getUserConfig1() {
		return userConfig1;
	}

	public void setUserConfig1(String userConfig1) {
		this.userConfig1 = userConfig1;
	}

	public String getUserConfig2() {
		return userConfig2;
	}

	public void setUserConfig2(String userConfig2) {
		this.userConfig2 = userConfig2;
	}

	public String getUserConfig3() {
		return userConfig3;
	}

	public void setUserConfig3(String userConfig3) {
		this.userConfig3 = userConfig3;
	}

	public String getUserConfig4() {
		return userConfig4;
	}

	public void setUserConfig4(String userConfig4) {
		this.userConfig4 = userConfig4;
	}
}