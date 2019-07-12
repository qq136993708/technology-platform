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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.out.OutProjectPlanService;
import com.pcitc.service.out.OutProjectService;
import com.pcitc.utils.DataServiceUtil;

/**
 * @author zhf 定时获取项目管理系统的项目预算的数据
 */
public class StpProjectItemJob implements Job, Serializable {

	private static final long serialVersionUID = 1L;

	public void execute(JobExecutionContext job) throws JobExecutionException {

		OutProjectService outProjectService = SpringContextUtil.getApplicationContext().getBean(OutProjectService.class);
		
		OutProjectPlanService outProjectPlanService = SpringContextUtil.getApplicationContext().getBean(OutProjectPlanService.class);
		
		// 先获取已经插入到数据库的原项目计划数据oldList，和新接口获取的数据进行比较。如果不存在就插入
		// 由于数据库数据不大，所以可以采用这个方式
		HashMap<String, String> map = new HashMap<String, String>();
		//List temList = outProjectService.getProjectItemList(map);
		int culTotal = 0;
		System.out.println("==========" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时获取项目管理系统的项目预算数据 ---开始=============");
		String sqlName = "fndktjfjh";
		
		Calendar date = Calendar.getInstance();
		String ndCon = String.valueOf(date.get(Calendar.YEAR));
		String str = null;
		try {
			// 远程当年获取数据 -----
			str = DataServiceUtil.getProjectData(sqlName, ndCon);
			System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时获取项目管理系统的项目预算数据 返回 success====="+ndCon);
			if (str != null) {
				List<OutProjectInfo> insertData = new ArrayList<OutProjectInfo>();
				List<OutProjectPlan> planData = new ArrayList<OutProjectPlan>();
				JSONArray jSONArray = JSONArray.parseArray(str);
				
				// 批量新增处理
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					culTotal++;
					String ktid = object.getString("XMID");
					String ysnd = object.getString("ND");
					String nd = object.getString("LXND"); //立项年度
					String ysje = object.getString("HJ_RMB");
					String zbje = object.getString("ZBBK_RMB");
					String fyje = object.getString("FYBK_RMB");
					String cddw = object.getString("DWMC");
					String dwbm = object.getString("DWBM");
					
					
					OutProjectInfo opi = new OutProjectInfo();
					opi.setYsnd(ysnd);
					opi.setNd(nd);
					opi.setYsje(ysje);
					opi.setYszbxje(zbje);
					opi.setYsfyxje(fyje);
					opi.setXmid(ktid);
					opi.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
					opi.setDefine8(cddw); //承担单位
					opi.setDefine9(dwbm);
					opi.setCreateDate(new Date());
					opi.setCreatePerson("newItem");
					opi.setDefine3("项目管理系统");
					
					insertData.add(opi);
					
					OutProjectPlan opp = new OutProjectPlan();
					opp.setYsnd(ysnd);
					opp.setNd(nd);
					opp.setYsje(ysje);
					opp.setYszbxje(zbje);
					opp.setYsfyxje(fyje);
					opp.setXmid(ktid);
					opp.setDefine8(cddw); //承担单位
					opp.setDefine9(dwbm);
					opp.setDefine4("项目管理系统");
					planData.add(opp);
					
				}
				if (insertData != null && insertData.size() > 0) {
					// 修改当前年度的预算费用。没有的，查询后插入
					//outProjectService.insertProjectItemDataTest(insertData, ndCon);
					outProjectService.insertProjectItemData(insertData, ndCon);
					
					// 修改当前年度的计划预算费用，没有的查询后插入
					outProjectPlanService.insertOutProjectPlanForYS(planData);
					
					// 数据插入后，修改统计用的属性分类（没有使用存储过程或者函数来弄）
					outProjectPlanService.updateProjectPropertyInfo();
					
				}
				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时任务--定时获取项目管理系统的项目数据--保存到本地数据库-结束========="+culTotal);
				// 统一调用存储过程，把数据中部分属性集中处理
			}
			
			
			/*// 远程获取第二年数据 -----
			str = DataServiceUtil.getProjectData(sqlName, String.valueOf(Integer.parseInt(ndCon)+1));
			System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时获取项目管理系统的项目预算数据 返回 success第二年====="+String.valueOf(Integer.parseInt(ndCon)+1));
			if (str != null) {
				List<OutProjectInfo> insertData = new ArrayList<OutProjectInfo>();
				List<OutProjectPlan> planData = new ArrayList<OutProjectPlan>();
				JSONArray jSONArray = JSONArray.parseArray(str);
				
				// 批量新增处理
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					culTotal++;
					String ktid = object.getString("ktid");
					String nd = object.getString("nd");
					String jfhj = object.getString("jfhj");

					OutProjectInfo opi = new OutProjectInfo();
					opi.setYsnd(nd);
					opi.setYsje(jfhj);
					opi.setXmid(ktid);
					insertData.add(opi);
					
					OutProjectPlan opp = new OutProjectPlan();
					opp.setYsnd(nd);
					opp.setYsje(jfhj);
					opp.setXmid(ktid);
					planData.add(opp);
				}
				if (insertData != null && insertData.size() > 0) {
					outProjectService.insertProjectItemData(insertData, String.valueOf(Integer.parseInt(ndCon)+1));
					
					// 修改当前年度的计划预算费用，没有的查询后插入
					outProjectPlanService.insertOutProjectPlanForYS(planData);
				}
				
				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时任务--定时获取项目管理系统的项目数据--保存到本地数据库-结束========="+culTotal);
				// 统一调用存储过程，把数据中部分属性集中处理
			}
			
			// 远程获取第三年数据 -----
			str = DataServiceUtil.getProjectData(sqlName, String.valueOf(Integer.parseInt(ndCon)+2));
			System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时获取项目管理系统的项目预算数据 返回 success第二年====="+String.valueOf(Integer.parseInt(ndCon)+2));
			if (str != null) {
				List<OutProjectInfo> insertData = new ArrayList<OutProjectInfo>();
				List<OutProjectPlan> planData = new ArrayList<OutProjectPlan>();
				JSONArray jSONArray = JSONArray.parseArray(str);
				
				// 批量新增处理
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					culTotal++;
					String ktid = object.getString("ktid");
					String nd = object.getString("nd");
					String jfhj = object.getString("jfhj");

					OutProjectInfo opi = new OutProjectInfo();
					opi.setYsnd(nd);
					opi.setYsje(jfhj);
					opi.setXmid(ktid);
					insertData.add(opi);
					
					OutProjectPlan opp = new OutProjectPlan();
					opp.setYsnd(nd);
					opp.setYsje(jfhj);
					opp.setXmid(ktid);
					planData.add(opp);
				}
				if (insertData != null && insertData.size() > 0) {
					outProjectService.insertProjectItemData(insertData, String.valueOf(Integer.parseInt(ndCon)+2));
					
					// 修改当前年度的计划预算费用，没有的查询后插入
					outProjectPlanService.insertOutProjectPlanForYS(planData);
				}
				
				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时任务--定时获取项目管理系统的项目数据--保存到本地数据库-结束========="+culTotal);
				// 统一调用存储过程，把数据中部分属性集中处理
			}*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
