package com.pcitc.web.system;

import java.util.Date;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.system.IndexOutPatent;
import com.pcitc.base.system.IndexOutPatentExample;
import com.pcitc.service.system.IndexOutPatentService;
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
 * <p>Table: index_out_patent - </p>
 *
 * @since 2019-05-23 07:13:54
 */
@Api(value = "IndexOutPatentClient-API", description = "服务接口")
@RestController
public class IndexOutPatentClient {
    private final static Logger logger = LoggerFactory.getLogger(IndexOutPatentClient.class);

    @Autowired
    IndexOutPatentService indexOutPatentService;

    //参数查询
    @ApiOperation(value = "带参查询列表", notes = "根据ID查询查询信息,返回一个的JSONObject对象")
    @RequestMapping(value = "/indexoutpatent-provider/indexoutpatent/indexoutpatent_list_param", method = RequestMethod.POST)
    public JSONObject selectIndexOutPatentListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            IndexOutPatent indexOutPatent = new IndexOutPatent();
            indexOutPatent.setId(id);
            List<IndexOutPatent> list = indexOutPatentService.findIndexOutPatentList(indexOutPatent);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "查询列表", notes = "自定义对象(条件)查询信息,返回存储在JSONObject对象中的列表")
    @RequestMapping(value = "/indexoutpatent-provider/indexoutpatent/indexoutpatent_list", method = RequestMethod.POST)
    public JSONObject selectIndexOutPatentList(@RequestBody IndexOutPatent indexOutPatent) {
        JSONObject retJson = new JSONObject();
        try {
            List<IndexOutPatent> list = indexOutPatentService.findIndexOutPatentList(indexOutPatent);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询树形详情信息", notes = "按ID查询详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/indexoutpatent-provider/indexoutpatent/get-indexoutpatent/{id}", method = RequestMethod.POST)
    public IndexOutPatent getIndexOutPatentInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return indexOutPatentService.getIndexOutPatentInfo(id);
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
    @ApiOperation(value = "查询(树)信息", notes = "查询(树)信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/indexoutpatent-provider/indexoutpatent/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return indexOutPatentService.selectObjectByTree();
    }

    /**
     * 删除-false
     *
     * @param indexOutPatentcId
     * @return
     */
    @ApiOperation(value = "伪删除信息", notes = "按ID伪删除信息,操作成功返回201")
    @RequestMapping(value = "/indexoutpatent-provider/indexoutpatent/del-indexoutpatent/{indexOutPatentId}")
    public Object deleteIndexOutPatent(@PathVariable("indexOutPatentId") String indexOutPatentcId) {
        return indexOutPatentService.deleteIndexOutPatent(indexOutPatentcId);
    }

    /**
     * 删除-true
     *
     * @param indexOutPatentcId
     * @return
     */
    @ApiOperation(value = "删除信息", notes = "按ID删除信息,操作成功返回201")
    @RequestMapping(value = "/indexoutpatent-provider/indexoutpatent/del-indexoutpatent-real/{indexOutPatentId}", method = RequestMethod.POST)
    public Object deleteIndexOutPatentReal(@PathVariable("indexOutPatentId") String indexOutPatentcId) {
        return indexOutPatentService.deleteIndexOutPatentReal(indexOutPatentcId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询信息-分页查询", notes = "查询信息-分页查询,Object")
    @RequestMapping(value = "/indexoutpatent-provider/indexoutpatent/indexoutpatent-page")
    public Object selectIndexOutPatentByPage(@RequestBody LayuiTableParam param) {
        return indexOutPatentService.findIndexOutPatentByPage(param);
    }

    /**
     * 保存
     *
     * @param indexOutPatent
     * @return
     */
    @ApiOperation(value = "新增信息", notes = "新增信息,操作成功返回500")
    @RequestMapping(value = "/indexoutpatent-provider/indexoutpatent/save_indexoutpatent", method = RequestMethod.POST)
    public int updateOrInsertIndexOutPatent(@RequestBody IndexOutPatent indexOutPatent) {
        try {
            return indexOutPatentService.updateOrInsertIndexOutPatent(indexOutPatent);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
