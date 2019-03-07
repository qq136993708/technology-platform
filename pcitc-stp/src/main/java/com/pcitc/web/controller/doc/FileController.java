package com.pcitc.web.controller.doc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	private static final String collectFileList = "http://pcitc-zuul/system-proxy/file-common-provider/files/collect/data-list";
	
	private static final String download = "http://pcitc-zuul/system-proxy/file-common-provider/version/download/";
    private static final String downloads = "http://pcitc-zuul/system-proxy/file-common-provider/version/downloads/";
	
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
	
	/**
	 * 
	 * 查询收藏的文件信息
	 */
	@RequestMapping(value = "/file/collect/data-list", method = RequestMethod.POST)
	@ResponseBody
	public String getFileCollectList(@ModelAttribute("param") LayuiTableParam param) throws IOException {
		
		param.getParam().put("userId", sysUserInfo.getUserId());
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(collectFileList, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		System.out.println(">>>>>>>>>>>>>country_table_data:" + result.toString());
		return result.toString();
	}
	
	/**
	 * 下载历史版本文件
	 */
	@RequestMapping(value = "/file/version/download/{versionUUID}", method = RequestMethod.GET, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<byte[]> downloadFile(@PathVariable("versionUUID") String versionUUID, HttpServletRequest request, HttpServletResponse response) throws IOException {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("versionUUID", versionUUID);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, this.httpHeaders);
        ResponseEntity<byte[]> responseEntity = this.restTemplate.postForEntity(((versionUUID.split("\\|").length > 1) ? downloads : download) + versionUUID, httpEntity, byte[].class);
        byte[] result = responseEntity.getBody();
        httpHeaders.add("x-frame-options", "ALLOW-FROM");
        response.addHeader("x-frame-options", "ALLOW-FROM");
        return responseEntity;
    }
    
}