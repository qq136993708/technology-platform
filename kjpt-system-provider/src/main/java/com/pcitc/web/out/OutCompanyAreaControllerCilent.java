package com.pcitc.web.out;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.service.out.OutCompanyAreaService;

@Api(value = "OUTPROJECT-API", description = "项目数据，从项目管理系统中获取")
@RestController
public class OutCompanyAreaControllerCilent {

	@Autowired
	private OutCompanyAreaService outCompanyAreaService;
	
	private final static Logger logger = LoggerFactory.getLogger(OutCompanyAreaControllerCilent.class);

	@ApiOperation(value = "分页显示项目数据", notes = "分页显示项目数据")
	@RequestMapping(value = "/out-provider/company-list", method = RequestMethod.POST)
	public LayuiTableData getCompanyListPage(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page getCompanyListPage===========================" + param);
		return outCompanyAreaService.getCompanyListPage(param);
	}
	
	/*@ApiOperation(value = "修改项目数据", notes = "项目的级别、项目属性等属性修改")
	@RequestMapping(value = "/out-provider/update-project", method = RequestMethod.POST)
	public String updateOutProject(@RequestBody JSONObject json) throws Exception {
		System.out.println("==-=-=-="+json);
		String projectLevel = json.getString("projectLevel");
		String projectProperty = json.getString("projectProperty");
		String projectAbc = json.getString("projectAbc");
		String projectSource = json.getString("projectSource");
		String dataId = json.getString("dataId");
		OutProjectInfo opi = new OutProjectInfo();
		
		opi.setDataId(dataId);
		opi.setProjectLevel(projectLevel);
		opi.setProjectProperty(projectProperty);
		opi.setProjectAbc(projectAbc);
		opi.setProjectSource(projectSource);
		outProjectService.updateOutProjectInfo(opi);
		return "1";
	}*/
    
	/**
	 * @author Nishikino
	 * 查询id
	 */
	/*@ApiOperation(value = "根据id查询详情", notes = "根据id查询详情")
	@RequestMapping(value = "/out-provider/get-project-list/{dataId}", method = RequestMethod.POST)
	public OutProjectInfo getOutProjectShow(@PathVariable(value = "dataId", required = true) String dataId) throws Exception{
		return outProjectService.getOutProjectShowById(dataId);
	}*/
}
