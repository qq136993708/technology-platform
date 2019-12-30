package com.pcitc.service.job;

import java.io.Serializable;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.pcitc.base.util.DateUtil;

//项目数据
public class OutProjectDataJob implements Job, Serializable {
	private static final long serialVersionUID = 1L;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("====质量系统获取数据======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "-----");

	}

}
