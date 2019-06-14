package com.pcitc.web.system;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.pcitc.base.stp.system.SysMeeting;
import com.pcitc.service.system.SysMeetingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "SysMeeting-API",tags = {"会议纪要"})
@RestController
public class SysMeetingProvideClient {
	

	private final static Logger logger = LoggerFactory.getLogger(SysMeetingProvideClient.class); 
	
	@Autowired
    private SysMeetingService sysMeetingService; 
	
	
	@ApiOperation(value = "会议纪要分页", notes = "会议纪要分页")
	@RequestMapping(value = "/system-provider/sys_meeting/page", method = RequestMethod.POST)
	public LayuiTableData getSysMeetingList(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=sysMeetingService.getSysMeetingPage(param) ;
		return rageResult;
	}
	
	

	@ApiOperation(value = "会议纪要列表", notes = "会议纪要列表")
	@RequestMapping(value = "/system-provider/sys_meeting/list", method = RequestMethod.POST)
	public JSONArray getSysMeeting_List(@RequestBody Map map)throws Exception{
		logger.info("============================getSysMeeting_List列表 =================");
		List<SysMeeting> list= sysMeetingService.getSysMeetingListByMap(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	@ApiOperation(value = "增加会议纪要", notes = "增加会议纪要")
	@RequestMapping(value = "/system-provider/sys_meeting/add", method = RequestMethod.POST)
	public String insertSysMeeting(@RequestBody SysMeeting SysMeeting) throws Exception{
		logger.info("====================add SysMeeting....========================");
		Integer count= sysMeetingService.insertSysMeeting(SysMeeting) ;
		return SysMeeting.getId();
	}
	
	
	@ApiOperation(value = "修改会议纪要", notes = "修改会议纪要")
	@RequestMapping(value = "/system-provider/sys_meeting/update", method = RequestMethod.POST)
	public Integer updateSysMeeting(@RequestBody SysMeeting SysMeeting) throws Exception{
		logger.info("==================update SysMeeting===========================");
		return sysMeetingService.updateSysMeeting(SysMeeting);
	}
	
	
	@RequestMapping(value = "/system-provider/sys_meeting/delete/{id}", method = RequestMethod.POST)
	public int deleteSysMeeting(@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete SysMeeting=================");
		return sysMeetingService.deleteSysMeeting(id);
	}
	
	
	
	@ApiOperation(value = "获取会议纪要", notes = "根据ID获取会议纪要")
	@RequestMapping(value = "/system-provider/sys_meeting/get/{id}", method = RequestMethod.GET)
	public SysMeeting selectUserByUserId(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get SysMeeting id "+id+"===========");
		return sysMeetingService.selectSysMeeting(id);
	}
	
}
