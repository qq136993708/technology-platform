package com.pcitc.service.job;

import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.system.IndexOutProjectInfoService;
import com.pcitc.web.feign.ZjkBaseInfoServiceClient;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.Serializable;

public class ExpertCountJob implements Job, Serializable {
	private static final long serialVersionUID = 1L;

	public void execute(JobExecutionContext job) throws JobExecutionException {

        ZjkBaseInfoServiceClient bean = SpringContextUtil.getApplicationContext().getBean(ZjkBaseInfoServiceClient.class);
		try {
            System.out.println("专家统计定时任务启动");
            bean.selectZjkBaseInfoByPageCountJob();
            System.out.println("专家统计定时任务结束");
        } catch (Exception e) {
            System.out.println("专家统计定时任务异常");
            e.printStackTrace();
		}
	}
}
