package com.pcitc.web.out;

import java.util.HashMap;
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
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.out.OutProject;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.service.out.IOutProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "OutProject-API",tags = {"外系统-项目接口"})
@RestController
public class OutProjectProviderClient {
	
	
	private final static Logger logger = LoggerFactory.getLogger(OutProjectProviderClient.class); 
	@Autowired
    private IOutProjectService outProjectService; 
	
	
	
	
	
	
	@ApiOperation(value = "查询技术族-项目热点", notes = "查询技术族-项目热点")
    @RequestMapping(value = "/out_project/getHotByTypeIndex", method = RequestMethod.POST)
    public JSONObject getHotByTypeIndex(@RequestBody Map map) {
        JSONObject retJson = new JSONObject();
        JSONObject obj = new JSONObject();
        obj.put("typeIndex", String.valueOf(map.get("typeIndex")));
        try {
            retJson = outProjectService.getHotByTypeIndex(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }
	
	
	@ApiOperation(value = "获取项目列表", notes = "获取项目列表")
	@RequestMapping(value = "/out_project/list", method = RequestMethod.POST)
	public JSONArray getOutProjectList(@RequestBody Map map)throws Exception {
		
		List<OutProject> list=	outProjectService.getOutProjectList(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	@ApiOperation(value = "批量插入项目", notes = "批量插入项目")
	@RequestMapping(value = "/out_project/insertBatch", method = RequestMethod.POST)
	public int insertBatch(@RequestBody JSONArray jSONArray)throws Exception {
		List<OutProject> list = JSONObject.parseArray(jSONArray.toJSONString(), OutProject.class);
		return	outProjectService.insertBatch(list);
	}
	
	
	
	
	
	@ApiOperation(value = "获取项目（分页）", notes = "获取项目（分页）")
	@RequestMapping(value = "/out_project/page", method = RequestMethod.POST)
	public LayuiTableData getOutProjectList(@RequestBody LayuiTableParam param)throws Exception
	{
		
		logger.info("=== OutProject param============"+param);
		return outProjectService.getOutProjectPage(param) ;
	}
	
	@ApiOperation(value = "增加项目信息", notes = "增加项目信息")
	@RequestMapping(value = "/out_project/add", method = RequestMethod.POST)
	public String insertOutProject(@RequestBody OutProject outProject) throws Exception{
		logger.info("====================add OutProject....========================");
		Integer count= outProjectService.insertOutProject(outProject);
		return outProject.getId();
	}
	
	
	@ApiOperation(value = "修改项目信息", notes = "修改项目信息")
	@RequestMapping(value = "/out_project/update", method = RequestMethod.POST)
	public Integer updateOutProject(@RequestBody OutProject outProject) throws Exception{
		logger.info("==================update OutProject===========================");
		return outProjectService.updateOutProject(outProject);
	}
	
	@ApiOperation(value = "根据ID物理删除项目信息", notes = "根据ID删除项目信息")
	@RequestMapping(value = "/out_project/delete/{id}", method = RequestMethod.POST)
	public int deleteOutProject(@PathVariable("id") String id)throws Exception{
		logger.info("=============================根据ID物理删除项目信息 OutProject==="+id+"==============");
		return outProjectService.deleteOutProject(id) ;
	}
	
	
	
	@ApiOperation(value = "根据ID获取项目信息详情", notes = "根据ID获取项目信息详情")
	@RequestMapping(value = "/out_project/get/{id}", method = RequestMethod.GET)
	public OutProject selectOutProjectId(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get OutProject id "+id+"===========");
		return outProjectService.selectOutProject(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
