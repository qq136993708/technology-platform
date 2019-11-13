package com.pcitc.web.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pcitc.web.utils.RestfulHttpClient;

@Controller
public class OutProjectAPIRestFul {

	public static void main(String[] args) {
		try {

			String url = "http://127.0.0.1:8764/stp-proxy/project-api/require/add";
			// 创建一个请求客户端
			RestfulHttpClient.HttpClient client = RestfulHttpClient.getClient(url);
			client.post();

			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJpbnN0aXR1dGVOYW1lcyI6WyLli5jmjqLpmaIiLCLnianmjqLpmaIiLCLlt6XnqIvpmaIiLCLnn7Pnp5HpmaIiLCLlpKfov57pmaIiLCLljJfljJbpmaIiLCLkuIrmtbfpmaIiLCLlronlt6XpmaIiXSwidW5pdE5hbWUiOiLkuK3lm73nn7PmsrnljJblt6Xpm4blm6Is5YuY5o6i5byA5Y-R56CU56m26ZmiLOenkeaKgOmDqOe7vOWQiOiuoeWIkuWkhCIsInVuaXRDb2RlIjoiMDAwMDAsMTAwNDAxMDAxLDMwMTMwMDU0IiwidW5pdElkIjoiNDZiN2U0NTc1NmVmNGRiODhiNmFjYjcxMWY5MTZlNDMsNDVkYjJkZDNlMTQyNDk1YzkxYmM5NGYyMGVmNDk5ZTgsYTgyMjNjY2EyYjkwNDczOWJmMjhhN2Y0MGQ3MzJjNzMiLCJ1c2VyRGlzcCI6IuiSi-a2myIsInVzZXJOYW1lIjoiYWFhYWEiLCJyb2xlTGlzdCI6W10sImV4cCI6MTU2MjYzOTMwOSwidXNlcklkIjoiMTY1NTUzNDM2ZWRfZGZkNWUxMzciLCJlbWFpbCI6IjEyMzQ1NjY2NjZAeHh4LmNvbSIsImluc3RpdHV0ZUNvZGVzIjpbIjExMjAsMTEyMywxMTI0LDExMjciLCIxMTMwIiwiNDM2MCIsIjEwMjAiLCIxMDYwLDEwNjEiLCIxMDQwLDEwNDEiLCIxMDgwIiwiMTEwMCwxMTAxIl19.2crRnr6GlN1BjFnVKW76Kd5BDyF1zg7MZ1rZzNZG_Oa3BFtny3X9bSTRGr9zcxHpPMsBTnoTx_rNYVT39EVmog");
			headerMap.put("Content-Type", "application/json");
			// 设置全局默认请求头，每次请求都会带上这些请求头
			RestfulHttpClient.setDefaultHeaders(headerMap);
			// 添加多个参数请求头
			client.addHeaders(headerMap);

			JsonObject jo = new JsonObject();
			jo.addProperty("dataCode", "2018");
			jo.addProperty("createDate", "2019-02-12 15:35:00");
			
			JsonArray ja = new JsonArray();
			JsonObject joItem1 = new JsonObject();
			joItem1.addProperty("requireItemName", "2018");
			joItem1.addProperty("requireItemCount", "4");
			ja.add(joItem1);
			
			JsonObject joItem2 = new JsonObject();
			joItem2.addProperty("requireItemName", "2019");
			joItem2.addProperty("requireItemCount", "42");
			ja.add(joItem2);
			
			jo.addProperty("itemList", ja.toString());
			
			// 添加请求体
			client.body(jo.toString());
			
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
