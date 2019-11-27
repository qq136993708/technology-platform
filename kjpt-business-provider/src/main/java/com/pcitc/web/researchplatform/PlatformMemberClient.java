package com.pcitc.web.researchplatform;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformMemberModel;
import com.pcitc.service.researchplatform.PlatformMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>服务接口</p>
 * <p>科研平台-成员</p>
 * @author ty
 */

@Api(value = "researchPlatformMember-api", description = "国家科研平台成员接口")
@RestController
@RequestMapping(value = "/researchPlatformMember-api")
public class PlatformMemberClient {

    @Autowired
    private PlatformMemberService pms;

    @ApiOperation(value = "根据主键获取一个平台成员的信息", notes = "根据主键获取一个平台成员的信息")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public PlatformMemberModel load(@PathVariable String id){
        return pms.load(id);
    }

    @ApiOperation(value = "科研平台项目保存", notes = "科研平台项目保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public PlatformMemberModel save(@RequestBody PlatformMemberModel platformMemberModel){

        return pms.save(platformMemberModel);
    }

    @ApiOperation(value = "平台项目批量保存", notes = "平台项目批量保存")
    @RequestMapping(value = "/batchSave", method = RequestMethod.POST)
    public Integer batchSave(@RequestBody List<PlatformMemberModel> list){
        return pms.batchSave(list);
    }

    @ApiOperation(value = "查询科研平台项目列表", notes = "查询科研平台项目列表")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return pms.query(param);
    }


    @ApiOperation(value = "科研平台项目删除", notes = "科研平台项目删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id){
        return pms.delete(id);
    }


    @ApiOperation(value = "修改团队人员的角色", notes = "修改团队人员的角色")
    @RequestMapping(value = "/updateMemberRole", method = RequestMethod.POST)
    public Integer updateMemberRole(@RequestParam String ids,@RequestParam String role){
        return pms.updateMemberRole(ids,role);
    }
}
