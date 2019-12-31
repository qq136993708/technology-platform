package com.pcitc.service.job;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.qims.QualityStatistics;
import com.pcitc.service.qims.QimsService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.pcitc.base.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

//质量系统获取数据
public class OutQualityDataJob implements Job, Serializable {
	private static final long serialVersionUID = 1L;

	@Value("${QIMS_URL}")
	private String QIMS_URL;

	@Value("${keyStr}")
	private String keyStr;

	@Autowired
	QimsService qimsService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("====质量系统获取数据======" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "-----");
		JSONObject jsonObject = new JSONObject(3);

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
		System.out.println(jsonObject.toJSONString());
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
