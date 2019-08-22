package com.pcitc.web.controller.mobile;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.FileResult;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkExpert;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class MobilePersonnelController extends BaseController{

	    /**
		 * 院士
		 */
		private static final String ZJK_YS_LIST = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/getYsList";

	    //查询所有人员列表,姓名&ID
	    private static final String queryAllExpert = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/queryAllExpert";
	    /**
		 * 分页查询
		 */
		private static final String LISTPAGE = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo-page";
		
		 /**
	     * 根据ID获取对象信息
	     */
	    private static final String GET_INFO = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/get-zjkbaseinfo/";
	
	    private static final String LIST_OUT_PATENT = "http://pcitc-zuul/system-proxy/out-patent-provider/outpatent_list";
	    private static final String PROJECT_LIST_PAGE = "http://pcitc-zuul/system-proxy/out-provider/project-list-expert";
	    /**
	     * 下载
	     */
	    private static final String download = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/download/";
	    private static final String video = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/video/";
	    private static final String downloads = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/downloads/";
	    private static final String previewImgagByByteBase64 = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/previewImgagByByteBase64/";
	    private static final String showFlag = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/showFlag/";
	    private static final String getFilesLayuiByFormId = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/getFilesLayuiByFormId";
	/**
	 * ================================================科研人才
	 */
	@RequestMapping(value = "/mobile/personnel")
	public String kytr(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);
		return "/mobile/personnel";
	}
	
	@RequestMapping(value = "/mobile/personnel_details")
	public String personnel_details(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//专家详情
        String expertId = request.getParameter("expertId");
        ResponseEntity<ZjkExpert> responseEntity = this.restTemplate.exchange(GET_INFO + expertId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ZjkExpert.class);
        ZjkExpert zjkBaseInfo = responseEntity.getBody();
        request.setAttribute("zjkBaseInfo", zjkBaseInfo);
        request.setAttribute("hylyName", zjkBaseInfo.getExpertProfessionalFieldName());
        request.setAttribute("hyly", zjkBaseInfo.getExpertProfessionalField());
        request.setAttribute("display", request.getParameter("display"));
		
		return "/mobile/personnel_details";
	}
	
	
	@RequestMapping(value = "/mobile/zjk-ys-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getmobileYsList(HttpServletRequest request) 
	{
		
		String key = CommonUtil.getParameter(request, "key", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("key", key);
		
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		ResponseEntity<Object> responseEntity = restTemplate.exchange(ZJK_YS_LIST, HttpMethod.POST, entity, Object.class);
		
		return responseEntity.getBody();
	}
	
	
	@RequestMapping(value = "/mobile/queryAllExpert", method = RequestMethod.GET)
    @ResponseBody
    public String querymobileAllExpert() {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ZjkExpert expert = new ZjkExpert();
        expert.setiSortCol("expert_name");
        expert.setsSortDir_0("asc");
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(queryAllExpert, HttpMethod.POST, new HttpEntity<ZjkExpert>(expert, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<Map<String, Object>> list = (List<Map<String, Object>>) retJson.get("expert");
        return JSON.toJSONString(list);
    }
	
	
	//所有专家
	@RequestMapping(value = "/mobile/getAllExpertTableData", method = RequestMethod.POST)
	@ResponseBody
	public Object getTableData(HttpServletRequest request, HttpServletResponse response) 
	{
		String key = CommonUtil.getParameter(request, "key", "");
		String page = CommonUtil.getParameter(request, "page", "1");
		LayuiTableParam param = new LayuiTableParam();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String limit = CommonUtil.getParameter(request, "limit", "15");


		param.setLimit(Integer.valueOf(limit));
		param.setPage(Integer.valueOf(page));
		param.getParam().put("nd", nd);
		param.getParam().put("key", key);
		System.out.println(">>>>>>>>>>>>nd:" + nd + "page=" + page);
		
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		System.out.println(JSON.toJSON(data).toString());
		return JSON.toJSON(data).toString();
		
	}
	
	
	
	
	
	 @RequestMapping(value = "/mobile/sysfile/viewPic/{id}", method = RequestMethod.GET)
	    public String viewPic(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
	        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
	        form.add("id", id);
	        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, this.httpHeaders);
	        ResponseEntity<byte[]> responseEntity = this.restTemplate.postForEntity(((id.split("\\|").length > 1) ? downloads : download) + id, httpEntity, byte[].class);
	        byte[] bytes = responseEntity.getBody();
	        String picBase64 = "data:image/png;base64,";
	        return picBase64 + new sun.misc.BASE64Encoder().encode(bytes);

	    }
	
	 
	 
	  /**
	     * 根据文件ID 获取文件
	     *
	     * @param fileIds
	     * @param request
	     * @return
	     */
	    @RequestMapping(value = "/mobile/sysfile/getFilesLayuiByFormId", method = RequestMethod.POST)
	    @ResponseBody
	    public FileResult getFilesLayuiByFormId(String fileIds, HttpServletRequest request) {
	        // this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	        this.httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
	        form.add("fileIds", fileIds);
	        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, httpHeaders);
	        ResponseEntity<FileResult> responseEntity = this.restTemplate.postForEntity(getFilesLayuiByFormId, httpEntity, FileResult.class);
	        return responseEntity.getBody();
	    }
	    
	    
	    
	    
	    //专利
	    @RequestMapping(value = "/mobile/queryOutPatentList", method = RequestMethod.POST)
	    @ResponseBody
	    public Object queryOutPatentList( HttpServletRequest request) 
	    {

	    	String name = CommonUtil.getParameter(request, "name", "");
	    	String page = CommonUtil.getParameter(request, "page", "1");
			LayuiTableParam param = new LayuiTableParam();
			String limit = CommonUtil.getParameter(request, "limit", "15");
			

			param.setLimit(Integer.valueOf(limit));
			param.setPage(Integer.valueOf(page));
			
			param.getParam().put("name", name);
	        LayuiTableData data = new LayuiTableData();
	        if (StrUtil.isNullLayuiTableParam(param)) 
	        {
	            data.setCount(0);
	            return JSONObject.toJSONString(data);
	        } else 
	        {
	            HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
	            ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LIST_OUT_PATENT, HttpMethod.POST, entity, LayuiTableData.class);
	            data = responseEntity.getBody();
	            return JSON.toJSON(data).toString();
	        }
	    }
	    
	    
	    //课题
	    @RequestMapping(value = "/mobile/outProjectList", method = RequestMethod.POST)
	    @OperationFilter(dataFlag = "true")
	    @ResponseBody
	    public Object outProjectList(HttpServletRequest request) {

	    	
	    	
	    	String name = CommonUtil.getParameter(request, "name", "");
	    	String page = CommonUtil.getParameter(request, "page", "1");
			LayuiTableParam param = new LayuiTableParam();
			String limit = CommonUtil.getParameter(request, "limit", "15");
			

			param.setLimit(Integer.valueOf(limit));
			param.setPage(Integer.valueOf(page));
			
			param.getParam().put("name", name);
			
			
	        param.getParam().put("leaderFlag", sysUserInfo.getUserLevel());
	        param.getParam().put("username", sysUserInfo.getUserName());
	        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
	        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_LIST_PAGE, HttpMethod.POST, entity, LayuiTableData.class);
	        LayuiTableData retJson = responseEntity.getBody();

	        return JSON.toJSON(retJson).toString();
	    }
	    
	    
}
