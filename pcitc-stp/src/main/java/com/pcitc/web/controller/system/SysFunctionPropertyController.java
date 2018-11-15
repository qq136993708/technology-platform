package com.pcitc.web.controller.system;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysFunctionProperty;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;



@Controller
@RequestMapping("functionProperty")
public class SysFunctionPropertyController extends BaseController {
	
	private static final String FUNCTION_LIST = "http://pcitc-zuul/system-proxy/sysFunctionProperty-provider/sysFunctionProperty_list";
	
	private static final String SAVE_FUNCTION = "http://pcitc-zuul/system-proxy/sysFunctionProperty-provider/saveSysFunctionProperty";
	
	private static final String DELETE_FUNCTION = "http://pcitc-zuul/system-proxy/sysFunctionProperty-provider/deleteSysFunctionProperty/";
	
	private static final String GET_FUNCTIONBYID = "http://pcitc-zuul/system-proxy/sysFunctionProperty-provider/getSysFunctionPropertyById/";
	
	private static final String GET_FUNCTION = "http://pcitc-zuul/system-proxy/sysFunctionProperty-provider/getSysFunctionProperty";

	/**
	 * 跳转到菜单配置列表页
	 */
	@RequestMapping(value = "/function_property")
	public String toList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/base/property/function_property";
	}
	
	/**
	 * 跳转到菜单配置详情页
	 */
	@RequestMapping(value = "/function_property_info")
	public String toInfo(String id, String funcId, String funcCode, Model model){
		if(StringUtils.isEmpty(id)) id = "";
		model.addAttribute("id", id);
		if(StringUtils.isNotEmpty(funcId)) model.addAttribute("funcId", funcId);
		if(StringUtils.isNotEmpty(funcCode)) model.addAttribute("funcCode", funcCode);
		return "/base/property/function_property_info";
	}
	
	/**
	 * 根据获取菜单配置列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getFunctionPropertyList", method = RequestMethod.POST)
	@ResponseBody
	public Object getFunctionPropertyList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SysFunctionProperty obj = new SysFunctionProperty();
		String page = request.getParameter("page"); // 起始索引
		String limit = request.getParameter("limit"); // 每页显示的行数
		String functionId = request.getParameter("functionId"); // 起始索引
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("code", "0");
		jsonObj.put("msg", "提示");
		jsonObj.put("count", 0);
		jsonObj.put("data", "");
		if(StringUtils.isEmpty(functionId)) {
			return jsonObj;
		}
		String functionCode = request.getParameter("functionCode"); // 每页显示的行数
		obj.setFunctionId(functionId);
		obj.setFunctionCode(functionCode);
        obj.setPage(page);
        obj.setLimit(limit);
		HttpEntity<SysFunctionProperty> entity = new HttpEntity<SysFunctionProperty>(obj, this.httpHeaders);
	    ResponseEntity<String> responseEntity = this.restTemplate.exchange(FUNCTION_LIST, HttpMethod.POST, entity, String.class);
		String result = responseEntity.getBody();
        JSONObject retJson = JSONObject.parseObject(result);
        if(retJson != null){
            Long totalCount = retJson.get("totalCount") != null? Long.parseLong(retJson.get("totalCount").toString()):0l;
            List<SysFunctionProperty> resultList = JSON.parseArray(retJson.getJSONArray("list").toJSONString(), SysFunctionProperty.class);
            jsonObj.put("count", totalCount);
            jsonObj.put("data", resultList);
        }
		return jsonObj;
	}
	
	/**
	 * 保存菜单配置
	 * @return
	 */
	@RequestMapping(value = "/saveData")
	@ResponseBody
	public int saveData(@RequestBody SysFunctionProperty SysFunctionProperty){
	    HttpEntity<SysFunctionProperty> entity = new HttpEntity<SysFunctionProperty>(SysFunctionProperty,this.httpHeaders);
	    ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE_FUNCTION, HttpMethod.POST, entity, Integer.class);
		int result = responseEntity.getBody();
		return result;
	}
	
	/**
	 * 删除菜单配置
	 * @param request
	 * @return
	 */
	@OperationFilter(modelName = "数据项配置", actionName = "删除配置")
	@RequestMapping(value = "/deleteData")
	@ResponseBody
	public int deleteData(HttpServletRequest request){
	    String id = request.getParameter("id");
	    ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DELETE_FUNCTION+id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		int result = responseEntity.getBody();
		return result;
	}
	
	/**
	 * 根据id获取菜单配置
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getDataById")
	@ResponseBody
	public Object getDataById(HttpServletRequest request){
	    String id = request.getParameter("id");
	    ResponseEntity<SysFunctionProperty> responseEntity = this.restTemplate.exchange(GET_FUNCTIONBYID+id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysFunctionProperty.class);
	    SysFunctionProperty SysFunctionProperty = responseEntity.getBody();
		return SysFunctionProperty;
	}
	
	/**
	 * 获取菜单配置
	 * @param obj
	 * @return
	 */
	@RequestMapping(value = "/getData")
	@ResponseBody
	public Object getData(@RequestBody SysFunctionProperty obj){
	    HttpEntity<SysFunctionProperty> entity = new HttpEntity<SysFunctionProperty>(obj, this.httpHeaders);
	    ResponseEntity<SysFunctionProperty> responseEntity = this.restTemplate.exchange(GET_FUNCTION, HttpMethod.POST, entity, SysFunctionProperty.class);
	    SysFunctionProperty SysFunctionProperty = responseEntity.getBody();
		return SysFunctionProperty;
	}

}
