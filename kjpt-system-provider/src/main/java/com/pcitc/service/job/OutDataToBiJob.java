package com.pcitc.service.job;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;

import com.pcitc.base.system.SysQrtzLog;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.system.SysJobService;
import com.pcitc.utils.QrtzUtils;
import com.pcitc.utils.RestfulHttpClient;

//领导驾驶舱数据同步
public class OutDataToBiJob implements Job, Serializable {

	private static final long serialVersionUID = 1L;
	private static final String DATATOBI = "http://localhost/cockpit/bi-api/dataToBi";
	public	SysJobService sysJobService = SpringContextUtil.getApplicationContext().getBean(SysJobService.class);
	

	@Override
	public void execute(JobExecutionContext context) {
		System.out.println("====领导驾驶舱数据同步======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "-----");
		RestfulHttpClient.HttpResponse response = null;         //发起请求
		try {
			response = RestfulHttpClient.getClient(DATATOBI)
					.get()              //设置post请求
					.request();
			//保存任务日志
			QrtzUtils.saveSysQrtzLog(context, sysJobService, "1", "com.pcitc.service.job.OutDataToBiJob", "");
		} catch (IOException e) {
			
			e.printStackTrace();
			//保存任务日志
			QrtzUtils.saveSysQrtzLog(context, sysJobService, "2", "com.pcitc.service.job.OutDataToBiJob", e.getMessage());
			
		}
		//System.out.println(response.getCode());     //响应状态码
		//System.out.println(response.getRequestUrl());//最终发起请求的地址
		if(response.getCode() == 200){
			//请求成功
			System.out.println("响应内容:"+response.getContent());  //响应内容
		}
	}

}
