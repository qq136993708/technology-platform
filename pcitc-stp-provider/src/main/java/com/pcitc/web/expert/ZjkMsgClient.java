package com.pcitc.web.expert;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.ZjkMsg;
import com.pcitc.base.expert.ZjkMsgExample;
import com.pcitc.service.expert.ZjkMsgService;
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
 * <p>Table: zjk_msg - 专家-回复管理</p>
 *
 * @since 2019-02-25 03:45:21
 */
@Api(value = "ZjkMsgClient-API", description = "专家-回复管理服务接口")
@RestController
public class ZjkMsgClient {
    private final static Logger logger = LoggerFactory.getLogger(ZjkMsgClient.class);

    @Autowired
    ZjkMsgService zjkMsgService;

    //参数查询
    @ApiOperation(value = "带参专家-回复管理查询列表", notes = "根据ID查询查询专家-回复管理信息,返回一个专家-回复管理的JSONObject对象")
    @RequestMapping(value = "/zjkmsg-provider/zjkmsg/zjkmsg_list_param", method = RequestMethod.POST)
    public JSONObject selectZjkMsgListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ZjkMsg zjkMsg = new ZjkMsg();
            zjkMsg.setId(id);
            List<ZjkMsg> list = zjkMsgService.findZjkMsgList(zjkMsg);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "专家-回复管理查询列表", notes = "自定义对象(条件)查询专家-回复管理信息,返回存储在JSONObject对象中的专家-回复管理列表")
    @RequestMapping(value = "/zjkmsg-provider/zjkmsg/zjkmsg_list", method = RequestMethod.POST)
    public JSONObject selectZjkMsgList(@RequestBody ZjkMsg zjkMsg) {
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkMsg> list = zjkMsgService.findZjkMsgList(zjkMsg);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询专家-回复管理树形详情信息", notes = "按ID查询专家-回复管理详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/zjkmsg-provider/zjkmsg/get-zjkmsg/{id}", method = RequestMethod.POST)
    public ZjkMsg getZjkMsgInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return zjkMsgService.getZjkMsgInfo(id);
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
    @ApiOperation(value = "查询(树)专家-回复管理信息", notes = "查询(树)专家-回复管理信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/zjkmsg-provider/zjkmsg/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return zjkMsgService.selectObjectByTree();
    }

    /**
     * 删除专家-回复管理-false
     *
     * @param zjkMsgcId
     * @return
     */
    @ApiOperation(value = "伪删除专家-回复管理信息", notes = "按ID伪删除专家-回复管理信息,操作成功返回201")
    @RequestMapping(value = "/zjkmsg-provider/zjkmsg/del-zjkmsg/{zjkMsgId}")
    public Object deleteZjkMsg(@PathVariable("zjkMsgId") String zjkMsgcId) {
        return zjkMsgService.deleteZjkMsg(zjkMsgcId);
    }

    /**
     * 删除专家-回复管理-true
     *
     * @param zjkMsgcId
     * @return
     */
    @ApiOperation(value = "删除专家-回复管理信息", notes = "按ID删除专家-回复管理信息,操作成功返回201")
    @RequestMapping(value = "/zjkmsg-provider/zjkmsg/del-zjkmsg-real/{zjkMsgId}", method = RequestMethod.POST)
    public Object deleteZjkMsgReal(@PathVariable("zjkMsgId") String zjkMsgcId) {
        return zjkMsgService.deleteZjkMsgReal(zjkMsgcId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询专家-回复管理信息-分页查询", notes = "查询专家-回复管理信息-分页查询,Object")
    @RequestMapping(value = "/zjkmsg-provider/zjkmsg/zjkmsg-page")
    public Object selectZjkMsgByPage(@RequestBody LayuiTableParam param) {
        return zjkMsgService.findZjkMsgByPage(param);
    }

    /**
     * 保存
     *
     * @param zjkMsg
     * @return
     */
    @ApiOperation(value = "新增专家-回复管理信息", notes = "新增专家-回复管理信息,操作成功返回500")
    @RequestMapping(value = "/zjkmsg-provider/zjkmsg/save_zjkmsg", method = RequestMethod.POST)
    public int updateOrInsertZjkMsg(@RequestBody ZjkMsg zjkMsg) {
        try {
            return zjkMsgService.updateOrInsertZjkMsg(zjkMsg);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
