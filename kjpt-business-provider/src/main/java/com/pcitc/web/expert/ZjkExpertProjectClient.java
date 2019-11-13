package com.pcitc.web.expert;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.ZjkExpertProject;
import com.pcitc.base.expert.ZjkExpertProjectExample;
import com.pcitc.service.expert.ZjkExpertProjectService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;
import java.util.List;

/**
 * <p>服务接口</p>
 * <p>Table: zjk_expert_project - 专家库-科研项目</p>
 *
 * @since 2019-04-02 04:42:39
 */
@Api(value = "ZjkExpertProjectClient-API", description = "专家库-科研项目服务接口")
@RestController
public class ZjkExpertProjectClient {
    private final static Logger logger = LoggerFactory.getLogger(ZjkExpertProjectClient.class);

    @Autowired
    ZjkExpertProjectService zjkExpertProjectService;

    //参数查询
    @ApiOperation(value = "带参专家库-科研项目查询列表", notes = "根据ID查询查询专家库-科研项目信息,返回一个专家库-科研项目的JSONObject对象")
    @RequestMapping(value = "/zjkexpertproject-provider/zjkexpertproject/zjkexpertproject_list_param", method = RequestMethod.POST)
    public JSONObject selectZjkExpertProjectListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ZjkExpertProject zjkExpertProject = new ZjkExpertProject();
            zjkExpertProject.setId(id);
            List<ZjkExpertProject> list = zjkExpertProjectService.findZjkExpertProjectList(zjkExpertProject);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "专家库-科研项目查询列表", notes = "自定义对象(条件)查询专家库-科研项目信息,返回存储在JSONObject对象中的专家库-科研项目列表")
    @RequestMapping(value = "/zjkexpertproject-provider/zjkexpertproject/zjkexpertproject_list", method = RequestMethod.POST)
    public JSONObject selectZjkExpertProjectList(@RequestBody ZjkExpertProject zjkExpertProject) {
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkExpertProject> list = zjkExpertProjectService.findZjkExpertProjectList(zjkExpertProject);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询专家库-科研项目树形详情信息", notes = "按ID查询专家库-科研项目详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/zjkexpertproject-provider/zjkexpertproject/get-zjkexpertproject/{id}", method = RequestMethod.POST)
    public ZjkExpertProject getZjkExpertProjectInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return zjkExpertProjectService.getZjkExpertProjectInfo(id);
        } catch (Exception e) {
            logger.error("[初始化信息失败：]", e);
        }
        return null;
    }

    /**
     * 树形展示
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询(树)专家库-科研项目信息", notes = "查询(树)专家库-科研项目信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/zjkexpertproject-provider/zjkexpertproject/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return zjkExpertProjectService.selectObjectByTree();
    }

    /**
     * 删除专家库-科研项目-false
     *
     * @param zjkExpertProjectcId
     * @return
     */
    @ApiOperation(value = "伪删除专家库-科研项目信息", notes = "按ID伪删除专家库-科研项目信息,操作成功返回201")
    @RequestMapping(value = "/zjkexpertproject-provider/zjkexpertproject/del-zjkexpertproject/{zjkExpertProjectId}")
    public Object deleteZjkExpertProject(@PathVariable("zjkExpertProjectId") String zjkExpertProjectcId) {
        return zjkExpertProjectService.deleteZjkExpertProject(zjkExpertProjectcId);
    }

    /**
     * 删除专家库-科研项目-true
     *
     * @param zjkExpertProjectcId
     * @return
     */
    @ApiOperation(value = "删除专家库-科研项目信息", notes = "按ID删除专家库-科研项目信息,操作成功返回201")
    @RequestMapping(value = "/zjkexpertproject-provider/zjkexpertproject/del-zjkexpertproject-real/{zjkExpertProjectId}", method = RequestMethod.POST)
    public Object deleteZjkExpertProjectReal(@PathVariable("zjkExpertProjectId") String zjkExpertProjectcId) {
        return zjkExpertProjectService.deleteZjkExpertProjectReal(zjkExpertProjectcId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询专家库-科研项目信息-分页查询", notes = "查询专家库-科研项目信息-分页查询,Object")
    @RequestMapping(value = "/zjkexpertproject-provider/zjkexpertproject/zjkexpertproject-page")
    public Object selectZjkExpertProjectByPage(@RequestBody LayuiTableParam param) {
        return zjkExpertProjectService.findZjkExpertProjectByPage(param);
    }

    /**
     * 保存
     *
     * @param zjkExpertProject
     * @return
     */
    @ApiOperation(value = "新增专家库-科研项目信息", notes = "新增专家库-科研项目信息,操作成功返回500")
    @RequestMapping(value = "/zjkexpertproject-provider/zjkexpertproject/save_zjkexpertproject", method = RequestMethod.POST)
    public int updateOrInsertZjkExpertProject(@RequestBody ZjkExpertProject zjkExpertProject) {
        try {
            return zjkExpertProjectService.updateOrInsertZjkExpertProject(zjkExpertProject);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
