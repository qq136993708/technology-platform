package com.pcitc.web.expert;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.ZjkComplaint;
import com.pcitc.base.expert.ZjkComplaintExample;
import com.pcitc.service.expert.ZjkComplaintService;
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
 * <p>Table: zjk_complaint - 专家-投诉管理</p>
 *
 * @since 2019-02-26 10:33:37
 */
@Api(value = "ZjkComplaintClient-API", description = "专家-投诉管理服务接口")
@RestController
public class ZjkComplaintClient {
    private final static Logger logger = LoggerFactory.getLogger(ZjkComplaintClient.class);

    @Autowired
    ZjkComplaintService zjkComplaintService;

    //参数查询
    @ApiOperation(value = "带参专家-投诉管理查询列表", notes = "根据ID查询查询专家-投诉管理信息,返回一个专家-投诉管理的JSONObject对象")
    @RequestMapping(value = "/zjkcomplaint-provider/zjkcomplaint/zjkcomplaint_list_param", method = RequestMethod.POST)
    public JSONObject selectZjkComplaintListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ZjkComplaint zjkComplaint = new ZjkComplaint();
            zjkComplaint.setId(id);
            List<ZjkComplaint> list = zjkComplaintService.findZjkComplaintList(zjkComplaint);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "专家-投诉管理查询列表", notes = "自定义对象(条件)查询专家-投诉管理信息,返回存储在JSONObject对象中的专家-投诉管理列表")
    @RequestMapping(value = "/zjkcomplaint-provider/zjkcomplaint/zjkcomplaint_list", method = RequestMethod.POST)
    public JSONObject selectZjkComplaintList(@RequestBody ZjkComplaint zjkComplaint) {
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkComplaint> list = zjkComplaintService.findZjkComplaintList(zjkComplaint);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询专家-投诉管理树形详情信息", notes = "按ID查询专家-投诉管理详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/zjkcomplaint-provider/zjkcomplaint/get-zjkcomplaint/{id}", method = RequestMethod.POST)
    public ZjkComplaint getZjkComplaintInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return zjkComplaintService.getZjkComplaintInfo(id);
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
    @ApiOperation(value = "查询(树)专家-投诉管理信息", notes = "查询(树)专家-投诉管理信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/zjkcomplaint-provider/zjkcomplaint/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return zjkComplaintService.selectObjectByTree();
    }

    /**
     * 删除专家-投诉管理-false
     *
     * @param zjkComplaintcId
     * @return
     */
    @ApiOperation(value = "伪删除专家-投诉管理信息", notes = "按ID伪删除专家-投诉管理信息,操作成功返回201")
    @RequestMapping(value = "/zjkcomplaint-provider/zjkcomplaint/del-zjkcomplaint/{zjkComplaintId}")
    public Object deleteZjkComplaint(@PathVariable("zjkComplaintId") String zjkComplaintcId) {
        return zjkComplaintService.deleteZjkComplaint(zjkComplaintcId);
    }

    /**
     * 删除专家-投诉管理-true
     *
     * @param zjkComplaintcId
     * @return
     */
    @ApiOperation(value = "删除专家-投诉管理信息", notes = "按ID删除专家-投诉管理信息,操作成功返回201")
    @RequestMapping(value = "/zjkcomplaint-provider/zjkcomplaint/del-zjkcomplaint-real/{zjkComplaintId}", method = RequestMethod.POST)
    public Object deleteZjkComplaintReal(@PathVariable("zjkComplaintId") String zjkComplaintcId) {
        return zjkComplaintService.deleteZjkComplaintReal(zjkComplaintcId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询专家-投诉管理信息-分页查询", notes = "查询专家-投诉管理信息-分页查询,Object")
    @RequestMapping(value = "/zjkcomplaint-provider/zjkcomplaint/zjkcomplaint-page")
    public Object selectZjkComplaintByPage(@RequestBody LayuiTableParam param) {
        return zjkComplaintService.findZjkComplaintByPage(param);
    }

    /**
     * 保存
     *
     * @param zjkComplaint
     * @return
     */
    @ApiOperation(value = "新增专家-投诉管理信息", notes = "新增专家-投诉管理信息,操作成功返回500")
    @RequestMapping(value = "/zjkcomplaint-provider/zjkcomplaint/save_zjkcomplaint", method = RequestMethod.POST)
    public int updateOrInsertZjkComplaint(@RequestBody ZjkComplaint zjkComplaint) {
        try {
            return zjkComplaintService.updateOrInsertZjkComplaint(zjkComplaint);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
