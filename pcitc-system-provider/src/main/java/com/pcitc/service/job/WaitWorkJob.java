package com.pcitc.service.job;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.pcitc.base.stp.out.OutWaitWork;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.out.OutWaitWorkService;
import com.pcitc.utils.DataServiceUtil;

public class WaitWorkJob implements Job, Serializable {

	private static final long serialVersionUID = 1L;

	public void execute(JobExecutionContext job) throws JobExecutionException {
		OutWaitWorkService outWaitWorkService = SpringContextUtil.getApplicationContext().getBean(OutWaitWorkService.class);

		System.out.println("==========" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时任务--项目管理所有待办任务接口 ---开始=============");
		String sqlName = "GetPendingTasks_ContractsManageN";
		JsonObject jo = new JsonObject();
		jo.addProperty("", "");
		// 参数
		String conditions = jo.toString();
		String str = null;
		try {
			// 远程获取数据 -----
			str = DataServiceUtil.getDataService(DataServiceUtil.GET_URL, sqlName, conditions);
			System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "项目管理所有待办任务接口返回 success=====");
			if (str != null) {
				// 先删除所有类型为2的代办
				JSONArray jSONArray = JSONArray.parseArray(str);
				List<OutWaitWork> insertList = new ArrayList<OutWaitWork>();
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					String title = object.getString("HDMC");
					String gcslxgxx = object.getString("gcslxgxx");
					String url = object.getString("HREF_STR");
					String shcl_href = object.getString("shcl_href");
					String userId = object.getString("YHMC");
					String userName = object.getString("YHXM");
					String XMLB_MC = object.getString("XMLB_MC");
					String RWDDSJ = object.getString("RWDDSJ");

					String FZDW_MC = object.getString("FZDW_MC");
					StringBuffer noteSB = new StringBuffer("");
					OutWaitWork outWaitWork = new OutWaitWork();
					if (title != null) {
						noteSB.append(title);
					}
					if (XMLB_MC != null) {
						noteSB.append("--"+XMLB_MC);
					}
					if (FZDW_MC != null) {
						noteSB.append("--"+FZDW_MC);
					}
					outWaitWork.setNotes(noteSB.toString());
					
					StringBuffer realUrl = new StringBuffer(DataServiceUtil.HOME_PAGE);
					if (url != null && url.length() > 5) {
						realUrl.append(url.substring(5));
					}
					outWaitWork.setUrl(realUrl.toString());
					
					outWaitWork.setUserId(userId);
					outWaitWork.setTitle(gcslxgxx);
					outWaitWork.setType("2");
					outWaitWork.setUserName(userName);
					outWaitWork.setCreateTime(new Date());
					
					if (RWDDSJ != null && RWDDSJ.length() > 18) {// 待办任务时间含T
						outWaitWork.setWaitTime(DateUtil.strToDate(RWDDSJ.substring(0, 19).replaceAll("T", " "), DateUtil.FMT_SS));
					}
					
					// 运程代办--》保存到本地数据库
					//outWaitWorkService.insertOutWaitWork(outWaitWork);
					insertList.add(outWaitWork);
				}
				
				if (insertList != null && insertList.size() > 1) {
					outWaitWorkService.deleteOutWaitWorkByType("2");
					System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "开始插入=========");
					outWaitWorkService.insertOutWaitWorkBatch(insertList);
				}
				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时任务--项目管理所有待办任务接口 --保存到本地数据库-结束=========");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
