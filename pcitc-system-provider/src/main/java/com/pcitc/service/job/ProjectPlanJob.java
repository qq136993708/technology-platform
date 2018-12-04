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
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.out.OutProjectPlanService;
import com.pcitc.utils.DataServiceUtil;

/**
 * @author zhf 定时获取项目管理系统的项目计划数据，并保存到本地数据
 */
public class ProjectPlanJob implements Job, Serializable {

	private static final long serialVersionUID = 1L;

	public void execute(JobExecutionContext job) throws JobExecutionException {

		OutProjectPlanService outProjectPlanService = SpringContextUtil.getApplicationContext().getBean(OutProjectPlanService.class);

		System.out.println("==========" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时获取项目管理系统的项目计划数据 ---开始=============");
		String sqlName = "SelectAllProjectFromPlanData";
		String ndCon = "2018";
		String str = null;
		try {
			// 远程获取数据 -----
			str = DataServiceUtil.getProjectData(sqlName, ndCon);
			System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时获取项目管理系统的项目计划数据 返回 success=====");
			if (str != null) {
				// 先删除年度为nd的本地数据（备份一份到临时表中，防止意外）
				List<OutProjectPlan> insertData = new ArrayList<OutProjectPlan>();
				JSONArray jSONArray = JSONArray.parseArray(str);
				
				// 批量新增处理
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					
					String nd = object.getString("ND");
					String xmid = object.getString("XMID");
					String hth = object.getString("HTH");
					String xmmc = object.getString("XMMC");
					String xmjb = object.getString("XMJB");
					String jf = object.getString("JF");
					String fwdxbm = object.getString("FWDXBM");
					String fwdx = object.getString("FWDX");
					String zylbbm = object.getString("ZYLBBM");

					String zylb = object.getString("ZYLB");
					String fzdwbm = object.getString("FZDWBM");
					String fzdw = object.getString("FZDW");
					String jtfzdwbm = object.getString("JTFZDWBM");
					String jtfzdw = object.getString("JTFZDW");
					String fzrxm = object.getString("FZRXM");
					String jssxxm = object.getString("JSSXXM");

					String yjsj = object.getString("YJSJ");
					String zyly = object.getString("ZYLY");
					String zysx = object.getString("ZYSX");
					String sjid = object.getString("SJID");
					String lxbj = object.getString("LXBJ");
					String yjnr = object.getString("YJNR");
					String jdap = object.getString("JDAP");
					String yjmb = object.getString("YJMB");
					
					String gsbmbm = object.getString("GSBMBM");
					String gsbmmc = object.getString("GSBMMC");
					String zycbm = object.getString("ZYCBM");
					String zycmc = object.getString("ZYCMC");
					String xmlbbm = object.getString("XMLBBM");
					String xmlbmc = object.getString("XMLBMC");
					
					String projectId = object.getString("XMID");

					OutProjectPlan opi = new OutProjectPlan();
					
					opi.setNd(nd);
					opi.setXmid(xmid);
					opi.setHth(hth);
					opi.setXmmc(xmmc);
					opi.setXmjb(xmjb);
					opi.setJf(jf);
					opi.setFwdxbm(fwdxbm);
					opi.setFwdx(fwdx);
					opi.setZylbbm(zylbbm);

					opi.setZylb(zylb);
					opi.setFzdwbm(fzdwbm);
					opi.setFzdw(fzdw);
					opi.setJtfzdwbm(jtfzdwbm);
					opi.setJtfzdw(jtfzdw);
					opi.setFzrxm(fzrxm);
					opi.setJssxxm(jssxxm);

					opi.setYjsj(yjsj);
					opi.setZyly(zyly);
					opi.setZysx(zysx);
					opi.setSjid(sjid);
					opi.setLxbj(lxbj);
					opi.setYjnr(yjnr);
					opi.setJdap(jdap);
					opi.setYjmb(yjmb);
					
					opi.setGsbmbm(gsbmbm);
					opi.setGsbmmc(gsbmmc);
					opi.setZycbm(zycbm);
					opi.setZycmc(zycmc);
					opi.setXmlbbm(xmlbbm);
					opi.setXmlbmc(xmlbmc);
					if (sjid != null && Integer.parseInt(sjid) > 0) {
						opi.setProjectType("2");
					}
					if (sjid != null && Integer.parseInt(sjid) == 0) {
						opi.setProjectType("1");
					}
					if (sjid != null && Integer.parseInt(sjid) == -1) {
						opi.setProjectType("0");
					}
					
					if (xmlbbm != null && xmlbbm.equals("KYZB")) {
						opi.setDefine1("资本性");
						opi.setProjectProperty("其他项目");
					} else {
						opi.setDefine1("费用性");
						if (xmlbbm != null && !xmlbbm.equals("KY")) {
							opi.setProjectProperty("其他项目");
						} else {
							if (xmjb != null && xmjb.equals("ZHONGDA")) {
								opi.setProjectProperty("重大专项");
							} else {
								opi.setProjectProperty("重点项目");
							}
						}
					}
					//opi.setProjectScope("新开课题");  //新开
					System.out.println("======----------------" + sjid + "-------------====="+opi.getProjectType()+"======="+sjid);
					opi.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
					insertData.add(opi);
				}
				if (insertData != null && insertData.size() > 0) {
					outProjectPlanService.insertOutProjectPlanBatch(insertData);
				}
				
				
				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时任务--定时获取项目管理系统的项目计划数据--保存到本地数据库-结束=========");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
