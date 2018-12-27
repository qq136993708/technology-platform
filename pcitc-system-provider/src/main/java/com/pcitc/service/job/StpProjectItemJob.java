package com.pcitc.service.job;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.out.OutProjectService;
import com.pcitc.utils.DataServiceUtil;

/**
 * @author zhf 定时获取项目管理系统的项目预算的数据
 */
public class StpProjectItemJob implements Job, Serializable {

	private static final long serialVersionUID = 1L;

	public void execute(JobExecutionContext job) throws JobExecutionException {

		OutProjectService outProjectService = SpringContextUtil.getApplicationContext().getBean(OutProjectService.class);
		
		// 先获取已经插入到数据库的原项目计划数据oldList，和新接口获取的数据进行比较。如果不存在就插入
		// 由于数据库数据不大，所以可以采用这个方式
		HashMap<String, String> map = new HashMap<String, String>();
		//List temList = outProjectService.getProjectItemList(map);
		int culTotal = 0;
		System.out.println("==========" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时获取项目管理系统的项目预算数据 ---开始=============");
		String sqlName = "ktxmndjf";
		String ndCon = "2019";
		String str = null;
		try {
			// 远程获取数据 -----
			str = DataServiceUtil.getProjectData(sqlName, ndCon);
			System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时获取项目管理系统的项目预算数据 返回 success=====");
			if (str != null) {
				// 先删除年度为nd的本地数据（备份一份到临时表中，防止意外）
				List<OutProjectInfo> insertData = new ArrayList<OutProjectInfo>();
				JSONArray jSONArray = JSONArray.parseArray(str);
				
				// 批量新增处理
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					culTotal++;
					boolean insertFlag = true;
					String ktid = object.getString("ktid");
					String nd = object.getString("nd");
/*					for (int j = 0; j < temList.size(); j++) {
						HashMap<String, String> opp = (HashMap<String, String>)temList.get(j);
						if (ktid.equals(opp.get("ktid").toString()) && nd.equals(opp.get("nd").toString())) {
							insertFlag = false;
							break;
						}
					}
*/					
					if (insertFlag) {
						String ktmc = object.getString("ktmc");
						String jfhj = object.getString("jfhj");

						OutProjectInfo opi = new OutProjectInfo();
						
						opi.setNd(nd);
						opi.setJfhj(jfhj);
						opi.setKtid(ktid);
						opi.setKtmc(ktmc);
						
						opi.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
						opi.setStatus("1");
						opi.setCreateDate(new Date());
						opi.setCreatePerson("admin");
						opi.setDefine1("项目管理系统预算接口");
						insertData.add(opi);
					}
				}
				if (insertData != null && insertData.size() > 0) {
					outProjectService.insertProjectItemData(insertData);
				}
				
				/*// for修改
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					
					String xmid = object.getString("XMID");
					String xmjb = object.getString("XMJB");
					String gsbmbm = object.getString("GSBMBM");
					String gsbmmc = object.getString("GSBMMC");
					String zycbm = object.getString("ZYCBM");
					String zycmc = object.getString("ZYCMC");
					String xmlbbm = object.getString("XMLBBM");
					String xmlbmc = object.getString("XMLBMC");

					OutProjectInfo opi = new OutProjectInfo();
					opi.setDataId(xmid);
					opi.setXmid(xmid);
					
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
					
					opi.setGsbmbm(gsbmbm);
					opi.setGsbmmc(gsbmmc);
					opi.setZycbm(zycbm);
					opi.setZycmc(zycmc);
					opi.setXmlbbm(xmlbbm);
					opi.setXmlbmc(xmlbmc);
					outProjectService.updateOutProjectInfo(opi);
				}*/
				
				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时任务--定时获取项目管理系统的项目数据--保存到本地数据库-结束========="+culTotal);
				// 统一调用存储过程，把数据中部分属性集中处理
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
