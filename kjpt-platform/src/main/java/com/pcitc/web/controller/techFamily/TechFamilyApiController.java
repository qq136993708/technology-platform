package com.pcitc.web.controller.techFamily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.FormSelectNode;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.TreeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "TechFamily-API",tags = {"技术族-接口"})
@RestController
public class TechFamilyApiController extends BaseController
{
	
	private static final String GET_FAMILY_URL = "http://kjpt-zuul/stp-proxy/tech-family-provider/getTechFamilyById/";
	private static final String TECH_TYPE_TREE_NODE = "http://kjpt-zuul/stp-proxy/tech-family-provider/type_tree";
	private static final String LIST_BY_IDS_URL = "http://kjpt-zuul/stp-proxy/tech-family-provider/getListByCodes";
	
	private static final String ADD_FAMILY =          "http://kjpt-zuul/stp-proxy/tech_family_provider/save";
	private static final String GET_FAMILY_PAGE_URL = "http://kjpt-zuul/stp-proxy/tech_family_provider/page";
	private static final String GET_FAMILY_List_URL = "http://kjpt-zuul/stp-proxy/tech_family_provider/getFamilyList";
	private static final String GET_FAMILY_TREE_URL = "http://kjpt-zuul/stp-proxy/tech_family_provider/getTreeNodeList";
	private static final String DEL_FAMILY_URL = "http://kjpt-zuul/stp-proxy/tech_family_provider/delete/";
	
	
	
	
	  
