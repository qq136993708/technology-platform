package com.pcitc.service.job;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.pcitc.utils.QrtzUtils;
import com.pcitc.utils.RestfulHttpClient;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.system.SysJobService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;


@Component
//质量系统获取数据
public class OutQualityDataJob implements Job, Serializable {

	private static final long serialVersionUID = 1L;
	private static final String Quality = "http://localhost:8080/qims-api/qualityStatistics";
	public	SysJobService sysJobService = SpringContextUtil.getApplicationContext().getBean(SysJobService.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("====质量系统获取数据======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "-----");
		RestfulHttpClient.HttpResponse response = null;         //发起请求
		try {
			response = RestfulHttpClient.getClient(Quality)
					.get()              //设置post请求
					.request();
			//保存任务日志
			QrtzUtils.saveSysQrtzLog(context, sysJobService, "1", "com.pcitc.service.job.OutQualityDataJob", response.getContent());
			
		} catch (IOException e) {
			e.printStackTrace();
			//保存任务日志
			QrtzUtils.saveSysQrtzLog(context, sysJobService, "2", "com.pcitc.service.job.OutQualityDataJob", e.getMessage());
			
		}

		System.out.println(response.getCode());     //响应状态码
		System.out.println(response.getRequestUrl());//最终发起请求的地址
		if(response.getCode() == 200){
			//请求成功
			System.out.println(response.getContent());  //响应内容
		}
		/*JSONObject jsonObject = new JSONObject(3);

		String [] keyArray = keyStr.split(",");
		for(String str:keyArray){
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(QIMS_URL+str+"/kjpt",String.class);
			QualityStatistics qualityStatistics = new QualityStatistics();
			qualityStatistics.setId(UUID.randomUUID().toString().replace("-",""));
			qualityStatistics.setKey(str);
			qualityStatistics.setContent(responseEntity.getBody().toString());
			qualityStatistics.setDate(DateUtil.dateAdd(new Date(),-1));
			qualityStatistics.setSecretLevel("4");
			qimsService.save(qualityStatistics);
		}
		jsonObject.put("code","success");
		jsonObject.put("message","成功");
		jsonObject.put("data","");
		System.out.println(jsonObject.toJSONString());*/
	}

	public class WxMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
		public WxMappingJackson2HttpMessageConverter() {
			List mediaTypes = new ArrayList<>();
			mediaTypes.add(MediaType.TEXT_PLAIN);
			mediaTypes.add(MediaType.TEXT_HTML); //加入text/html类型的支持
			setSupportedMediaTypes(mediaTypes);// tag6
		}
	}
}
