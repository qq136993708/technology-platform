package com.pcitc.web.outApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
import com.pcitc.base.stp.out.OutProjectCheck;
import com.pcitc.base.stp.out.OutProjectCheckItem;
import com.pcitc.service.outApi.OutProjectCheckService;

@Api(value = "对外提供的项目需求接收接口", tags = { "项目需求接收" })
@RestController
public class OutProjectCheckProviderClient {
	private final static Logger logger = LoggerFactory.getLogger(OutProjectCheckProviderClient.class);

	@Autowired
	private OutProjectCheckService outProjectCheckService;

	@ApiOperation(value = "保存项目需求", notes = "保存项目需求")
	@RequestMapping(value = "/project-api/check/add", method = RequestMethod.POST)
	public JSONObject saveOutProjectCheck(@RequestBody String jsonStr) throws Exception {
		System.out.println("1saveOutProjectCheck==================" + jsonStr);
		//flowProjectInfoService.batchInsertFlowProjectInfo(flowProjectInfo);
		JSONObject json = JSONObject.parseObject(jsonStr);
		JSONArray jsonArray = json.getJSONArray("itemList");
		List<OutProjectCheckItem> itemList = new ArrayList<OutProjectCheckItem>();
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject temJson = jsonArray.getJSONObject(i);
			OutProjectCheckItem opri = JSON.toJavaObject(temJson,OutProjectCheckItem.class);
			itemList.add(opri);
		}
		// 转换出点bug，先删除再添加
		json.remove("itemList");
		
		OutProjectCheck outProjectCheck = JSON.toJavaObject(json,OutProjectCheck.class);
		outProjectCheck.setItemList(itemList);
		outProjectCheckService.saveOutProjectCheck(outProjectCheck);
		
		JSONObject result = new JSONObject();
		result.put("resCode", "0");
		result.put("resMsg", "success");
		result.put("total", "1");
		result.put("result", "");
		return result;

	}

}
