package com.pcitc.web.controller.out;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "LocalApi-API",tags = {"本系统-对外接口"})
@RestController
public class LocalApiController extends BaseController
{
	
	    @Value("${localApiRouteHosts}")
	    private String localApiRouteHosts;
	    private static final String GET_FAMILY_URL = "http://kjpt-zuul/stp-proxy/tech_family_provider/getTreeNodeApiList";
	    
	    @ApiOperation(value = "查询技术族列表（不分页）", notes = "查询技术族列表（不分页）")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name = "unifyIdentityId", value = "统一身份ID(身份证号)",                dataType = "string", paramType = "query",required=true),
	        @ApiImplicitParam(name = "userSecretLevel", value = "用户密级（4核心，3重要，2一般，1非密）",   dataType = "string", paramType = "query",required=true),
	        @ApiImplicitParam(name = "parentId",        value = "父ID",                             dataType = "string", paramType = "query"),
	        @ApiImplicitParam(name = "levelCode",       value = "层级",                             dataType = "string", paramType = "query")
	    })
	    @RequestMapping(value = "/getTreeNodeListForOutApi", method = RequestMethod.GET)
		public String getTreeNodeListForOutApi(HttpServletRequest request, HttpServletResponse response)throws Exception
	    {
	    	
	    	
	    	    Result results = new Result();
	            String unifyIdentityId=CommonUtil.getParameter(request, "unifyIdentityId", "");
	            String userSecretLevel=CommonUtil.getParameter(request, "userSecretLevel", "");
	            String levelCode=CommonUtil.getParameter(request, "levelCode", "");
	            String parentId=CommonUtil.getParameter(request, "parentId", "");
	            String host= EquipmentUtils.getRemoteHost(request);
	            
	    		System.out.println(">>>>>>>>>>身份证号: "+unifyIdentityId);
	    		System.out.println(">>>>>>>>>>用户密级（4核心，3重要，2一般，1非密）: "+userSecretLevel);
	    		System.out.println(">>>>>>>>>>合法主机: "+localApiRouteHosts);
	    		System.out.println(">>>>>>>>>>远程主机: "+host);
	    		
	            if(localApiRouteHosts!=null && !"".equals(localApiRouteHosts) && localApiRouteHosts.contains(host)==false)
          	    {
	            	results.setSuccess(false);
	            	results.setMessage("请求的IP不合法");
	            	JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(results));
				    return ob.toString();
          	    }
	            
	            if(unifyIdentityId.equals("") || userSecretLevel.equals("") )
	            {
	            	results.setSuccess(false);
	            	results.setMessage("参数为空");
	            	JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(results));
				    return ob.toString();
	            }
	            SysUser user= EquipmentUtils.getUserByIdentityId(unifyIdentityId, restTemplate, httpHeaders);
	            if(user!=null)
	            {
	            	Map<String ,Object> paramMap = new HashMap<String ,Object>();
			   		paramMap.put("unifyIdentityId", unifyIdentityId);
			   	    paramMap.put("levelCode", levelCode);
			   	    paramMap.put("parentId", parentId);
			   	    paramMap.put("status", "1");
			   	    paramMap.put("userSecretLevel", userSecretLevel);
			   	    paramMap.put("knowledgeScope", user.getUserName());
			   	 
			   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
			   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_FAMILY_URL, HttpMethod.POST, httpEntity, JSONArray.class);
			   		int statusCode = responseEntity.getStatusCodeValue();
		  	   		JSONArray jSONArray=null;
		  	   		if (statusCode == 200)
		  	   		{
		  	   			jSONArray = responseEntity.getBody();
		  	   		    results.setData(jSONArray);
		  	   		}else
		  	   		{
		  	   		  results.setSuccess(false);
		  	   		  results.setMessage("网络有误");
		  	   		}
	            }else
	            {
	            	results.setSuccess(false);
	            	results.setMessage("没有此用户");
	            }
	  	   	    JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(results));
			    return ob.toString();
		}
	    
	

}
