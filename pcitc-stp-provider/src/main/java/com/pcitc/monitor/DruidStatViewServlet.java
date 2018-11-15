package com.pcitc.monitor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.support.http.StatViewServlet;

@WebServlet(urlPatterns = "/druid/*",  
initParams={  
        @WebInitParam(name="allow",value="127.0.0.1"),// IP白名单 (没有配置或者为空，则允许所有访问)  
        @WebInitParam(name="deny",value="192.168.1.1"),// IP黑名单 (存在共同时，deny优先于allow)  
        @WebInitParam(name="loginUsername",value="pcitc"),// druid监控页面登陆用户名  
        @WebInitParam(name="loginPassword",value="pcitc123"),// druid监控页面登陆密码  
        @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能  
})  
public class DruidStatViewServlet extends StatViewServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4399151602192714213L;

	@Override
	public void init() throws ServletException {
		System.out.println("init druid serverlet........");
		super.init();
	}

	@Override
	protected String process(String url) {
		System.out.println("process druid serverlet........");
		return super.process(url);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget druid serverlet........");
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dopost druid serverlet........");
		super.doPost(req, resp);
	}
	

}
