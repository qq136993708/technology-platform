package com.pcitc.web.expert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.expert.*;
import com.pcitc.service.expert.IAcademicianService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "Academician-API",tags = {"院士库院士相关的接口"})
@RestController
public class AcademicianProviderClient {
	
	
	private final static Logger logger = LoggerFactory.getLogger(AcademicianProviderClient.class);
	@Autowired
    private IAcademicianService academicianService;

	
	/**===============================================院士===================================================*/
	
	
	
	@ApiOperation(value = "人才转为院士", notes = "人才转为院士")
	@RequestMapping(value = "/academician/outPersonToZjkAcademicianBase", method = RequestMethod.POST)
	public Integer outPersonToZjkAcademicianBase(@RequestBody  Map map)throws Exception
	{

		JSONObject parma = JSONObject.parseObject(JSONObject.toJSONString(map));
		System.out.println(">>>>>>>>>>人才转为院士 参数: "+parma.toJSONString());
		Integer count=academicianService.outPersonToZjkAcademicianBase(map);
		return count;
	}
	
	
	
	
	
	
	@ApiOperation(value = "获取院士（分页）", notes = "获取院士（分页）")
	@RequestMapping(value = "/academician/page", method = RequestMethod.POST)
	public LayuiTableData getZjkAcademicianBaseList(@RequestBody LayuiTableParam param)throws Exception
	{
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(param));
		System.out.println("======== 获取院士参数: "+result.toString());
		return academicianService.getZjkAcademicianBasePage(param) ;
	}
	
	
	@ApiOperation(value = "获取院士", notes = "获取院士")
	@RequestMapping(value = "/academician/list", method = RequestMethod.POST)
	public JSONArray getZjkAcademicianBase_List(@RequestBody Map param)throws Exception
	{
		logger.info("=== ZjkAcademicianBase param============"+param);
		List list=academicianService.getZjkAcademicianBaseList(param);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	@ApiOperation(value = "获取院士个数", notes = "获取院士个数")
	@RequestMapping(value = "/academician/getZjkAcademicianBaseCount", method = RequestMethod.POST)
	public Integer getZjkAcademicianBaseCount()throws Exception
	{
		Integer count=academicianService.getZjkAcademicianBaseCount();
		return count;
	}
	
	

	
	@ApiOperation(value = "增加院士信息", notes = "增加院士信息")
	@RequestMapping(value = "/academician/add", method = RequestMethod.POST)
	public String insertZjkAcademicianBase(@RequestBody ZjkAcademicianBase ZjkAcademicianBase) throws Exception{
		logger.info("====================add ZjkAcademicianBase....========================");
		Integer count= academicianService.insertZjkAcademicianBase(ZjkAcademicianBase);
		return ZjkAcademicianBase.getId();
	}
	
	
	@ApiOperation(value = "修改院士信息", notes = "修改院士信息")
	@RequestMapping(value = "/academician/update", method = RequestMethod.POST)
	public Integer updateZjkAcademicianBase(@RequestBody ZjkAcademicianBase ZjkAcademicianBase) throws Exception{
		logger.info("==================update ZjkAcademicianBase===========================");
		return academicianService.updateZjkAcademicianBase(ZjkAcademicianBase);
	}
	
	@ApiOperation(value = "根据ID物理删除院士信息", notes = "根据ID删除院士信息")
	@RequestMapping(value = "/academician/delete/{id}", method = RequestMethod.POST)
	public int deleteZjkAcademicianBase(@PathVariable("id") String id)throws Exception{
		logger.info("=============================根据ID物理删除院士信息 ZjkAcademicianBase==="+id+"==============");
		return academicianService.deleteZjkAcademicianBase(id) ;
	}
	
	
	@ApiOperation(value = "根据ID逻辑删除院士信息", notes = "根据ID删除院士信息")
	@RequestMapping(value = "/academician/logic_delete/{id}", method = RequestMethod.POST)
	public int deleteLoginZjkAcademicianBase(@PathVariable("id") String id)throws Exception{
		logger.info("=============================根据ID逻辑删除院士信息 ZjkAcademicianBase==="+id+"==============");
		return academicianService.deleteLogicZjkAcademicianBase(id);
	}
	
	
	@ApiOperation(value = "根据ID获取院士信息详情", notes = "根据ID获取院士信息详情")
	@RequestMapping(value = "/academician/get/{id}", method = RequestMethod.GET)
	public ZjkAcademicianBase selectMeetingById(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get ZjkAcademicianBase id "+id+"===========");
		return academicianService.selectZjkAcademicianBase(id);
	}
	
	
	
	@ApiOperation(value = "根据ID获取院士详情", notes = "根据ID获取院士详情")
	@RequestMapping(value = "/academician/getByNum/{num}", method = RequestMethod.GET)
	public ZjkAcademicianBase getZjkAcademicianBaseByNum(@PathVariable(value = "num", required = true) String num) throws Exception {
		logger.info("===============================get getZjkAcademicianBaseByNum num "+num+"===========");
		return academicianService.getZjkAcademicianBaseByNum(num);
	}
	
	
	
	
	@ApiOperation(value = "导入院士信息", notes = "导入院士信息")
    @RequestMapping(value = "/academician/excel_input", method = RequestMethod.POST)
    public Result excel_input(@RequestBody List<ZjkAcademicianBase> list) throws Exception 
	{
		Result result=new Result();
        try {
            int count = academicianService.insertBatch(list);
            result.setSuccess(true);
        } catch (Exception e) {
        	 result.setSuccess(false);
        	 result.setMessage("导入院士信息失败");
            logger.error("导入院士信息失败", e);
        }
        return result;
    }
	
	
	
	
	
	
	
	
	
	
	
	@ApiOperation(value = "获取院士奖励（分页）", notes = "获取院士奖励（分页）")
	@RequestMapping(value = "/academician_reward/page", method = RequestMethod.POST)
	public LayuiTableData getZjkRewardList(@RequestBody LayuiTableParam param)throws Exception
	{
		
		logger.info("=== ZjkReward param============"+param);
		return academicianService.getZjkRewardPage(param) ;
	}
	
	@ApiOperation(value = "增加院士奖励信息", notes = "增加院士奖励信息")
	@RequestMapping(value = "/academician_reward/add", method = RequestMethod.POST)
	public String insertZjkReward(@RequestBody ZjkReward zjkReward) throws Exception{
		logger.info("====================add zjkReward....========================");
		Integer count= academicianService.insertZjkReward(zjkReward);
		return zjkReward.getId();
	}
	
	
	@ApiOperation(value = "修改院士奖励信息", notes = "修改院士奖励信息")
	@RequestMapping(value = "/academician_reward/update", method = RequestMethod.POST)
	public Integer updateZjkReward(@RequestBody ZjkReward zjkReward) throws Exception{
		logger.info("==================update ZjkReward===========================");
		return academicianService.updateZjkReward(zjkReward);
	}
	
	@ApiOperation(value = "根据ID物理删除院士奖励信息", notes = "根据ID删除院士奖励信息")
	@RequestMapping(value = "/academician_reward/delete/{id}", method = RequestMethod.POST)
	public int deleteZjkReward(@PathVariable("id") String id)throws Exception{
		logger.info("=============================根据ID物理删除院士奖励信息 ZjkReward==="+id+"==============");
		return academicianService.deleteZjkReward(id) ;
	}
	
	
	@ApiOperation(value = "根据ID逻辑删除院士奖励信息", notes = "根据ID删除院士奖励信息")
	@RequestMapping(value = "/academician_reward/logic_delete/{id}", method = RequestMethod.POST)
	public int deleteLoginZjkReward(@PathVariable("id") String id)throws Exception{
		logger.info("=============================根据ID逻辑删除院士奖励信息 ZjkReward==="+id+"==============");
		return academicianService.deleteLogicZjkReward(id);
	}
	
	
	@ApiOperation(value = "根据ID获取院士奖励信息详情", notes = "根据ID获取院士奖励信息详情")
	@RequestMapping(value = "/academician_reward/get/{id}", method = RequestMethod.GET)
	public ZjkReward selectZjkRewardId(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get ZjkReward id "+id+"===========");
		return academicianService.selectZjkReward(id);
	}


	@ApiOperation(value = "获取院士项目（分页）", notes = "获取院士项目（分页）")
	@RequestMapping(value = "/academician_project/page", method = RequestMethod.POST)
	public LayuiTableData getZjkProjectList(@RequestBody LayuiTableParam param)throws Exception
	{
		
		logger.info("=== ZjkProject param============"+param);
		return academicianService.getZjkProjectPage(param) ;
	}
	
	@ApiOperation(value = "增加院士项目信息", notes = "增加院士项目信息")
	@RequestMapping(value = "/academician_project/add", method = RequestMethod.POST)
	public String insertZjkProject(@RequestBody ZjkProject zjkProject) throws Exception{
		logger.info("====================add ZjkProject....========================");
		Integer count= academicianService.insertZjkProject(zjkProject);
		return zjkProject.getId();
	}
	
	
	@ApiOperation(value = "修改院士项目信息", notes = "修改院士项目信息")
	@RequestMapping(value = "/academician_project/update", method = RequestMethod.POST)
	public Integer updateZjkProject(@RequestBody ZjkProject zjkProject) throws Exception{
		logger.info("==================update ZjkProject===========================");
		return academicianService.updateZjkProject(zjkProject);
	}
	
	@ApiOperation(value = "根据ID物理删除院士项目信息", notes = "根据ID删除院士项目信息")
	@RequestMapping(value = "/academician_project/delete/{id}", method = RequestMethod.POST)
	public int deleteZjkProject(@PathVariable("id") String id)throws Exception{
		logger.info("=============================根据ID物理删除院士项目信息 ZjkProject==="+id+"==============");
		return academicianService.deleteZjkProject(id) ;
	}
	
	
	@ApiOperation(value = "根据ID逻辑删除院士项目信息", notes = "根据ID删除院士项目信息")
	@RequestMapping(value = "/academician_project/logic_delete/{id}", method = RequestMethod.POST)
	public int deleteLoginZjkProject(@PathVariable("id") String id)throws Exception{
		logger.info("=============================根据ID逻辑删除院士项目信息 ZjkProject==="+id+"==============");
		return academicianService.deleteLogicZjkProjectById(id);
	}
	
	
	@ApiOperation(value = "根据ID获取院士项目信息详情", notes = "根据ID获取院士项目信息详情")
	@RequestMapping(value = "/academician_project/get/{id}", method = RequestMethod.GET)
	public ZjkProject selectZjkProjectId(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get ZjkProject id "+id+"===========");
		return academicianService.selectZjkProject(id);
	}
	
	
	
	
	
	
	
	


	@ApiOperation(value = "获取院士专利（分页）", notes = "获取院士专利（分页）")
	@RequestMapping(value = "/academician_patent/page", method = RequestMethod.POST)
	public LayuiTableData getZjkPatentList(@RequestBody LayuiTableParam param)throws Exception
	{
		
		logger.info("=== ZjkPatent param============"+param);
		return academicianService.getZjkPatentPage(param) ;
	}
	
	@ApiOperation(value = "增加院士专利信息", notes = "增加院士专利信息")
	@RequestMapping(value = "/academician_patent/add", method = RequestMethod.POST)
	public String insertZjkPatent(@RequestBody ZjkPatent zjkPatent) throws Exception{
		logger.info("====================add ZjkPatent....========================");
		Integer count= academicianService.insertZjkPatent(zjkPatent);
		return zjkPatent.getId();
	}
	
	
	@ApiOperation(value = "修改院士专利信息", notes = "修改院士专利信息")
	@RequestMapping(value = "/academician_patent/update", method = RequestMethod.POST)
	public Integer updateZjkPatent(@RequestBody ZjkPatent zjkPatent) throws Exception{
		logger.info("==================update zjkPatent===========================");
		return academicianService.updateZjkPatent(zjkPatent);
	}
	
	@ApiOperation(value = "根据ID物理删除院士专利信息", notes = "根据ID删除院士专利信息")
	@RequestMapping(value = "/academician_patent/delete/{id}", method = RequestMethod.POST)
	public int deleteZjkPatent(@PathVariable("id") String id)throws Exception{
		logger.info("=============================根据ID物理删除院士专利信息 ZjkPatent==="+id+"==============");
		return academicianService.deleteZjkPatent(id) ;
	}
	
	
	@ApiOperation(value = "根据ID逻辑删除院士专利信息", notes = "根据ID删除院士专利信息")
	@RequestMapping(value = "/academician_patent/logic_delete/{id}", method = RequestMethod.POST)
	public int deleteLoginZjkPatent(@PathVariable("id") String id)throws Exception{
		logger.info("=============================根据ID逻辑删除院士专利信息==="+id+"==============");
		return academicianService.deleteLogicZjkPatentById(id);
	}
	
	
	@ApiOperation(value = "根据ID获取院士专利信息详情", notes = "根据ID获取院士专利信息详情")
	@RequestMapping(value = "/academician_patent/get/{id}", method = RequestMethod.GET)
	public ZjkPatent selectZjkPatentId(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get ZjkPatent id "+id+"===========");
		return academicianService.selectZjkPatent(id);
	}
	
	
	@ApiOperation(value = "批量保存-院士专利", notes = "批量保存-院士专利")
	@RequestMapping(value = "/academician_patent/insertBatchZjkPatent", method = RequestMethod.POST)
	public Integer insertBatchZjkPatent(@RequestBody String jsonStr) throws Exception 
    {
    	
		System.out.println("======insertBatchZjkPatent===========" + jsonStr);
		List<ZjkPatent> list = JSONObject.parseArray(jsonStr, ZjkPatent.class);
		academicianService.deleteAllZjkPatent();
		return academicianService.insertBatchZjkPatent(list);

	}


	@ApiOperation(value = "获取院士成果（分页）", notes = "获取院士成果（分页）")
	@RequestMapping(value = "/academician_achievement/page", method = RequestMethod.POST)
	public LayuiTableData getZjkAchievementList(@RequestBody LayuiTableParam param)throws Exception
	{
		
		logger.info("=== ZjkAchievement param============"+param);
		return academicianService.getZjkAchievementPage(param) ;
	}
	
	@ApiOperation(value = "增加院士成果信息", notes = "增加院士成果信息")
	@RequestMapping(value = "/academician_achievement/add", method = RequestMethod.POST)
	public String insertZjkAchievement(@RequestBody ZjkAchievement zjkAchievement) throws Exception{
		logger.info("====================add ZjkAchievement....========================");
		Integer count= academicianService.insertZjkAchievement(zjkAchievement);
		return zjkAchievement.getId();
	}
	
	
	@ApiOperation(value = "修改院士成果信息", notes = "修改院士成果信息")
	@RequestMapping(value = "/academician_achievement/update", method = RequestMethod.POST)
	public Integer updateZjkAchievement(@RequestBody ZjkAchievement zjkAchievement) throws Exception{
		logger.info("==================update zjkAchievement===========================");
		return academicianService.updateZjkAchievement(zjkAchievement);
	}
	
	@ApiOperation(value = "根据ID物理删除院士成果信息", notes = "根据ID删除院士成果信息")
	@RequestMapping(value = "/academician_achievement/delete/{id}", method = RequestMethod.POST)
	public int deleteZjkAchievement(@PathVariable("id") String id)throws Exception{
		logger.info("=============================根据ID物理删除院士成果信息 ZjkAchievement==="+id+"==============");
		return academicianService.deleteZjkAchievement(id) ;
	}
	
	
	@ApiOperation(value = "根据ID逻辑删除院士成果信息", notes = "根据ID删除院士成果信息")
	@RequestMapping(value = "/academician_achievement/logic_delete/{id}", method = RequestMethod.POST)
	public int deleteLoginZjkAchievement(@PathVariable("id") String id)throws Exception{
		logger.info("=============================根据ID逻辑删除院士成果信息==="+id+"==============");
		return academicianService.deleteLogicZjkAchievementById(id);
	}
	
	
	@ApiOperation(value = "根据ID获取院士成果信息详情", notes = "根据ID获取院士成果信息详情")
	@RequestMapping(value = "/academician_achievement/get/{id}", method = RequestMethod.GET)
	public ZjkAchievement selectZjkAchievementId(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get ZjkAchievement id "+id+"===========");
		return academicianService.selectZjkAchievement(id);
	}
	
	

	@ApiOperation(value = "获取院士奖惩（分页）", notes = "获取院士奖惩（分页）")
	@RequestMapping(value = "/academician_punish/page", method = RequestMethod.POST)
	public LayuiTableData getZjkRewardPunishList(@RequestBody LayuiTableParam param)throws Exception
	{
		
		logger.info("=== getZjkRewardPunishList param============"+param);
		return academicianService.getZjkRewardPunishPage(param) ;
	}
	
	@ApiOperation(value = "增加院士奖惩信息", notes = "增加院士奖惩信息")
	@RequestMapping(value = "/academician_punish/add", method = RequestMethod.POST)
	public String insertZjkRewardPunish(@RequestBody ZjkRewardPunish ZjkRewardPunish) throws Exception{
		logger.info("====================add getZjkRewardPunishList....========================");
		Integer count= academicianService.insertZjkRewardPunish(ZjkRewardPunish);
		return ZjkRewardPunish.getId();
	}
	
	@ApiOperation(value = "修改院士奖惩信息", notes = "修改院士奖惩信息")
	@RequestMapping(value = "/academician_punish/update", method = RequestMethod.POST)
	public Integer updateZjkRewardPunish(@RequestBody ZjkRewardPunish ZjkRewardPunish) throws Exception{
		logger.info("==================update getZjkRewardPunishList===========================");
		return academicianService.updateZjkRewardPunish(ZjkRewardPunish);
	}
	
	@ApiOperation(value = "根据ID物理删除院士奖惩信息", notes = "根据ID删除院士奖惩信息")
	@RequestMapping(value = "/academician_punish/delete/{id}", method = RequestMethod.POST)
	public int deleteZjkRewardPunish(@PathVariable("id") String id)throws Exception{
		logger.info("=============================根据ID物理删除院士奖惩信息 ZjkRewardPunish==="+id+"==============");
		return academicianService.deleteZjkRewardPunish(id) ;
	}
	
	
	@ApiOperation(value = "根据ID获取院士奖惩信息详情", notes = "根据ID获取院士奖惩信息详情")
	@RequestMapping(value = "/academician_punish/get/{id}", method = RequestMethod.GET)
	public ZjkRewardPunish selectZjkRewardPunishId(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get getZjkRewardPunishList id "+id+"===========");
		return academicianService.selectZjkRewardPunish(id);
	}
	
	
	@ApiOperation(value = "批量保存-院士奖惩", notes = "批量保存-院士奖惩")
	@RequestMapping(value = "/academician_punish/insertBatchPunish", method = RequestMethod.POST)
	public Integer insertBatchPunish(@RequestBody String jsonStr) throws Exception 
    {
    	
		System.out.println("==============insertBatchPunish=============" + jsonStr);
		List<ZjkRewardPunish> list = JSONObject.parseArray(jsonStr, ZjkRewardPunish.class);
		academicianService.deleteAllZjkRewardPunish();
		return academicianService.insertBatchZjkRewardPunish(list);

	}
	

}
