package com.pcitc.web.expert;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.TfmType;
import com.pcitc.base.expert.TfmTypeExample;
import com.pcitc.service.expert.TfmTypeService;
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
 * <p>Table: tfm_type - </p>
 *
 * @since 2019-01-16 02:47:25
 */
@Api(value = "TfmTypeClient-API", description = "服务接口")
@RestController
public class TfmTypeClient {
    private final static Logger logger = LoggerFactory.getLogger(TfmTypeClient.class);

    @Autowired
    TfmTypeService tfmTypeService;

    //参数查询
    @ApiOperation(value = "带参查询列表", notes = "根据ID查询查询信息,返回一个的JSONObject对象")
    @RequestMapping(value = "/tfmtype-provider/tfmtype/tfmtype_list_param", method = RequestMethod.POST)
    public JSONObject selectTfmTypeListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            TfmType tfmType = new TfmType();
            tfmType.setId(id);
            List<TfmType> list = tfmTypeService.findTfmTypeList(tfmType);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "查询列表", notes = "自定义对象(条件)查询信息,返回存储在JSONObject对象中的列表")
    @RequestMapping(value = "/tfmtype-provider/tfmtype/tfmtype_list", method = RequestMethod.POST)
    public JSONObject selectTfmTypeList(@RequestBody TfmType tfmType) {
        JSONObject retJson = new JSONObject();
        try {
            List<TfmType> list = tfmTypeService.findTfmTypeList(tfmType);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询树形详情信息", notes = "按ID查询详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/tfmtype-provider/tfmtype/get-tfmtype/{id}", method = RequestMethod.POST)
    public TfmType getTfmTypeInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return tfmTypeService.getTfmTypeInfo(id);
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
    @RequestMapping(value = "/tfmtype-provider/tfmtype/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return tfmTypeService.selectObjectByTree();
    }

    /**
     * 删除-false
     *
     * @param tfmTypecId
     * @return
     */
    @ApiOperation(value = "伪删除信息", notes = "按ID伪删除信息,操作成功返回201")
    @RequestMapping(value = "/tfmtype-provider/tfmtype/del-tfmtype/{tfmTypeId}")
    public Object deleteTfmType(@PathVariable("tfmTypeId") String tfmTypecId) {
        return tfmTypeService.deleteTfmType(tfmTypecId);
    }

    /**
     * 删除-true
     *
     * @param tfmTypecId
     * @return
     */
    @ApiOperation(value = "删除信息", notes = "按ID删除信息,操作成功返回201")
    @RequestMapping(value = "/tfmtype-provider/tfmtype/del-tfmtype-real/{tfmTypeId}", method = RequestMethod.POST)
    public Object deleteTfmTypeReal(@PathVariable("tfmTypeId") String tfmTypecId) {
        return tfmTypeService.deleteTfmTypeReal(tfmTypecId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询信息-分页查询", notes = "查询信息-分页查询,Object")
    @RequestMapping(value = "/tfmtype-provider/tfmtype/tfmtype-page")
    public Object selectTfmTypeByPage(@RequestBody LayuiTableParam param) {
        return tfmTypeService.findTfmTypeByPage(param);
    }

    /**
     * 保存
     *
     * @param tfmType
     * @return
     */
    @ApiOperation(value = "新增信息", notes = "新增信息,操作成功返回500")
    @RequestMapping(value = "/tfmtype-provider/tfmtype/save_tfmtype", method = RequestMethod.POST)
    public int updateOrInsertTfmType(@RequestBody TfmType tfmType) {
        try {
            return tfmTypeService.updateOrInsertTfmType(tfmType);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
