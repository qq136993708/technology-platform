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
import com.pcitc.base.stp.out.OutProjectContract;
import com.pcitc.base.stp.out.OutProjectContractItem;
import com.pcitc.service.outApi.OutProjectContractService;

@Api(value = "对外提供的项目合同接收接口", tags = { "项目合同接收" })
@RestController
public class OutProjectContractProviderClient {
	private final static Logger logger = LoggerFactory.getLogger(OutProjectContractProviderClient.class);

	@Autowired
	private OutProjectContractService outProjectContractService;

	@ApiOperation(value = "保存项目合同", notes = "保存项目合同")
	@RequestMapping(value = "/project-api/contract/add", method = RequestMethod.POST)
	public JSONObject saveOutProjectContract(@RequestBody String jsonStr) throws Exception {
		System.out.println("1saveOutProjectContract==================" + jsonStr);
		//flowProjectInfoService.batchInsertFlowProjectInfo(flowProjectInfo);
		JSONObject json = JSONObject.parseObject(jsonStr);
		JSONArray jsonArray = json.getJSONArray("itemList");
		List<OutProjectContractItem> itemList = new ArrayList<OutProjectContractItem>();
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject temJson = jsonArray.getJSONObject(i);
			OutProjectContractItem opri = JSON.toJavaObject(temJson,OutProjectContractItem.class);
			itemList.add(opri);
		}
		// 转换出点bug，先删除再添加
		json.remove("itemList");
		
		OutProjectContract outProjectContract = JSON.toJavaObject(json,OutProjectContract.class);
		outProjectContract.setItemList(itemList);
		outProjectContractService.saveOutProjectContract(outProjectContract);
		
		JSONObject result = new JSONObject();
		result.put("resCode", "0");
		result.put("resMsg", "success");
		result.put("total", "1");
		result.put("result", "");
		return result;

	}

}