    /**
	  * 删除专家项目
	 */
    @ApiOperation(value = "根据ID删除技术族信息", notes = "根据ID删除技术族信息")
	@RequestMapping(value = "/techFamily-api/delete/{tfmTypeId}", method = RequestMethod.GET)
	public String deleteExpert(@PathVariable("tfmTypeId") String tfmTypeId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_FAMILY_URL + tfmTypeId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		int status = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode + "  status=" + status);
		if (statusCode == 200) {
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
		} else {
			resultsDate = new Result(false, "删除失败");
		}
		response.setContentType("text/html;charset=UTF-8");
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return ob.toString();
	}
    
    
	    @ApiOperation(value = "保存技术族信息", notes = "保存技术族信息")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name = "parentId",    value = "父节点id",  dataType = "string", paramType = "form",required=true),
	        @ApiImplicitParam(name = "typeName", value = "分类名称", dataType = "string", paramType = "form",required=true),
	        @ApiImplicitParam(name = "typeCode",   value = "分类编码", dataType = "string", paramType = "form",required=true)
	    })
	    @RequestMapping(method = RequestMethod.POST, value = "/techFamily-api/save")
		public String saetechFamily(@RequestBody  TechFamily techFamily,HttpServletRequest request, HttpServletResponse response) throws Exception {

		    	Result resultsDate = new Result();
		    	JSONObject parma = JSONObject.parseObject(JSONObject.toJSONString(techFamily));
				System.out.println(">>>>>>>>>> 参数: "+parma.toJSONString());
				SysUser sysUserInfo = this.getUserProfile();
				String dateid = UUID.randomUUID().toString().replaceAll("-", "");
				techFamily.setTfmTypeId(dateid);
				techFamily.setStatus("1");
				techFamily.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
				techFamily.setIsParent("0");
				techFamily.setCreateUserId(sysUserInfo.getUserId());
				//处理知悉范围
				String userName=sysUserInfo.getUserName();
				String knowledgeScope=techFamily.getKnowledgeScope();
				String knowledgePerson=techFamily.getKnowledgePerson();
				if(knowledgeScope==null || "".equals(knowledgeScope))
				{
					techFamily.setKnowledgeScope(userName);
					techFamily.setKnowledgePerson(sysUserInfo.getUserDisp()); 
				}else 
				{
					if(!knowledgeScope.contains(userName))
					{
						techFamily.setKnowledgeScope(knowledgeScope+","+userName);
						techFamily.setKnowledgePerson(knowledgePerson+","+sysUserInfo.getUserDisp());
					}else
					{
						techFamily.setKnowledgeScope(knowledgeScope);
						techFamily.setKnowledgePerson(knowledgePerson);
					}
				}
				ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_FAMILY, HttpMethod.POST, new HttpEntity<TechFamily>(techFamily, this.httpHeaders), String.class);
				int statusCode = responseEntity.getStatusCodeValue();
				String dataId = responseEntity.getBody();
				// 返回结果代码
				if (statusCode == 200) {
					resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
				} else {
					resultsDate = new Result(false, "保存专家信息失败");
				}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
			return result.toString();
	    }
	
	

	/**
	  * 获取专家专利（分页）
	 */
    @ApiOperation(value = "获取技术族列表（分页）", notes = "获取技术族列表（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",                value = "页码", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit",               value = "每页显示条数", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "typeName",            value = "专家ID", dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "tfmTypeId",           value = "分类id", dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "typeCode",            value = "分类编码", dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "parentId",            value = "父节点id", dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "parentCode",          value = "父节点编码", dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "levelCode",           value = "层级", dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "typeIndex",           value = "检索辅助字段", dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "isCloudParentId",     value = "参数如有parentId时，是否包含parentId本身", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/techFamily-api/page", method = RequestMethod.POST)
	public String getExpertPage(
			

			@RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) String typeName,
            @RequestParam(required = false) String tfmTypeId,
            @RequestParam(required = false) String typeCode,
            @RequestParam(required = false) String parentId,
            @RequestParam(required = false) String parentCode,
            @RequestParam(required = false) String levelCode,
            @RequestParam(required = false) String typeIndex,
            @RequestParam(required = false) String isCloudParentId,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
     {

    	LayuiTableParam param =new LayuiTableParam();
    	param.getParam().put("typeName", typeName);
    	param.getParam().put("tfmTypeId", tfmTypeId);
    	param.getParam().put("typeCode", typeCode);
    	param.getParam().put("parentId", parentId);
    	param.getParam().put("parentCode", parentCode);
    	param.getParam().put("levelCode", levelCode);
    	param.getParam().put("typeIndex", typeIndex);
    	param.getParam().put("status", "1");
    	param.getParam().put("isCloudParentId", isCloudParentId);
    	param.setLimit(limit);
    	param.setPage(page);
    	//默认查询小于等于用户密级的
    	SysUser sysUserInfo = this.getUserProfile();
    	param.getParam().put("userSecretLevel",sysUserInfo.getSecretLevel() );
    	param.getParam().put("knowledgeScope", sysUserInfo.getUserName());
    	
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(GET_FAMILY_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============获取技术族列表（分页） " + result.toString());
		return result.toString();
	}
    
    
    @ApiOperation(value = "查询技术族列表", notes = "查询技术族列表")
    @RequestMapping(value = "/techFamily-api/getFamilyList", method = RequestMethod.GET)
	public String getFamilyList(HttpServletRequest request, HttpServletResponse response)throws Exception
    {
    	    Result resultsDate = new Result();
            String parentId=CommonUtil.getParameter(request, "parentId", "");
            String levelCode=CommonUtil.getParameter(request, "levelCode", "");
            String typeIndex=CommonUtil.getParameter(request, "typeIndex", "");
            String status=CommonUtil.getParameter(request, "status", "");
    	    this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("typeIndex", typeIndex);
	   	    paramMap.put("levelCode", levelCode);
	   	    paramMap.put("parentId", parentId);
	   	    paramMap.put("status", status);
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_FAMILY_List_URL, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		
  	   		JSONArray jSONArray=null;
  	   		if (statusCode == 200)
  	   		{
  	   			jSONArray = responseEntity.getBody();
  	   		    resultsDate.setData(jSONArray);
  	   		}
  	      	 JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
  	   		 return result.toString();
	   		
	}
    
    
    
    
    
    @ApiOperation(value = "根据父ID查询技术族个数", notes = "根据父ID查询技术族个数")
    @RequestMapping(value = "/techFamily-api/getFamilyCountByParentId", method = RequestMethod.GET)
	public String getFamilyListByParentId(HttpServletRequest request, HttpServletResponse response)throws Exception
    {
    	    Result resultsDate = new Result();
    	    resultsDate.setData(0);
            String parentId=CommonUtil.getParameter(request, "parentId", "");
    	    this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   	    paramMap.put("parentId", parentId);
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_FAMILY_List_URL, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
  	   		JSONArray jSONArray=null;
  	   		if (statusCode == 200)
  	   		{
  	   			jSONArray = responseEntity.getBody();
  	   			if(jSONArray!=null)
  	   			{
  	   			  resultsDate.setData(jSONArray.size());
  	   			}
  	   		}
  	   	   JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
	   		 return result.toString();
	   		
	}
    
    
    @ApiOperation(value = "查询技术族(树)列表", notes = "查询技术族(树)列表")
    @RequestMapping(value = "/techFamily-api/getTreeNodeList", method = RequestMethod.GET)
	public String getTreeNodeList(HttpServletRequest request, HttpServletResponse response)throws Exception
    {
            String parentId=CommonUtil.getParameter(request, "parentId", "10");
            String levelCode=CommonUtil.getParameter(request, "levelCode", "");
            String typeIndex=CommonUtil.getParameter(request, "typeIndex", "");
            String isCloudParentId=CommonUtil.getParameter(request, "isCloudParentId", "");
            
            
            
            
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("typeIndex", typeIndex);
	   	    paramMap.put("levelCode", levelCode);
	   	    paramMap.put("parentId", parentId);
	   	    paramMap.put("isCloudParentId", isCloudParentId);
	   	    paramMap.put("status", "1");
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_FAMILY_TREE_URL, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
  	   		JSONArray jSONArray=null;
  	   		if (statusCode == 200)
  	   		{
  	   			jSONArray = responseEntity.getBody();
  	   		}
	   		return jSONArray.toString();
	   		
	}
    
    
    
	
	/**
	  *查询技术族列表
	 */
	@ApiOperation(value = "查询技术族-树形结构", notes = "查询技术-族树形结构")
	@RequestMapping(value = "/techFamily-api/getTreeList", method = RequestMethod.GET)
	public String getChildsListByCodeTree(HttpServletRequest request, HttpServletResponse response) throws Exception {

		TechFamily techType = new TechFamily();
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(TECH_TYPE_TREE_NODE, HttpMethod.POST,new HttpEntity<TechFamily>(techType, this.httpHeaders), JSONArray.class);
		JSONArray temparray = responseEntity.getBody();
		List<TechFamily> list = JSONObject.parseArray(temparray.toJSONString(), TechFamily.class);
		List<FormSelectNode> alllist =TreeUtils.treeNodeToSelectNodeList(list);
		JSONArray trreeJsovvn = JSONArray.parseArray(JSON.toJSONString(alllist));
		
		//System.out.println(">>>>>>>>>nodeList条数:"+trreeJsovvn.toString());		
		JSONObject trreeJson = JSONObject.parseObject(JSONObject.toJSONString(TreeUtils.recursiveTree(Constant.TECHFAMILY_ROOT_ID,alllist)));
		//System.out.println("-----------------树形结构："+trreeJson.toString());
		return trreeJson.toString();
	}
	
	
	
	
	
	
	@ApiOperation(value = "根据编码（多个）查询技术族列表", notes = "根据编码（多个）查询技术族列表")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "codes",           value = "编码(多个用逗号分开)", dataType = "string", paramType = "query",required=true)
    })
	@RequestMapping(value = "/techFamily-api/getListByCodes", method = RequestMethod.GET)
	public String getListByCodes( @RequestParam(required = true) String codes,HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
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
	
	
	
	
	  /**
		  *根据ID获取技术族信息详情
		 */
	    @ApiOperation(value = "根据ID获取技术族信息详情", notes = "根据ID获取技术族信息详情")
		@RequestMapping(value = "/techFamily-api/get/{id}", method = RequestMethod.GET)
		public String getTechFamilyById(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception 
	    {
	    	Result resultsDate = new Result();
	    	ResponseEntity<TechFamily> responseEntity = this.restTemplate.exchange(GET_FAMILY_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), TechFamily.class);
			int statusCode = responseEntity.getStatusCodeValue();
			TechFamily techFamily = responseEntity.getBody();
			logger.info("============远程返回  statusCode " + statusCode);
			if (statusCode == 200)
			{
				resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
				resultsDate.setData(techFamily);
			} else 
			{
				resultsDate = new Result(false, "根据ID获取技术族信息详情失败");
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
			return result.toString();
		}
	
	

}
