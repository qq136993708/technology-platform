package com.pcitc.service.job;

import java.io.Serializable;
import java.util.Date;

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

public class PatentWaitWorkJob implements Job, Serializable {

	private static final long serialVersionUID = 1L;

	public void execute(JobExecutionContext job) throws JobExecutionException {

		OutWaitWorkService outWaitWorkService = SpringContextUtil.getApplicationContext().getBean(OutWaitWorkService.class);
		System.out.println("==========" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "---定时任务--专利管理待办任务接口---开始=============");
		String sqlName = "zl_daiban1";
		JsonObject jo = new JsonObject();
		jo.addProperty("", "");
		// 参数
		String conditions = jo.toString();
		String str = null;
		try {
			// 远程获取数据 -----
			str = DataServiceUtil.getDataService(DataServiceUtil.GET_URL, sqlName, conditions);
			System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "--专利管理待办任务接口接口返回 success=====");
			if (str != null) {
				// 先删除所有类型为3的代办
				outWaitWorkService.deleteOutWaitWorkByType("3");
				JSONArray jSONArray = JSONArray.parseArray(str);
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					String ZLID = object.getString("ZLID");// 专利ID
					String ZLMC = object.getString("ZLMC");// 专利名称
					String HDMC = object.getString("HDMC");// 处理名称
					String ztsj_waitting = object.getString("ztsj_waitting");// 到达时间
					String DWMC = object.getString("DWMC");// 填报单位
					String Email = object.getString("Email");

					OutWaitWork outWaitWork = new OutWaitWork();
					outWaitWork.setTitle(ZLMC);
					outWaitWork.setType("3");
					outWaitWork.setUserName("");
					outWaitWork.setUserId(Email);
					outWaitWork.setUrl(DataServiceUtil.HOME_PAGE);
					outWaitWork.setCreateTime(new Date());
					outWaitWork.setNotes(DWMC + "--" + HDMC + "--" + ZLID);
					// 运程代办--》保存到本地数据库
					outWaitWorkService.insertOutWaitWork(outWaitWork);
				}
				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时任务--专利管理待办任务接口 --保存到本地数据库-结束=========");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
