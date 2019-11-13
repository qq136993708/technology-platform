package com.pcitc.service.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.pcitc.base.stp.out.OutReward;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.out.OutProjectService;
import com.pcitc.service.out.OutRewardService;
import com.pcitc.utils.DataServiceUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TfcJob implements Job, Serializable {
	private static final long serialVersionUID = 1L;

	public void execute(JobExecutionContext job) throws JobExecutionException {

        OutProjectService outProjectService = SpringContextUtil.getApplicationContext().getBean(OutProjectService.class);
		try {
            System.out.println("------------------");
            outProjectService.saveProjectToES();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
