package com.pcitc.service.job;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.pcitc.base.util.DateSegment;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.MD5Util;
import com.pcitc.utils.RestfulHttpClient;

public class ExpensesJobTest {

	public static String testGetData(String realStartDate,String realEndDate) throws IOException 
	{
		// 调用报销系统数据
		String url = "http://10.248.36.236/ers/bull/unify/request";
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
		
		jo.addProperty("executeKey", "sysnPubPaymentBillInfo");
		jo.addProperty("reqMsg", "{'compCode':'1010','begDate':'"+realStartDate+"','endDate':'"+realEndDate+"'}");
		Date nowDate = new Date();
		String reqTime = DateUtil.dateToStr(nowDate, DateUtil.FMT_SS);
		jo.addProperty("reqTime", reqTime);
		String signMd5 = MD5Util.MD5Encode("sysnPubPaymentBillInfo"+reqTime+"pubBill");
		jo.addProperty("sign", signMd5);
		
		System.out.println(">>>>请求体参数>>>>>>>>"+jo.toString());
		// 添加请求体
		client.body(jo.toString());
		RestfulHttpClient.HttpResponse response;
		response = client.request();
		// 根据状态码判断请求是否成功
		if (response.getCode()==200) {
			// 获取响应内容
			String result = response.getContent();
			//System.out.println(result);
			return result;
		}else {
			return null;
		}
	}
	public static void main(String[] args) throws IOException 
	{
		
		Date startDate = DateUtil.strToDate("20191105", "yyyyMMdd");
		
		Date monthDay = DateUtil.getNextMonth(startDate);
		List<DateSegment> ds = DateUtil.getMonthList(monthDay, monthDay);
		
		String realStartDate = DateUtil.format(ds.get(0).getStartDate(), DateUtil.FMT_YYYY_DD);
		String realEndDate = DateUtil.format(ds.get(0).getEndDate(), DateUtil.FMT_YYYY_DD);
		
		String rs = testGetData(realStartDate,realEndDate);
		System.out.println(rs);
	}

}
