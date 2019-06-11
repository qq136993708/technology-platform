package com.pcitc.service.job;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.flow.FlowProjectInfo;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.feign.stp.FlowProjectRemoteClient;
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
		//List<OutProjectInfo> temList = outProjectService.getProjectList(null);
		int culTotal = 0;
		System.out.println("==========" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时获取项目管理系统的项目数据 ---开始=============");
		String sqlName = "SelectAllProjectFromSinopecData2017";
		
		Calendar date = Calendar.getInstance();
		String ndCon = String.valueOf(date.get(Calendar.YEAR));
		ndCon = "2018";
		String str = null;
		try {
			// 远程获取数据 -----
			str = DataServiceUtil.getProjectData(sqlName, ndCon);
			System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时获取项目管理系统的项目数据 返回 success====="+(str != null));
			if (str != null) {
				// 先删除年度为nd的本地数据（备份一份到临时表中，防止意外）
				List<OutProjectInfo> insertData = new ArrayList<OutProjectInfo>();
				JSONArray jSONArray = JSONArray.parseArray(str);
				
				// 批量新增处理
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					culTotal++;
					
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
					
					String lxrxm = object.getString("LXR_Xm");
					String lxryx = object.getString("LXR_Email");
					String lxrdh = object.getString("LXR_Tel");
					
					String jssxxm = object.getString("JSSXXM");

					String yjsj = object.getString("YJSJ");
					String zyly = object.getString("ZYLY");
					String zysx = object.getString("ZYSX");
					String sjid = object.getString("SJID");
					//String lxbj = object.getString("LXBJ");
					//String yjnr = object.getString("YJNR");
					//String jdap = object.getString("JDAP");
					//String yjmb = object.getString("YJMB");
					
					String gsbmbm = object.getString("GSBMBM");
					String gsbmmc = object.getString("GSBMMC");
					String zycbm = object.getString("ZYCBM");
					String zycmc = object.getString("ZYCMC");
					String xmlbbm = object.getString("XMLBBM");
					String xmlbmc = object.getString("XMLBMC");
					
					String projectId = object.getString("XMID");

					OutProjectInfo opi = new OutProjectInfo();
					
					opi.setNd(nd);
					opi.setYsnd(nd); //预算年度初始值和起始年度一致
					opi.setXmid(xmid);
					opi.setHth(hth);
					opi.setXmmc(xmmc);
					opi.setXmjb(xmjb);
					opi.setJf(jf);
					opi.setFwdxbm(fwdxbm);
					if (fwdxbm.equals("JT")) {
						opi.setFwdx("集团");
					} else if (fwdxbm.equals("GF")) {
						opi.setFwdx("股份");
					} else if (fwdxbm.equals("ZC")) {
						opi.setFwdx("资产");
					}  
					
					opi.setZylbbm(zylbbm);

					opi.setZylb(zylb);
					opi.setFzdwbm(fzdwbm);
					opi.setFzdw(fzdw);
					
					opi.setJtfzdwbm(jtfzdwbm);
					opi.setJtfzdw(jtfzdw);
					opi.setFzrxm(fzrxm);
					opi.setLxrdh(lxrdh);
					opi.setLxryx(lxryx);
					opi.setLxrxm(lxrxm);
					opi.setJssxxm(jssxxm);
					
					yjsj = yjsj.replaceAll(" ", "");
					String[] temDateFlag = yjsj.split("/");
					opi.setYjsj(yjsj);
					opi.setKssj(temDateFlag[0].length() == 7 ? temDateFlag[0] : temDateFlag[0].split("-")[0] + "-0" + temDateFlag[0].split("-")[1]);
					opi.setJssj(temDateFlag[1].length() == 7 ? temDateFlag[1] : temDateFlag[1].split("-")[0] + "-0" + temDateFlag[1].split("-")[1]);
					
					opi.setZyly(zyly);
					opi.setZysx(zysx);
					opi.setSjid(sjid);
					//opi.setLxbj(lxbj);
					//opi.setYjnr(yjnr);
					//opi.setJdap(jdap);
					//opi.setYjmb(yjmb);
					
					opi.setGsbmbm(gsbmbm);
					opi.setGsbmmc(gsbmmc);
					opi.setZycbm(zycbm);
					opi.setZycmc(zycmc);
					
					if (hth != null) {
						if (hth.indexOf("P") == 0 || hth.indexOf("JP") == 0 || hth.indexOf("LP") == 0) {
							opi.setDefine10("101油田处");
						} else if (hth.indexOf("P") == 0 || hth.indexOf("J1") == 0 || hth.indexOf("L1") == 0) {
							opi.setDefine10("102炼油处");
						} else if (hth.indexOf("4") == 0 || hth.indexOf("J4") == 0 || hth.indexOf("L4") == 0) {
							opi.setDefine10("103化工处");
						} else if (hth.indexOf("2") == 0 || hth.indexOf("J2") == 0 || hth.indexOf("L2") == 0) {
							opi.setDefine10("104材料处");
						} else if (hth.indexOf("3") == 0 || hth.indexOf("J3") == 0 || hth.indexOf("L3") == 0) {
							opi.setDefine10("105装储处");
						} else if (hth.indexOf("R") == 0 || hth.indexOf("X") == 0 || hth.indexOf("KL") == 0 || hth.indexOf("JR") == 0 || hth.indexOf("LR") == 0 || hth.indexOf("JX") == 0 || hth.indexOf("LX") == 0 || hth.indexOf("J5") == 0 || hth.indexOf("L5") == 0 || hth.indexOf("JKL") == 0 || hth.indexOf("LKL") == 0) {
							opi.setDefine10("106计划处");
						} else if (hth.indexOf("G") == 0 || hth.indexOf("JG") == 0 || hth.indexOf("LG") == 0) {
							opi.setDefine10("107技术监督处");
						} else if (hth.indexOf("H") == 0 || hth.indexOf("JH") == 0 || hth.indexOf("LH") == 0) {
							opi.setDefine10("108三剂处");
						} else if (hth.indexOf("9") == 0 || hth.indexOf("J9") == 0 || hth.indexOf("L9") == 0) {
							opi.setDefine10("109知识产权处");
						} else if (hth.indexOf("W") == 0 || hth.indexOf("JW") == 0 || hth.indexOf("LW") == 0) {
							opi.setDefine10("110物装部");
						} else if (hth.indexOf("CLY") == 0 || hth.indexOf("JCLY") == 0 || hth.indexOf("LCLY") == 0) {
							opi.setDefine10("114炼油部（B2、C类）");
						} else if (hth.indexOf("CHG") == 0 || hth.indexOf("JCHG") == 0 || hth.indexOf("LCHG") == 0) {
							opi.setDefine10("115化工部（B2、C类）");
						} else if (hth.indexOf("E") == 0 || hth.indexOf("JE") == 0 || hth.indexOf("LE") == 0) {
							opi.setDefine10("111信息部");
						} else if (hth.indexOf("Z") == 0 || hth.indexOf("JZ") == 0 || hth.indexOf("LZ") == 0) {
							opi.setDefine10("112工程部");
						} 
					}
					opi.setXmlbbm(xmlbbm);
					opi.setXmlbmc(xmlbmc);
					if (sjid != null && Integer.parseInt(sjid) > 0) {
						opi.setParentProjectId(sjid);
						opi.setProjectType("2");
					}
					if (sjid != null && Integer.parseInt(sjid) == 0) {
						opi.setProjectType("1");
					}
					if (sjid != null && Integer.parseInt(sjid) < 0) {
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
					System.out.println("======----------------" + xmid);
					//opi.setProjectScope("新开课题");  //新开
					opi.setProjectId(projectId);
					
					opi.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
					opi.setStatus("1");
					opi.setCreateDate(new Date());
					opi.setCreatePerson("admin");
					opi.setDefine3("项目管理系统");
					insertData.add(opi);
					
				}
				if (insertData != null && insertData.size() > 0) {
					outProjectService.insertProjectData(insertData, ndCon);
				}
				
				
				
				
				
				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "定时任务--定时获取项目管理系统的项目数据--保存到本地数据库-结束========="+culTotal);
				// 统一调用存储过程，把数据中部分属性集中处理
			}
			FlowProjectRemoteClient flowProjectRemoteClient = SpringContextUtil.getApplicationContext().getBean(FlowProjectRemoteClient.class);
			System.out.println("定时开始调用feign获取stp数据---------------"+flowProjectRemoteClient);
			FlowProjectInfo flowProjectInfo = new FlowProjectInfo();
			flowProjectInfo.setDataId("123");
			Date date1 = new Date();
			flowProjectRemoteClient.insertFlowProjectInfo(flowProjectInfo);
			Date date2 = new Date();
			System.out.println("========feign========调用时间*************====="+(date2.getTime()-date1.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
