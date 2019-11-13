package com.pcitc.web.out.api;

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
import com.pcitc.base.stp.out.OutReward;
import com.pcitc.service.out.OutRewardService;

@Api(value = "对外提供的奖励信息接收接口", tags = { "奖励信息接收" })
@RestController
public class RewardAPIClient {
	private final static Logger logger = LoggerFactory.getLogger(RewardAPIClient.class);

	@Autowired
	private OutRewardService outRewardService;

	@ApiOperation(value = "保存奖励信息", notes = "数据表不分行项目，就一张表")
	@RequestMapping(value = "/reward-api/info/add", method = RequestMethod.POST)
	public JSONObject saveOutReward(@RequestBody String jsonStr) throws Exception {
		System.out.println("saveOutReward==================" + jsonStr);
		JSONObject json = JSONObject.parseObject(jsonStr);
		JSONArray jsonArray = json.getJSONArray("itemList");
		List<OutReward> itemList = new ArrayList<OutReward>();
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject temJson = jsonArray.getJSONObject(i);
			OutReward op = JSON.toJavaObject(temJson,OutReward.class);
			op.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
			itemList.add(op);
		}
		outRewardService.insertRewardData(itemList);
		JSONObject result = new JSONObject();
		result.put("resCode", "0");
		result.put("resMsg", "success");
		result.put("total", "1");
		result.put("result", "");
		return result;

	}

}
