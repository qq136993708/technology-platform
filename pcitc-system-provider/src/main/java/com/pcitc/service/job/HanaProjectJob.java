package com.pcitc.service.job;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.feign.hana.OutProjectRemoteClient;

/**
 * @author zhf 定时获取项目管理系统的项目数据，并保存到本地数据
 */
@Component
public class HanaProjectJob implements Job, Serializable {

	private static final long serialVersionUID = 1L;
	

	public void execute(JobExecutionContext job) throws JobExecutionException {
		
		OutProjectRemoteClient outProjectRemoteClient = SpringContextUtil.getApplicationContext().getBean(OutProjectRemoteClient.class);
		System.out.println("定时开始调用feign获取hana数据---------------"+outProjectRemoteClient);
		
		HashMap<String, String> map = new HashMap<String, String>();
		JSONArray resultList = outProjectRemoteClient.getLastCountryProject(map);
		
		for (int i = 0; i < resultList.size(); i++) {
			JSONObject json = resultList.getJSONObject(i);
			
			/*OutProjectInfo opi = new OutProjectInfo();
			
			// 研究院
			opi.setDefine2(json.getString("G0GSJC"));
			opi.setDefine3("1直属研究院");
			opi.setDefine4("sap"); //数据来源
			opi.setNd(json.getString("G0YEARXM")); //年度
			
			String jf = json.getString("K0ZTJHYS");
			opi.setJf(String.valueOf(Double.parseDouble(jf)/1000)); //金额
			
			opi.setHth(json.getString("KKBE170051")); //项目编码
			opi.setXmmc(json.getString("G0PROJTXT")); //项目名称
			opi.setProjectProperty("国家项目");
			
			// 状态
			String zt = json.getString("G0PROJTXT");
			if (zt.equals("I0046")) { //已关闭、已释放
				opi.setProjectScope("完工课题");
			} else if (zt.equals("I0001")) {
				opi.setProjectScope("新开课题");
			} else {
				opi.setProjectScope("结转课题");
			}
			
			// 资本性、费用性
			String zbxfyx = json.getString("G0XMLXMS");
			if (zbxfyx.contains("费用")) { //已关闭、已释放
				opi.setDefine1("费用性");
			} else {
				opi.setDefine1("资本性");
			}
			
			// 项目是否有子项目（都按照没有子项目来考虑）
			opi.setProjectType("0");
			
			opi.setFwdxbm(json.getString("G0GSDM"));
			opi.setFwdx(json.getString("G0GSJC"));
			
			opi.setProjectScope("新开课题");  //新开
			opi.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
			opi.setXmid(opi.getDataId());
			opi.setCreateDate(new Date());
			opi.setCreatePerson("admin");*/
			//insertData.add(opi);
			
			
		}
		
		System.out.println("定时结束调用feign获取hana数据---------------"+resultList);
	}

}
