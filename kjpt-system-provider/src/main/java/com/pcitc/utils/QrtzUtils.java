package com.pcitc.utils;

import java.util.Date;
import java.util.UUID;

import org.quartz.JobExecutionContext;
import org.quartz.JobKey;

import com.pcitc.base.system.SysQrtzLog;
import com.pcitc.service.system.SysJobService;

public class QrtzUtils {
	
	
	public static void saveSysQrtzLog(JobExecutionContext context,SysJobService sysJobService,String LogType,String jobClass,String content) {
		//保存任务日志
		JobKey key = context.getJobDetail().getKey();
		SysQrtzLog sysQrtzLog=new SysQrtzLog();
		sysQrtzLog.setCreateTime(new Date());
		sysQrtzLog.setJobName(key.getName());
		sysQrtzLog.setLogType(LogType);//1正常，2异常
		sysQrtzLog.setJobBiginTime(new Date());
		sysQrtzLog.setContent(content);
		sysQrtzLog.setTitle(key.getName());
		sysQrtzLog.setJobClass(jobClass);
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		sysQrtzLog.setId(id);
		try {
			sysJobService.insertSysCronExceptionLog(sysQrtzLog);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
