package com.pcitc.web.achieve;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveBase;
import com.pcitc.base.achieve.AchieveRecord;
import com.pcitc.base.achieve.AchieveReward;
import com.pcitc.base.common.Result;
import com.pcitc.base.workflow.Constants;
import com.pcitc.service.achieve.AchieveBaseService;
import com.pcitc.service.achieve.AchieveRewardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>成果转化-激励</p>
 * @author ty
 */

@Api(value = "achieveReward-api", description = "成果转化激励接口")
@RestController
@RequestMapping(value = "/achieveReward-api")
public class AchieveRewardClient {
    @Autowired
    private AchieveRewardService ars;
    @ApiOperation(value = "load成果转换激励", notes = "load成果转换激励")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public AchieveReward load(@PathVariable String id){
        return ars.load(id);
    }

    @ApiOperation(value = "成果转换激励保存", notes = "成果转换激励保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody AchieveReward achieveReward){
         ars.save(achieveReward);
    }


    @ApiOperation(value = "查询成果转换激励列表分页", notes = "查询成果转换列激励表分页")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return ars.query(param);
    }



    @ApiOperation(value = "成果转换激励删除", notes = "成果转换激励删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id){
         return ars.delete(id);
    }
    
    
    
    
    
    
    
    
    
    

	
	@ApiOperation(value="流程处理-激励方案上报",notes="流程处理-激励方案上报")
	@RequestMapping(value = "/task/start_activity/{id}", method = RequestMethod.POST)
	public Result dealWorkFlow(@PathVariable("id") String id,@RequestBody Map map)throws Exception 
	{
		return ars.dealWorkFlow(id,map);
	}
	
	
	@ApiOperation(value="流程处理-驳回",notes="流程处理-驳回")
	@RequestMapping(value = "/task/reject/{id}", method = RequestMethod.POST)
	public Integer taskreject(@PathVariable(value = "id", required = true) String id)throws Exception {
		
		AchieveReward ar=ars.load(id); 
		ar.setAuditStatus(String.valueOf(Constants.FLOW_STATE_SAVE)); 
		Integer count=ars.update(ar); 
		return count;
	}
	
	@ApiOperation(value="流程处理-同意",notes="流程处理-同意")
	@RequestMapping(value = "/task/agree/{id}", method = RequestMethod.POST)
	public Integer taskagree(@PathVariable(value = "id", required = true) String id)throws Exception {
		
		System.out.println(">>>>>taskagree>>id="+id);
		AchieveReward ar=ars.load(id);
		ar.setAuditStatus(String.valueOf(Constants.FLOW_STATE_DONE));
		Integer count=ars.update(ar) ;
		return count;
	}
	
	
	

}
