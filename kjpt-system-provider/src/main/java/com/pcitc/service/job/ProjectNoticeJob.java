package com.pcitc.service.job;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.pcitc.base.stp.out.OutNotice;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.out.OutNoticeService;
import com.pcitc.utils.DataServiceUtil;

//项目管理系统的通知公告
public class ProjectNoticeJob implements Job, Serializable {
	private static final long serialVersionUID = 1L;

	public void execute(JobExecutionContext job) throws JobExecutionException {

		OutNoticeService outNoticeService = SpringContextUtil.getApplicationContext().getBean(OutNoticeService.class);
		System.out.println("==========" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "---定时任务--项目管理系统通知接口---开始=============");
		String sqlName = "GetInfoList_KJBL";
		JsonObject jo = new JsonObject();
		// 参数
		String conditions = jo.toString();
		String str = null;
		try {
			// 远程获取数据 -----
			str = DataServiceUtil.getDataService(DataServiceUtil.GET_URL, sqlName, conditions);
			if (str != null) {
				JSONArray jSONArray = JSONArray.parseArray(str);
				List<OutNotice> insertData = new ArrayList<OutNotice>();
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					OutNotice notice = new OutNotice();
					String xxbt = object.getString("xxbt");
					String xxnr = object.getString("xxnr");
					String fbsj = object.getString("fbsj");
					
					if (fbsj != null && fbsj.length() > 18) {// 待办任务时间含T
						notice.setNoticeDate(fbsj.substring(0, 19).replaceAll("T", " "));
					}
					notice.setNoticeTitle(xxbt);
					notice.setNoticeContext(xxnr);
					notice.setNoticeSystemType("项目管理系统");
					
					notice.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
					notice.setCreateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
					
					insertData.add(notice);
				}

				outNoticeService.insertNoticeDataBatch(insertData, "项目管理系统");
				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "项目管理系统通知--保存到本地数据库-结束=========");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
