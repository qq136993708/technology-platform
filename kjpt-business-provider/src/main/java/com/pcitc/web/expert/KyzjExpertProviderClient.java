package com.pcitc.web.expert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.expert.KyzjExpert;
import com.pcitc.service.expert.IKyzjExpertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "KyzjExpert-API",tags = {"科研专家维护相关的接口"})
@RestController
public class KyzjExpertProviderClient {
	
	
	private final static Logger logger = LoggerFactory.getLogger(KyzjExpertProviderClient.class);
	@Autowired
    private IKyzjExpertService kyzjExpertService;
	

	@ApiOperation(value = "获取科研专家（分页）", notes = "获取科研专家（分页）")
	@RequestMapping(value = "/kyzjExpert/page", method = RequestMethod.POST)
	public LayuiTableData getKyzjExpertList(@RequestBody LayuiTableParam param)throws Exception
	{
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(param));
		System.out.println("======== 获取科研专家参数: "+result.toString());
		return kyzjExpertService.getKyzjExpertPage(param) ;
	}
	
	
	@ApiOperation(value = "获取科研专家", notes = "获取科研专家")
	@RequestMapping(value = "/kyzjExpert/list", method = RequestMethod.POST)
	public JSONArray getKyzjExpert_List(@RequestBody Map param)throws Exception
	{
		logger.info("=== KyzjExpert param============"+param);
		List list=kyzjExpertService.getKyzjExpertList(param);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	@ApiOperation(value = "获取科研专家个数", notes = "获取科研专家个数")
	@RequestMapping(value = "/kyzjExpert/getKyzjExpertCount", method = RequestMethod.POST)
	public Integer getKyzjExpertCount()throws Exception
	{
		Integer count=kyzjExpertService.getKyzjExpertCount();
		return count;
	}
	
	@ApiOperation(value = "增加科研专家信息", notes = "增加科研专家信息")
	@RequestMapping(value = "/kyzjExpert/add", method = RequestMethod.POST)
	public String insertKyzjExpert(@RequestBody KyzjExpert kyzjExpert) throws Exception{
		logger.info("====================add kyzjExpert....========================");
		Integer count= kyzjExpertService.insertKyzjExpert(kyzjExpert);
		return kyzjExpert.getId();
	}
	
	
	@ApiOperation(value = "修改科研专家信息", notes = "修改科研专家信息")
	@RequestMapping(value = "/kyzjExpert/update", method = RequestMethod.POST)
	public Integer updateKyzjExpert(@RequestBody KyzjExpert kyzjExpert) throws Exception{
		logger.info("==================update kyzjExpert===========================");
		return kyzjExpertService.updateKyzjExpert(kyzjExpert);
	}
	
	@ApiOperation(value = "根据ID物理删除科研专家信息", notes = "根据ID删除科研专家信息")
	@RequestMapping(value = "/kyzjExpert/delete/{id}", method = RequestMethod.POST)
	public int deleteKyzjExpert(@PathVariable("id") String id)throws Exception{
		logger.info("=============================根据ID物理删除专家信息 zjkBase==="+id+"==============");
		return kyzjExpertService.deleteKyzjExpert(id) ;
	}
	
	
	@ApiOperation(value = "根据ID逻辑删除科研专家信息", notes = "根据ID删除科研专家信息")
	@RequestMapping(value = "/kyzjExpert/logic_delete/{id}", method = RequestMethod.POST)
	public int deleteLoginKyzjExpert(@PathVariable("id") String id)throws Exception{
		logger.info("=============================根据ID逻辑删除专家信息 kyzjExpert==="+id+"==============");
		return kyzjExpertService.deleteKyzjExpert(id);
	}
	
	
	@ApiOperation(value = "根据ID获取科研专家详情", notes = "根据ID获取专家信息详情")
	@RequestMapping(value = "/kyzjExpert/get/{id}", method = RequestMethod.GET)
	public KyzjExpert selectKyzjExpertById(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get KyzjExpert id "+id+"===========");
		return kyzjExpertService.selectZjkBase(id);
	}
	
	
	@ApiOperation(value = "导入科研专家信息", notes = "导入科研专家信息")
    @RequestMapping(value = "/kyzjExpert/excel_input", method = RequestMethod.POST)
    public Result excel_input(@RequestBody List<KyzjExpert> list) throws Exception
	{
		Result result=new Result();
        try {
            int count = kyzjExpertService.insertBatch(list);
            result.setSuccess(true);
        } catch (Exception e) {
        	 result.setSuccess(false);
        	 result.setMessage("导入科研专家信息失败");
            logger.error("导入科研专家信息失败", e);
        }
        return result;
    }

}
