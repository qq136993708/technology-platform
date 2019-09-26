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
import org.quartz.JobKey;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.expenses.ExpensesPayHana;
import com.pcitc.base.system.SysCronExceptionLog;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.feign.hana.OutProjectRemoteClient;
import com.pcitc.service.feign.stp.ExpensesRemoteClient;
import com.pcitc.service.system.SysJobService;

/**
 * @author zhf 定时获取hana中报销费用挂账清账信息
 */
@Component
public class HanaExpensesPayJob implements Job, Serializable {

	private static final long serialVersionUID = 1L;
	

	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		
		SysJobService sysJobService = SpringContextUtil.getApplicationContext().getBean(SysJobService.class);
		Date jobBiginTime=new Date();
		
		
		OutProjectRemoteClient outProjectRemoteClient = SpringContextUtil.getApplicationContext().getBean(OutProjectRemoteClient.class);
		System.out.println("定时开始调用feign获取hana数据---------------"+outProjectRemoteClient);
		
		ExpensesRemoteClient expensesRemoteClient = SpringContextUtil.getApplicationContext().getBean(ExpensesRemoteClient.class);
		HashMap<String, String> map = new HashMap<String, String>();
		
		List<ExpensesPayHana> insertData = new ArrayList<ExpensesPayHana>();
		
		Calendar date = Calendar.getInstance();
		String ysYear = String.valueOf(date.get(Calendar.YEAR));
		map.put("nd", ysYear);
		
		try {
			JSONArray resultList = outProjectRemoteClient.getExpensesPayInfo(map);
			if (resultList != null && resultList.size() > 0) 
			{
				System.out.println(">>>>>>>>>>>>>>>>获取hana成本并落地（拨款）: "+resultList.size()+" 条");
				expensesRemoteClient.saveExpensesPayHana(resultList.toJSONString());
				
				/*for (int i = 0; i < resultList.size(); i++) {
					JSONObject json = resultList.getJSONObject(i);
					
					ExpensesPayHana opi = new ExpensesPayHana();
					
					String G0LOGSYS = json.getString("0LOGSYS");
					String G0GSDM = json.getString("G0GSDM");
					String G0GSJC = json.getString("G0GSJC");
					String G0ZPZID = json.getString("G0ZPZID");
					String G0ZECSID = json.getString("G0ZECSID");
					String G0BUDAT = json.getString("G0BUDAT");
					String G0ZTMSVOUCHERID = json.getString("G0ZTMSVOUCHERID");
					String G0BELNR = json.getString("G0BELNR");
					String G0GJAHR = json.getString("G0GJAHR");
					String G0AUGBL = json.getString("G0AUGBL");
					String G0AUGDT = json.getString("G0AUGDT");
					String G0LIFNR = json.getString("G0LIFNR");
					String dataId = UUID.randomUUID().toString().replaceAll("-", "");
					System.out.println("=========研究院-----------------"+G0GSJC);
					
					opi.setDataId(dataId);
					opi.setCreateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
					
					insertData.add(opi);
					
				}*/
				
				
			}
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>获取hana成本并落地（拨款）  调用异常>>>>>>>>>>>>>>>>");
			
			JobKey key = jobExecutionContext.getJobDetail().getKey();
			SysCronExceptionLog record=new SysCronExceptionLog();
			record.setCreateTime(new Date());
			record.setJobBiginTime(jobBiginTime);
			record.setJobName(key.getName());
			record.setJobClass("com.pcitc.service.job.HanaExpensesPayJob");
			record.setContent(e.getMessage());
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			record.setId(id);
			try 
			{
				sysJobService.insertSysCronExceptionLog(record);
			} catch (Exception e1) 
			{
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		
		
	}

}
