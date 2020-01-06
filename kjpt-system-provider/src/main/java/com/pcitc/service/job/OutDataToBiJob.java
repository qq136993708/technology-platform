package com.pcitc.service.job;

import com.pcitc.base.util.DateUtil;
import com.pcitc.utils.RestfulHttpClient;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
//质量系统获取数据
public class OutDataToBiJob implements Job, Serializable {

	private static final long serialVersionUID = 1L;
	private static final String DATATOBI = "http://localhost:8080/cockpit/bi-api/dataToBi";

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

		System.out.println(response.getCode());     //响应状态码
		System.out.println(response.getRequestUrl());//最终发起请求的地址
		if(response.getCode() == 200){
			//请求成功
			System.out.println(response.getContent());  //响应内容
		}
	}

}
