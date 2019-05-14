package com.pcitc.web.test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.google.gson.JsonObject;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.MD5Util;
import com.pcitc.web.utils.RestfulHttpClient;

@Controller
public class OAAPIRestFul {

	public static void main(String[] args) {
		try {

			String url = "http://10.1.4.10:80/kjb/_layouts/15/ZBAppPage/oacount.aspx";
			// 创建一个请求客户端
			RestfulHttpClient.HttpClient client = RestfulHttpClient.getClient(url);
			client.post();

			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("Content-Type", "application/json");
			// 设置全局默认请求头，每次请求都会带上这些请求头
			RestfulHttpClient.setDefaultHeaders(headerMap);
			// 添加多个参数请求头
			client.addHeaders(headerMap);

			RestfulHttpClient.HttpResponse response = client.request();

			// 根据状态码判断请求是否成功
			if (response.getCode() == 200) {
				// 获取响应内容
				String result = response.getContent();
				System.out.println("返回--------" + result);
			}
		} catch (Exception e) {
			System.out.println("执行异常" + e.getStackTrace().toString());
		}
		System.out.println("执行完毕--------");
	}


}
