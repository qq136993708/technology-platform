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


@Api(value = "OutPerson-API",tags = {"外系统-人员接口"})
@RestController
public class OutPersonController extends BaseController {
	
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String PAGE_OUTPROJECT_URL = "http://kjpt-zuul/stp-proxy/out_person/page";

		
	
	
	/**
	  * 获取人员（分页）
	 */
    @ApiOperation(value = "查询外系统-人员列表（分页）", notes = "查询外系统-人员列表（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",           value = "页码",       dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit",          value = "每页显示条数",  dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "name",           value = "名称",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "education",      value = "学历(字典)",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "belongUnitId",    value = "所在单位ID",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "post",            value = "职务",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "title",           value = "职称",     dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/outPerson-api/page", method = RequestMethod.GET)
	public String getExpertPage(
			

			@RequestParam(required = true) Integer page,
            @RequestParam(required = true) Integer limit,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String education,
            @RequestParam(required = false) String belongUnitId,
            @RequestParam(required = false) String post,
            @RequestParam(required = false) String title,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
     {

    	LayuiTableParam param =new LayuiTableParam();
    	param.getParam().put("name", name);
    	param.getParam().put("education", education);
    	param.getParam().put("belongUnitId", belongUnitId);
    	param.getParam().put("post", post);
    	param.getParam().put("title", title);
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
		logger.info("============查询外系统- " + result.toString());
		return result.toString();
	}


   
	
    
    
    
  
    

}
