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
 * @author zhf 定时获取hana中的国家级项目，并保存到本地数据
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
		
		
		JSONArray resultList;
		try {
			resultList = outProjectRemoteClient.getLastCountryProject(map);
			if (resultList != null) {
				System.out.println(">>>>>>>>>>>>>>>>获取sap中国家项目数据: "+resultList.size()+" 条");
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
						G0GSJC = "A0107" + G0GSJC;
					} else if (G0GSJC.equals("勘探院")) {
						G0GSJC = "A0101" + G0GSJC;
					} else if (G0GSJC.equals("北化院")) {
						G0GSJC = "A0106" + G0GSJC;
					} else if (G0GSJC.equals("大连院")) {
						G0GSJC = "A0105" + G0GSJC;
					} else if (G0GSJC.equals("安工院")) {
						G0GSJC = "A0108" + G0GSJC;
					} else if (G0GSJC.equals("物探院")) {
						G0GSJC = "A0102" + G0GSJC;
					} else if (G0GSJC.equals("工程院")) {
						G0GSJC = "A0103" + G0GSJC;
					} else if (G0GSJC.equals("石科院")) {
						G0GSJC = "A0104" + G0GSJC;
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
					opi.setJf(String.valueOf(Double.parseDouble(jf)/10000)); //金额
					opi.setProjectProperty("国家项目");
					
					opp.setJf(String.valueOf(Double.parseDouble(jf)/10000)); //金额
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
					opi.setTypeFlag("A01直属研究院");
					
					opp.setProjectType("0");
					opp.setFzdwbm(json.getString("G0GSDM"));
					opp.setFzdw(json.getString("G0GSJC"));
					opp.setXmlbbm("GB");
					opp.setXmlbmc("国拨项目");
					opp.setDefine3("A01直属研究院");
					
					opi.setDataId(dataId);
					opi.setXmid(G0PROJCODE);
					opi.setCreateDate(new Date());
					opi.setCreatePerson("admin");
					
					opp.setDataId(dataId);
					opp.setXmid(G0PROJCODE);
					
					//预算相关
					opi.setYsnd(ysYear); //预算年度
					String jfhj = json.getString("K0BNYSJE");
					String xdjf = json.getString("K0BNSJJE");
					opi.setYsje(String.valueOf(Double.parseDouble(jfhj)/10000)); //报销金额
					opi.setYsxd(String.valueOf(Double.parseDouble(xdjf)/10000)); //下达金额
					
					opp.setYsnd(ysYear); //预算年度
					opp.setYsje(String.valueOf(Double.parseDouble(jfhj)/10000)); //报销金额
					
					//sap项目是否已经关闭
					String G0XMZT = json.getString("G0XMZT");
					
					if (G0XMZT != null && G0XMZT.equals("I0046")) {
						opi.setDefine7("sap项目已关闭");
					} else {
						opi.setDefine7("sap项目未关闭");
					}
					
					insertData.add(opi);
					insertPlanDate.add(opp);
					
				}
				System.out.println("定时结束feign获取hana数据---------------"+insertPlanDate.size());
				System.out.println("定时结束feign获取hana数据---------------"+insertData.size());
				if (insertPlanDate != null && insertPlanDate.size() > 0) {
					
					outProjectPlanService.insertCountryProjectPlanBatch(insertPlanDate, ysYear);
					outProjectService.insertCountryProjectData(insertData, ysYear);
				}
				
			}
			
		} catch (NumberFormatException e) {
			System.out.println(">>>>>>>>>>>>>获取sap中国家项目数据  调用异常>>>>>>>>>>>>>>>>");
			e.printStackTrace();
		}
		
		
	}

}
