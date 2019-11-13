package com.pcitc.web.expert;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.TechFamilyType;
import com.pcitc.base.expert.TechFamilyTypeExample;
import com.pcitc.service.expert.TechFamilyTypeService;
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
 * <p>Table: tech_family_type - 技术族-分类</p>
 *
 * @since 2018-12-29 11:34:35
 */
@Api(value = "TechFamilyTypeClient-API", description = "技术族-分类服务接口")
@RestController
public class TechFamilyTypeClient {
    private final static Logger logger = LoggerFactory.getLogger(TechFamilyTypeClient.class);

    @Autowired
    TechFamilyTypeService techFamilyTypeService;


    //参数查询
    @ApiOperation(value = "带参技术族-分类查询列表", notes = "根据ID查询查询技术族-分类信息,返回一个技术族-分类的JSONObject对象")
    @RequestMapping(value = "/techfamilytype-provider/techfamilytype/techfamilytype_list_param", method = RequestMethod.POST)
    public JSONObject selectTechFamilyTypeListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            TechFamilyType techFamilyType = new TechFamilyType();
            techFamilyType.setId(id);
            List<TechFamilyType> list = techFamilyTypeService.findTechFamilyTypeList(techFamilyType);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "技术族-分类查询列表", notes = "自定义对象(条件)查询技术族-分类信息,返回存储在JSONObject对象中的技术族-分类列表")
    @RequestMapping(value = "/techfamilytype-provider/techfamilytype/techfamilytype_list", method = RequestMethod.POST)
    public JSONObject selectTechFamilyTypeList(@RequestBody TechFamilyType techFamilyType) {
        JSONObject retJson = new JSONObject();
        try {
            List<TechFamilyType> list = techFamilyTypeService.findTechFamilyTypeList(techFamilyType);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }


    @ApiOperation(value = "查询技术族-分类树形详情信息", notes = "按ID查询技术族-分类详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/techfamilytype-provider/techfamilytype/get-techfamilytype/{id}", method = RequestMethod.POST)
    public TechFamilyType getTechFamilyTypeInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return techFamilyTypeService.getTechFamilyTypeInfo(id);
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
    @ApiOperation(value = "查询(树)技术族-分类信息", notes = "查询(树)技术族-分类信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/techfamilytype-provider/techfamilytype/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return techFamilyTypeService.selectObjectByTree();
    }


    /**
     * 删除技术族-分类-false
     *
     * @param techFamilyTypecId
     * @return
     */
    @ApiOperation(value = "伪删除技术族-分类信息", notes = "按ID伪删除技术族-分类信息,操作成功返回201")
    @RequestMapping(value = "/techfamilytype-provider/techfamilytype/del-techfamilytype/{techFamilyTypeId}")
    public Object deleteTechFamilyType(@PathVariable("techFamilyTypeId") String techFamilyTypecId) {
        return techFamilyTypeService.deleteTechFamilyType(techFamilyTypecId);
    }

    /**
     * 删除技术族-分类-true
     *
     * @param techFamilyTypecId
     * @return
     */
    @ApiOperation(value = "删除技术族-分类信息", notes = "按ID删除技术族-分类信息,操作成功返回201")
    @RequestMapping(value = "/techfamilytype-provider/techfamilytype/del-techfamilytype-real/{techFamilyTypeId}", method = RequestMethod.POST)
    public Object deleteTechFamilyTypeReal(@PathVariable("techFamilyTypeId") String techFamilyTypecId) {
        return techFamilyTypeService.deleteTechFamilyTypeReal(techFamilyTypecId);
    }


    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询技术族-分类信息-分页查询", notes = "查询技术族-分类信息-分页查询,Object")
    @RequestMapping(value = "/techfamilytype-provider/techfamilytype/techfamilytype-page")
    public Object selectTechFamilyTypeByPage(@RequestBody LayuiTableParam param) {
        return techFamilyTypeService.findTechFamilyTypeByPage(param);
    }

    /**
     * 保存
     *
     * @param techFamilyType
     * @return
     */
    @ApiOperation(value = "新增技术族-分类信息", notes = "新增技术族-分类信息,操作成功返回500")
    @RequestMapping(value = "/techfamilytype-provider/techfamilytype/save_techfamilytype", method = RequestMethod.POST)
    public int updateOrInsertTechFamilyType(@RequestBody TechFamilyType techFamilyType) {
        try {
            return techFamilyTypeService.updateOrInsertTechFamilyType(techFamilyType);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
