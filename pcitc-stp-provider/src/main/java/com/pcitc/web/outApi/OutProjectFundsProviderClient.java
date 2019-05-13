package com.pcitc.web.outApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

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
import com.pcitc.base.stp.out.OutProjectFunds;
import com.pcitc.base.stp.out.OutProjectFundsItem;
import com.pcitc.service.outApi.OutProjectFundsService;

@Api(value = "对外提供的项目经费接收接口", tags = { "项目经费接收" })
@RestController
public class OutProjectFundsProviderClient {
	private final static Logger logger = LoggerFactory.getLogger(OutProjectFundsProviderClient.class);

	@Autowired
	private OutProjectFundsService outProjectFundsService;

	@ApiOperation(value = "保存项目经费", notes = "保存项目经费")
	@RequestMapping(value = "/project-api/funds/add", method = RequestMethod.POST)
	public JSONObject saveOutProjectFunds(@RequestBody String jsonStr) throws Exception {
		System.out.println("1saveOutProjectFunds==================" + jsonStr);
		//flowProjectInfoService.batchInsertFlowProjectInfo(flowProjectInfo);
		JSONObject json = JSONObject.parseObject(jsonStr);
		JSONArray jsonArray = json.getJSONArray("itemList");
		List<OutProjectFundsItem> itemList = new ArrayList<OutProjectFundsItem>();
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject temJson = jsonArray.getJSONObject(i);
			OutProjectFundsItem opri = JSON.toJavaObject(temJson,OutProjectFundsItem.class);
			itemList.add(opri);
		}
		// 转换出点bug，先删除再添加
		json.remove("itemList");
		
		OutProjectFunds outProjectFunds = JSON.toJavaObject(json,OutProjectFunds.class);
		outProjectFunds.setItemList(itemList);
		outProjectFundsService.saveOutProjectFunds(outProjectFunds);
		
		JSONObject result = new JSONObject();
		result.put("resCode", "0");
		result.put("resMsg", "success");
		result.put("total", "1");
		result.put("result", "");
		return result;

	}

}
