package com.pcitc.service.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
