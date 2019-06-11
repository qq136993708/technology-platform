package com.pcitc.service.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class JobTest implements Job{
	 /**
     * 
    * @Title: execute 
    * @Description: 数据同步方法
    * @return List<DBEntity>    返回类型 
    * @throws
     */
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("job start======");
	}
	
	public static void main(String[] args) {


	}
}
