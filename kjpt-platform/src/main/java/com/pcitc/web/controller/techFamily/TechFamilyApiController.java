package com.pcitc.web.controller.techFamily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.FormSelectNode;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.web.common.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "TechFamily-API",tags = {"技术族-接口"})
@RestController
public class TechFamilyApiController extends BaseController{
	
	private static final String TECH_TYPE_TREE = "http://kjpt-zuul/stp-proxy/tech-family-provider/type-tree";
	
	
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
		
		
		List<FormSelectNode> alllist =treeNodeToSelectNodeList(list);
		
		
		JSONArray trreeJsovvn = JSONArray.parseArray(JSON.toJSONString(alllist));
		
		System.out.println(">>>>>>>>>nodeList条数:"+trreeJsovvn.toString());		
		JSONObject trreeJson = JSONObject.parseObject(JSONObject.toJSONString(recursiveTree(Constant.TECHFAMILY_ROOT_ID,alllist)));
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
	
	
	
	
	
	
	
	
	public List<FormSelectNode> treeNodeToSelectNodeList(List<TechFamily> alllist)
	{
		
		List<FormSelectNode> reslutList=new ArrayList();
		for(int i=0;i<alllist.size();i++)
		{
			TechFamily node=alllist.get(i);
			FormSelectNode formSelectNode=new FormSelectNode();
			formSelectNode.setpId(node.getParentId());
			formSelectNode.setCode(node.getTypeCode());
			formSelectNode.setId(node.getTfmTypeId());
			formSelectNode.setLevelCode(node.getLevelCode());
			formSelectNode.setValue(node.getTypeCode());
			formSelectNode.setName(node.getTypeName());
			formSelectNode.setParentId(node.getParentId());
			reslutList.add(formSelectNode);
			
		}
		return reslutList;
	}
	
	

	   /**
	        *    递归算法解析成树形结构
	   */
		public FormSelectNode recursiveTree(String cid, List<FormSelectNode> allList)
		{
			FormSelectNode node = getSysDictionary(cid,  allList);
			// 查询cid下的所有子节点(SELECT * FROM tb_tree t WHERE t.pid=?)
			List<FormSelectNode> childTreeNodes = getChlids(cid,  allList);
			// 遍历子节点
			for (FormSelectNode child : childTreeNodes)
			{
				FormSelectNode n = recursiveTree(child.getId(), allList); // 递归
				node.getChildren().add(n) ;
			}
			return node;
		}
		public FormSelectNode getSysDictionary(String id, List<FormSelectNode> allList)
		{
			FormSelectNode sd=null;
			for(int i=0;i<allList.size();i++)
			{
				FormSelectNode sysDictionary=allList.get(i);
				if(sysDictionary.getId().equals(id))
				{
					sd=sysDictionary;
				}
			}
			return sd;
		}
		
		public List<FormSelectNode>  getChlids(String id, List<FormSelectNode> allList)
		{
			List<FormSelectNode>  list=new ArrayList<FormSelectNode>();
			for(int i=0;i<allList.size();i++)
			{
				FormSelectNode sysDictionary=allList.get(i);
				String parentId=sysDictionary.getParentId();
				if(parentId!=null)
				{
					if(parentId.equals(id))
					{
						list.add(sysDictionary);
					}
				}
				
			}
			return list;
		}
		
	
	

}
