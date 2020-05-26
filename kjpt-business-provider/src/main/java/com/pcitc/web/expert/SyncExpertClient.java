package com.pcitc.web.expert;

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
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkBaseSync;
import com.pcitc.base.expert.ZjkPatentSync;
import com.pcitc.service.expert.IExpertSynService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "expert-sync-api", description = "专家临时表接口")
@RestController
@RequestMapping(value = "/sync-expert-api")
public class SyncExpertClient {

    @Autowired
    private IExpertSynService  expertSynService;

    @ApiOperation(value = "根据主键获取一个专家的信息", notes = "根据主键获取一个专家的信息")
    @RequestMapping(value = "/getZjkBase/{id}", method = RequestMethod.GET)
    public ZjkBaseSync getZjkBaseSync(@PathVariable String id)throws Exception{
    	return expertSynService.selectZjkBaseSync(id);
    }

    @ApiOperation(value = "科研专家保存", notes = "科研专家保存")
    @RequestMapping(value = "/saveZjkBase", method = RequestMethod.POST)
    public Integer saveZjkBaseSync(@RequestBody ZjkBaseSync record)throws Exception{
        return	expertSynService.insertZjkBaseSync(record);
    }


    @ApiOperation(value = "查询科研专家列表", notes = "查询科研专家列表")
    @RequestMapping(value = "/queryZjkBase", method = RequestMethod.POST)
    public LayuiTableData queryZjkBaseSync(@RequestBody(required = false) LayuiTableParam param)throws Exception{
    	return expertSynService.getZjkBaseSyncPage(param);
    }

    @ApiOperation(value = "查询专家信息列表", notes = "查询专家信息列表")
    @RequestMapping(value = "/getZjkBaseList", method = RequestMethod.POST)
    public JSONArray getZjkBaseSyncList(@RequestBody(required = false) Map map)throws Exception{
        List list=expertSynService.getZjkBaseSyncList(map);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }


    @ApiOperation(value = "科研专家删除", notes = "科研专家删除")
    @RequestMapping(value = "/deleteZjkBaseSync/{id}", method = RequestMethod.DELETE)
    public Integer deleteZjkBaseSync(@PathVariable String id)throws Exception{
    	return expertSynService.deleteZjkBaseSync(id);
    }
    
    
    
    
    @ApiOperation(value = "根据主键获取一个专利的信息", notes = "根据主键获取一个专利的信息")
    @RequestMapping(value = "/getPatent/{id}", method = RequestMethod.GET)
    public ZjkPatentSync selectZjkPatentSync(@PathVariable String id)throws Exception{
    	return expertSynService.selectZjkPatentSync(id);
    }

    @ApiOperation(value = "科研专利保存", notes = "科研专利保存")
    @RequestMapping(value = "/savePatent", method = RequestMethod.POST)
    public Integer insertZjkPatentSync(@RequestBody ZjkPatentSync record)throws Exception{
        return	expertSynService.insertZjkPatentSync(record);
    }


    @ApiOperation(value = "查询科研专利列表", notes = "查询科研专利列表")
    @RequestMapping(value = "/queryPatent", method = RequestMethod.POST)
    public LayuiTableData query(@RequestBody(required = false) LayuiTableParam param)throws Exception{
    	return expertSynService.getZjkPatentSyncPage(param);
    }

    @ApiOperation(value = "查询专利信息列表", notes = "查询专利信息列表")
    @RequestMapping(value = "/getZjkPatentList", method = RequestMethod.POST)
    public JSONArray getZjkPatentSyncList(@RequestBody(required = false) Map map)throws Exception{
        List list=expertSynService.getZjkPatentSyncList(map);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }


    @ApiOperation(value = "科研专利删除", notes = "科研专利删除")
    @RequestMapping(value = "/deleteZjkPatent/{id}", method = RequestMethod.DELETE)
    public Integer deleteZjkPatentSync(@PathVariable String id)throws Exception{
    	return expertSynService.deleteZjkPatentSync(id);
    }
    
    
    
    @ApiOperation(value = "批量保存专家", notes = "批量保存专家")
	@RequestMapping(value = "/insertBatchZjkBaseSync", method = RequestMethod.POST)
	public Integer insertBatchZjkBaseSync(@RequestBody String jsonStr) throws Exception 
    {
    	
		System.out.println("insertBatchZjkBaseSync==================" + jsonStr);
		List<ZjkBaseSync> list = JSONObject.parseArray(jsonStr, ZjkBaseSync.class);
		expertSynService.deleteAllZjkSync();
		return expertSynService.insertBatchZjkBaseSync(list);

	}
    
    
    
    @ApiOperation(value = "批量保存专利", notes = "批量保存专利")
	@RequestMapping(value = "/insertBatchPatent", method = RequestMethod.POST)
	public Integer insertBatchPatent(@RequestBody String jsonStr) throws Exception 
    {
    	
		System.out.println("insertBatchPatent==================" + jsonStr);
		List<ZjkPatentSync> list = JSONObject.parseArray(jsonStr, ZjkPatentSync.class);
		expertSynService.deleteAllPatentSync();
		return expertSynService.insertBatchPatent(list);

	}
    
}
