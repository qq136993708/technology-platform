package com.pcitc.base.system.ireport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;


//用户信息(导出)
public class SysUserInfo {
	
	private String unitname ="";//单位名称
	private String username ="";//用户登录名称
	private String userdisp ="";//用户显示名称
	private String userpost ="";//用户岗位
	private String usermobile ="";//用户手机
	private String userphone ="";//用户电话
	private String usermail ="";//用户邮箱
	private String usersign ="";//用户签章(是、否)
	
	private static final String USER_LIST_PAGE_URL = "http://pcitc-zuul/system-proxy/user-provider/user/user-list";
	
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
		String userName = orgs[0];
		String userKind = orgs[1];
		String userUnit = orgs[2];
		
		//设置参数
		LayuiTableParam param = new LayuiTableParam();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName", userName);
		map.put("userKind", userKind);
		map.put("userUnit", userUnit);
		param.setPage(1);
		param.setLimit(10000);
		param.setParam(map);
		
		//数据库查询结果  or 前台页面传递数据
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(USER_LIST_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retData = responseEntity.getBody();
		
		JSONObject dataObject = (JSONObject) JSON.toJSON(retData);
		JSONArray dataArray = dataObject.getJSONArray("data");
	    try {
			data.add("more");//多条记录
			for(int i = 0; i < dataArray.size(); i++){
				SysUserInfo userinfo = new SysUserInfo();
				JSONObject object = dataArray.getJSONObject(i);
				//userinfo.setUnitname(object.getString("userUnit"));
				userinfo.setUserdisp(object.getString("userDisp"));
				userinfo.setUsermail(object.getString("userMail"));
				userinfo.setUsermobile(object.getString("userMobile"));
				userinfo.setUsername(object.getString("userName"));
				userinfo.setUserphone(object.getString("userPhone"));
				//userinfo.setUserpost(object.getString("userPost"));
				//userinfo.setUsersign(object.getString("userSign"));
				data.add(userinfo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		//处理无数据情况
		if(data.size() == 1){
			SysUserInfo1 userinfo = new SysUserInfo1();
			data.add(userinfo);
		}
		return data;
	}

}
