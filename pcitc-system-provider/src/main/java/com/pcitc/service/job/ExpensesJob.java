package com.pcitc.service.job;

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
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		
		SysJobService sysJobService = SpringContextUtil.getApplicationContext().getBean(SysJobService.class);
		Date jobBiginTime=new Date();
		try {
			
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
			
			ExpenseJobClient expenseJobClient = SpringContextUtil.getApplicationContext().getBean(ExpenseJobClient.class);
			String str=expenseJobClient.selectMaxUpdate();
			
			// 查询最大值，+一个月作为本次的查询条件
			String startDate = (str == null?"20180201":str);
			Date temStartDate = DateUtil.strToDate(startDate, DateUtil.FMT_YYYY_DD);
			
			Date monthDay = DateUtil.getNextMonth(temStartDate);
			
			List<DateSegment> ds = DateUtil.getMonthList(monthDay, monthDay);
			String realStartDate = DateUtil.format(ds.get(0).getStartDate(), DateUtil.FMT_YYYY_DD);
			String realEndDate = DateUtil.format(ds.get(0).getEndDate(), DateUtil.FMT_YYYY_DD);
			
			/*Calendar rightNow1 = Calendar.getInstance();
			rightNow1.setTime(temStartDate);
			rightNow1.add(Calendar.DAY_OF_YEAR, 1);// 日期加1天
			Date temDate1 = rightNow1.getTime();

			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(temDate1);
			rightNow.add(Calendar.MONTH, 1);
			rightNow.add(Calendar.DAY_OF_YEAR, -1);// 日期加1天
			Date temDate = rightNow.getTime();
			String realStartDate = DateUtil.dateToStr(temDate1, DateUtil.FMT_YYYY_DD);
			String realEndDate = DateUtil.dateToStr(temDate, DateUtil.FMT_YYYY_DD);*/
			

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
			RestfulHttpClient.HttpResponse response;
			response = client.request();
			// 根据状态码判断请求是否成功
			if (response.getCode()==200) {
				// 获取响应内容
				String result = response.getContent();
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
