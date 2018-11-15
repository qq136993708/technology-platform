package com.pcitc.service.job;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

//奖励系统
public class RewardJob implements Job, Serializable {
	private static final long serialVersionUID = 1L;

	public void execute(JobExecutionContext job) throws JobExecutionException {

		OutRewardService outRewardService = SpringContextUtil.getApplicationContext().getBean(OutRewardService.class);

		String sqlName = "SelectAllProject";
		JsonObject jo = new JsonObject();

		jo.addProperty("nd", "");
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
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					temI++;
					OutReward op = new OutReward();

					op.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
					op.setCreateDate(new Date());

					insertData.add(op);
					if (temI > 1000) {
						temI = 0;
						//OutRewardService.insertPatentData(insertData);
						temB = false;
						insertData.clear();
					} else {
						temB = true;
					}
				}
				if (temB && insertData != null && insertData.size() > 0) {
					//OutRewardService.insertPatentData(insertData);
				}

				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "专利项目--保存到本地数据库-结束=========");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
