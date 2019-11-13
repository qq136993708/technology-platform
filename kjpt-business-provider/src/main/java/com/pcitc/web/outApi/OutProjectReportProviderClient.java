package com.pcitc.web.outApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.out.OutProjectReport;
import com.pcitc.service.outApi.OutProjectReportService;

@Api(value = "对外提供的项目报告接收接口", tags = { "项目报告接收" })
@RestController
public class OutProjectReportProviderClient {
	private final static Logger logger = LoggerFactory.getLogger(OutProjectReportProviderClient.class);

	@Autowired
	private OutProjectReportService outProjectReportService;

	@ApiOperation(value = "保存项目报告", notes = "保存项目报告")
	@RequestMapping(value = "/project-api/report/add", method = RequestMethod.POST)
	public JSONObject saveOutProjectReport(@RequestBody String jsonStr) throws Exception {
		System.out.println("1saveOutProjectReport==================" + jsonStr);
		JSONObject json = JSONObject.parseObject(jsonStr);
		JSONArray jsonArray = json.getJSONArray("itemList");
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject temJson = jsonArray.getJSONObject(i);
			OutProjectReport opri = JSON.toJavaObject(temJson, OutProjectReport.class);
			outProjectReportService.saveOutProjectReport(opri);
		}
		JSONObject result = new JSONObject();
		result.put("resCode", "0");
		result.put("resMsg", "success");
		result.put("total", "1");
		result.put("result", "");
		return result;
	}

}
