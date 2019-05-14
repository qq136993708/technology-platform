package com.pcitc.web.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.pcitc.base.stp.expenses.ExpensesBills;
import com.pcitc.base.stp.expenses.ExpensesBillsApproves;
import com.pcitc.base.stp.expenses.ExpensesBillsItem;
import com.pcitc.base.stp.expenses.ExpensesBillsPay;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.MD5Util;
import com.pcitc.web.utils.RestfulHttpClient;

@Controller
public class ExpensesAPIRestFul {

	public static void main(String[] args) {
		try {

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
			// 查询最大值，+一个月作为本次的查询条件
			String startDate = "2018-05-01";

			if (startDate!=null&&!startDate.equals("")) {
				startDate = "2018-05-01";
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

			RestfulHttpClient.HttpResponse response = client.request();
			System.out.println("返回--------");
			// 根据状态码判断请求是否成功
			if (response.getCode()==200) {
				// 获取响应内容
				String result = response.getContent();
				System.out.println("1返回--------"+result);
				JSONObject json = JSONObject.parseObject(result);
				if (json!=null&&json.get("result")!=null) {
					List<ExpensesBillsPay> payList = new ArrayList<ExpensesBillsPay>();
					List<ExpensesBillsApproves> apprList = new ArrayList<ExpensesBillsApproves>();
					List<ExpensesBillsItem> itemList = new ArrayList<ExpensesBillsItem>();
					List<ExpensesBills> exList = new ArrayList<ExpensesBills>();
					JSONArray jsonArray = (JSONArray) json.get("result");
					for (int i = 0; i<jsonArray.size(); i++) {
						JSONObject temJson = (JSONObject) jsonArray.get(i);
						if (temJson != null && temJson.get("expenses") != null) {
							JSONArray expArray = (JSONArray) temJson.get("expenses");
							System.out.println("21返回--------"+expArray.toJSONString());
							for (int e = 0; e < expArray.size(); e++) {
								JSONObject eJson = expArray.getJSONObject(e);
								ExpensesBillsItem ebi = JSON.toJavaObject(eJson,ExpensesBillsItem.class);
								itemList.add(ebi);
							}
						}
						if (temJson != null && temJson.get("payoffs") != null) {
							JSONArray payArray = (JSONArray) temJson.get("payoffs");
							System.out.println("22返回--------"+payArray.toJSONString());
							for (int p = 0; p < payArray.size(); p++) {
								JSONObject pJson = payArray.getJSONObject(p);
								ExpensesBillsPay ebp = JSON.toJavaObject(pJson,ExpensesBillsPay.class);
								payList.add(ebp);
							}
							
						}
						if (temJson != null && temJson.get("approves") != null) {
							JSONArray apprArray = (JSONArray) temJson.get("approves");
							System.out.println("23返回--------"+apprArray.toJSONString());
							for (int a = 0; a < apprArray.size(); a++) {
								JSONObject aJson = apprArray.getJSONObject(a);
								ExpensesBillsApproves eba = JSON.toJavaObject(aJson,ExpensesBillsApproves.class);
								apprList.add(eba);
							}
						}
						//temJson.remove("approves");
						//temJson.remove("payoffs");
						//temJson.remove("expenses");
						ExpensesBills expensesBills = JSON.toJavaObject(temJson,ExpensesBills.class);
						exList.add(expensesBills);
					}
					System.out.println("31返回--------"+apprList.size());
					System.out.println("31返回--------"+payList.size());
					System.out.println("31返回--------"+itemList.size());
					System.out.println("31返回--------"+exList.size());
				}

			}
		} catch (Exception e) {
			System.out.println("执行异常"+e.getStackTrace().toString());
		}
		System.out.println("执行完毕--------");
	}

}
