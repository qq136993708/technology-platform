package com.pcitc.web.controller.out;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcitc.web.common.OperationFilter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.FileUtil;

@Controller
public class OutProjectController extends BaseController {

	private static final String PROJECT_LIST_PAGE = "http://pcitc-zuul/system-proxy/out-provider/project-list";
	
	private static final String ERP_PROJECT_LIST_PAGE = "http://pcitc-zuul/hana-proxy/hana/out/erp-project-list";
	
	private static final String CONFIG_ERP_URL = "http://pcitc-zuul/system-proxy/out-provider/config-erp-project";

	private static final String UPDATE_PROJECT_URL = "http://pcitc-zuul/system-proxy/out-provider/update-project";

	private static final String GET_OUT_PROJECT = "http://pcitc-zuul/system-proxy/out-provider/get-project-list/";
	
	private static final String FILE_DOWNLOAD = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/downloadFileFromOss";
	
	
	@RequestMapping(value = "/out/ini-project-list")
	public String iniOutProjectList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/out/out-project-list";
	}
	
	@RequestMapping(value = "/out/project-list", method = RequestMethod.POST)
	@ResponseBody
	public Object outProjectList(@ModelAttribute("param") LayuiTableParam param) {

		System.out.println("====/out/project-list");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_LIST_PAGE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}
	
	@RequestMapping(value = "/out/erp-project-config/{dataId}")
	public String iniErpProjectConfig(@PathVariable("dataId") String dataId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("1=====iniDealTask====" + dataId);


		// 当前人信息
		request.setAttribute("userInfo", sysUserInfo);

		return "/stp/out/erp-project-config";
	}
	
	@RequestMapping(value = "/out/erp-project-list", method = RequestMethod.POST)
	@ResponseBody
	public Object erpProjectList(@ModelAttribute("param") LayuiTableParam param) {

		System.out.println("====/out/erp-project-list");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(ERP_PROJECT_LIST_PAGE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}
	
	@RequestMapping(value = "/out/config-erp", method = RequestMethod.POST)
	@ResponseBody
	public Object saveErpConfig(@RequestBody String params) {

		System.out.println("1====/out/config-erp----"+params);
		// 把原有的当前页匹配都取消，同时把当前新匹配的配上
		JSONObject reJson = JSONObject.parseObject(params);

		HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(reJson, this.httpHeaders);

		ResponseEntity<String> responseEntity = this.restTemplate.exchange(CONFIG_ERP_URL, HttpMethod.POST, entity, String.class);
		String retFlag = responseEntity.getBody();
		System.out.println("2====/out/config-erp----"+retFlag);
		return new Result(true, "操作成功!");
	}
	
	/**
	 * 修改project
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/out/update-project", method = RequestMethod.POST)
	@ResponseBody
	public Object updateProject(@RequestBody String params) {

		System.out.println("1====/out/update-project----"+params);
		// 把原有的当前页匹配都取消，同时把当前新匹配的配上
		JSONObject reJson = JSONObject.parseObject(params);

		HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(reJson, this.httpHeaders);

		ResponseEntity<String> responseEntity = this.restTemplate.exchange(UPDATE_PROJECT_URL, HttpMethod.POST, entity, String.class);
		String retFlag = responseEntity.getBody();
		System.out.println("2====/out/update-project----"+retFlag);
		return new Result(true, "操作成功!");
	}

	@RequestMapping(value = "/out/project-detail/{dataId}", method = RequestMethod.GET)
	public String iniOutProjectShow(@PathVariable("dataId") String dataId, HttpServletRequest request) {
		return "/stp/out/out-project-show";
	}
	
	/**
	 * @author Nishikino 
	 * 根据id获取數據
	 */
	@RequestMapping(value = "/out/getOutProjectShow/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object getOutProjectShow(@PathVariable("dataId") String dataId, HttpServletRequest request) {
		System.out.println("-------------------------getOutProjectShow--------------------------------");
		ResponseEntity<OutProjectInfo> responseEntity = this.restTemplate.exchange(GET_OUT_PROJECT + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), OutProjectInfo.class);
		OutProjectInfo outProjectInfo = responseEntity.getBody();
		return outProjectInfo;
	}

    @RequestMapping(value = "/out/getOutProjectShowSearch", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(dataFlag = "true")
    public Object getOutProjectShowSearch(HttpServletRequest request) {
        ResponseEntity<OutProjectInfo> responseEntity = this.restTemplate.exchange(GET_OUT_PROJECT + request.getParameter("data_id"), HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), OutProjectInfo.class);
        OutProjectInfo outProjectInfo = responseEntity.getBody();
        //权限判断
        Object zycbm = request.getAttribute("zycbm");
        zycbm = (zycbm==null)?"":zycbm;
        if(!Arrays.asList(zycbm.toString().split(",")).contains(outProjectInfo.getZycbm())){
            outProjectInfo = new OutProjectInfo();
            outProjectInfo.setFzrxm("0");
        }
        return outProjectInfo;
    }
	
	@RequestMapping(value = "/out/report_download")
	public ResponseEntity<byte[]> downLoadPlantRunningListInfo(@RequestParam(value = "fileName", required = true) String fileName,HttpServletRequest req,HttpServletResponse res) throws IOException {
		
        HttpEntity<String> httpEntity = new HttpEntity<String>(fileName, this.httpHeaders);
        ResponseEntity<byte[]> responseEntity = this.restTemplate.postForEntity(FILE_DOWNLOAD, httpEntity, byte[].class);
        byte[] result = responseEntity.getBody();
        httpHeaders.add("x-frame-options", "SAMEORIGIN");
        response.addHeader("x-frame-options", "SAMEORIGIN");
        return responseEntity;
		//System.out.println("download fileName:"+fileName);
		//req.setAttribute("filePath", fileName);
		
		//File f = new File(fileName);
		//FileUtil.fileDownload(f, res);
	}
}
