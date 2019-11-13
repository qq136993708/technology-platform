package com.pcitc.service.job;

import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.system.IndexOutProjectInfoService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.Serializable;

public class TfcIndexProjectInfoJob implements Job, Serializable {
	private static final long serialVersionUID = 1L;

	public void execute(JobExecutionContext job) throws JobExecutionException {

        IndexOutProjectInfoService bean = SpringContextUtil.getApplicationContext().getBean(IndexOutProjectInfoService.class);
		try {
            System.out.println("------------------");
            bean.selectTfcToIndexProjectInfo();
//            bean.selectAppraisalToIndexProjectInfo();
//            bean.selectPatentToIndexProjectInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
