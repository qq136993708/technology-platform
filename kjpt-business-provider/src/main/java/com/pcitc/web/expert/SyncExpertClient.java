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
import com.pcitc.base.expert.ZjkBookSync;
import com.pcitc.base.expert.ZjkPatentSync;
import com.pcitc.base.expert.ZjkRewardPunishSync;
import com.pcitc.base.expert.ZjkRewardSync;
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
    @RequestMapping(value = "/getZjkBaseSyncList", method = RequestMethod.POST)
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
    @ApiOperation(value = "批量保存专家", notes = "批量保存专家")
  	@RequestMapping(value = "/insertBatchZjkBaseSync", method = RequestMethod.POST)
  	public Integer insertBatchZjkBaseSync(@RequestBody String jsonStr) throws Exception 
      {
      	
  		System.out.println("insertBatchZjkBaseSync==================" + jsonStr);
  		List<ZjkBaseSync> list = JSONObject.parseArray(jsonStr, ZjkBaseSync.class);
  		expertSynService.deleteAllZjkSync();
  		return expertSynService.insertBatchZjkBaseSync(list);

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
    
    
    @ApiOperation(value = "批量保存专利", notes = "批量保存专利")
	@RequestMapping(value = "/insertBatchPatent", method = RequestMethod.POST)
	public Integer insertBatchPatent(@RequestBody String jsonStr) throws Exception 
    {
    	
		System.out.println("insertBatchPatent==================" + jsonStr);
		List<ZjkPatentSync> list = JSONObject.parseArray(jsonStr, ZjkPatentSync.class);
		expertSynService.deleteAllPatentSync();
		return expertSynService.insertBatchPatent(list);

	}
    
    
    
    
    
    
    
    
    
    
    @ApiOperation(value = "根据主键获取一个奖励的信息", notes = "根据主键获取一个奖励的信息")
    @RequestMapping(value = "/getReward/{id}", method = RequestMethod.GET)
    public ZjkRewardSync selectZjkRewardSync(@PathVariable String id)throws Exception{
    	return expertSynService.selectZjkRewardSync(id);
    }

    @ApiOperation(value = "科研奖励保存", notes = "科研奖励保存")
    @RequestMapping(value = "/saveReward", method = RequestMethod.POST)
    public Integer insertZjkRewardSync(@RequestBody ZjkRewardSync record)throws Exception{
        return	expertSynService.insertZjkRewardSync(record);
    }


    @ApiOperation(value = "查询科研奖励列表", notes = "查询科研奖励列表")
    @RequestMapping(value = "/queryReward", method = RequestMethod.POST)
    public LayuiTableData queryZjkRewardSync(@RequestBody(required = false) LayuiTableParam param)throws Exception{
    	return expertSynService.getZjkRewardSyncPage(param);
    }

    @ApiOperation(value = "查询奖励信息列表", notes = "查询奖励信息列表")
    @RequestMapping(value = "/getZjkRewardSyncList", method = RequestMethod.POST)
    public JSONArray getZjkRewardSyncList(@RequestBody(required = false) Map map)throws Exception{
        List list=expertSynService.getZjkRewardSyncList(map);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }


    @ApiOperation(value = "科研奖励删除", notes = "科研奖励删除")
    @RequestMapping(value = "/deleteZjkRewardSync/{id}", method = RequestMethod.DELETE)
    public Integer deleteZjkRewardSync(@PathVariable String id)throws Exception{
    	return expertSynService.deleteZjkRewardSync(id);
    }
    
    
    @ApiOperation(value = "批量保存奖励", notes = "批量保存奖励")
	@RequestMapping(value = "/insertBatchReward", method = RequestMethod.POST)
	public Integer insertBatchZjkRewardSync(@RequestBody String jsonStr) throws Exception 
    {
    	
		System.out.println("insertBatchZjkRewardSync==================" + jsonStr);
		List<ZjkRewardSync> list = JSONObject.parseArray(jsonStr, ZjkRewardSync.class);
		expertSynService.deleteAllReward();
		return expertSynService.insertBatchRewardSync(list);

	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    @ApiOperation(value = "根据主键获取一个论著的信息", notes = "根据主键获取一个论著的信息")
    @RequestMapping(value = "/getBookSync/{id}", method = RequestMethod.GET)
    public ZjkBookSync selectZjkBookSync(@PathVariable String id)throws Exception{
    	return expertSynService.selectZjkBookSync(id);
    }

    @ApiOperation(value = "科研论著保存", notes = "科研论著保存")
    @RequestMapping(value = "/saveBookSync", method = RequestMethod.POST)
    public Integer insertZjkBookSync(@RequestBody ZjkBookSync record)throws Exception{
        return	expertSynService.insertZjkBookSync(record);
    }


    @ApiOperation(value = "查询科研论著列表", notes = "查询科研论著列表")
    @RequestMapping(value = "/queryBookSync", method = RequestMethod.POST)
    public LayuiTableData queryZjkBookSync(@RequestBody(required = false) LayuiTableParam param)throws Exception{
    	return expertSynService.getZjkBookSyncPage(param);
    }

    @ApiOperation(value = "查询论著信息列表", notes = "查询论著信息列表")
    @RequestMapping(value = "/getBookSyncList", method = RequestMethod.POST)
    public JSONArray getZjkBookSyncList(@RequestBody(required = false) Map map)throws Exception{
        List list=expertSynService.getZjkBookSyncList(map);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }


    @ApiOperation(value = "科研论著删除", notes = "科研论著删除")
    @RequestMapping(value = "/deleteBookSync/{id}", method = RequestMethod.DELETE)
    public Integer deleteZjkBookSync(@PathVariable String id)throws Exception{
    	return expertSynService.deleteZjkBookSync(id);
    }
    
    
    @ApiOperation(value = "批量保存论著", notes = "批量保存论著")
	@RequestMapping(value = "/insertBatchBookSync", method = RequestMethod.POST)
	public Integer insertBatchBookSync(@RequestBody String jsonStr) throws Exception 
    {
    	
		System.out.println("======insertBatchBookSync===========" + jsonStr);
		List<ZjkBookSync> list = JSONObject.parseArray(jsonStr, ZjkBookSync.class);
		expertSynService.deleteAllBookSync();
		return expertSynService.insertBatchBookSync(list);

	}
    
    
    
    
    
    
    
    
    
    
    
    
    @ApiOperation(value = "根据主键获取一个奖惩的信息", notes = "根据主键获取一个奖惩的信息")
    @RequestMapping(value = "/getPunishSync/{id}", method = RequestMethod.GET)
    public ZjkRewardPunishSync selectZjkRewardPunishSync(@PathVariable String id)throws Exception{
    	return expertSynService.selectZjkRewardPunishSync(id);
    }

    @ApiOperation(value = "科研奖惩保存", notes = "科研奖惩保存")
    @RequestMapping(value = "/savePunishSSync", method = RequestMethod.POST)
    public Integer insertZjkRewardPunishSync(@RequestBody ZjkRewardPunishSync record)throws Exception{
        return	expertSynService.insertZjkRewardPunishSync(record);
    }


    @ApiOperation(value = "查询科研奖惩列表", notes = "查询科研奖惩列表")
    @RequestMapping(value = "/queryPunishSSync", method = RequestMethod.POST)
    public LayuiTableData queryZjkRewardPunishSync(@RequestBody(required = false) LayuiTableParam param)throws Exception{
    	return expertSynService.getZjkRewardPunishSyncPage(param);
    }

    @ApiOperation(value = "查询奖惩信息列表", notes = "查询奖惩信息列表")
    @RequestMapping(value = "/getPunishSSyncList", method = RequestMethod.POST)
    public JSONArray getZjkRewardPunishSyncList(@RequestBody(required = false) Map map)throws Exception{
        List list=expertSynService.getZjkRewardPunishSyncList(map);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }


    @ApiOperation(value = "科研奖惩删除", notes = "科研奖惩删除")
    @RequestMapping(value = "/deletePunishSSync/{id}", method = RequestMethod.DELETE)
    public Integer deleteZjkRewardPunishSync(@PathVariable String id)throws Exception{
    	return expertSynService.deleteZjkRewardPunishSync(id);
    }
    
    
    @ApiOperation(value = "批量保存奖惩", notes = "批量保存奖惩")
	@RequestMapping(value = "/insertBatchPunishSync", method = RequestMethod.POST)
	public Integer insertBatchPunishSync(@RequestBody String jsonStr) throws Exception 
    {
    	
		System.out.println("======insertBatchPunishSync===========" + jsonStr);
		List<ZjkRewardPunishSync> list = JSONObject.parseArray(jsonStr, ZjkRewardPunishSync.class);
		expertSynService.deleteAllBookSync();
		return expertSynService.insertBatchPunishSync(list);

	}
    
    
    
    
}
