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
import com.google.gson.JsonObject;
import com.pcitc.base.stp.out.OutPatentWithBLOBs;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.out.OutPatentService;
import com.pcitc.utils.DataServiceUtil;

//专利系统
public class PatentJob implements Job, Serializable {
	private static final long serialVersionUID = 1L;

	public void execute(JobExecutionContext job) throws JobExecutionException {

		OutPatentService outPatentService = SpringContextUtil.getApplicationContext().getBean(OutPatentService.class);

		String sqlName = "SelectByDate";
		JsonObject jo = new JsonObject();
		String startDate = outPatentService.getMaxImportDate("国内专利");
		if (startDate == null || startDate.equals("")) {
			startDate = "2001-01-17";
		}

		Date temStartDate = DateUtil.strToDate(startDate, DateUtil.FMT_DD);
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(temStartDate);

		rightNow.add(Calendar.DAY_OF_YEAR, 1);// 日期加1天
		Date temDate1 = rightNow.getTime();

		String realStartDate = DateUtil.dateToStr(temDate1, DateUtil.FMT_DD);
		String realEndDate = DateUtil.dateToStr(new Date(), DateUtil.FMT_DD);
		jo.addProperty("ksrq", realStartDate);
		jo.addProperty("jzrq", realEndDate);
		System.out.println("==========开始导入---定时任务--专利项目接口---结束日期=============" + realEndDate);
		// 参数
		String conditions = jo.toString();
		String str = null;
		try {
			// 远程获取数据 -----
			str = DataServiceUtil.getDataService(DataServiceUtil.GET_URL, sqlName, conditions);
			if (str != null) {
				JSONArray jSONArray = JSONArray.parseArray(str);
				List<OutPatentWithBLOBs> insertData = new ArrayList<OutPatentWithBLOBs>();
				int temI = 0;
				boolean temB = true;
				for (int i = 0; i < jSONArray.size(); i++) {
					JSONObject object = (JSONObject) jSONArray.get(i);
					temI++;
					OutPatentWithBLOBs op = new OutPatentWithBLOBs();

					op.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
					op.setSqh(object.getString("SQH"));
					op.setSqri(object.getString("SQRI"));
					op.setFmmc(object.getString("FMMC"));
					op.setZhy(object.getString("ZHY"));
					op.setGkh(object.getString("GKH"));
					op.setGkr(object.getString("GKR"));
					op.setWxlx(object.getString("WXLX"));
					op.setShenqr(object.getString("SHENQR"));
					op.setFmr(object.getString("FMR"));
					op.setSqrdz(object.getString("SQRDZ"));
					op.setDlr(object.getString("DLR"));

					op.setDljg(object.getString("DLJG"));
					op.setGbdm(object.getString("GBDM"));
					op.setIpcflh(object.getString("IPCFLH"));
					op.setCpcflh(object.getString("CPCFLH"));
					op.setLjnflh(object.getString("LJNFLH"));
					op.setYxqh(object.getString("YXQH"));
					op.setYxqr(object.getString("YXQR"));
					op.setDqflzt(object.getString("DQFLZT"));
					op.setFlztlsxx(object.getString("FLZTLSXX"));
					op.setFlztggrq(object.getString("FLZTGGRQ"));
					op.setFlztyj(object.getString("FLZTYJ"));
					op.setFlztej(object.getString("FLZTEJ"));
					op.setShouqr(object.getString("SHOUQR"));

					op.setSqggh(object.getString("SQGGH"));
					op.setZsh(object.getString("ZSH"));
					op.setZlqr(object.getString("ZLQR"));
					op.setZlh(object.getString("ZLH"));
					op.setQlyq(object.getString("QLYQ"));
					op.setZlpdf(object.getString("ZLPDF"));
					op.setScyjtzsfwr(object.getString("SCYJTZSFWR"));
					op.setScyjdfr(object.getString("SCYJDFR"));
					op.setBztzffwr(object.getString("BZTZFFWR"));
					op.setBhtzsfwr(object.getString("BHTZSFWR"));
					op.setFsqqr(object.getString("FSQQR"));
					op.setFsslfwr(object.getString("FSSLFWR"));
					op.setDfgcwj(object.getString("DFGCWJ"));
					op.setSqbz(object.getString("SQBZ"));
					op.setRksj(object.getString("RKSJ"));

					op.setGmjjhyml(object.getString("GMJJHYML"));
					op.setGmjjhydl(object.getString("GMJJHYDL"));
					op.setGmjjhyzl(object.getString("GMJJHYZL"));
					op.setZxcyyj(object.getString("ZXCYYJ"));
					op.setZxcyej(object.getString("ZXCYEJ"));
					op.setZxcysj(object.getString("ZXCYSJ"));
					op.setByzcs(object.getString("BYZCS"));
					op.setBfmryycs(object.getString("BFMRYYCS"));
					op.setBscyyycs(object.getString("BSCYYYCS"));
					op.setZycs(object.getString("ZYCS"));
					op.setTycs(object.getString("TYCS"));
					op.setSqrdm(object.getString("SQRDM"));
					op.setJghdmc(object.getString("JGHDMC"));
					op.setJswthyyxg(object.getString("JSWTHYYXG"));
					op.setFmdhhxfa(object.getString("FMDHHXFA"));
					op.setYt(object.getString("YT"));

					op.setRemarks("国内专利");
					op.setCreateDate(new Date());

					insertData.add(op);
					if (temI > 1000) {
						temI = 0;
						outPatentService.insertPatentData(insertData);
						temB = false;
						insertData.clear();
					} else {
						temB = true;
					}
				}
				if (temB && insertData != null && insertData.size() > 0) {
					outPatentService.insertPatentData(insertData);
				}

				System.out.println("======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "专利项目--保存到本地数据库-结束=========");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
