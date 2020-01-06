package com.pcitc.service.job;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import com.pcitc.base.system.SysQrtzLog;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.system.SysJobService;
import com.pcitc.utils.RestfulHttpClient;

//质量系统获取数据
@Service
public class OutDataToBiJob implements Job, Serializable {

	private static final long serialVersionUID = 1L;
	private static final String DATATOBI = "http://localhost:8080/cockpit/bi-api/dataToBi";
	
	public	SysJobService sysJobService = SpringContextUtil.getApplicationContext().getBean(SysJobService.class);
	

	@Override
	public void execute(JobExecutionContext context) {
		System.out.println("====质量系统获取数据======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "-----");
		RestfulHttpClient.HttpResponse response = null;         //发起请求
		try {
			response = RestfulHttpClient.getClient(DATATOBI)
					.get()              //设置post请求
					.request();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		SysQrtzLog sysQrtzLog=new SysQrtzLog();
		sysQrtzLog.setCreateTime(new Date());
		sysQrtzLog.setJobBiginTime(new Date());
		sysQrtzLog.setTitle("质量系统获取数据");
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		sysQrtzLog.setId(id);
		try {
			sysJobService.insertSysCronExceptionLog(sysQrtzLog);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(response.getCode());     //响应状态码
		System.out.println(response.getRequestUrl());//最终发起请求的地址
		if(response.getCode() == 200){
			//请求成功
			System.out.println(response.getContent());  //响应内容
		}
	}

}
