package com.pcitc.web.controller.system;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.system.SysProcessDic;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
@RequestMapping(value = "/process_dic")
public class ProcessDicController extends BaseController{
	
	public  static final String GET_URL =    "http://pcitc-zuul/system-proxy/system-provider/sys_process_dic/get/";
	private static final String PAGE_URL =   "http://pcitc-zuul/system-proxy/system-provider/sys_process_dic/page";
	public  static final String ADD_URL =    "http://pcitc-zuul/system-proxy/system-provider/sys_process_dic/add";
	public  static final String UPDATE_URL = "http://pcitc-zuul/system-proxy/system-provider/sys_process_dic/update";
	private static final String DEL_URL =    "http://pcitc-zuul/system-proxy/system-provider/sys_process_dic/delete/";

	
    @RequestMapping(value = "/type_list")
	public String plan_audit_list(HttpServletRequest request, HttpServletResponse response) 
    {
    	List<SysDictionary> list=EquipmentUtils.getSysDictionaryListByParentCode("ROOT_QLCMXWH", restTemplate, httpHeaders);
    	request.setAttribute("list", list);
		return "/stp/processDic/type_list";
	}
    
    
    @RequestMapping(value = "/process_list")
   	public String process_node_list(HttpServletRequest request, HttpServletResponse response) 
    {
    	
    	String type = CommonUtil.getParameter(request, "type", "");
    	request.setAttribute("type", type);
   		return "/stp/processDic/process_list";
   	}
    
    
    
    @RequestMapping(value = "/choose_process")
   	public String choose_process(HttpServletRequest request, HttpServletResponse response) 
    {
    	
    	String type = CommonUtil.getParameter(request, "type", "");
    	request.setAttribute("type", type);
   		return "/stp/processDic/choose_process";
   	}
    
    
    
    
    @RequestMapping(value = "/process_list_data")
	@ResponseBody
	public String process_node_list_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
    {
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============查询结果：" + result);
		return result.toString();
	}
    
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	SysProcessDic sysProcessDic = null;
    	String id = CommonUtil.getParameter(request, "id", "");
    	String type = CommonUtil.getParameter(request, "type", "");
    	if(!id.equals(""))
    	{
    		ResponseEntity<SysProcessDic> se = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysProcessDic.class);
    		sysProcessDic = se.getBody();
    	}
    	request.setAttribute("id", id);
    	request.setAttribute("type", type);
		request.setAttribute("sysProcessDic", sysProcessDic);
		return "/stp/processDic/add";
	}

	/**
	 * 保存-更新操作
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public String saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		String name = CommonUtil.getParameter(request, "name", "");
		// 业务ID
		String ext1 = CommonUtil.getParameter(request, "ext1", "");
		String ext2 = CommonUtil.getParameter(request, "ext2", "");
		String type = CommonUtil.getParameter(request, "type", "");
		String notes = CommonUtil.getParameter(request, "notes", "");
		String id = CommonUtil.getParameter(request, "id", "");
		String parentName = CommonUtil.getParameter(request, "parentName", "");
		String parentId = CommonUtil.getParameter(request, "parentId", "");
		
		
		// 流程状态-是保存还是提交
		SysProcessDic sysProcessDic = null;
		ResponseEntity<String> responseEntity = null;
		// 判断是新增还是修改
		if (id.equals("")) 
		{
			String idv = UUID.randomUUID().toString().replaceAll("-", "");
			sysProcessDic = new SysProcessDic();
			sysProcessDic.setId(idv);
			sysProcessDic.setCreateTime(new Date());
			sysProcessDic.setType(type);
			System.out.println("---------------ext1:" + ext1 + " name=" + name + " ext2=" + ext2);
		} else {
			ResponseEntity<SysProcessDic> se = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysProcessDic.class);
			sysProcessDic = se.getBody();
		}
		// 流程状态
		sysProcessDic.setName(name);;
		sysProcessDic.setNotes(notes);
		sysProcessDic.setExt1(ext1);
		sysProcessDic.setExt2(ext2);
		sysProcessDic.setParentName(parentName);
		sysProcessDic.setParentId(parentId);
		// 判断是新增还是修改
		if (id.equals("")) {
			responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SysProcessDic>(sysProcessDic, this.httpHeaders), String.class);

		} else {
			responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SysProcessDic>(sysProcessDic, this.httpHeaders), String.class);
		}
		// 返回结果代码
		int statusCode = responseEntity.getStatusCodeValue();
		System.out.println(">>>>>>>>>>>>>>>>>>>返回  statusCode=" + statusCode);
		if (statusCode == 200) 
		{
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		} else {
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}
	
	
	
	
	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_URL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		int status = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode + "  status=" + status);
		if (responseEntity.getBody() > 0) {
			resultsDate = new Result(true);
		} else {
			resultsDate = new Result(false, "删除失败，请联系系统管理员！");
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}
	
	

}
