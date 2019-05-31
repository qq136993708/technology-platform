package com.pcitc.web.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.google.gson.JsonObject;
import com.pcitc.web.utils.RestfulHttpClient;

@Controller
public class ExpensesAPIRestFul {

	public static void main(String[] args) {
		try {

			// 调用统一身份认证组的刷新oauth码的接口（此接口返回值可以继续调用统一身份的接口来获取人员信息）
			
			
			String refreshOauthUrl = "https://oauth.siam.sinopec.com/oauth/interface/getUserInfo";
			RestfulHttpClient.HttpClient client = RestfulHttpClient.getClient(refreshOauthUrl);
			client.post();

			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("Content-Type", "application/json");
			RestfulHttpClient.setDefaultHeaders(headerMap);
			
			// 添加多个参数请求头
			client.addHeaders(headerMap);
			JsonObject jo = new JsonObject();
			client.addQueryParam("access_token", "5e7a5647253662e0a581f465e4fdf842");
			client.addQueryParam("client_id", "YWlvYmdjbWJjcGpibmhra2FwZG1lcGdvYmRnbmRtbWdmbm1vZW1sYWdtcGdtamZjamFobGRnY2lwaGFpZGtrcA==");
			client.addQueryParam("client_secret", "b25ibGFrY2hoZGxsZ2VmaWxtZmdiaGRobG9mZmNvbWlvaWdobGJoYWdub2NmbmVlb21qbG5qZmhja2JlcHBlbw==");

			RestfulHttpClient.HttpResponse authResponse = client.request();

			// 是否获取人员信息成功标识
			boolean testFlag = false;
			String uid = "";
			System.out.println("authResponse--------"+authResponse);
			System.out.println("authResponse--------"+authResponse.getCode());
			System.out.println("authResponse--------"+authResponse.getContent());
		} catch (Exception e) {
			System.out.println("执行异常"+e.getStackTrace().toString());
		}
		System.out.println("执行完毕--------");
	}

}
