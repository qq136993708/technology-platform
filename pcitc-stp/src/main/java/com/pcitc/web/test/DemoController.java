package com.pcitc.web.test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.pcitc.web.utils.RestfulHttpClient;

@Controller
public class DemoController {

	@RequestMapping(value = "/demo/test")
	public String testLogin(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * httpHeaders.set("applicationName", "AwardsClientTest");
		 * httpHeaders.set("userName", "wangcong382.slyt");
		 * 
		 * MultiValueMap<String, String> requestBody = new
		 * LinkedMultiValueMap<String, String>(); requestBody.add("sqlName",
		 * "SelectAllProjectInfo"); requestBody.add("nd", "2008");
		 * HttpEntity<MultiValueMap<String, String>> entity = new
		 * HttpEntity<MultiValueMap<String, String>>(requestBody,
		 * this.httpHeaders);
		 * 
		 * ResponseEntity<JSONObject> responseEntity =
		 * this.restTemplate.exchange(TEST_URL, HttpMethod.POST, entity,
		 * JSONObject.class); System.out.println("===返回======"+responseEntity);
		 */
		return "/index";
	}

	public static void main(String[] args) {
		/*
		 * String maxTypeCode = "100011011031011"; String retCode = "101"; if
		 * (maxTypeCode != null) { //取后四位+1 String temcode =
		 * maxTypeCode.substring(maxTypeCode.length()-4, maxTypeCode.length());
		 * System.out.println(maxTypeCode+"===="+temcode); retCode =
		 * maxTypeCode.substring(0, maxTypeCode.length() - 4) +
		 * String.valueOf(Integer.parseInt(temcode) + 1); }
		 * System.out.println(maxTypeCode+"===="+retCode);
		 */

		try {
			String temS = "";
			String TEST_URL = "http://10.1.19.131:9001/DataService/BasicQuery/Sql";
			System.out.println("=====开始访问===" + TEST_URL);
			// 创建一个请求客户端
			RestfulHttpClient.HttpClient client = RestfulHttpClient.getClient(TEST_URL);
			client.get();

			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("Authorization", "Basic AwardsClientTest:wangcong382.slyt");
			
			// 设置全局默认请求头，每次请求都会带上这些请求头
			RestfulHttpClient.setDefaultHeaders(headerMap);
			// 添加多个参数请求头
			client.addHeaders(headerMap);

			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("sqlName", "GetZYWCR");
			JsonObject jo = new JsonObject();
			jo.addProperty("xmid", "3613");

			System.out.println(jo.toString());
			paramMap.put("conditions", jo.toString());
			// 添加多个参数
			client.queryParams(paramMap);

			System.out.println("马上要访问--------" + client);
			// 最终访问路径是：http://10.1.19.131:9001/DataService/BasicQuery/Sql?sqlName=SelectAllProjectInfo&nd=2008
			RestfulHttpClient.HttpResponse response = client.request();

			System.out.println("返回--------" + response.getCode());
			// 根据状态码判断请求是否成功
			if (response.getCode() == 200) {
				// 获取响应内容
				String result = response.getContent();
				System.out.println("===返回======" + result);
			}
		} catch (Exception e) {

		}

	}

