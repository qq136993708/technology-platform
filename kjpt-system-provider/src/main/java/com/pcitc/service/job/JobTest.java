package com.pcitc.service.job;

import java.io.Serializable;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class JobTest implements Job, Serializable{
	private static final long serialVersionUID = 1L;
	
	
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println(">>>>>>>>>>>>>>测试定时任务>>>>>>>>>>>>");
	}
	
}
