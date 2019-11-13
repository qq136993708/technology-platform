package com.pcitc.web.expert;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.ZjkTrain;
import com.pcitc.base.expert.ZjkTrainExample;
import com.pcitc.service.expert.ZjkTrainService;
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
 * <p>Table: zjk_train - 专家培训</p>
 *
 * @since 2019-03-01 09:34:09
 */
@Api(value = "ZjkTrainClient-API", description = "专家培训服务接口")
@RestController
public class ZjkTrainClient {
    private final static Logger logger = LoggerFactory.getLogger(ZjkTrainClient.class);

    @Autowired
    ZjkTrainService zjkTrainService;

    //参数查询
    @ApiOperation(value = "带参专家培训查询列表", notes = "根据ID查询查询专家培训信息,返回一个专家培训的JSONObject对象")
    @RequestMapping(value = "/zjktrain-provider/zjktrain/zjktrain_list_param", method = RequestMethod.POST)
    public JSONObject selectZjkTrainListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ZjkTrain zjkTrain = new ZjkTrain();
            zjkTrain.setId(id);
            List<ZjkTrain> list = zjkTrainService.findZjkTrainList(zjkTrain);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "专家培训查询列表", notes = "自定义对象(条件)查询专家培训信息,返回存储在JSONObject对象中的专家培训列表")
    @RequestMapping(value = "/zjktrain-provider/zjktrain/zjktrain_list", method = RequestMethod.POST)
    public JSONObject selectZjkTrainList(@RequestBody ZjkTrain zjkTrain) {
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkTrain> list = zjkTrainService.findZjkTrainList(zjkTrain);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询专家培训树形详情信息", notes = "按ID查询专家培训详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/zjktrain-provider/zjktrain/get-zjktrain/{id}", method = RequestMethod.POST)
    public ZjkTrain getZjkTrainInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return zjkTrainService.getZjkTrainInfo(id);
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
    @ApiOperation(value = "查询(树)专家培训信息", notes = "查询(树)专家培训信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/zjktrain-provider/zjktrain/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return zjkTrainService.selectObjectByTree();
    }

    /**
     * 删除专家培训-false
     *
     * @param zjkTraincId
     * @return
     */
    @ApiOperation(value = "伪删除专家培训信息", notes = "按ID伪删除专家培训信息,操作成功返回201")
    @RequestMapping(value = "/zjktrain-provider/zjktrain/del-zjktrain/{zjkTrainId}")
    public Object deleteZjkTrain(@PathVariable("zjkTrainId") String zjkTraincId) {
        return zjkTrainService.deleteZjkTrain(zjkTraincId);
    }

    /**
     * 删除专家培训-true
     *
     * @param zjkTraincId
     * @return
     */
    @ApiOperation(value = "删除专家培训信息", notes = "按ID删除专家培训信息,操作成功返回201")
    @RequestMapping(value = "/zjktrain-provider/zjktrain/del-zjktrain-real/{zjkTrainId}", method = RequestMethod.POST)
    public Object deleteZjkTrainReal(@PathVariable("zjkTrainId") String zjkTraincId) {
        return zjkTrainService.deleteZjkTrainReal(zjkTraincId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询专家培训信息-分页查询", notes = "查询专家培训信息-分页查询,Object")
    @RequestMapping(value = "/zjktrain-provider/zjktrain/zjktrain-page")
    public Object selectZjkTrainByPage(@RequestBody LayuiTableParam param) {
        return zjkTrainService.findZjkTrainByPage(param);
    }

    /**
     * 保存
     *
     * @param zjkTrain
     * @return
     */
    @ApiOperation(value = "新增专家培训信息", notes = "新增专家培训信息,操作成功返回500")
    @RequestMapping(value = "/zjktrain-provider/zjktrain/save_zjktrain", method = RequestMethod.POST)
    public int updateOrInsertZjkTrain(@RequestBody ZjkTrain zjkTrain) {
        try {
            return zjkTrainService.updateOrInsertZjkTrain(zjkTrain);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