	public static void main3(String[] args) {
		/*
		 * 测试成功方法一 try { String TEST_URL =
		 * "http://10.1.19.131:9001/DataService/BasicQuery/Sql";
		 * System.out.println("=====开始访问==="+TEST_URL); // 创建一个请求客户端
		 * RestfulHttpClient.HttpClient client =
		 * RestfulHttpClient.getClient(TEST_URL); client.get();
		 * 
		 * Map<String, String> headerMap = new HashMap<String, String>();
		 * headerMap.put("Authorization",
		 * "Basic AwardsClientTest:wangcong382.slyt");
		 * 
		 * // 设置全局默认请求头，每次请求都会带上这些请求头
		 * RestfulHttpClient.setDefaultHeaders(headerMap); //添加多个参数请求头
		 * client.addHeaders(headerMap);
		 * 
		 * Map<String, String> paramMap = new HashMap<String, String>();
		 * paramMap.put("sqlName", "SelectAllCountry"); JsonObject jo = new
		 * JsonObject(); jo.addProperty("lb", "001");
		 * 
		 * System.out.println(jo.toString()); paramMap.put("conditions",
		 * jo.toString()); //添加多个参数 client.queryParams(paramMap);
		 * 
		 * System.out.println("马上要访问--------"+client);
		 * //最终访问路径是：http://10.1.19.131
		 * :9001/DataService/BasicQuery/Sql?sqlName=SelectAllProjectInfo&nd=2008
		 * RestfulHttpClient.HttpResponse response = client.request();
		 * 
		 * System.out.println("返回--------"+response.getCode()); //根据状态码判断请求是否成功
		 * if(response.getCode() == 200){ //获取响应内容 String result =
		 * response.getContent(); System.out.println("===返回======"+result); } }
		 * catch (Exception e) {
		 * 
		 * }
		 */

		try {

			String TEST_URL = "http://10.1.19.131:9001/DataService/BasicQuery/Sql";
			System.out.println("=====开始访问===" + TEST_URL);
			// 创建一个请求客户端
			RestfulHttpClient.HttpClient client = RestfulHttpClient.getClient(TEST_URL);
			client.get();

			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("Authorization", "Basic AwardsClientTest:wangcong382.slyt");

			// 设置全局默认请求头，每次请求都会带上这些请求头
			RestfulHttpClient.setDefaultHeaders(headerMap);
			// 添加多个参数请求头
			client.addHeaders(headerMap);

			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("sqlName", "SHYK_ZSHKJXMGL_DWXXB");
			JsonObject jo = new JsonObject();
			jo.addProperty("DWBM", "%%");
			jo.addProperty("SJBM", "%%");
			//jo.addProperty("ksrq", "2018-01-01");
			//jo.addProperty("jzrq", "2018-02-05");

			System.out.println(jo.toString());
			paramMap.put("conditions", jo.toString());
			// 添加多个参数
			client.queryParams(paramMap);

			System.out.println("马上要访问--------" + client);
			// 最终访问路径是：http://10.1.19.131:9001/DataService/BasicQuery/Sql?sqlName=SelectAllProjectInfo&nd=2008
			RestfulHttpClient.HttpResponse response = client.request();

			System.out.println("1返回--------" + response);
			System.out.println("2返回--------" + response.getCode());
			// 根据状态码判断请求是否成功
			if (response.getCode() == 200) {
				// 获取响应内容
				String result = response.getContent();
				System.out.println("返回--------" + result);
				/*JSONArray jsArr = JSONObject.parseArray(result);
				System.out.println("返回--------" + jsArr.size());
				for (int i =0; i < jsArr.size(); i++) {
					JSONObject jsonObject = JSON.parseObject(jsArr.get(i).toString());
					System.out.println(jsonObject.get("LXND")+"==="+jsonObject.get("ND")+"==="+jsonObject.get("XMID"));
					//System.out.println(jsonObject.toJSONString());
				}*/
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("执行异常" + e.getStackTrace().toString());
		}
		System.out.println("执行完毕--------");
	}

	public static String getDataService(String url, JsonObject jo) throws Exception {
		String result = null;
		RestfulHttpClient.HttpClient client = RestfulHttpClient.getClient(url);
		client.get();
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Authorization", "Basic AwardsClientTest:wangcong382.slyt");

		RestfulHttpClient.setDefaultHeaders(headerMap);
		client.addHeaders(headerMap);
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("sqlName", "SelectAllProjectFromSinopecData2017");
		if (jo != null) {
			paramMap.put("conditions", jo.toString());
			client.queryParams(paramMap);
		}
		// 最终访问路径是：http://10.1.19.131:9001/DataService/BasicQuery/Sql?sqlName=SelectAllProjectInfo&nd=2008
		RestfulHttpClient.HttpResponse response = client.request();
		if (response.getCode() == 200) {
			result = response.getContent();
			System.out.println("===返回======" + result);
		}
		return result;
	}

}
