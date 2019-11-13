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
				List<OutUnit> temUnit = outUnitService.selectByDefine1("科研项目系统");
				JSONArray jSONArray = JSONArray.parseArray(str);
				List<OutUnit> unitList = new ArrayList<OutUnit>();
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					OutUnit oa = new OutUnit();
					String dwbm = object.getString("DWBM");
					String dwjc = object.getString("DWJC");
					String dwqc = object.getString("DWQC");
					String sjbm = object.getString("SJBM");
					String dwlb = object.getString("DWLB");
					boolean addFlag = true;
					for (int k = 0; k < temUnit.size(); k++) {
						if (temUnit.get(k).getUnitCode() != null && temUnit.get(k).getUnitCode().equals(dwbm) && temUnit.get(k).getUnitName().equals(dwqc)) {
							addFlag = false;
							break;
						}
					}
					if (dwbm != null && dwbm.equals("111011")) {
						System.out.println("=====dwbm++++++===="+dwbm+"====="+dwqc);
					}
					if (addFlag) {
						oa.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));

						oa.setUnitCode(dwbm);
						oa.setUnitName(dwqc);
						oa.setUnitAli(dwjc);
						oa.setParentCode(sjbm);
						oa.setDefine1("科研项目系统");
						oa.setDefine2(dwlb);
						if (dwlb != null && dwlb.equals("YK")) {
							oa.setDefine3("盈科");
						}
						if (dwlb != null && dwlb.equals("XTW")) {
							oa.setDefine3("外部单位");
						}
						if (dwlb != null && (dwlb.equals("YJY") || dwlb.equals("ZSY"))) {
							oa.setDefine3("直属研究院");
						}
						if (dwlb != null && dwlb.equals("JTZS")) {
							oa.setDefine3("集团公司");
						}
						if (dwlb != null && dwlb.equals("ZCGS")) {
							oa.setDefine3("资产公司");
						}
						System.out.println("=====dwbm++++++===="+dwbm);
						oa.setCreateDate(new Date());
						if (dwqc == null || (dwqc != null && dwqc.equals(""))) {
							// 单位全称是空的，不保存
						} else {
							if (dwqc != null && (dwjc == null || dwjc.equals(""))) {
								dwjc = dwqc;
							}
							unitList.add(oa);
						}
					}

				}
				if (unitList != null && unitList.size() > 0) {
					outUnitService.insertOutUnitBatch(unitList, "科研项目系统");
				}

				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "组织机构数据--保存到本地数据库-结束=========");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * // 奖励系统的组织机构数据 System.out.println("==========" +
		 * DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) +
		 * "---定时任务--组织机构接口---开始============="); String sqlName = "GetDWXXB";
		 * JsonObject jo = new JsonObject(); // 参数 String conditions =
		 * jo.toString(); String str = null; try { // 远程获取数据 ----- str =
		 * DataServiceUtil.getDataService(DataServiceUtil.GET_URL, sqlName,
		 * conditions); if (str != null) { JSONArray jSONArray =
		 * JSONArray.parseArray(str); List<OutUnit> unitList = new
		 * ArrayList<OutUnit>(); for (int i = 0; i < jSONArray.size(); i++) {
		 * JSONObject object = (JSONObject) jSONArray.get(i); OutUnit oa = new
		 * OutUnit(); oa.setDataId(UUID.randomUUID().toString().replaceAll("-",
		 * "")); String dwbm = object.getString("DWBM"); String dwjc =
		 * object.getString("DWJC"); String dwqc = object.getString("DWQC");
		 * String sjbm = object.getString("SJBM"); String dwxz =
		 * object.getString("DWXZ"); String dwjb = object.getString("DWJB");
		 * String dwlb = object.getString("DWLB");
		 * 
		 * oa.setUnitCode(dwbm); oa.setUnitName(dwqc); oa.setUnitAli(dwjc);
		 * oa.setParentCode(sjbm); oa.setUnitType(dwxz); oa.setUnitLevel(dwjb);
		 * oa.setDefine1("奖励系统"); oa.setDefine2(dwlb); oa.setCreateDate(new
		 * Date()); unitList.add(oa); } if (unitList != null && unitList.size()
		 * > 0) { //outUnitService.insertOutUnitBatch(unitList); // 批量修改
		 * outUnitService.updateUnitDataBatch(unitList); }
		 * 
		 * System.out.println("======" + DateUtil.dateToStr(new Date(),
		 * DateUtil.FMT_SS) + "组织机构数据--保存到本地数据库-结束========="); }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */

	}
}
