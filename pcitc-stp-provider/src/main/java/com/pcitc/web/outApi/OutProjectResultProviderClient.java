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
import com.pcitc.base.stp.out.OutProjectResult;
import com.pcitc.service.outApi.OutProjectResultService;

@Api(value = "对外提供的项目检查结果接收接口", tags = { "项目检查结果接收" })
@RestController
public class OutProjectResultProviderClient {
	private final static Logger logger = LoggerFactory.getLogger(OutProjectResultProviderClient.class);

	@Autowired
	private OutProjectResultService outProjectResultService;

	@ApiOperation(value = "保存项目检查结果", notes = "保存项目检查结果")
	@RequestMapping(value = "/project-api/result/add", method = RequestMethod.POST)
	public JSONObject saveOutProjectResult(@RequestBody String jsonStr) throws Exception {
		System.out.println("1saveOutProjectResult==================" + jsonStr);
		JSONObject json = JSONObject.parseObject(jsonStr);
		JSONArray jsonArray = json.getJSONArray("itemList");
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject temJson = jsonArray.getJSONObject(i);
			OutProjectResult opri = JSON.toJavaObject(temJson, OutProjectResult.class);
			outProjectResultService.saveOutProjectResult(opri);
		}
		JSONObject result = new JSONObject();
		result.put("resCode", "0");
		result.put("resMsg", "success");
		result.put("total", "1");
		result.put("result", "");
		return result;
	}

}
