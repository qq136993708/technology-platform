package com.pcitc.service.feign;

import java.util.List;
import java.util.Set;

import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectInfoExample;
import com.pcitc.base.system.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkExtractConfig;
import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.base.stp.system.SysMeeting;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysPost;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.workflow.WorkflowVo;

import io.swagger.annotations.ApiOperation;

@FeignClient(value = "pcitc-system-provider", fallback = SystemHystric.class)
public interface SystemRemoteClient {
    @RequestMapping(value = "/workflow-provider/workflow/start/id", method = RequestMethod.POST)
    public String startWorkflowByProcessDefinitionId(@RequestBody WorkflowVo workflowVo);

    @RequestMapping(value = "/user-provider/user/get-user-bypostcode/{postCode}", method = RequestMethod.POST)
    public List<SysUser> selectUsersByPostCode(@PathVariable(value = "postCode", required = true) String postCode);

    @RequestMapping(value = "/post-provider/post/get-post-bycode/{postCode}", method = RequestMethod.POST)
    public SysPost getSysPostByCode(@PathVariable(value = "postCode", required = true) String postCode);
    /**
     * 字典-根据父编码获取子集
     * @param parentCode
     * @return
     */
    @RequestMapping(value = "/dictionary-provider/dictionary/{parentCode}", method = RequestMethod.POST)
    public List<SysDictionary> getDictionaryListByParentCode(@PathVariable(value = "parentCode", required = false) String parentCode);
    
    @RequestMapping(value = "/out-unit-provider/project-unit/list-bydefine2/{define2}", method = RequestMethod.POST)
	public List<OutUnit> selectProjectUnits(@PathVariable("define2") String define2);

    @RequestMapping(value = "/zjkextractconfig-provider/zjkextractconfig/get-zjkextractconfig/{id}", method = RequestMethod.POST)
    public ZjkExtractConfig getZjkExtractConfigInfo(@PathVariable(value = "id", required = true) String id);
   
	/**
	 * 获取项目计划数据
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "/out-project-plan-provider/project-plan/page/list", method = RequestMethod.POST)
	public LayuiTableData selectProjectPlanByCond(@RequestBody LayuiTableParam param);
    /**
     * 获取项目实际完成金额数据
     * @param param
     * @return
     */
	@RequestMapping(value = "/out-project-provider/common-project/list", method = RequestMethod.POST)
	public LayuiTableData selectCommonProjectByCond(@RequestBody LayuiTableParam param);
	
	
	
	
	//增加会议纪要
	@RequestMapping(value = "/system-provider/sys_meeting/add", method = RequestMethod.POST)
	public String insertSysMeeting(@RequestBody SysMeeting sysMeeting);
	
	//查询成果信息
    @RequestMapping(value = "/out-provider/appraisal-list", method = RequestMethod.POST)
    public LayuiTableData getOutAppraisalListPage(@RequestBody LayuiTableParam param) throws Exception;
    //查询专利信息
    @RequestMapping(value = "/out-patent-provider/outpatent_list", method = RequestMethod.POST)
    public LayuiTableData selectOutPatentList(@RequestBody LayuiTableParam param);
    //查询奖励信息
    @RequestMapping(value = "/out-provider/reward-list", method = RequestMethod.POST)
    public LayuiTableData getOutRewardListPage(@RequestBody LayuiTableParam param) throws Exception;
    //查询课题信息
    @RequestMapping(value = "/out-provider/project-list-expert", method = RequestMethod.POST)
    public LayuiTableData getOutProjectListPageExpert(@RequestBody LayuiTableParam param) throws Exception;
    //自定义查询项目信息
//    @RequestMapping(value = "/out-provider/selectByExample", method = RequestMethod.POST)
//    public List<OutProjectInfo> selectByExample(OutProjectInfoExample example) throws Exception;


    //根据菜单URL查询菜单信息
    @RequestMapping(value = "/function-provider/get-by-url", method = RequestMethod.POST)
    public SysFunction getFunctionByUrl(@RequestBody String url);
    @RequestMapping(value = "/out-provider/selectByExample", method = RequestMethod.POST)
    public List<OutProjectInfo> selectByExample(@RequestBody OutProjectInfoExample example) throws Exception;
    //自定义查询index课题信息
    @RequestMapping(value = "/indexoutprojectinfo-provider/indexoutprojectinfo/selectByExample", method = RequestMethod.POST)
    public List<IndexOutProjectInfo> selectByExampleKt(@RequestBody List<String> strings);
    //自定义查询index专利信息
    @RequestMapping(value = "/indexoutpatent-provider/indexoutpatent/selectByExample", method = RequestMethod.POST)
    public List<IndexOutPatent> selectByExampleZl(@RequestBody List<String> strings);
    //检索项目负责单位信息
    @RequestMapping(value = "/out-provider/select-project-unit", method = RequestMethod.POST)
	public List<OutProjectInfo> selectProjectUnit(@RequestBody OutProjectInfo example);

    @RequestMapping(value = "/out-unit-provider/project-unit/list-by-unitcodes", method = RequestMethod.POST)
	public List<OutUnit> selectProjectUnitsByCodes(@RequestBody Set<String> unitIds);
}
