package com.pcitc.web.controller.techFamily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.base.stp.techFamily.TechFamilys;
import com.pcitc.base.util.CommonUtil;
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
	
	
	/**
	 * 获取技术族树
	 */
	private static final String NODE_LIST_TECH_URL = "http://kjpt-zuul/stp-proxy/tech-family-provider/getNodeList";
	/**
	 * 根据ID获取对象信息
	 */
	public static final String ADD_TECH_URL = "http://kjpt-zuul/stp-proxy/tech-family-provider/add";

	/**
	 * 根据ID获取对象信息
	 */
	public static final String UPDATE_TECH_URL = "http://kjpt-zuul/stp-proxy/tech-family-provider/update";
	
	/**
	 * 根据ID删除
	 */
	private static final String DEL_TECH_URL = "http://kjpt-zuul/stp-proxy/tech-family-provider/delete/";
	
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String GET_TECH_URL = "http://kjpt-zuul/stp-proxy/tech-family-provider/get/";

	/**
	 * 根据ID查询下级技术族个数
	 */
	private static final String GET_CHILD_TECH_COUNT = "http://kjpt-zuul/stp-proxy/tech-family-provider/getChildCount/";
	
	/**
	 * 获取下级技术（分页）
	 */
	private static final String PAGE_TECH_URL = "http://kjpt-zuul/stp-proxy/tech-family-provider/getChildslist";
	
	
	
	
	
	/**
	  * 获取技术族（分页）
	 */
    @ApiOperation(value = "获取下级技术族列表（分页）", notes = "获取下级技术族列表（分页）")
    @ApiImplicitParams({
       @ApiImplicitParam(name = "page",           value = "页码", dataType = "string", paramType = "query"),
       @ApiImplicitParam(name = "limit",          value = "每页显示条数", dataType = "string", paramType = "query"),
       @ApiImplicitParam(name = "parentId",       value = "专父节点id", dataType = "string", paramType = "query")
       
    })
    @RequestMapping(value = "/techFamily-api/getChildslist", method = RequestMethod.POST)
	public String getExpertPage(
			

			@RequestParam(required = false) Integer page,
           @RequestParam(required = false) Integer limit,
           @RequestParam(required = false) String parentId,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
    {

   	LayuiTableParam param =new LayuiTableParam();
   	param.getParam().put("parentId", parentId);
   	param.setLimit(limit);
   	param.setPage(page);
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_TECH_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============获取技术族列表（分页） " + result.toString());
		return result.toString();
	}

	
	

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 *             获取技术族分类树，异步方法
	 */
	 @ApiOperation(value = "获取技术族分类树", notes = "获取技术族分类树")
	@RequestMapping(value = "/techFamily-api/getNodeTree", method = RequestMethod.GET)
	@ResponseBody
	public String getNodeTree(HttpServletRequest request) throws Exception {
		TechFamily techType = new TechFamily();
		ResponseEntity<List> responseEntity = this.restTemplate.exchange(NODE_LIST_TECH_URL, HttpMethod.POST, new HttpEntity<TechFamily>(techType, this.httpHeaders), List.class);
		List<TreeNode> treeNodes = responseEntity.getBody();
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(treeNodes));

		System.out.println("----"+json.toString().replaceAll("\\\\", ""));
		return JSONUtils.toJSONString(treeNodes);
	}
	
	
	
	    @ApiOperation(value = "根据ID查询下级技术族个数", notes = "根据ID查询下级技术族个数")
	    @RequestMapping(value = "/techFamily-api/getChildCount/{id}", method = RequestMethod.GET)
		public String getChildCount(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
	    	
	    	Result resultsDate = new Result();
	    	Integer count =0;
	    	ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(GET_CHILD_TECH_COUNT+ id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) 
			{
				count = responseEntity.getBody();
			}
			resultsDate.setData(count);
			JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
			return ob.toString();
	    }
	
	
	
	 /**
	  * 删除技术族
	 */
   @ApiOperation(value = "根据ID删除技术族信息", notes = "根据ID删除技术族信息")
	@RequestMapping(value = "/techFamily-api/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_TECH_URL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
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
   
   
   /**
	  *根据ID获取技术族信息详情
	 */
   @ApiOperation(value = "根据ID获取技术族信息详情", notes = "根据ID获取技术族信息详情")
	@RequestMapping(value = "/techFamily-api/getTechFamilysById/{id}", method = RequestMethod.GET)
	public String getExpert(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
   	Result resultsDate = new Result();
   	ResponseEntity<TechFamilys> responseEntity = this.restTemplate.exchange(GET_TECH_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), TechFamilys.class);
		int statusCode = responseEntity.getStatusCodeValue();
		TechFamilys ZjkReward = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode);
		if (statusCode == 200) {
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			resultsDate.setData(ZjkReward);
		} else {
			resultsDate = new Result(false, "根据ID获取技术族信息详情失败");
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
	}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   @ApiOperation(value = "保存技术族信息", notes = "保存技术族信息")
   @ApiImplicitParams({
       @ApiImplicitParam(name = "id",        value = "主键",     dataType = "string", paramType = "form"),
       @ApiImplicitParam(name = "techNamne", value = "分类名称",  dataType = "string", paramType = "form",required=true),
       @ApiImplicitParam(name = "parentId",  value = "父节点id", dataType = "string", paramType = "form",required=true),
       @ApiImplicitParam(name = "orders",    value = "排序字段",  dataType = "string", paramType = "form"),
       @ApiImplicitParam(name = "levelCode", value = "层级",     dataType = "string", paramType = "form")
   })
  
   @RequestMapping(method = RequestMethod.POST, value = "/techFamily-api/save")
	public String saveExpert(@RequestBody  TechFamilys zjkBase,HttpServletRequest request, HttpServletResponse response) throws Exception {

	   	Result resultsDate = new Result();
	   	String id=zjkBase.getId();
	   	
	   	JSONObject parma = JSONObject.parseObject(JSONObject.toJSONString(zjkBase));
		System.out.println(">>>>>>>>>> 参数: "+parma.toJSONString());
		
		if (id!=null && !id.equals("")) 
		{
			ResponseEntity<TechFamilys> se = this.restTemplate.exchange(GET_TECH_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), TechFamilys.class);
			TechFamilys oldTechFamilys = se.getBody();
			oldTechFamilys.setTechNamne(zjkBase.getTechNamne());
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_TECH_URL, HttpMethod.POST, new HttpEntity<TechFamilys>(oldTechFamilys, this.httpHeaders), Integer.class);
			int statusCode = responseEntity.getStatusCodeValue();
			Integer dataId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}
		} else 
		{
			zjkBase.setCreateTime(new Date());
			zjkBase.setDelStatus(Constant.DEL_STATUS_NOT);
			String dateid = UUID.randomUUID().toString().replaceAll("-", "");
			zjkBase.setId(dateid);
			
			ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_TECH_URL, HttpMethod.POST, new HttpEntity<TechFamilys>(zjkBase, this.httpHeaders), String.class);
			int statusCode = responseEntity.getStatusCodeValue();
			String dataId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, "保存专家信息失败");
			}
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
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
		
		System.out.println(">>>>>>>>>nodeList条数:"+trreeJsovvn.toString());		
		JSONObject trreeJson = JSONObject.parseObject(JSONObject.toJSONString(TreeUtils.recursiveTree(Constant.TECHFAMILY_ROOT_ID,alllist)));
		System.out.println("-----------------树形结构："+trreeJson.toString());
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
