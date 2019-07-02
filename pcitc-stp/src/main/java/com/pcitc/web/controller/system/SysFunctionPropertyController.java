package com.pcitc.web.controller.system;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysDataModel;
import com.pcitc.base.system.SysFunctionProperty;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;



@Controller
public class SysFunctionPropertyController extends BaseController {
	
	private static final String FUNCTION_LIST = "http://pcitc-zuul/system-proxy/sysFunctionProperty-provider/sysFunctionProperty_list";
	
	private static final String SAVE_FUNCTION = "http://pcitc-zuul/system-proxy/sysFunctionProperty-provider/saveSysFunctionProperty";
	
	private static final String DELETE_FUNCTION = "http://pcitc-zuul/system-proxy/sysFunctionProperty-provider/deleteSysFunctionProperty/";
	
	private static final String GET_FUNCTIONBYID = "http://pcitc-zuul/system-proxy/sysFunctionProperty-provider/getSysFunctionPropertyById/";
	
	private static final String GET_FUNCTION = "http://pcitc-zuul/system-proxy/sysFunctionProperty-provider/getSysFunctionProperty";
	
	private static final String DATA_MODEL_LIST = "http://pcitc-zuul/system-proxy/sysFunctionProperty-provider/data/model/list";
	
	private static final String DATA_MODEL_VALUE_LIST = "http://pcitc-zuul/system-proxy/sysFunctionProperty-provider/data/model/value/list";
	
	private static final String SAVE_DATA_MODEL = "http://pcitc-zuul/system-proxy/sysFunctionProperty-provider/data/model/save";
	
	private static final String SELECTED_LIST = "http://pcitc-zuul/system-proxy/sysFunctionProperty-provider/dictionary/data/control/list";
	
	/**
	 * 跳转到菜单配置列表页
	 */
	@RequestMapping(value = "/functionProperty/function_property")
	public String toList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/base/property/function_property";
	}
	
	/**
	 * 跳转到菜单配置列表页
	 * 一个功能中，配置菜单的控制项及这个控制项对应的内容属性
	 */
	@RequestMapping(value = "/functionProperty/function_property_all")
	public String toFunctionPropertyList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/base/property/function_property_all";
	}
	
	/**
	 * 跳转到菜单配置详情页
	 */
	@RequestMapping(value = "/functionProperty/function_property_info")
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
	@RequestMapping(value = "/functionProperty/getFunctionPropertyList", method = RequestMethod.POST)
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
	@RequestMapping(value = "/functionProperty/saveData")
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
	@RequestMapping(value = "/functionProperty/deleteData")
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
	@RequestMapping(value = "/functionProperty/getDataById")
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
	@RequestMapping(value = "/functionProperty/getData")
	@ResponseBody
	public Object getData(@RequestBody SysFunctionProperty obj){
	    HttpEntity<SysFunctionProperty> entity = new HttpEntity<SysFunctionProperty>(obj, this.httpHeaders);
	    ResponseEntity<SysFunctionProperty> responseEntity = this.restTemplate.exchange(GET_FUNCTION, HttpMethod.POST, entity, SysFunctionProperty.class);
	    SysFunctionProperty SysFunctionProperty = responseEntity.getBody();
		return SysFunctionProperty;
	}
	
	@RequestMapping(value = "/functionProperty/data/model", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray getDataModelList(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (request.getParameter("proCode")!= null) {
			map.put("proCode", request.getParameter("proCode"));
		}
		if (request.getParameter("dataCode")!= null) {
			map.put("dataCode", request.getParameter("dataCode"));
		}
		map.put("userId", sysUserInfo.getUserId());
		HttpEntity<HashMap<String, Object>> entity = new HttpEntity<HashMap<String, Object>>(map, this.httpHeaders);

		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(DATA_MODEL_LIST, HttpMethod.POST, entity, JSONArray.class);
		return responseEntity.getBody();
	}
	
	@RequestMapping(value = "/functionProperty/data/model/value", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray getDataModelValueList(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (request.getParameter("proCode")!= null) {
			map.put("proCode", request.getParameter("proCode"));
		}
		if (request.getParameter("dataCode")!= null) {
			map.put("dataCode", request.getParameter("dataCode"));
		}
		map.put("userId", sysUserInfo.getUserId());
		HttpEntity<HashMap<String, Object>> entity = new HttpEntity<HashMap<String, Object>>(map, this.httpHeaders);

		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(DATA_MODEL_VALUE_LIST, HttpMethod.POST, entity, JSONArray.class);
		return responseEntity.getBody();
	}
	
	/**
	 * @author zhf
	 * @date 2019年4月17日 下午8:09:37 
	 * 初始化新增数据模板功能
	 */
	@RequestMapping(value = "/functionProperty/data/model/ini-add")
	public String iniAddDataModel(HttpServletRequest request) throws Exception {

		return "/base/property/data_model_add";
	}
	
	/**
	 * @author zhf
	 * @date 2019年4月17日 下午8:09:37 
	 * 初始化新增数据模板功能
	 */
	@RequestMapping(value = "/functionProperty/data/model/save")
	@ResponseBody
	public Result saveSysDataModel(@RequestBody SysDataModel sysDataModel) {

		sysDataModel.setCreateUser(sysUserInfo.getUserDisp());
		Integer retI = this.restTemplate.exchange(SAVE_DATA_MODEL, HttpMethod.POST, new HttpEntity<SysDataModel>(sysDataModel, this.httpHeaders), Integer.class).getBody();
		System.out.println("------"+retI);
		if (retI == 0) {
			return new Result(false, "操作失败!");
		} else {
			return new Result(true, "操作成功!");
		}
	}
	
	/**
	 * 查询已经某个菜单、某个配置项、某个岗位已经配置的研究院
	 */
	@RequestMapping(value = "/functionProperty/dictionary/data/control/list", method = RequestMethod.POST)
	@ResponseBody
	public Object selectInstituteData(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (request.getParameter("proCode")!= null) {
			map.put("proCode", request.getParameter("proCode"));
		}
		if (request.getParameter("postId")!= null) {
			map.put("postId", request.getParameter("postId"));
		}
		if (request.getParameter("functionId")!= null) {
			map.put("functionId", request.getParameter("functionId"));
		}
		if (request.getParameter("keyWord")!= null) {
			map.put("keyWord", request.getParameter("keyWord"));
		}
		if (request.getParameter("dicIndex")!= null) {
			map.put("dicIndex", request.getParameter("dicIndex"));
		}
		if (request.getParameter("dicLevel")!= null) {
			map.put("dicLevel", request.getParameter("dicLevel"));
		}
		map.put("userId", sysUserInfo.getUserId());
		HttpEntity<HashMap<String, Object>> entity = new HttpEntity<HashMap<String, Object>>(map, this.httpHeaders);

		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(SELECTED_LIST, HttpMethod.POST, entity, JSONArray.class);
		System.out.println("======"+responseEntity.getBody().toJSONString());
		
		JSONArray jsonArr = responseEntity.getBody();
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("code", "0");
		jsonObj.put("msg", "提示");
		jsonObj.put("count", jsonArr.size());
		jsonObj.put("data", jsonArr);
		System.out.println("2====selectInstituteData====" + jsonObj.toString());
		return jsonObj.toString();
	}

}
