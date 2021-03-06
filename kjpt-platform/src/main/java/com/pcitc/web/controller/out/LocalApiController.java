package com.pcitc.web.controller.out;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.researchplatform.PlatformInfoModel;
import com.pcitc.base.stp.techFamily.TechFamily;
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
	    
	    private static final String getPlatformListForOutApi = "http://kjpt-zuul/stp-proxy/researchPlatform-api/queryPlatformListApi";
	    private static final String GET_FAMILY_URL = "http://kjpt-zuul/stp-proxy/tech_family_provider/getTreeNodeApiList";
	    private static final String LIST_BY_IDS_URL = "http://kjpt-zuul/stp-proxy/tech-family-provider/getListByCodesForApi";
		
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
	    		System.out.println(">>>>>>>>>>合法主机: "+localApiRouteHosts +" 远程主机:"+host);
	    		
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
	            Map<String ,Object> paramMap = new HashMap<String ,Object>();
	            paramMap.put("status", "1");
	            paramMap.put("unifyIdentityId", unifyIdentityId);
		   	    paramMap.put("levelCode", levelCode);
		   	    paramMap.put("parentId", parentId);
	            //如果人员不存在，则返回非密数据
	            if(user!=null)
	            {
			   	    paramMap.put("userSecretLevel", userSecretLevel);
			   	    paramMap.put("knowledgeScope", user.getUserName());
			   		
	            }else
	            {
			   	    paramMap.put("secretLevel", "0");
	            }
	            
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
	  	   	    JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(results));
			    return ob.toString();
		}
	    
	    
	    
	    @ApiOperation(value = "查询科研平台列表", notes = "查询科研平台列表")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name = "unifyIdentityId",        value = "统一身份ID(身份证号)",                 dataType = "string", paramType = "query"),
	        @ApiImplicitParam(name = "userSecretLevel",        value = "用户密级（4核心，3重要，2一般，1非密）",   dataType = "string", paramType = "query"),
	        @ApiImplicitParam(name = "id",                     value = "ID",                              dataType = "string", paramType = "query"),
	        @ApiImplicitParam(name = "platformName",            value = "平台名称",                           dataType = "string", paramType = "query"),
	        @ApiImplicitParam(name = "level",                  value = "平台等级(01：国家级科研平台、02：部委级科研平台、03：省部级科研平台、04：集团级科研平台、05：板块级科研平台)",                           dataType = "string", paramType = "query")
	    })
	    @RequestMapping(value = "/getPlatformListForOutApi", method = RequestMethod.GET)
		public String getPlatformListForOutApi(HttpServletRequest request, HttpServletResponse response)throws Exception
	    {
	    	
	    	
	    	    Result results = new Result();
	            String unifyIdentityId=CommonUtil.getParameter(request, "unifyIdentityId", "");
	            String userSecretLevel=CommonUtil.getParameter(request, "userSecretLevel", "");
	            String platformName=CommonUtil.getParameter(request, "platformName", "");
	            String level=CommonUtil.getParameter(request, "level", "");
	            String host= EquipmentUtils.getRemoteHost(request);
	            
	    		System.out.println(">>>>>>>>>>身份证号: "+unifyIdentityId);
	    		System.out.println(">>>>>>>>>>用户密级（4核心，3重要，2一般，1非密）: "+userSecretLevel);
	    		System.out.println(">>>>>>>>>>合法主机: "+localApiRouteHosts+ "远程主机:"+host);
	    		
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
	        	Map<String ,Object> paramMap = new HashMap<String ,Object>();
	        	paramMap.put("deleted", "0");
	        	paramMap.put("level", level);
		   	    paramMap.put("platformName", platformName);
	            if(user!=null)
	            {
	            
			   	    paramMap.put("userSecretLevel", userSecretLevel);
			   	    paramMap.put("knowledgeScope", user.getUserName());
	            }else
	            {
	            	  paramMap.put("secretLevel", "0");
	            	  
	            }
	            
	            HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
		   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getPlatformListForOutApi, HttpMethod.POST, httpEntity, JSONArray.class);
		   		int statusCode = responseEntity.getStatusCodeValue();
	  	   		JSONArray jSONArray=null;
	  	   		if (statusCode == 200)
	  	   		{
	  	   			jSONArray = responseEntity.getBody();
	  	   		    jSONArray=getJSONArray(jSONArray);
	  	   		    results.setData(jSONArray);
	  	   		}else
	  	   		{
	  	   		  results.setSuccess(false);
	  	   		  results.setMessage("网络有误");
	  	   		}
	            
	  	   	    JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(results));
			    return ob.toString();
		}
	    
	    
	    
	    
	    
	    
	    @ApiOperation(value = "根据编码（多个）查询技术族列表", notes = "根据编码（多个）查询技术族列表")
		@ApiImplicitParams({
	        @ApiImplicitParam(name = "codes",           value = "编码(多个用逗号分开)", dataType = "string", paramType = "query",required=true)
	    })
		@RequestMapping(value = "/getTechFamilyListByCodesForOutApi", method = RequestMethod.GET)
		public String getTechFamilyListByCodesForOutApi(HttpServletRequest request, HttpServletResponse response) throws Exception {

			Result resultsDate = new Result();
		    String host= EquipmentUtils.getRemoteHost(request);
    		System.out.println(">>>>>>>>>>合法主机: "+localApiRouteHosts);
    		System.out.println(">>>>>>>>>>远程主机: "+host);
            if(localApiRouteHosts!=null && !"".equals(localApiRouteHosts) && localApiRouteHosts.contains(host)==false)
    	    {
            	resultsDate.setSuccess(false);
            	resultsDate.setMessage("请求的IP不合法");
            	JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
			    return ob.toString();
    	    }
			String codes=CommonUtil.getParameter(request, "codes", "");
			List returnlist = new ArrayList();
			if (!codes.equals("")) 
			{
				String chkbox[] = codes.split(",");
				if (chkbox != null && chkbox.length > 0) {
					List<String> list = Arrays.asList(chkbox);
					JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(list));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					ResponseEntity<List> responseEntity = restTemplate.exchange(LIST_BY_IDS_URL, HttpMethod.POST, entity, List.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) {
						returnlist = responseEntity.getBody();

					}
				}
			}
			resultsDate.setData(returnlist);
			SimplePropertyPreFilter filter = new SimplePropertyPreFilter(TechFamily.class, "createDate","typeIndex");  
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate,filter));
			return result.toString();
		}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    @ApiOperation(value = "获取当前用户信息", notes = "获取当前用户信息")
		@RequestMapping(value = "/getCurrentUserInfo", method = RequestMethod.GET)
		public SysUser getCurrentUserInfo( HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	Result resultsDate = new Result();
	    	SysUser sysUser=(SysUser)request.getSession().getAttribute("sysUser");
			//JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
			return sysUser;
		}
	    
	    
	    
	    
	    //实体转换
	    private JSONArray getJSONArray(JSONArray jSONArray)
	    {
	    	    List<PlatformInfoModel> resault =new ArrayList<PlatformInfoModel>();
	   		    List<PlatformInfoModel> list = JSONObject.parseArray(jSONArray.toJSONString(), PlatformInfoModel.class);
	   		    if(list!=null)
	   		    {
	   		    	for(int i=0;i<list.size();i++)
	   		    	{
	   		    	     PlatformInfoModel platformInfoModel=list.get(i);
	   		    	     PlatformInfoModel pm=new  PlatformInfoModel();
	   		    	     pm.setId(platformInfoModel.getId());
	   		             pm.setPlatformName(platformInfoModel.getPlatformName());
	   		             pm.setLevel(platformInfoModel.getLevel());
	   		             pm.setResearchFieldText(platformInfoModel.getResearchFieldText());
	   		             pm.setResearchField(platformInfoModel.getResearchField());
	   		             pm.setPlatformIntroduction(platformInfoModel.getPlatformIntroduction());
	   		             pm.setPlatformScoring(platformInfoModel.getPlatformScoring());
	   		             pm.setTeamIntroduction(platformInfoModel.getTeamIntroduction());
	   		             pm.setOverallSituation(platformInfoModel.getOverallSituation());
	   		             pm.setSecretLevel(platformInfoModel.getSecretLevel());
	   		             pm.setCreateUnitId(platformInfoModel.getCreateUnitId());
	   		             pm.setCreateUnitName(platformInfoModel.getCreateUnitName());
	   		             pm.setLevelText(platformInfoModel.getLevelText());
	   		             pm.setSecretLevelText(platformInfoModel.getSecretLevelText());
	   		             pm.setSupportingInstitutions(platformInfoModel.getSupportingInstitutions());
	   		             pm.setSupportingInstitutionsText(platformInfoModel.getSupportingInstitutionsText());
	   		        	 resault.add(pm);
	   		    	}
	   		    }
	   		 JSONArray array= JSONArray.parseArray(JSON.toJSONString(resault));
	   	     return  array;
	    }
	    
	

}
