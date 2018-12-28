package com.pcitc.service.job;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.feign.hana.OutProjectRemoteClient;
import com.pcitc.service.out.OutProjectPlanService;
import com.pcitc.service.out.OutProjectService;

/**
 * @author zhf 定时获取项目管理系统的项目数据，并保存到本地数据
 */
@Component
public class HanaProjectJob implements Job, Serializable {

	private static final long serialVersionUID = 1L;
	

	public void execute(JobExecutionContext job) throws JobExecutionException {
		
		OutProjectRemoteClient outProjectRemoteClient = SpringContextUtil.getApplicationContext().getBean(OutProjectRemoteClient.class);
		System.out.println("定时开始调用feign获取hana数据---------------"+outProjectRemoteClient);
		
		OutProjectService outProjectService = SpringContextUtil.getApplicationContext().getBean(OutProjectService.class);
		OutProjectPlanService outProjectPlanService = SpringContextUtil.getApplicationContext().getBean(OutProjectPlanService.class);
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		List<OutProjectInfo> insertItemData = new ArrayList<OutProjectInfo>();
		List<OutProjectInfo> insertData = new ArrayList<OutProjectInfo>();
		List<OutProjectPlan> insertPlanDate = new ArrayList<OutProjectPlan>();
		
		Calendar date = Calendar.getInstance();
		String ysYear = String.valueOf(date.get(Calendar.YEAR));
		
		map.put("nd", ysYear);
		JSONArray resultList = outProjectRemoteClient.getLastCountryProject(map);
		if (resultList != null) {
			for (int i = 0; i < resultList.size(); i++) {
				JSONObject json = resultList.getJSONObject(i);
				
				OutProjectInfo opi = new OutProjectInfo();
				OutProjectInfo opItem = new OutProjectInfo();
				OutProjectPlan opp = new OutProjectPlan();
				
				String G0PROJCODE = json.getString("G0PROJCODE");
				String dataId = UUID.randomUUID().toString().replaceAll("-", "");
				opi.setHth(json.getString("G0PROJCODE")); //项目编码
				opi.setXmmc(json.getString("G0PROJTXT")); //项目名称
				
				opp.setHth(json.getString("G0PROJCODE")); //项目编码
				opp.setXmmc(json.getString("G0PROJTXT")); //项目名称
				
				// 研究院
				String G0GSJC = json.getString("G0GSJC");
				if (G0GSJC.equals("上海院")) {
					G0GSJC = "A07" + G0GSJC;
				} else if (G0GSJC.equals("勘探院")) {
					G0GSJC = "A01" + G0GSJC;
				} else if (G0GSJC.equals("北化院")) {
					G0GSJC = "A06" + G0GSJC;
				} else if (G0GSJC.equals("大连院")) {
					G0GSJC = "A05" + G0GSJC;
				} else if (G0GSJC.equals("安工院")) {
					G0GSJC = "A08" + G0GSJC;
				} else if (G0GSJC.equals("物探院")) {
					G0GSJC = "A02" + G0GSJC;
				} else if (G0GSJC.equals("工程院")) {
					G0GSJC = "A03" + G0GSJC;
				} else if (G0GSJC.equals("石科院")) {
					G0GSJC = "A04" + G0GSJC;
				} 
				System.out.println("=========研究院-----------------"+G0GSJC);
				opi.setDefine2(G0GSJC);
				opi.setDefine3("sap国家项目"); //数据来源
				opi.setNd(json.getString("G0YEARXM")); //年度
				
				opp.setDefine2(G0GSJC);
				opp.setDefine4("sap国家项目"); //数据来源
				opp.setNd(json.getString("G0YEARXM")); //年度
				
				opi.setFwdxbm("GF");
				opi.setFwdx("股份");
				
				opp.setFwdxbm("GF");
				opp.setFwdx("股份");
				
				String jf = json.getString("K0ZTYSJE");
				opi.setJf(String.valueOf(Double.parseDouble(jf)/1000)); //金额
				opi.setProjectProperty("国家项目");
				
				opp.setJf(String.valueOf(Double.parseDouble(jf)/1000)); //金额
				opp.setProjectProperty("国家项目");
				
				// 资本性、费用性
				String zbxfyx = json.getString("G0XMLXMS");
				if (zbxfyx.contains("费用")) { //已关闭、已释放
					opi.setDefine1("费用性");
					opp.setDefine1("费用性");
				} else {
					opi.setDefine1("资本性");
					opp.setDefine1("资本性");
				}
				
				// 项目是否有子项目（都按照没有子项目来考虑）
				opi.setProjectType("0");
				opi.setFzdwbm(json.getString("G0GSDM"));
				opi.setFzdw(json.getString("G0GSJC"));
				opi.setXmlbbm("GB");
				opi.setXmlbmc("国拨项目");
				opi.setTypeFlag("A直属研究院");
				
				opp.setProjectType("0");
				opp.setFzdwbm(json.getString("G0GSDM"));
				opp.setFzdw(json.getString("G0GSJC"));
				opp.setXmlbbm("GB");
				opp.setXmlbmc("国拨项目");
				opp.setDefine3("A直属研究院");
				
				opi.setDataId(dataId);
				opi.setXmid(G0PROJCODE);
				opi.setCreateDate(new Date());
				opi.setCreatePerson("admin");
				
				opp.setDataId(dataId);
				opp.setXmid(G0PROJCODE);
				
				insertData.add(opi);
				insertPlanDate.add(opp);
				
				//保留预算相关
				opItem.setKtid(json.getString("G0PROJCODE")); //项目编码
				opItem.setKtmc(json.getString("G0PROJTXT")); //项目名称
				opItem.setDefine1("sap国家项目预算"); //数据来源
				opItem.setNd(ysYear); //年度
				
				String jfhj = json.getString("K0BNYSJE");
				String xdjf = json.getString("K0BNSJJE");
				opItem.setJfhj(String.valueOf(Double.parseDouble(jfhj)/1000)); //金额
				opItem.setSjhf(String.valueOf(Double.parseDouble(jfhj)/1000)); //报销金额
				opItem.setXdjf(String.valueOf(Double.parseDouble(xdjf)/1000)); //下达金额
				
				opItem.setDataId(dataId);
				opItem.setCreateDate(new Date());
				opItem.setCreatePerson("admin");
				
				//项目是否已经关闭
				String G0XMZT = json.getString("G0XMZT");
				
				if (G0XMZT != null && G0XMZT.equals("I0046")) {
					opItem.setDefine2("sap项目已关闭");
				} else {
					opItem.setDefine2("sap项目未关闭");
				}
				insertItemData.add(opItem);
			}
			
			if (insertPlanDate != null && insertPlanDate.size() > 0) {
				
				outProjectPlanService.insertCountryProjectPlanBatch(insertPlanDate);
				outProjectService.insertCountryProjectData(insertData);
			}
			
			if (insertItemData != null && insertItemData.size() > 0) {
				System.out.println("保存预算---------------"+resultList);
				outProjectService.insertCountryProjectItemData(insertItemData, ysYear);
			}
		}
		
		
		System.out.println("定时结束调用feign获取hana数据---------------"+resultList);
	}

}
