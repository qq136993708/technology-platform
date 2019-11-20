package com.pcitc.web.controller.techFamily;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "SysDictionary-API",tags = {"共用-字典接口"})
@RestController
public class SysDictionaryApiController extends BaseController {
	
	
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
        *    递归算法解析成树形结构
   */
	public SysDictionary recursiveTree(String cid, List allList)
	{
		SysDictionary node = getSysDictionary(cid,  allList);
		// 查询cid下的所有子节点(SELECT * FROM tb_tree t WHERE t.pid=?)
		List<SysDictionary> childTreeNodes = getChlids(cid,  allList);
		// 遍历子节点
		for (SysDictionary child : childTreeNodes)
		{
			SysDictionary n = recursiveTree(child.getId(), allList); // 递归
			node.getChildNodes().add(n);
		}
		return node;
	}
	public SysDictionary getSysDictionary(String id, List<SysDictionary> allList)
	{
		SysDictionary sd=null;
		for(int i=0;i<allList.size();i++)
		{
			SysDictionary sysDictionary=allList.get(i);
			if(sysDictionary.getId().equals(id))
			{
				sd=sysDictionary;
			}
		}
		return sd;
	}
	
	public List<SysDictionary>  getChlids(String id, List<SysDictionary> allList)
	{
		List<SysDictionary>  list=new ArrayList<SysDictionary>();
		for(int i=0;i<allList.size();i++)
		{
			SysDictionary sysDictionary=allList.get(i);
			if(sysDictionary.getParentId().equals(id))
			{
				list.add(sysDictionary);
			}
		}
		return list;
	}
	

}
