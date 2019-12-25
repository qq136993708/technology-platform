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
