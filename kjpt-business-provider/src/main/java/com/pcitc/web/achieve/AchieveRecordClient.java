package com.pcitc.web.achieve;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveBase;
import com.pcitc.base.achieve.AchieveRecord;
import com.pcitc.base.achieve.AchieveSubmit;
import com.pcitc.base.common.Result;
import com.pcitc.base.workflow.Constants;
import com.pcitc.service.achieve.AchieveBaseService;
import com.pcitc.service.achieve.AchieveRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>成果转换备案</p>
 * @author ty
 */

@Api(value = "achieveRecord-api", description = "成果转换备案备案接口")
@RestController
@RequestMapping(value = "/achieveRecord-api")
public class AchieveRecordClient {
    @Autowired
    private AchieveRecordService ars;
    @ApiOperation(value = "load成果转换备案备案接口", notes = "load成果转换备案备案接口")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public AchieveRecord load(@PathVariable String id){
        return ars.load(id);
    }

    @ApiOperation(value = "成果转换备案保存", notes = "成果转换备案保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody AchieveSubmit as){
         ars.save(as);
    }

    @ApiOperation(value = "成果转换备案简单保存", notes = "成果转换备案简单保存")
    @RequestMapping(value = "/simpleSave", method = RequestMethod.POST)
    public void simpleSave(@RequestBody AchieveSubmit as){
         ars.simpleSave(as);
    }


    @ApiOperation(value = "查询成果转换备案列表分页", notes = "查询成果转换备案列表分页")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return ars.query(param);
    }

    @ApiOperation(value = "辅助决策成果转化明细", notes = "辅助决策成果转化明细")
    @RequestMapping(value = "/queryAchieveSubsidiarity", method = RequestMethod.POST)
    public PageInfo queryAchieveSubsidiarity(@RequestBody(required = false) Map param){
        return ars.queryAchieveSubsidiarity(param);
    }



    @ApiOperation(value = "成果转换备案删除", notes = "成果转换备案删除")
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String ids){
         return ars.delete(ids);
    }


    @ApiOperation(value = "查询成果不分页", notes = "查询成果不分页")
    @RequestMapping(value = "/queryNoPage", method = RequestMethod.POST)
    public JSONArray queryNoPage(@RequestBody(required = false) Map param){
        List list=ars.queryNoPage(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }



    @ApiOperation(value = "导出成果转化明细表", notes = "导出成果转化明细表")
    @RequestMapping(value = "/queryAchieveSubsidiarityExport", method = RequestMethod.POST)
    public JSONArray queryAchieveSubsidiarityExport(@RequestBody(required = false) Map param){
        List list=ars.queryAchieveSubsidiarityExport(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }


    
    

	
	@ApiOperation(value="流程处理-成果转化备案上报",notes="流程处理-成果转化备案上报")
	@RequestMapping(value = "/task/start_activity/{id}", method = RequestMethod.POST)
	public Result dealWorkFlow(@PathVariable("id") String id,@RequestBody Map map)throws Exception 
	{
		return ars.dealWorkFlow(id,map);
	}
	
	
	@ApiOperation(value="流程处理-驳回",notes="流程处理-驳回")
	@RequestMapping(value = "/task/reject/{id}", method = RequestMethod.POST)
	public Integer taskRejectSreProjectTaskInner(@PathVariable(value = "id", required = true) String id)throws Exception {
		
		AchieveRecord ar=ars.load(id); 
		ar.setAuditStatus(String.valueOf(Constants.FLOW_STATE_SAVE)); 
		int count=ars.saveAchieveRecord(ar);
		return count;
	}
	
	@ApiOperation(value="流程处理-同意",notes="流程处理-同意")
	@RequestMapping(value = "/task/agree/{id}", method = RequestMethod.POST)
	public Integer taskAgreeSreProjectTaskInner(@PathVariable(value = "id", required = true) String id)throws Exception {
		
		System.out.println(">>>>>taskAgreeSreProjectTaskInner>>id="+id);
		AchieveRecord ar=ars.load(id);
		ar.setAuditStatus(String.valueOf(Constants.FLOW_STATE_DONE));
		int count=ars.saveAchieveRecord(ar) ;
		return count;
	}
	

}
