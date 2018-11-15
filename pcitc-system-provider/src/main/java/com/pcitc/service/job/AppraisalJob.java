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
import com.pcitc.base.stp.out.OutAppraisal;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.out.OutAppraisalService;
import com.pcitc.utils.DataServiceUtil;

//鉴定系统
public class AppraisalJob implements Job, Serializable {
	private static final long serialVersionUID = 1L;

	public void execute(JobExecutionContext job) throws JobExecutionException {

		OutAppraisalService outAppraisalService = SpringContextUtil.getApplicationContext().getBean(OutAppraisalService.class);
		System.out.println("==========" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "---定时任务--鉴定项目接口---开始=============");
		String sqlName = "SelectAllJDSQ";
		JsonObject jo = new JsonObject();
		jo.addProperty("", "");
		// 参数
		String conditions = jo.toString();
		String str = null;
		try {
			// 远程获取数据 -----
			str = DataServiceUtil.getDataService(DataServiceUtil.GET_URL, sqlName, conditions);
			if (str != null) {
				JSONArray jSONArray = JSONArray.parseArray(str);
				List<OutAppraisal> insertData = new ArrayList<OutAppraisal>();
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);

					int cgid = object.getInteger("cgid");
					String nd = object.getString("nd");
					String cgmc = object.getString("cgmc");
					String sqjddw = object.getString("sqjddw");
					String SQDJH = object.getString("SQDJH");
					String StartTime = object.getString("StartTime");
					String EndTime = object.getString("EndTime");

					String CGLX = object.getString("CGLX");
					String ZY = object.getString("ZY");
					String JDH = object.getString("JDH");
					String isSCZS = object.getString("isSCZS");
					String SBZT = object.getString("SBZT");
					String JDJG = object.getString("JDJG");
					
					String sqlNameHt = "GetHTHfromCGJD";
					JsonObject joHt = new JsonObject();
					joHt.addProperty("xmid", cgid);
					// 参数
					String conditionsHt = joHt.toString();
					String strHt = DataServiceUtil.getDataService(DataServiceUtil.GET_URL, sqlNameHt, conditionsHt);
					
					if (strHt != null) {
						JSONArray jSONArrayHt = JSONArray.parseArray(strHt);
						
						for (int j = 0; j < jSONArrayHt.size(); j++) {
							JSONObject objectHt = (JSONObject) jSONArrayHt.get(j);
							OutAppraisal oa = new OutAppraisal();
							oa.setCgid(String.valueOf(cgid));
							oa.setCgmc(cgmc);
							oa.setNd(nd);
							oa.setSqjddw(sqjddw);
							oa.setSqdjh(SQDJH);
							oa.setStarttime(StartTime);
							oa.setEndtime(EndTime);
							oa.setCglx(CGLX);
							oa.setZy(ZY);
							oa.setJdh(JDH);
							oa.setIssczs(isSCZS);
							oa.setSbzt(SBZT);
							oa.setJdjg(JDJG);

							oa.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
							oa.setStatus("1");
							oa.setCreateDate(new Date());
							
							oa.setHth(objectHt.getString("LinkHTH"));
							oa.setXmmc(objectHt.getString("LinkXMMC"));
							oa.setRwly(objectHt.getString("RWLY"));
							System.out.println("========================================================" + objectHt.getString("LinkHTH"));
							insertData.add(oa);
						}
					} else {
						OutAppraisal oa = new OutAppraisal();
						oa.setCgid(String.valueOf(cgid));
						oa.setCgmc(cgmc);
						oa.setNd(nd);
						oa.setSqjddw(sqjddw);
						oa.setSqdjh(SQDJH);
						oa.setStarttime(StartTime);
						oa.setEndtime(EndTime);
						oa.setCglx(CGLX);
						oa.setZy(ZY);
						oa.setJdh(JDH);
						oa.setIssczs(isSCZS);
						oa.setSbzt(SBZT);
						oa.setJdjg(JDJG);

						oa.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
						oa.setStatus("1");
						oa.setCreateDate(new Date());
						
						insertData.add(oa);
					}
					
					
				}

				outAppraisalService.insertAppraisalData(insertData, "");
				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "鉴定项目--保存到本地数据库-结束=========");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
