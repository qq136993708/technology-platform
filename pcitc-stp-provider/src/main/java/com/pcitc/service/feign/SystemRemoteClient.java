package com.pcitc.service.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkExtractConfig;
import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysPost;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.workflow.WorkflowVo;

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
    @RequestMapping(value = "/out-project-plna-provider/project-plan/page/list", method = RequestMethod.POST)
	public LayuiTableData selectProjectPlanByCond(@RequestBody LayuiTableParam param);
    /**
     * 获取项目实际完成金额数据
     * @param param
     * @return
     */
	@RequestMapping(value = "/out-project-provider/common-project/list", method = RequestMethod.POST)
	public LayuiTableData selectCommonProjectByCond(@RequestBody LayuiTableParam param);
}
