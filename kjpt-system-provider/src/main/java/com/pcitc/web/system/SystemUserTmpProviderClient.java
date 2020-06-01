package com.pcitc.web.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysUnitTmp;
import com.pcitc.base.system.SysUserTmp;
import com.pcitc.service.system.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "expert-sync-api", description = "用户临时表接口")
@RestController
@RequestMapping(value = "/user-tmp-api")
public class SystemUserTmpProviderClient {
	
	
	@Autowired
	private UserService userService;
	
    
    @ApiOperation(value = "根据主键获取用户", notes = "根据主键用户")
    @RequestMapping(value = "/getSysUserTmp/{id}", method = RequestMethod.GET)
    public SysUserTmp selectSysUserTmp(@PathVariable String id)throws Exception{
    	return userService.selectSysUserTmp(id);
    }

    @ApiOperation(value = "用户保存", notes = "用户保存")
    @RequestMapping(value = "/saveSysUserTmp", method = RequestMethod.POST)
    public Integer insertSysUserTmp(@RequestBody SysUserTmp record)throws Exception{
        return	userService.insertSysUserTmp(record);
    }


    @ApiOperation(value = "查询用户列表", notes = "查询用户列表")
    @RequestMapping(value = "/querySysUserTmp", method = RequestMethod.POST)
    public LayuiTableData querySysUserTmp(@RequestBody(required = false) LayuiTableParam param)throws Exception{
    	return userService.getSysUserTmpPage(param);
    }

    @ApiOperation(value = "查询用户信息列表", notes = "查询用户信息列表")
    @RequestMapping(value = "/getSysUserTmpList", method = RequestMethod.POST)
    public JSONArray getSysUserTmpList(@RequestBody(required = false) Map map)throws Exception{
        List list=userService.getSysUserTmpList(map);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }


    @ApiOperation(value = "用户删除", notes = "用户删除")
    @RequestMapping(value = "/deleteSysUserTmp/{id}", method = RequestMethod.DELETE)
    public Integer deleteSysUserTmp(@PathVariable String id)throws Exception{
    	return userService.deleteSysUserTmp(id);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    @ApiOperation(value = "根据主键获取组织机构", notes = "根据主键组织机构")
    @RequestMapping(value = "/getSysUnitTmp/{id}", method = RequestMethod.GET)
    public SysUnitTmp selectSysUnitTmp(@PathVariable String id)throws Exception{
    	return userService.selectSysUnitTmp(id);
    }

    @ApiOperation(value = "组织机构保存", notes = "组织机构保存")
    @RequestMapping(value = "/saveSysUnitTmp", method = RequestMethod.POST)
    public Integer insertSysUnitTmp(@RequestBody SysUnitTmp record)throws Exception{
        return	userService.insertSysUnitTmp(record);
    }


    @ApiOperation(value = "查询组织机构列表", notes = "查询组织机构列表")
    @RequestMapping(value = "/querySysUnitTmp", method = RequestMethod.POST)
    public LayuiTableData querySysUnitTmp(@RequestBody(required = false) LayuiTableParam param)throws Exception{
    	return userService.getSysUnitTmpPage(param);
    }

    @ApiOperation(value = "查询组织机构信息列表", notes = "查询组织机构信息列表")
    @RequestMapping(value = "/getSysUnitTmpList", method = RequestMethod.POST)
    public JSONArray getSysUnitTmpList(@RequestBody(required = false) Map map)throws Exception{
        List list=userService.getSysUnitTmpList(map);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }


    @ApiOperation(value = "组织机构删除", notes = "组织机构删除")
    @RequestMapping(value = "/deleteSysUnitTmp/{id}", method = RequestMethod.DELETE)
    public Integer deleteSysUnitTmp(@PathVariable String id)throws Exception{
    	return userService.deleteSysUnitTmp(id);
    }
    
    
    
    
    
    
    @ApiOperation(value = "查询组织机构树", notes = "查询组织机构树")
    @RequestMapping(value = "/getSysUnitTmpTreeNodeList", method = RequestMethod.POST)
	public JSONArray getSysUnitTmpTreeNodeList(@RequestBody Map map)throws Exception
    {
    	List<TreeNode> list= userService.getTreeNodeList(map);
    	if(list!=null)
    	{
    		for (int i = 0; i < list.size(); i++) 
			{
				TreeNode tree = list.get(i);
				// 前几层默认打开
				if (tree.getLevelCode() < 2)
				{
					tree.setOpen("true");
				} else {
					tree.setOpen("false");
				}
				// 判断节点是否有孩子（异步加载用）
				/*
				 * if (tree.getParentFlag().equals("0")) { tree.setIsParent(false); } else {
				 * tree.setIsParent(true); }
				 */
			}
    	}
    	JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
    	return json;
	}
    
    
    
    
    
    
    

}
