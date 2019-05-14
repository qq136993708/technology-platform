package com.pcitc.service.job;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.MD5Util;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.utils.RestfulHttpClient;

/**
 * @author zhf 定时获取报销数据，并保存到本地数据
 */
public class ExpensesJob implements Job, Serializable {

	private static final long	serialVersionUID	= 1L;

	private static final String	INSERT_EXPENSES		= "http://pcitc-zuul/stp-proxy/expenses/add";
	private static final String	MAX_EXPENSES		= "http://pcitc-zuul/stp-proxy/expenses/max-date/update";

	public void execute(JobExecutionContext job) throws JobExecutionException {
		try {
			// 调用报销系统数据
			String url = "http://10.248.67.142/ers/bull/unify/request";
			// 创建一个请求客户端
			RestfulHttpClient.HttpClient client = RestfulHttpClient.getClient(url);
			client.post();

			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("Content-Type", "application/json");
			// 设置全局默认请求头，每次请求都会带上这些请求头
			RestfulHttpClient.setDefaultHeaders(headerMap);
			// 添加多个参数请求头
			client.addHeaders(headerMap);

			JsonObject jo = new JsonObject();
			
			RestTemplate restTemplate = SpringContextUtil.getApplicationContext().getBean(RestTemplate.class);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
			HttpEntity<String> strEntity = new HttpEntity<String>(null, headers);
			ResponseEntity<Object> responseEntity = restTemplate.postForEntity(MAX_EXPENSES, strEntity, Object.class);
			// 查询最大值，+一个月作为本次的查询条件
			String startDate = responseEntity.getBody().toString();
			System.out.println("11执行完毕--------"+startDate);
			if (startDate!=null&&!startDate.equals("")) {
				startDate = "2017-05-01";
			}

			Date temStartDate = DateUtil.strToDate(startDate, DateUtil.FMT_DD);
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(temStartDate);
			rightNow.add(Calendar.DAY_OF_YEAR, 30);// 日期加30天
			Date temDate1 = rightNow.getTime();
			String realStartDate = DateUtil.dateToStr(temStartDate, DateUtil.FMT_YYYY_DD);
			String realEndDate = DateUtil.dateToStr(temDate1, DateUtil.FMT_YYYY_DD);
			System.out.println("1执行完毕--------"+realStartDate);
			System.out.println("1执行完毕--------"+realEndDate);

			jo.addProperty("executeKey", "sysnPubPaymentBillInfo");
			jo.addProperty("reqMsg", "{'compCode':'1010','begDate':'"+realStartDate+"','endDate':'"+realEndDate+"'}");
			Date nowDate = new Date();
			String reqTime = DateUtil.dateToStr(nowDate, DateUtil.FMT_SS);
			jo.addProperty("reqTime", reqTime);
			String signMd5 = MD5Util.MD5Encode("sysnPubPaymentBillInfo"+reqTime+"pubBill");
			jo.addProperty("sign", signMd5);

			// 添加请求体
			client.body(jo.toString());

			RestfulHttpClient.HttpResponse response;
			response = client.request();

			// 根据状态码判断请求是否成功
			if (response.getCode()==200) {
				// 获取响应内容
				String result = response.getContent();
				System.out.println("返回--------"+result);
				// 分解返回结果
				JSONObject json = JSONObject.parseObject(result);
				
				// 传递参数
				strEntity = new HttpEntity<String>(result, headers);
				responseEntity = restTemplate.postForEntity(MAX_EXPENSES, strEntity, Object.class);
			}

			HttpStatus statusCode = responseEntity.getStatusCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
