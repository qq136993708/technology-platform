package com.pcitc.web.controller.out;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.RestfulHttpClient;

/**
 * 
 * @author uuy
 *
 */
@Controller
public class OutNewsController extends BaseController 
{
	private static final String OUT_URL = "http://10.1.19.131:9001/DataService/BasicQuery/Sql";

	/**
	 * 新闻工作动态
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/out/news-workdynamics-list", method = RequestMethod.POST)
	@ResponseBody
	public Object outAppraisalList(@ModelAttribute("param") LayuiTableParam param) {
		String result = getDataService(OUT_URL);
		JSONArray jsArr = JSONObject.parseArray(result);
		//[{"xxbt":"关于2019年新开科研项目合同（任务书）上报相关事宜的通知","fbsj":"2019-06-03T16:59:22"}]
		if (jsArr != null) {
			return jsArr.toString();
		} else {
			return null;
		}
	}
	/**
	 * 获取新闻列表
	 * @param url
	 * @param jo
	 * @return
	 */
	private String getDataService(String url){
		String result = null;
		try {
			RestfulHttpClient.HttpClient client = RestfulHttpClient.getClient(url);
			client.get();
			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("Authorization", "Basic AwardsClientTest:wangcong382.slyt");

			// 设置全局默认请求头，每次请求都会带上这些请求头
			RestfulHttpClient.setDefaultHeaders(headerMap);
			// 添加多个参数请求头
			client.addHeaders(headerMap);

			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("sqlName", "GetInfoList_KJBL");
			JsonObject jo = new JsonObject();
			//System.out.println(jo.toString());
			//jo.addProperty("ND", "2019");
			//jo.addProperty("ksrq", "2018-01-01");
			//jo.addProperty("jzrq", "2018-02-05");

			//System.out.println(jo.toString());
			paramMap.put("conditions", jo.toString());
			client.queryParams(paramMap);
			RestfulHttpClient.HttpResponse response = client.request();

			// 根据状态码判断请求是否成功
			if (response.getCode() == 200) {
				// 获取响应内容
				result = response.getContent();
				System.out.println("返回--------" + result);
				JSONArray jsArr = JSONObject.parseArray(result);
				System.out.println("返回--------" + jsArr.size());
				for (int i =0; i < jsArr.size(); i++) {
					JSONObject jsonObject = JSON.parseObject(jsArr.get(i).toString());
					System.out.println(jsonObject.toJSONString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
