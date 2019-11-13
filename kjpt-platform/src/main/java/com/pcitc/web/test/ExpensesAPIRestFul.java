package com.pcitc.web.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.pcitc.web.utils.RestfulHttpClient;

@Controller
public class ExpensesAPIRestFul {

	public static void main(String[] args) {
		try {

			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("Content-Type", "application/json");
			RestfulHttpClient.setDefaultHeaders(headerMap);
			
			String refreshOauthUrl = "https://oauth.siam.sinopec.com/oauth/interface/token";
			RestfulHttpClient.HttpClient client = RestfulHttpClient.getClient(refreshOauthUrl);
			client.post();

			// 添加多个参数请求头
			client.addHeaders(headerMap);
			client.addQueryParam("client_id", "YWlvYmdjbWJjcGpibmhra2FwZG1lcGdvYmRnbmRtbWdmbm1vZW1sYWdtcGdtamZjamFobGRnY2lwaGFpZGtrcA==");
			client.addQueryParam("client_secret", "b25ibGFrY2hoZGxsZ2VmaWxtZmdiaGRobG9mZmNvbWlvaWdobGJoYWdub2NmbmVlb21qbG5qZmhja2JlcHBlbw==");
			client.addQueryParam("refresh_token", "c19005c1d27eed520ef77fd7620bbbe8");
			client.addQueryParam("grant_type", "refresh_token");
			client.addQueryParam("client_ip", "10.238.105.193");
			RestfulHttpClient.HttpResponse authResponse = client.request();

			// 是否获取人员信息成功标识
			boolean testFlag = false;
			String uid = "";
			System.out.println("authResponse--------"+authResponse);
			System.out.println("authResponse--------"+authResponse.getCode());
			System.out.println("authResponse--------"+authResponse.getContent());
			// 根据状态码判断请求是否成功
			if (authResponse.getCode()==200) {
				// 获取响应内容
				String result = authResponse.getContent();
				System.out.println("refreshOauth返回--------"+result);
				JSONObject json = JSONObject.parseObject(result);
				if (json!=null&&json.get("access_token")!=null) {
					String access_token = json.getString("access_token");
					
					Map<String, String> headerMap1 = new HashMap<String, String>();
					headerMap1.put("Content-Type", "application/json");
					RestfulHttpClient.setDefaultHeaders(headerMap1);
					
					// 获取用户信息
					String userUrl = "https://oauth.siam.sinopec.com/oauth/interface/getUserInfo";
					// 创建一个请求客户端
					RestfulHttpClient.HttpClient userClient = RestfulHttpClient.getClient(userUrl);
					userClient.post();
					// 添加多个参数请求头
					userClient.addHeaders(headerMap1);
					userClient.addQueryParam("access_token", access_token);
					userClient.addQueryParam("client_id", "YWlvYmdjbWJjcGpibmhra2FwZG1lcGdvYmRnbmRtbWdmbm1vZW1sYWdtcGdtamZjamFobGRnY2lwaGFpZGtrcA==");
					userClient.addQueryParam("client_secret", "b25ibGFrY2hoZGxsZ2VmaWxtZmdiaGRobG9mZmNvbWlvaWdobGJoYWdub2NmbmVlb21qbG5qZmhja2JlcHBlbw==");

					
					System.out.println("1userOauth返回--------"+userClient.getUrl());
					RestfulHttpClient.HttpResponse userResponse = userClient.request();
					if (userResponse.getCode()==200) {
						// 获取响应内容
						String userResult = userResponse.getContent();
						System.out.println("userOauth返回--------"+userResult);
						JSONObject userJson = JSONObject.parseObject(userResult);
						if (userJson!=null&&userJson.get("result")!=null) {
							uid = userJson.getString("uid");
							System.out.println("uid返回--------"+uid);
							
							// sprolelist 判断此人是否有《科技管理平台》的权限，没有的话，直接返回
							testFlag = true;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("执行异常"+e.getStackTrace().toString());
		}
		System.out.println("执行完毕--------");
	}

}
