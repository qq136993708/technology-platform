package com.pcitc.util;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableParam;
/*
 * 利用HttpClient进行post请求的工具类
 */
public class HttpClientUtil 
{
	/**
	 * 
	 * @param url
	 * @param map
	 * @param charset
	 * @return
	 */
	public String doPostFormData(String url,Map<String,String> map,String charset){
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try{
			//httpClient = new SSLClient();
			httpClient = HttpClientBuilder.create().build();
			httpPost = new HttpPost(url);
			//设置参数
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Entry<String,String> elem = (Entry<String, String>) iterator.next();
				list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
			}
			if(list.size() > 0){
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
				httpPost.setEntity(entity);
			}
			HttpResponse response = httpClient.execute(httpPost);
			if(response != null){
				HttpEntity resEntity = response.getEntity();
				if(resEntity != null){
					result = EntityUtils.toString(resEntity,charset);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 * @param url
	 * @param obj
	 * @return
	 */
	public String doPostBody(String url, Object obj, String charset)
	{
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try
		{
			httpClient = HttpClientBuilder.create().build();
			httpPost = new HttpPost(url);

			StringEntity entity = new StringEntity(JSON.toJSONString(obj), Charset.forName(charset));
			entity.setContentEncoding(charset);
			entity.setContentType("application/json");
			httpPost.setEntity(entity);
			HttpResponse response = httpClient.execute(httpPost);
			// 检验返回码
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK)
			{
				System.out.println("请求出错"+statusCode);
			}
			else
			{
				if (response != null)
				{
					HttpEntity resEntity = response.getEntity();
					if (resEntity != null)
					{
						result = EntityUtils.toString(resEntity, charset);
					}
				}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return result;
	}
	public static void main(String [] args) 
	{
		HttpClientUtil httpClientUtil = new HttpClientUtil();
		String url = "http://localhost:8765/stp-provider/budget/budget-grouptotal-list";
		LayuiTableParam params = new LayuiTableParam();
		params.setLimit(10);
		params.setPage(1);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("nd", "2019");
		params.setParam(param);
		
		//创建集团单位预算表信息
		/*url = "http://localhost:8765/stp-provider/budget/budget-grouptotal-save";
		BudgetInfo params = (BudgetInfo) MyBeanUtils.createDefaultModel(BudgetInfo.class);
		params.setAuditStatus(WorkFlowStatusEnum.STATUS_WAITING.getCode());
		params.setBudgetType(BudgetInfoEnum.GROUP_TOTAL.getCode());
		params.setNd("2018");
		params.setBudgetMoney(28000d);
		params.setDataVersion("vs-2018-02");*/
		
		String rs = httpClientUtil.doPostBody(url,params,"UTF-8");
		System.out.println(rs);
		
		
	}
}

