package com.pcitc.web.search;

import com.pcitc.base.common.HotWord;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.search.ZjkSearchLog;
import com.pcitc.base.search.ZjkSearchLogExample;
import com.pcitc.service.search.ZjkSearchLogService;
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
 * <p>Table: zjk_search_log - 专家库-搜索关键字日志</p>
 *
 * @since 2019-07-20 10:11:09
 */
@Api(value = "ZjkSearchLogClient-API", description = "专家库-搜索关键字日志服务接口")
@RestController
public class ZjkSearchLogClient {
    private final static Logger logger = LoggerFactory.getLogger(ZjkSearchLogClient.class);

    @Autowired
    ZjkSearchLogService zjkSearchLogService;

    //参数查询
    @ApiOperation(value = "带参专家库-搜索关键字日志查询列表", notes = "根据ID查询查询专家库-搜索关键字日志信息,返回一个专家库-搜索关键字日志的JSONObject对象")
    @RequestMapping(value = "/zjksearchlog-provider/zjksearchlog/zjksearchlog_list_param", method = RequestMethod.POST)
    public JSONObject selectZjkSearchLogListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ZjkSearchLog zjkSearchLog = new ZjkSearchLog();
            zjkSearchLog.setId(id);
            List<ZjkSearchLog> list = zjkSearchLogService.findZjkSearchLogList(zjkSearchLog);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "专家库-搜索关键字日志查询列表", notes = "自定义对象(条件)查询专家库-搜索关键字日志信息,返回存储在JSONObject对象中的专家库-搜索关键字日志列表")
    @RequestMapping(value = "/zjksearchlog-provider/zjksearchlog/zjksearchlog_list", method = RequestMethod.POST)
    public JSONObject selectZjkSearchLogList(@RequestBody ZjkSearchLog zjkSearchLog) {
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkSearchLog> list = zjkSearchLogService.findZjkSearchLogList(zjkSearchLog);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @RequestMapping(value = "/zjksearchlog-provider/zjksearchlog/getListEs", method = RequestMethod.POST)
    public JSONObject getListEs(@RequestBody HotWord hotWord) {
        JSONObject retJson = new JSONObject();
        try {
            List<String> list = zjkSearchLogService.getListEs(hotWord);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询专家库-搜索关键字日志树形详情信息", notes = "按ID查询专家库-搜索关键字日志详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/zjksearchlog-provider/zjksearchlog/get-zjksearchlog/{id}", method = RequestMethod.POST)
    public ZjkSearchLog getZjkSearchLogInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return zjkSearchLogService.getZjkSearchLogInfo(id);
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
    @ApiOperation(value = "查询(树)专家库-搜索关键字日志信息", notes = "查询(树)专家库-搜索关键字日志信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/zjksearchlog-provider/zjksearchlog/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return zjkSearchLogService.selectObjectByTree();
    }

    /**
     * 删除专家库-搜索关键字日志-false
     *
     * @param zjkSearchLogcId
     * @return
     */
    @ApiOperation(value = "伪删除专家库-搜索关键字日志信息", notes = "按ID伪删除专家库-搜索关键字日志信息,操作成功返回201")
    @RequestMapping(value = "/zjksearchlog-provider/zjksearchlog/del-zjksearchlog/{zjkSearchLogId}")
    public Object deleteZjkSearchLog(@PathVariable("zjkSearchLogId") String zjkSearchLogcId) {
        return zjkSearchLogService.deleteZjkSearchLog(zjkSearchLogcId);
    }

    /**
     * 删除专家库-搜索关键字日志-true
     *
     * @param zjkSearchLogcId
     * @return
     */
    @ApiOperation(value = "删除专家库-搜索关键字日志信息", notes = "按ID删除专家库-搜索关键字日志信息,操作成功返回201")
    @RequestMapping(value = "/zjksearchlog-provider/zjksearchlog/del-zjksearchlog-real/{zjkSearchLogId}", method = RequestMethod.POST)
    public Object deleteZjkSearchLogReal(@PathVariable("zjkSearchLogId") String zjkSearchLogcId) {
        return zjkSearchLogService.deleteZjkSearchLogReal(zjkSearchLogcId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询专家库-搜索关键字日志信息-分页查询", notes = "查询专家库-搜索关键字日志信息-分页查询,Object")
    @RequestMapping(value = "/zjksearchlog-provider/zjksearchlog/zjksearchlog-page")
    public Object selectZjkSearchLogByPage(@RequestBody LayuiTableParam param) {
        return zjkSearchLogService.findZjkSearchLogByPage(param);
    }

    /**
     * 保存
     *
     * @param zjkSearchLog
     * @return
     */
    @ApiOperation(value = "新增专家库-搜索关键字日志信息", notes = "新增专家库-搜索关键字日志信息,操作成功返回500")
    @RequestMapping(value = "/zjksearchlog-provider/zjksearchlog/save_zjksearchlog", method = RequestMethod.POST)
    public int updateOrInsertZjkSearchLog(@RequestBody ZjkSearchLog zjkSearchLog) {
        try {
            return zjkSearchLogService.updateOrInsertZjkSearchLog(zjkSearchLog);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
