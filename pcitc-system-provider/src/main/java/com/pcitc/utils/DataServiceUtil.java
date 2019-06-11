package com.pcitc.utils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class DataServiceUtil {

	public static final String HOME_PAGE = "10.1.19.130:8008";
	public static final String HOST_PORT = "10.1.19.131:9001";
	public static final String GET_URL = "http://" + HOST_PORT + "/DataService/BasicQuery/Sql";

	public static String getDataService(String url, String sqlName, String conditions) throws Exception {
		String result = null;
		RestfulHttpClient.HttpClient client = RestfulHttpClient.getClient(url);
		client.get();
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Authorization", "Basic AwardsClientTest:wangcong382.slyt");
		RestfulHttpClient.setDefaultHeaders(headerMap);
		client.addHeaders(headerMap);

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("sqlName", sqlName);
		paramMap.put("conditions", conditions);
		client.queryParams(paramMap);
		RestfulHttpClient.HttpResponse response = client.request();
		if (response.getCode() == 200) {
			result = response.getContent();
		}
		return result;
	}

	public static String getProjectData(String sqlName, String nd) throws Exception {
		String result = null;
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
			paramMap.put("sqlName", sqlName);
			JsonObject jo = new JsonObject();
			jo.addProperty("ND", nd);

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
				result = response.getContent();
				System.out.println("===返回======" + result);
			}
		} catch (Exception e) {

		}
		return result;
	}

	/*
	 * public static void main(String[] args) throws Exception {
	 * 
	 * 
	 * 
	 * //项目管理待办任务接口--根据ID获取 String sqlName="GetPendingTasks_ContractsManage";
	 * JsonObject jo = new JsonObject(); jo.addProperty("yhmc", "Bilifei.slyt");
	 * String conditions=jo.toString(); String
	 * str=getDataService(GET_URL,sqlName,conditions);
	 * System.out.println("========项目管理待办任务接口:"+str);
	 * 
	 * 
	 * 
	 * //项目管理待办任务接口-所有
	 * 
	 * String sqlName="GetPendingTasks_ContractsManageN"; JsonObject jo = new
	 * JsonObject(); jo.addProperty("", ""); String conditions=jo.toString();
	 * String str=getDataService(GET_URL,sqlName,conditions); JSONArray json =
	 * JSONArray.parseArray(str);
	 * System.out.println("========项目管理待办任务接口-所有:"+json.toJSONString());
	 * 
	 * 
	 * String sqlName="zl_daiban1"; JsonObject jo = new JsonObject();
	 * jo.addProperty("", ""); String conditions=jo.toString(); String
	 * str=getDataService(GET_URL,sqlName,conditions); JSONArray json =
	 * JSONArray.parseArray(str);
	 * System.out.println("========专利管理待办任务接口:"+json.toJSONString());
	 * 
	 * 
	 * 
	 * 
	 * //中石化科技奖励系统2017年获奖项目信息 String sqlName="SelectAllProject"; JsonObject jo =
	 * new JsonObject(); jo.addProperty("", ""); String
	 * conditions=jo.toString(); String
	 * str=getDataService(GET_URL,sqlName,conditions);
	 * System.out.println("========中石化科技奖励系统2017年获奖项目信息:"+str);
	 * 
	 * 
	 * 
	 * //鉴定系统2017年获得鉴定号的项目查询接口 String sqlName="SelectAllJDSQ"; JsonObject jo =
	 * new JsonObject(); jo.addProperty("", ""); String
	 * conditions=jo.toStriong(); String
	 * str=getDataService(GET_URL,sqlName,conditions);
	 * System.out.println("========鉴定系统2017年获得鉴定号的项目查询接口:"+str);
	 * 
	 * }
	 */

	public static void main(String[] args) throws IOException {
		String text = "www.baidu.com";
		int width = 200;
		int height = 200;
		String format = "png";
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
			Path file = new java.io.File("D:/new.png").toPath();
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
