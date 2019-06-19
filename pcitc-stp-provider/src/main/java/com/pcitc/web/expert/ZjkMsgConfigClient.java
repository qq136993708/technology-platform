package com.pcitc.web.expert;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.ZjkMsgConfig;
import com.pcitc.base.expert.ZjkMsgConfigExample;
import com.pcitc.service.expert.ZjkMsgConfigService;
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
 * <p>Table: zjk_msg_config - 专家回复消息配置表</p>
 *
 * @since 2019-02-25 03:04:53
 */
@Api(value = "ZjkMsgConfigClient-API", description = "专家回复消息配置表服务接口")
@RestController
public class ZjkMsgConfigClient {
    private final static Logger logger = LoggerFactory.getLogger(ZjkMsgConfigClient.class);

    @Autowired
    ZjkMsgConfigService zjkMsgConfigService;

    //参数查询
    @ApiOperation(value = "带参专家回复消息配置表查询列表", notes = "根据ID查询查询专家回复消息配置表信息,返回一个专家回复消息配置表的JSONObject对象")
    @RequestMapping(value = "/zjkmsgconfig-provider/zjkmsgconfig/zjkmsgconfig_list_param", method = RequestMethod.POST)
    public JSONObject selectZjkMsgConfigListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ZjkMsgConfig zjkMsgConfig = new ZjkMsgConfig();
            zjkMsgConfig.setId(id);
            List<ZjkMsgConfig> list = zjkMsgConfigService.findZjkMsgConfigList(zjkMsgConfig);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "专家回复消息配置表查询列表", notes = "自定义对象(条件)查询专家回复消息配置表信息,返回存储在JSONObject对象中的专家回复消息配置表列表")
    @RequestMapping(value = "/zjkmsgconfig-provider/zjkmsgconfig/zjkmsgconfig_list", method = RequestMethod.POST)
    public JSONObject selectZjkMsgConfigList(@RequestBody ZjkMsgConfig zjkMsgConfig) {
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkMsgConfig> list = zjkMsgConfigService.findZjkMsgConfigList(zjkMsgConfig);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询专家回复消息配置表树形详情信息", notes = "按ID查询专家回复消息配置表详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/zjkmsgconfig-provider/zjkmsgconfig/get-zjkmsgconfig/{id}", method = RequestMethod.POST)
    public ZjkMsgConfig getZjkMsgConfigInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return zjkMsgConfigService.getZjkMsgConfigInfo(id);
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
    @ApiOperation(value = "查询(树)专家回复消息配置表信息", notes = "查询(树)专家回复消息配置表信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/zjkmsgconfig-provider/zjkmsgconfig/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return zjkMsgConfigService.selectObjectByTree();
    }

    /**
     * 删除专家回复消息配置表-false
     *
     * @param zjkMsgConfigcId
     * @return
     */
    @ApiOperation(value = "伪删除专家回复消息配置表信息", notes = "按ID伪删除专家回复消息配置表信息,操作成功返回201")
    @RequestMapping(value = "/zjkmsgconfig-provider/zjkmsgconfig/del-zjkmsgconfig/{zjkMsgConfigId}")
    public Object deleteZjkMsgConfig(@PathVariable("zjkMsgConfigId") String zjkMsgConfigcId) {
        return zjkMsgConfigService.deleteZjkMsgConfig(zjkMsgConfigcId);
    }

    /**
     * 删除专家回复消息配置表-true
     *
     * @param zjkMsgConfigcId
     * @return
     */
    @ApiOperation(value = "删除专家回复消息配置表信息", notes = "按ID删除专家回复消息配置表信息,操作成功返回201")
    @RequestMapping(value = "/zjkmsgconfig-provider/zjkmsgconfig/del-zjkmsgconfig-real/{zjkMsgConfigId}", method = RequestMethod.POST)
    public Object deleteZjkMsgConfigReal(@PathVariable("zjkMsgConfigId") String zjkMsgConfigcId) {
        return zjkMsgConfigService.deleteZjkMsgConfigReal(zjkMsgConfigcId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询专家回复消息配置表信息-分页查询", notes = "查询专家回复消息配置表信息-分页查询,Object")
    @RequestMapping(value = "/zjkmsgconfig-provider/zjkmsgconfig/zjkmsgconfig-page")
    public Object selectZjkMsgConfigByPage(@RequestBody LayuiTableParam param) {
        return zjkMsgConfigService.findZjkMsgConfigByPage(param);
    }

    /**
     * 保存
     *
     * @param zjkMsgConfig
     * @return
     */
    @ApiOperation(value = "新增专家回复消息配置表信息", notes = "新增专家回复消息配置表信息,操作成功返回500")
    @RequestMapping(value = "/zjkmsgconfig-provider/zjkmsgconfig/save_zjkmsgconfig", method = RequestMethod.POST)
    public int updateOrInsertZjkMsgConfig(@RequestBody ZjkMsgConfig zjkMsgConfig) {
        try {
            return zjkMsgConfigService.updateOrInsertZjkMsgConfig(zjkMsgConfig);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
    /**
     * 批量保存
     *
     * @param jsonObject
     * @return
     */
    @ApiOperation(value = "修改专家回复消息配置表信息", notes = "批量修改专家回复消息配置表信息,操作成功返回500")
    @RequestMapping(value = "/zjkmsgconfig-provider/zjkmsgconfig/save_zjkmsgconfig_bat", method = RequestMethod.POST)
    public int updateOrInsertZjkMsgConfigBat(@RequestBody JSONObject jsonObject) {
        try {
            return zjkMsgConfigService.updateOrInsertZjkMsgConfigBat(jsonObject);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
