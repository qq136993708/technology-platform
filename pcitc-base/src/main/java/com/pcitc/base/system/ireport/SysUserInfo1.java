package com.pcitc.base.system.ireport;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.pcitc.base.system.SysUser;


//用户信息(表单打印)
public class SysUserInfo1 {
	
	private String unitname ="";//单位名称
	private String username ="";//用户登录名称
	private String userdisp ="";//用户显示名称
	private String userpost ="";//用户岗位
	private String usermobile ="";//用户手机
	private String userphone ="";//用户电话
	private String usermail ="";//用户邮箱
	private String usersign ="";//用户签章(是、否)
	private String remark   ="";//备注
	
	private static final String USER_GET_URL = "http://pcitc-zuul/system-proxy/user-provider/user/get-user/";
	
	public String getUnitname() {
		return unitname;
	}
	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserdisp() {
		return userdisp;
	}
	public void setUserdisp(String userdisp) {
		this.userdisp = userdisp;
	}
	public String getUserpost() {
		return userpost;
	}
	public void setUserpost(String userpost) {
		this.userpost = userpost;
	}
	public String getUsermobile() {
		return usermobile;
	}
	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public String getUsersign() {
		return usersign;
	}
	public void setUsersign(String usersign) {
		this.usersign = usersign;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * ireport获取数据
	 * @param orgs 前台页面传递参数
	 * @param request
	 * @param restTemplate
	 * @param httpHeaders
	 * @return
	 */
	public List getData(String[] orgs, HttpServletRequest request,RestTemplate restTemplate, HttpHeaders httpHeaders){
		List data  = new ArrayList();
		String userId = orgs[0];
		
		//数据库查询结果  or 前台页面传递数据
		SysUser sysuser = restTemplate.exchange(USER_GET_URL + userId, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class).getBody();
	    try {
			if(sysuser != null) {
				SysUserInfo1 userinfo = new SysUserInfo1();
				//userinfo.setUnitname(sysuser.getUnitname());
				userinfo.setUserdisp(sysuser.getUserDisp());
				userinfo.setUsermail(sysuser.getUserMail());
				userinfo.setUsermobile(sysuser.getUserMobile());
				userinfo.setUsername(sysuser.getUserName());
				userinfo.setUserphone(sysuser.getUserPhone());
				//userinfo.setUserpost(sysuser.getUserPost());
				//userinfo.setUsersign(sysuser.getUserSign());
				userinfo.setRemark(sysuser.getUserComment());
				data.add(userinfo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		//处理无数据情况
		if(data.size() == 0){
			SysUserInfo1 userinfo = new SysUserInfo1();
			data.add(userinfo);
		}
		return data;
	}

}
