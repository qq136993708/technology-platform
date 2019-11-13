package com.pcitc.web.expert;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.ZjkSkmType;
import com.pcitc.base.expert.ZjkSkmTypeExample;
import com.pcitc.service.expert.ZjkSkmTypeService;
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
 * <p>Table: zjk_skm_type - </p>
 *
 * @since 2019-01-23 02:39:13
 */
@Api(value = "ZjkSkmTypeClient-API", description = "服务接口")
@RestController
public class ZjkSkmTypeClient {
    private final static Logger logger = LoggerFactory.getLogger(ZjkSkmTypeClient.class);

    @Autowired
    ZjkSkmTypeService zjkSkmTypeService;

    //参数查询
    @ApiOperation(value = "带参查询列表", notes = "根据ID查询查询信息,返回一个的JSONObject对象")
    @RequestMapping(value = "/zjkskmtype-provider/zjkskmtype/zjkskmtype_list_param", method = RequestMethod.POST)
    public JSONObject selectZjkSkmTypeListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ZjkSkmType zjkSkmType = new ZjkSkmType();
            zjkSkmType.setId(id);
            List<ZjkSkmType> list = zjkSkmTypeService.findZjkSkmTypeList(zjkSkmType);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "查询列表", notes = "自定义对象(条件)查询信息,返回存储在JSONObject对象中的列表")
    @RequestMapping(value = "/zjkskmtype-provider/zjkskmtype/zjkskmtype_list", method = RequestMethod.POST)
    public JSONObject selectZjkSkmTypeList(@RequestBody ZjkSkmType zjkSkmType) {
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkSkmType> list = zjkSkmTypeService.findZjkSkmTypeList(zjkSkmType);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询树形详情信息", notes = "按ID查询详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/zjkskmtype-provider/zjkskmtype/get-zjkskmtype/{id}", method = RequestMethod.POST)
    public ZjkSkmType getZjkSkmTypeInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return zjkSkmTypeService.getZjkSkmTypeInfo(id);
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
    @RequestMapping(value = "/zjkskmtype-provider/zjkskmtype/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return zjkSkmTypeService.selectObjectByTree();
    }

    /**
     * 删除-false
     *
     * @param zjkSkmTypecId
     * @return
     */
    @ApiOperation(value = "伪删除信息", notes = "按ID伪删除信息,操作成功返回201")
    @RequestMapping(value = "/zjkskmtype-provider/zjkskmtype/del-zjkskmtype/{zjkSkmTypeId}")
    public Object deleteZjkSkmType(@PathVariable("zjkSkmTypeId") String zjkSkmTypecId) {
        return zjkSkmTypeService.deleteZjkSkmType(zjkSkmTypecId);
    }

    /**
     * 删除-true
     *
     * @param zjkSkmTypecId
     * @return
     */
    @ApiOperation(value = "删除信息", notes = "按ID删除信息,操作成功返回201")
    @RequestMapping(value = "/zjkskmtype-provider/zjkskmtype/del-zjkskmtype-real/{zjkSkmTypeId}", method = RequestMethod.POST)
    public Object deleteZjkSkmTypeReal(@PathVariable("zjkSkmTypeId") String zjkSkmTypecId) {
        return zjkSkmTypeService.deleteZjkSkmTypeReal(zjkSkmTypecId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询信息-分页查询", notes = "查询信息-分页查询,Object")
    @RequestMapping(value = "/zjkskmtype-provider/zjkskmtype/zjkskmtype-page")
    public Object selectZjkSkmTypeByPage(@RequestBody LayuiTableParam param) {
        return zjkSkmTypeService.findZjkSkmTypeByPage(param);
    }

    /**
     * 保存
     *
     * @param zjkSkmType
     * @return
     */
    @ApiOperation(value = "新增信息", notes = "新增信息,操作成功返回500")
    @RequestMapping(value = "/zjkskmtype-provider/zjkskmtype/save_zjkskmtype", method = RequestMethod.POST)
    public int updateOrInsertZjkSkmType(@RequestBody ZjkSkmType zjkSkmType) {
        try {
            return zjkSkmTypeService.updateOrInsertZjkSkmType(zjkSkmType);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
