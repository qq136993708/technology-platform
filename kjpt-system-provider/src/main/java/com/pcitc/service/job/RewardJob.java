package com.pcitc.service.job;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.pcitc.base.stp.out.OutReward;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.out.OutRewardService;
import com.pcitc.utils.DataServiceUtil;
import com.pcitc.utils.RestfulHttpClient;

//奖励系统
public class RewardJob implements Job, Serializable {
	private static final long serialVersionUID = 1L;

	public void execute(JobExecutionContext job) throws JobExecutionException {

		OutRewardService outRewardService = SpringContextUtil.getApplicationContext().getBean(OutRewardService.class);

		String sqlName = "SelectAllProject";
		JsonObject jo = new JsonObject();
		Calendar date = Calendar.getInstance();
		//String ndCon = String.valueOf(date.get(Calendar.YEAR));
		// jo.addProperty("nd", ndCon);

		System.out.println("==========开始导入---定时任务--奖励系统接口--=============");
		// 参数
		String conditions = jo.toString();
		String str = null;
		try {
			// 远程获取数据 -----
			str = DataServiceUtil.getDataService(DataServiceUtil.GET_URL, sqlName, conditions);
			if (str != null) {
				JSONArray jSONArray = JSONArray.parseArray(str);
				List<OutReward> insertData = new ArrayList<OutReward>();
				int temI = 0;
				boolean temB = true;
				System.out.println("==========开始导入---定时任务--奖励系统接口--=============" + jSONArray.size());
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					temI++;
					OutReward op = new OutReward();

					op.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
					op.setCreateDate(new Date());

					op.setXmid(String.valueOf(object.getInteger("XMID")));
					op.setXmbh(object.getString("XMBH"));
					op.setNd(object.getString("ND"));
					op.setXmmc(object.getString("XMMC"));
					op.setSbdw(object.getString("SBDW"));
					op.setSbjz(object.getString("SBJZ"));
					op.setXkfl(object.getString("XKFL"));
					op.setSbdj(object.getString("SBDJ"));
					op.setSbrq(object.getString("SBRQ"));
					op.setRwly(object.getString("RWLY"));
					op.setJddw(object.getString("JDDW"));
					op.setHth(object.getString("HTH"));
					op.setKssj(object.getString("KSSJ"));
					op.setJssj(object.getString("JSSJ"));
					op.setSbzt(object.getString("sbzt"));
					op.setPsdj(object.getString("PSDJ"));
					
					op.setStatus("newData");

					try {
						String temS = "";
						String TEST_URL = "http://10.1.19.131:9001/DataService/BasicQuery/Sql";
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
						JsonObject jo1 = new JsonObject();
						jo1.addProperty("xmid", String.valueOf(object.getInteger("XMID")));

						paramMap.put("conditions", jo1.toString());
						// 添加多个参数
						client.queryParams(paramMap);

						// 最终访问路径是：http://10.1.19.131:9001/DataService/BasicQuery/Sql?sqlName=SelectAllProjectInfo&nd=2008
						RestfulHttpClient.HttpResponse response = client.request();
						System.out.println(String.valueOf(object.getInteger("XMID"))+"===返回======" + response.getCode()+"============="+(response.getCode() == 200));
						// 根据状态码判断请求是否成功
						if (response.getCode() == 200) {
							// 获取响应内容
							String result = response.getContent();
							JSONArray jSONArray1 = JSONArray.parseArray(result);
							StringBuffer xm = new StringBuffer("");
							StringBuffer sfzh = new StringBuffer("");
							for (int k = 0; k < jSONArray1.size(); k++) {
								JSONObject object1 = (JSONObject) jSONArray1.get(k);
								if (k != 0) {
									xm.append(",");
									sfzh.append(",");
								}
								xm.append(object1.getString("xm"));
								sfzh.append(object1.getString("sfzh"));
								
							}
							System.out.println(xm+"===返1111111111回======" + sfzh);
							op.setDefine3(xm.toString());
							op.setDefine4(sfzh.toString());
						}
					} catch (Exception e) {

					}

					insertData.add(op);
					if (temI > 1000) {
						temI = 0;
						outRewardService.insertRewardData(insertData);
						temB = false;
						insertData.clear();
					} else {
						temB = true;
					}
				}
				if (temB && insertData != null && insertData.size() > 0) {
					outRewardService.insertRewardData(insertData);
				}

				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "奖励--保存到本地数据库-结束=========");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
