package com.pcitc.web.expert;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.ZjkExtractConfig;
import com.pcitc.base.expert.ZjkExtractConfigExample;
import com.pcitc.service.expert.ZjkExtractConfigService;
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
 * <p>Table: zjk_extract_config - 专家抽取逻辑配置</p>
 *
 * @since 2019-01-29 04:04:35
 */
@Api(value = "ZjkExtractConfigClient-API", description = "专家抽取逻辑配置服务接口")
@RestController
public class ZjkExtractConfigClient {
    private final static Logger logger = LoggerFactory.getLogger(ZjkExtractConfigClient.class);

    @Autowired
    ZjkExtractConfigService zjkExtractConfigService;

    //参数查询
    @ApiOperation(value = "带参专家抽取逻辑配置查询列表", notes = "根据ID查询查询专家抽取逻辑配置信息,返回一个专家抽取逻辑配置的JSONObject对象")
    @RequestMapping(value = "/zjkextractconfig-provider/zjkextractconfig/zjkextractconfig_list_param", method = RequestMethod.POST)
    public JSONObject selectZjkExtractConfigListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ZjkExtractConfig zjkExtractConfig = new ZjkExtractConfig();
            zjkExtractConfig.setId(id);
            List<ZjkExtractConfig> list = zjkExtractConfigService.findZjkExtractConfigList(zjkExtractConfig);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "专家抽取逻辑配置查询列表", notes = "自定义对象(条件)查询专家抽取逻辑配置信息,返回存储在JSONObject对象中的专家抽取逻辑配置列表")
    @RequestMapping(value = "/zjkextractconfig-provider/zjkextractconfig/zjkextractconfig_list", method = RequestMethod.POST)
    public JSONObject selectZjkExtractConfigList(@RequestBody ZjkExtractConfig zjkExtractConfig) {
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkExtractConfig> list = zjkExtractConfigService.findZjkExtractConfigList(zjkExtractConfig);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询专家抽取逻辑配置树形详情信息", notes = "按ID查询专家抽取逻辑配置详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/zjkextractconfig-provider/zjkextractconfig/get-zjkextractconfig/{id}", method = RequestMethod.POST)
    public ZjkExtractConfig getZjkExtractConfigInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return zjkExtractConfigService.getZjkExtractConfigInfo(id);
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
    @ApiOperation(value = "查询(树)专家抽取逻辑配置信息", notes = "查询(树)专家抽取逻辑配置信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/zjkextractconfig-provider/zjkextractconfig/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return zjkExtractConfigService.selectObjectByTree();
    }

    /**
     * 删除专家抽取逻辑配置-false
     *
     * @param zjkExtractConfigcId
     * @return
     */
    @ApiOperation(value = "伪删除专家抽取逻辑配置信息", notes = "按ID伪删除专家抽取逻辑配置信息,操作成功返回201")
    @RequestMapping(value = "/zjkextractconfig-provider/zjkextractconfig/del-zjkextractconfig/{zjkExtractConfigId}")
    public Object deleteZjkExtractConfig(@PathVariable("zjkExtractConfigId") String zjkExtractConfigcId) {
        return zjkExtractConfigService.deleteZjkExtractConfig(zjkExtractConfigcId);
    }

    /**
     * 删除专家抽取逻辑配置-true
     *
     * @param zjkExtractConfigcId
     * @return
     */
    @ApiOperation(value = "删除专家抽取逻辑配置信息", notes = "按ID删除专家抽取逻辑配置信息,操作成功返回201")
    @RequestMapping(value = "/zjkextractconfig-provider/zjkextractconfig/del-zjkextractconfig-real/{zjkExtractConfigId}", method = RequestMethod.POST)
    public Object deleteZjkExtractConfigReal(@PathVariable("zjkExtractConfigId") String zjkExtractConfigcId) {
        return zjkExtractConfigService.deleteZjkExtractConfigReal(zjkExtractConfigcId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询专家抽取逻辑配置信息-分页查询", notes = "查询专家抽取逻辑配置信息-分页查询,Object")
    @RequestMapping(value = "/zjkextractconfig-provider/zjkextractconfig/zjkextractconfig-page")
    public Object selectZjkExtractConfigByPage(@RequestBody LayuiTableParam param) {
        return zjkExtractConfigService.findZjkExtractConfigByPage(param);
    }

    /**
     * 保存
     *
     * @param zjkExtractConfig
     * @return
     */
    @ApiOperation(value = "新增专家抽取逻辑配置信息", notes = "新增专家抽取逻辑配置信息,操作成功返回500")
    @RequestMapping(value = "/zjkextractconfig-provider/zjkextractconfig/save_zjkextractconfig", method = RequestMethod.POST)
    public int updateOrInsertZjkExtractConfig(@RequestBody ZjkExtractConfig zjkExtractConfig) {
        try {
            return zjkExtractConfigService.updateOrInsertZjkExtractConfig(zjkExtractConfig);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
