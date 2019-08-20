package com.pcitc.service.job;

import java.io.Serializable;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.out.OutProjectService;
/**
 * 合同合同信息同步
 * @author uuy
 *
 */
@Component
public class SyncProjectInfoJob implements Job, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4446117092725479823L;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException 
	{
		OutProjectService outProjectService = SpringContextUtil.getApplicationContext().getBean(OutProjectService.class);
	
		List<OutProjectInfo> infolist = outProjectService.selectAllProjectInfo();
		for(OutProjectInfo info:infolist) 
		{
			System.out.println(info.getNd());
		}
		
	}

}
