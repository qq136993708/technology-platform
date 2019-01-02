package com.pcitc.web.expert;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.ZjkTree;
import com.pcitc.base.expert.ZjkTreeExample;
import com.pcitc.service.expert.ZjkTreeService;
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
 * <p>Table: zjk_tree - 专家库-树</p>
 *
 * @since 2019-01-02 09:53:32
 */
@Api(value = "ZjkTreeClient-API", description = "专家库-树服务接口")
@RestController
public class ZjkTreeClient {
    private final static Logger logger = LoggerFactory.getLogger(ZjkTreeClient.class);

    @Autowired
    ZjkTreeService zjkTreeService;


    //参数查询
    @ApiOperation(value = "带参专家库-树查询列表", notes = "根据ID查询查询专家库-树信息,返回一个专家库-树的JSONObject对象")
    @RequestMapping(value = "/zjktree-provider/zjktree/zjktree_list_param", method = RequestMethod.POST)
    public JSONObject selectZjkTreeListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ZjkTree zjkTree = new ZjkTree();
            zjkTree.setId(id);
            List<ZjkTree> list = zjkTreeService.findZjkTreeList(zjkTree);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "专家库-树查询列表", notes = "自定义对象(条件)查询专家库-树信息,返回存储在JSONObject对象中的专家库-树列表")
    @RequestMapping(value = "/zjktree-provider/zjktree/zjktree_list", method = RequestMethod.POST)
    public JSONObject selectZjkTreeList(@RequestBody ZjkTree zjkTree) {
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkTree> list = zjkTreeService.findZjkTreeList(zjkTree);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }


    @ApiOperation(value = "查询专家库-树树形详情信息", notes = "按ID查询专家库-树详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/zjktree-provider/zjktree/get-zjktree/{id}", method = RequestMethod.POST)
    public ZjkTree getZjkTreeInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return zjkTreeService.getZjkTreeInfo(id);
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
    @ApiOperation(value = "查询(树)专家库-树信息", notes = "查询(树)专家库-树信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/zjktree-provider/zjktree/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return zjkTreeService.selectObjectByTree();
    }


    /**
     * 删除专家库-树-false
     *
     * @param zjkTreecId
     * @return
     */
    @ApiOperation(value = "伪删除专家库-树信息", notes = "按ID伪删除专家库-树信息,操作成功返回201")
    @RequestMapping(value = "/zjktree-provider/zjktree/del-zjktree/{zjkTreeId}")
    public Object deleteZjkTree(@PathVariable("zjkTreeId") String zjkTreecId) {
        return zjkTreeService.deleteZjkTree(zjkTreecId);
    }

    /**
     * 删除专家库-树-true
     *
     * @param zjkTreecId
     * @return
     */
    @ApiOperation(value = "删除专家库-树信息", notes = "按ID删除专家库-树信息,操作成功返回201")
    @RequestMapping(value = "/zjktree-provider/zjktree/del-zjktree-real/{zjkTreeId}", method = RequestMethod.POST)
    public Object deleteZjkTreeReal(@PathVariable("zjkTreeId") String zjkTreecId) {
        return zjkTreeService.deleteZjkTreeReal(zjkTreecId);
    }


    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询专家库-树信息-分页查询", notes = "查询专家库-树信息-分页查询,Object")
    @RequestMapping(value = "/zjktree-provider/zjktree/zjktree-page")
    public Object selectZjkTreeByPage(@RequestBody LayuiTableParam param) {
        return zjkTreeService.findZjkTreeByPage(param);
    }

    /**
     * 保存
     *
     * @param zjkTree
     * @return
     */
    @ApiOperation(value = "新增专家库-树信息", notes = "新增专家库-树信息,操作成功返回500")
    @RequestMapping(value = "/zjktree-provider/zjktree/save_zjktree", method = RequestMethod.POST)
    public int updateOrInsertZjkTree(@RequestBody ZjkTree zjkTree) {
        try {
            return zjkTreeService.updateOrInsertZjkTree(zjkTree);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }

    @ApiOperation(value = "工具-树形展示", notes = "树形展示,返回Result")
    @RequestMapping(value = "/zjktree-provider/zjktree/selectTrees", method = RequestMethod.POST)
    public JSONObject selectTrees(@RequestBody JSONObject jsonObject) {
        JSONObject retJson = new JSONObject();
        try {
            retJson = zjkTreeService.selectTree(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

}
