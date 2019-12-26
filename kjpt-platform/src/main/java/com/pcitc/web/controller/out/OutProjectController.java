package com.pcitc.web.controller.out;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.out.OutProject;
import com.pcitc.web.common.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@Api(value = "ExpertPatent-API",tags = {"外系统-项目接口"})
@RestController
public class OutProjectController extends BaseController {
	
	
	/**
	 * 获取项目（分页）
	 */
	private static final String LIST_OUTPROJECT_URL = "http://kjpt-zuul/stp-proxy/out_project/list";
	/**
	 * 根据ID获取对象信息
	 */
	public static final String PAGE_OUTPROJECT_URL = "http://kjpt-zuul/stp-proxy/out_project/page";
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String GET_OUTPROJECT_URL = "http://kjpt-zuul/stp-proxy/expert_patent/get/";

	 private static final String GET_HOT_FAMILY_URL = "http://kjpt-zuul/stp-proxy/out_project/getHotByTypeIndex";
		
	/**
	  *查询外系统-项目
	 */
	@ApiOperation(value = "查询外系统-项目", notes = "查询外系统-项目")
	@ApiImplicitParams({
	       @ApiImplicitParam(name = "techType",  value = "专业领域", dataType = "string", paramType = "query"),
	       @ApiImplicitParam(name = "techTypeIndex",  value = "专业领域索引", dataType = "string", paramType = "query")
	   })
	@RequestMapping(value = "/outProject-api/getList", method = RequestMethod.GET)
	public String getChildsListByCodeTree(
			@RequestParam(required = false) String techType,
			@RequestParam(required = false) String techTypeIndex,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

	    Map  map = new HashMap();
	    map.put("techTypeIndex", techTypeIndex);
	    map.put("techType", techType);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(LIST_OUTPROJECT_URL, HttpMethod.POST,new HttpEntity<Map>(map, this.httpHeaders), JSONArray.class);
		JSONArray temparray = responseEntity.getBody();
		List<OutProject> list = JSONObject.parseArray(temparray.toJSONString(), OutProject.class);
		JSONArray trreeJsovvn = JSONArray.parseArray(JSON.toJSONString(list));
		System.out.println("-----------------查询外系统-项目："+trreeJsovvn.toString());
		return trreeJsovvn.toString();
	}
	
	
	
	
	/**
	  * 获取项目（分页）
	 */
    @ApiOperation(value = "查询外系统-项目列表（分页）", notes = "查询外系统-项目列表（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",           value = "页码",       dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit",          value = "每页显示条数",  dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "techType",       value = "专业领域",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "techTypeIndex",  value = "专业领域索引",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "projectName",    value = "项目名称",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "setupYear",      value = "年份",     dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/outProject-api/page", method = RequestMethod.GET)
	public String getExpertPage(
			

			@RequestParam(required = true) Integer page,
            @RequestParam(required = true) Integer limit,
            @RequestParam(required = false) String techType,
            @RequestParam(required = false) String techTypeIndex,
            @RequestParam(required = false) String projectName,
            @RequestParam(required = false) String setupYear,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
     {
    	
    	
		System.out.println(">>>>>>>>>projectName "+projectName);
		System.out.println(">>>>>>>>>setupYear "+setupYear);

    	LayuiTableParam param =new LayuiTableParam();
    	param.getParam().put("techType", techType);
    	param.getParam().put("techTypeIndex", techTypeIndex);
    	param.getParam().put("projectName", projectName);
    	param.getParam().put("setupYear", setupYear);
    	param.setLimit(limit);
    	param.setPage(page);
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_OUTPROJECT_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		//logger.info("============查询外系统- " + result.toString());
		return result.toString();
	}


    @ApiOperation(value = "查询技术族-项目热点", notes = "查询技术-项目热点")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "typeIndex",  value = "专业领域索引",     dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/outProject-api/getHotByTypeIndex", method = RequestMethod.GET)
    public String getHotByTypeIndex(  @RequestParam(required = false) String typeIndex,HttpServletRequest request, HttpServletResponse response) throws Exception  {

    	
    	logger.info("============typeIndex" + typeIndex);
    	 Map  map = new HashMap();
 	     map.put("typeIndex", typeIndex);
 	    ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(GET_HOT_FAMILY_URL, HttpMethod.POST,new HttpEntity<Map>(map, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        return JSON.toJSON(retJson).toString();
    }
   
	
    
    
    
  
    

}
