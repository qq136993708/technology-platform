package com.pcitc.service.job;

import java.io.Serializable;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pcitc.service.feign.hana.OutProjectRemoteClient;

/**
 * @author zhf 定时获取项目管理系统的项目数据，并保存到本地数据
 */
@Component
public class HanaProjectJob implements Job, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private static OutProjectRemoteClient outProjectRemoteClient;

	public void execute(JobExecutionContext job) throws JobExecutionException {
		System.out.println("定时开始调用feign获取hana数据---------------"+outProjectRemoteClient);
		outProjectRemoteClient.getLastCountryProject(null);
		
		System.out.println("定时结束调用feign获取hana数据---------------");
	}

}
