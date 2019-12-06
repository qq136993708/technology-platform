package com.pcitc.web.achieve;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveBase;
import com.pcitc.base.common.Result;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.workflow.Constants;
import com.pcitc.service.achieve.AchieveBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>成果转化</p>
 * @author ty
 */

@Api(value = "achieve-api", description = "成果转化接口")
@RestController
@RequestMapping(value = "/achieve-api")
public class AchieveClient {
    @Autowired
    private AchieveBaseService abs;
    @ApiOperation(value = "load成果转换", notes = "load成果转换")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public AchieveBase load(@PathVariable String id){
        return abs.load(id);
    }

    @ApiOperation(value = "成果转换保存", notes = "成果转换保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody AchieveBase achieveBase){
         abs.save(achieveBase);
    }


    @ApiOperation(value = "查询成果转换列表分页", notes = "查询成果转换列表分页")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return abs.query(param);
    }



    @ApiOperation(value = "成果转换删除", notes = "成果转换删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id){
         return abs.delete(id);
    }
    
    
    
    
    
    
    
    
    

	
	@ApiOperation(value="流程处理-成果转化上报",notes="流程处理-成果转化上报")
	@RequestMapping(value = "/task/start_activity/{id}", method = RequestMethod.POST)
	public Result dealWorkFlow(@PathVariable("id") String id,@RequestBody Map map)throws Exception 
	{
		return abs.dealWorkFlow(id,map);
	}
	
	
	@ApiOperation(value="流程处理-驳回",notes="流程处理-驳回")
	@RequestMapping(value = "/task/reject/{id}", method = RequestMethod.POST)
	public Integer taskRejectSreProjectTaskInner(@PathVariable(value = "id", required = true) String id)throws Exception {
		
		AchieveBase achieveBase=abs.load(id);
		achieveBase.setAuditStatus(String.valueOf(Constants.FLOW_STATE_SAVE)); 
		int count=abs.save(achieveBase) ;
		return count;
	}
	
	@ApiOperation(value="流程处理-同意",notes="流程处理-同意")
	@RequestMapping(value = "/task/agree/{id}", method = RequestMethod.POST)
	public Integer taskAgreeSreProjectTaskInner(@PathVariable(value = "id", required = true) String id)throws Exception {
		
		AchieveBase achieveBase=abs.load(id);
		achieveBase.setAuditStatus(String.valueOf(Constants.FLOW_STATE_DONE));
		int count=abs.save(achieveBase) ;
		return count;
	}
	

}
