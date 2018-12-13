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
import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.out.OutUnitService;
import com.pcitc.utils.DataServiceUtil;

//组织机构数据
public class UnitJob implements Job, Serializable {
	private static final long serialVersionUID = 1L;

	public void execute(JobExecutionContext job) throws JobExecutionException {

		OutUnitService outUnitService = SpringContextUtil.getApplicationContext().getBean(OutUnitService.class);
		System.out.println("==========" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "---定时任务--组织机构接口---开始=============");
		String sqlName = "SHYK_ZSHKJXMGL_DWXXB";
		JsonObject jo = new JsonObject();
		jo.addProperty("DWBM", "%%");
		jo.addProperty("SJBM", "%%");
		// 参数
		String conditions = jo.toString();
		String str = null;
		try {
			// 远程获取数据 -----
			str = DataServiceUtil.getDataService(DataServiceUtil.GET_URL, sqlName, conditions);
			if (str != null) {
				JSONArray jSONArray = JSONArray.parseArray(str);
				List<OutUnit> unitList = new ArrayList<OutUnit>();
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					OutUnit oa = new OutUnit();
					oa.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
					String dwbm = object.getString("DWBM");
					String dwjc = object.getString("DWJC");
					String dwqc = object.getString("DWQC");
					String sjbm = object.getString("SJBM");
					String dwlb = object.getString("DWLB");
					
					
					oa.setUnitCode(dwbm);
					oa.setUnitName(dwqc);
					oa.setUnitAli(dwjc);
					oa.setParentCode(sjbm);
					oa.setDefine1("科研项目系统");
					oa.setDefine2(dwlb);
					
					oa.setCreateDate(new Date());
					unitList.add(oa);
				}
				if (unitList != null && unitList.size() > 0) {
					//outUnitService.insertOutUnitBatch(unitList);
					// 批量修改
					outUnitService.updateUnitDataBatch(unitList);
				}
				
				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "组织机构数据--保存到本地数据库-结束=========");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*// 奖励系统的组织机构数据
		System.out.println("==========" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "---定时任务--组织机构接口---开始=============");
		String sqlName = "GetDWXXB";
		JsonObject jo = new JsonObject();
		// 参数
		String conditions = jo.toString();
		String str = null;
		try {
			// 远程获取数据 -----
			str = DataServiceUtil.getDataService(DataServiceUtil.GET_URL, sqlName, conditions);
			if (str != null) {
				JSONArray jSONArray = JSONArray.parseArray(str);
				List<OutUnit> insertData = new ArrayList<OutUnit>();
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					OutUnit oa = new OutUnit();
					oa.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
					String dwbm = object.getString("DWBM");
					String dwjc = object.getString("DWJC");
					String dwqc = object.getString("DWQC");
					String sjbm = object.getString("SJBM");
					String dwxz = object.getString("DWXZ");
					String dwjb = object.getString("DWJB");
					
					oa.setUnitCode(dwbm);
					oa.setUnitName(dwqc);
					oa.setUnitAli(dwjc);
					oa.setParentCode(sjbm);
					oa.setUnitType(dwxz);
					oa.setUnitLevel(dwjb);
					oa.setDefine1("奖励系统");
					oa.setCreateDate(new Date());
					insertData.add(oa);
				}
				if (insertData != null && insertData.size() > 0) {
					outUnitService.insertOutUnitBatch(insertData);
				}
				
				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "组织机构数据--保存到本地数据库-结束=========");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}*/

	}
}
