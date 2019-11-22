package com.pcitc.web.controller.techFamily;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.FormSelectNode;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysUnit;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.TreeUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "SysDictionary-API",tags = {"共用-字典接口"})
@RestController
public class SysDictionaryApiController extends BaseController {
	
	private static final String UNIT_LIST_ZTREE_DATA = "http://kjpt-zuul/system-proxy/unit-provider/unit/getAllList";
	/**
	  *根据字典编号查下级内容
	 */
    @ApiOperation(value = "根据字典编号查下级内容", notes = "根据字典编号查下级内容")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "code", value = "字典编号", dataType = "string", paramType = "query",required=true)
    })
	@RequestMapping(value = "/sysDictionary-api/getChildsListByCode/{code}", method = RequestMethod.GET)
	public String getChildsListByCode( @PathVariable("code") String code, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Result resultsDate = new Result();
   	    List<SysDictionary> list=	EquipmentUtils.getSysDictionaryListByParentCode(code, restTemplate, httpHeaders);
   	    resultsDate.setData(list);
   	   
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
	}
    
    
    
    
    
    /**
	  *根据字典编号查字典详情
	 */
   @ApiOperation(value = "根据字典编号查字典详情", notes = "根据字典编号查字典详情")
   @ApiImplicitParams({
       @ApiImplicitParam(name = "code", value = "字典编号", dataType = "string", paramType = "query",required=true)
   })
	@RequestMapping(value = "/sysDictionary-api/getDictionaryByCode/{code}", method = RequestMethod.GET)
	public String getDictionaryByCode(@PathVariable("code") String code, HttpServletRequest request, HttpServletResponse response) throws Exception {
  	    
      	Result resultsDate = new Result();
     	SysDictionary sysDictionary=	EquipmentUtils.getDictionaryByCode(code, restTemplate, httpHeaders);
     	resultsDate.setData(sysDictionary);
  	   
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
	}
   
   
   
   
   
   
   /**
	  *查询组织机构列表
	 */
	@ApiOperation(value = "查询组织机构-树形结构", notes = "查询组织机构-族树形结构")
	@RequestMapping(value = "/unit-api/getTreeList", method = RequestMethod.GET)
	public String getChildsListByCodeTree(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map techType = new HashMap();
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(UNIT_LIST_ZTREE_DATA, HttpMethod.POST,new HttpEntity<Map>(techType, this.httpHeaders), JSONArray.class);
		JSONArray temparray = responseEntity.getBody();
		List<SysUnit> list = JSONObject.parseArray(temparray.toJSONString(), SysUnit.class);
		
		
		List<FormSelectNode> alllist =TreeUtils.sysUnitToSelectNodeList(list);
		
		
		JSONArray trreeJsovvn = JSONArray.parseArray(JSON.toJSONString(alllist));
		
		System.out.println(">>>>>>>>>nodeList条数:"+trreeJsovvn.toString());		
		JSONObject trreeJson = JSONObject.parseObject(JSONObject.toJSONString(TreeUtils.recursiveTree(Constant.UNIT_ROOT_ID,alllist)));
		System.out.println("-----------------树形结构："+trreeJson.toString());
		return trreeJson.toString();
	}
	
	
	
	
	
	
	
	
	
	
	

}
