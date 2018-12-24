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
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.out.OutProjectService;
import com.pcitc.utils.DataServiceUtil;

/**
 * @author zhf 定时获取项目管理系统的项目数据，并保存到本地数据
 */
public class StpProjectJob implements Job, Serializable {

	private static final long serialVersionUID = 1L;

	public void execute(JobExecutionContext job) throws JobExecutionException {

		OutProjectService outProjectService = SpringContextUtil.getApplicationContext().getBean(OutProjectService.class);
		
		// 先获取已经插入到数据库的原项目计划数据oldList，和新接口获取的数据进行比较。如果不存在就插入
		// 由于数据库数据不大，所以可以采用这个方式
		List<OutProjectInfo> temList = outProjectService.getProjectList(null);
		
		System.out.println("==========" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时获取项目管理系统的项目数据 ---开始=============");
		String sqlName = "SelectAllProjectFromSinopecData2017";
		String ndCon = "2017";
		String str = null;
		try {
			// 远程获取数据 -----
			str = DataServiceUtil.getProjectData(sqlName, ndCon);
			System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时获取项目管理系统的项目数据 返回 success=====");
			if (str != null) {
				// 先删除年度为nd的本地数据（备份一份到临时表中，防止意外）
				List<OutProjectInfo> insertData = new ArrayList<OutProjectInfo>();
				JSONArray jSONArray = JSONArray.parseArray(str);
				
				// 批量新增处理
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					
					boolean insertFlag = true;
					String temXmid = object.getString("XMID");
					for (int j = 0; j < temList.size(); j++) {
						OutProjectInfo opp = temList.get(j);
						if (temXmid.equals(opp.getXmid())) {
							insertFlag = false;
							break;
						}
					}
					
					if (insertFlag) {
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

						OutProjectInfo opi = new OutProjectInfo();
						
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
						/*opi.setLxbj(lxbj);
						opi.setYjnr(yjnr);
						opi.setJdap(jdap);
						opi.setYjmb(yjmb);*/
						
						opi.setGsbmbm(gsbmbm);
						opi.setGsbmmc(gsbmmc);
						opi.setZycbm(zycbm);
						opi.setZycmc(zycmc);
						opi.setXmlbbm(xmlbbm);
						opi.setXmlbmc(xmlbmc);
						if (sjid != null && Integer.parseInt(sjid) > 0) {
							opi.setParentProjectId(sjid);
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
						
						opi.setProjectScope("新开课题");  //新开
						opi.setProjectId(projectId);
						System.out.println("======----------------" + sjid + "-------------====="+opi.getProjectType()+"======="+sjid);
						opi.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
						opi.setStatus("1");
						opi.setCreateDate(new Date());
						opi.setCreatePerson("admin");
						opi.setDefine3("项目管理系统");
						insertData.add(opi);
					}
					
				}
				if (insertData != null && insertData.size() > 0) {
					outProjectService.insertProjectData(insertData, ndCon);
				}
				
				
				/*// for修改
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					
					String xmid = object.getString("XMID");
					String gsbmbm = object.getString("GSBMBM");
					String gsbmmc = object.getString("GSBMMC");
					String zycbm = object.getString("ZYCBM");
					String zycmc = object.getString("ZYCMC");
					String xmlbbm = object.getString("XMLBBM");
					String xmlbmc = object.getString("XMLBMC");

					OutProjectInfo opi = new OutProjectInfo();
					opi.setDataId(xmid);
					
					opi.setGsbmbm(gsbmbm);
					opi.setGsbmmc(gsbmmc);
					opi.setZycbm(zycbm);
					opi.setZycmc(zycmc);
					opi.setXmlbbm(xmlbbm);
					opi.setXmlbmc(xmlbmc);
					outProjectService.updateOutProjectInfo(opi);
				}*/
				
				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时任务--定时获取项目管理系统的项目数据--保存到本地数据库-结束=========");
				// 统一调用存储过程，把数据中部分属性集中处理
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
