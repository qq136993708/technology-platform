package com.pcitc.web.controller.doc;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.web.common.BaseController;

/**
 * @since 2019-02-14 14:01:58
 */

@Controller
public class FileController extends BaseController {

	private static final String commonFileList = "http://pcitc-zuul/system-proxy/file-common-provider/files/common/data-list";
	
	/**
	 * 
	 * 文档管理的查询方法，查询公共的和分享给自己文件
	 */
	@RequestMapping(value = "/file/common/data-list", method = RequestMethod.POST)
	@ResponseBody
	public String getFileCommonList(@ModelAttribute("param") LayuiTableParam param) throws IOException {
		
		param.getParam().put("userId", sysUserInfo.getUserId());
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(commonFileList, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		System.out.println(">>>>>>>>>>>>>country_table_data:" + result.toString());
		return result.toString();
	}
}