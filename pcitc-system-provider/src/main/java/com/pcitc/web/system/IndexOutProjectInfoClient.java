package com.pcitc.web.system;

import java.util.Date;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.system.IndexOutProjectInfo;
import com.pcitc.base.system.IndexOutProjectInfoExample;
import com.pcitc.service.system.IndexOutProjectInfoService;
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
 * <p>Table: index_out_project_info - 首页-科研项目</p>
 *
 * @since 2019-05-22 03:38:18
 */
@Api(value = "IndexOutProjectInfoClient-API", description = "首页-科研项目服务接口")
@RestController
public class IndexOutProjectInfoClient {
    private final static Logger logger = LoggerFactory.getLogger(IndexOutProjectInfoClient.class);

    @Autowired
    IndexOutProjectInfoService indexOutProjectInfoService;

    //参数查询
    @ApiOperation(value = "带参首页-科研项目查询列表", notes = "根据ID查询查询首页-科研项目信息,返回一个首页-科研项目的JSONObject对象")
    @RequestMapping(value = "/indexoutprojectinfo-provider/indexoutprojectinfo/indexoutprojectinfo_list_param", method = RequestMethod.POST)
    public JSONObject selectIndexOutProjectInfoListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            IndexOutProjectInfo indexOutProjectInfo = new IndexOutProjectInfo();
            indexOutProjectInfo.setId(id);
            List<IndexOutProjectInfo> list = indexOutProjectInfoService.findIndexOutProjectInfoList(indexOutProjectInfo);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "首页-科研项目查询列表", notes = "自定义对象(条件)查询首页-科研项目信息,返回存储在JSONObject对象中的首页-科研项目列表")
    @RequestMapping(value = "/indexoutprojectinfo-provider/indexoutprojectinfo/indexoutprojectinfo_list", method = RequestMethod.POST)
    public JSONObject selectIndexOutProjectInfoList(@RequestBody IndexOutProjectInfo indexOutProjectInfo) {
        JSONObject retJson = new JSONObject();
        try {
            List<IndexOutProjectInfo> list = indexOutProjectInfoService.findIndexOutProjectInfoList(indexOutProjectInfo);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询首页-科研项目树形详情信息", notes = "按ID查询首页-科研项目详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/indexoutprojectinfo-provider/indexoutprojectinfo/get-indexoutprojectinfo/{id}", method = RequestMethod.POST)
    public IndexOutProjectInfo getIndexOutProjectInfoInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return indexOutProjectInfoService.getIndexOutProjectInfoInfo(id);
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
    @ApiOperation(value = "查询(树)首页-科研项目信息", notes = "查询(树)首页-科研项目信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/indexoutprojectinfo-provider/indexoutprojectinfo/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return indexOutProjectInfoService.selectObjectByTree();
    }

    /**
     * 删除首页-科研项目-false
     *
     * @param indexOutProjectInfocId
     * @return
     */
    @ApiOperation(value = "伪删除首页-科研项目信息", notes = "按ID伪删除首页-科研项目信息,操作成功返回201")
    @RequestMapping(value = "/indexoutprojectinfo-provider/indexoutprojectinfo/del-indexoutprojectinfo/{indexOutProjectInfoId}")
    public Object deleteIndexOutProjectInfo(@PathVariable("indexOutProjectInfoId") String indexOutProjectInfocId) {
        return indexOutProjectInfoService.deleteIndexOutProjectInfo(indexOutProjectInfocId);
    }

    /**
     * 删除首页-科研项目-true
     *
     * @param indexOutProjectInfocId
     * @return
     */
    @ApiOperation(value = "删除首页-科研项目信息", notes = "按ID删除首页-科研项目信息,操作成功返回201")
    @RequestMapping(value = "/indexoutprojectinfo-provider/indexoutprojectinfo/del-indexoutprojectinfo-real/{indexOutProjectInfoId}", method = RequestMethod.POST)
    public Object deleteIndexOutProjectInfoReal(@PathVariable("indexOutProjectInfoId") String indexOutProjectInfocId) {
        return indexOutProjectInfoService.deleteIndexOutProjectInfoReal(indexOutProjectInfocId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询首页-科研项目信息-分页查询", notes = "查询首页-科研项目信息-分页查询,Object")
    @RequestMapping(value = "/indexoutprojectinfo-provider/indexoutprojectinfo/indexoutprojectinfo-page")
    public Object selectIndexOutProjectInfoByPage(@RequestBody LayuiTableParam param) {
        return indexOutProjectInfoService.findIndexOutProjectInfoByPage(param);
    }

    @ApiOperation(value = "查询首页-科研项目信息-分页查询", notes = "查询首页-科研项目信息-分页查询,Object")
    @RequestMapping(value = "/indexoutprojectinfo-provider/indexoutprojectinfo/indexoutprojectinfo-page-tree")
    public Object selectIndexOutProjectInfoByPageTree(@RequestBody LayuiTableParam param) {
        return indexOutProjectInfoService.findIndexOutProjectInfoByPageTree(param);
    }

    /**
     * 保存
     *
     * @param indexOutProjectInfo
     * @return
     */
    @ApiOperation(value = "新增首页-科研项目信息", notes = "新增首页-科研项目信息,操作成功返回500")
    @RequestMapping(value = "/indexoutprojectinfo-provider/indexoutprojectinfo/save_indexoutprojectinfo", method = RequestMethod.POST)
    public int updateOrInsertIndexOutProjectInfo(@RequestBody IndexOutProjectInfo indexOutProjectInfo) {
        try {
            return indexOutProjectInfoService.updateOrInsertIndexOutProjectInfo(indexOutProjectInfo);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
