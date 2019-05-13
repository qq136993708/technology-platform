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
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.service.out.OutProjectService;

@Api(value = "对外提供的项目信息接收接口", tags = { "项目信息接收" })
@RestController
public class ProjectInfoAPIClient {
	private final static Logger logger = LoggerFactory.getLogger(ProjectInfoAPIClient.class);

	@Autowired
	private OutProjectService outProjectService;

	@ApiOperation(value = "保存项目信息", notes = "数据表不分行项目，就一张表")
	@RequestMapping(value = "/project-api/info/add", method = RequestMethod.POST)
	public JSONObject saveOutProjectInfo(@RequestBody String jsonStr) throws Exception {
		System.out.println("saveOutProjectInfo==================" + jsonStr);
		JSONObject json = JSONObject.parseObject(jsonStr);
		JSONArray jsonArray = json.getJSONArray("itemList");
		List<OutProjectInfo> itemList = new ArrayList<OutProjectInfo>();
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject temJson = jsonArray.getJSONObject(i);
			OutProjectInfo opri = JSON.toJavaObject(temJson,OutProjectInfo.class);
			opri.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
			opri.setXmid(json.getString("xmid"));
			opri.setNd(json.getString("nd"));
			opri.setHth(json.getString("hth"));
			itemList.add(opri);
		}
		outProjectService.insertProjectData(itemList, null);
		JSONObject result = new JSONObject();
		result.put("resCode", "0");
		result.put("resMsg", "success");
		result.put("total", "1");
		result.put("result", "");
		return result;

	}

}
