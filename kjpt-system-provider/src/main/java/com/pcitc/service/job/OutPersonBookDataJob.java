package com.pcitc.service.job;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.system.SysJobService;
import com.pcitc.utils.QrtzUtils;
import com.pcitc.utils.RestfulHttpClient;

//人才论著
public class OutPersonBookDataJob implements Job, Serializable {
	private static final long serialVersionUID = 1L;
	private static final String Quality = "http://localhost/getHanaOutPersonBookList";
	public	SysJobService sysJobService = SpringContextUtil.getApplicationContext().getBean(SysJobService.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("====人才论著======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "-----");
        RestfulHttpClient.HttpResponse response = null;        
		
		try {
			response = RestfulHttpClient.getClient(Quality)
					.get()              //设置post请求
					.request();
			//保存任务日志
			QrtzUtils.saveSysQrtzLog(context, sysJobService, "1", "com.pcitc.service.job.OutPersonBookDataJob", response.getContent());
			
		} catch (IOException e) {
			e.printStackTrace();
			//保存任务日志
			QrtzUtils.saveSysQrtzLog(context, sysJobService, "2", "com.pcitc.service.job.OutPersonBookDataJob", e.getMessage());
			
		}

		System.out.println(">>>>>>>>最终发起请求的地址: "+response.getRequestUrl());//最终发起请求的地址
		if(response.getCode() == 200){
			//请求成功
			System.out.println(">>>>>>>>>>响应内容:"+response.getContent());     //响应内容
		}
	}

}
