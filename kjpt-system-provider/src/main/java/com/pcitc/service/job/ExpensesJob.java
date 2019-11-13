package com.pcitc.service.job;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.pcitc.base.system.SysCronExceptionLog;
import com.pcitc.base.util.DateSegment;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.MD5Util;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.feign.stp.ExpenseJobClient;
import com.pcitc.service.system.SysJobService;
import com.pcitc.utils.RestfulHttpClient;

/**
 * @author zhf 定时获取报销数据，并保存到本地数据
 */
@Component
public class ExpensesJob implements Job, Serializable {

	private static final long	serialVersionUID	= 1L;
	
	
	private String processGetData(String realStartDate,String realEndDate) throws IOException 
	{
		System.out.println(">>>>>>>>>>>>>>获取报销数据开始调用远程接口>>>>>>>>>>>>>");
		// 调用报销系统数据
		String url = "http://10.248.36.236/ers/bull/unify/request";
		// 创建一个请求客户端
		RestfulHttpClient.HttpClient client = RestfulHttpClient.getClient(url);
		client.post();
		
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		// 设置全局默认请求头，每次请求都会带上这些请求头
		RestfulHttpClient.setDefaultHeaders(headerMap);
		// 添加多个参数请求头
		client.addHeaders(headerMap);
		JsonObject jo = new JsonObject();
		
		jo.addProperty("executeKey", "sysnPubPaymentBillInfo");
		jo.addProperty("reqMsg", "{'compCode':'1010','begDate':'"+realStartDate+"','endDate':'"+realEndDate+"'}");
		Date nowDate = new Date();
		String reqTime = DateUtil.dateToStr(nowDate, DateUtil.FMT_SS);
		jo.addProperty("reqTime", reqTime);
		String signMd5 = MD5Util.MD5Encode("sysnPubPaymentBillInfo"+reqTime+"pubBill");
		jo.addProperty("sign", signMd5);
		
		System.out.println(">>>>请求体参数>>>>>>>>"+jo.toString());
		// 添加请求体
		client.body(jo.toString());
		RestfulHttpClient.HttpResponse response = client.request();
		
		// 根据状态码判断请求是否成功
		if (response.getCode()==200) {
			// 获取响应内容
			return response.getContent();
		}
		return null;
	}
	
	
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		
		SysJobService sysJobService = SpringContextUtil.getApplicationContext().getBean(SysJobService.class);
		Date jobBiginTime=new Date();
		try {
			ExpenseJobClient expenseJobClient = SpringContextUtil.getApplicationContext().getBean(ExpenseJobClient.class);
			String str=expenseJobClient.selectMaxUpdate();
			
			// 查询最大值，+一个月作为本次的查询条件
			String startDateStr = (str == null?"20180201":str);
			//获取最新日期的下一天
			Date startDate =DateUtil.getTomorrowDay(DateUtil.strToDate(startDateStr, DateUtil.FMT_YYYY_DD));
			//获取当前日期的前一天
			Date endDate = DateUtil.getYesterDay(DateUtil.strToDate(DateUtil.format(new Date(), DateUtil.FMT_YYYY_DD), DateUtil.FMT_YYYY_DD));
			
			List<DateSegment> dtlist = DateUtil.getMonthList(startDate, endDate);
			for(DateSegment s:dtlist) 
			{
				Date start = (s.getStartDate().getTime()<=startDate.getTime()?startDate:s.getStartDate());
				Date end = (s.getEndDate().getTime()>=endDate.getTime()?endDate:s.getEndDate());
				
				String realStartDate = DateUtil.format(start, DateUtil.FMT_YYYY_DD);
				String realEndDate = DateUtil.format(end, DateUtil.FMT_YYYY_DD);
				
				String result = processGetData(realStartDate,realEndDate);
				expenseJobClient.saveExpenses(result);
			}
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>获取报销数据 调用异常>>>>>>>>>>>>>>");
			JobKey key = jobExecutionContext.getJobDetail().getKey();
			SysCronExceptionLog record=new SysCronExceptionLog();
			record.setCreateTime(new Date());
			record.setJobBiginTime(jobBiginTime);
			record.setJobName(key.getName());
			record.setJobClass("com.pcitc.service.job.ExpensesJob");
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
