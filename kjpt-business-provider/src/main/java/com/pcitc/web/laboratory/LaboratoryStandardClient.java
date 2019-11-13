package com.pcitc.web.laboratory;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.laboratory.LaboratoryStandard;
import com.pcitc.base.laboratory.LaboratoryStandardExample;
import com.pcitc.service.laboratory.LaboratoryStandardService;
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
* <p>Table: laboratory_standard - 实验室-标准情况</p>
*
* @since 2019-07-01 09:14:31
*/
@Api(value = "LaboratoryStandardClient-API", description = "实验室-标准情况服务接口")
@RestController
public class LaboratoryStandardClient
        {
        private final static Logger logger = LoggerFactory.getLogger(LaboratoryStandardClient.class);

        @Autowired
LaboratoryStandardService laboratoryStandardService;


        //参数查询
@ApiOperation(value = "带参实验室-标准情况查询列表", notes = "根据ID查询查询实验室-标准情况信息,返回一个实验室-标准情况的JSONObject对象")
        @RequestMapping(value = "/laboratorystandard-provider/laboratorystandard/laboratorystandard_list_param",method = RequestMethod.POST)
        public JSONObject selectLaboratoryStandardListParam(@RequestParam(value="id", required=false) String id) {
             JSONObject retJson = new JSONObject();
                try {
LaboratoryStandard laboratoryStandard= new LaboratoryStandard();
laboratoryStandard.setId(id);
                    List<LaboratoryStandard> list = laboratoryStandardService.findLaboratoryStandardList(laboratoryStandard);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }

        //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
@ApiOperation(value = "实验室-标准情况查询列表", notes = "自定义对象(条件)查询实验室-标准情况信息,返回存储在JSONObject对象中的实验室-标准情况列表")
        @RequestMapping(value = "/laboratorystandard-provider/laboratorystandard/laboratorystandard_list",method = RequestMethod.POST)
        public JSONObject selectLaboratoryStandardList(@RequestBody LaboratoryStandard laboratoryStandard) {
             JSONObject retJson = new JSONObject();
                try {
                List<LaboratoryStandard> list = laboratoryStandardService.findLaboratoryStandardList(laboratoryStandard);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }


@ApiOperation(value = "查询实验室-标准情况树形详情信息", notes = "按ID查询实验室-标准情况详情信息(带父ID),操作成功返回SysFileKind对象")
        @RequestMapping(value = "/laboratorystandard-provider/laboratorystandard/get-laboratorystandard/{id}",method = RequestMethod.POST)
        public LaboratoryStandard getLaboratoryStandardInfo(@PathVariable(value = "id", required = true) String id){
        try {
        return laboratoryStandardService.getLaboratoryStandardInfo(id);
        } catch (Exception e) {
        logger.error("[初始化信息失败：]", e);
        }
        return null;
        }


        /**
        * 树形展示
        * @return
        * @throws Exception
        */
@ApiOperation(value = "查询(树)实验室-标准情况信息", notes = "查询(树)实验室-标准情况信息,操作成功返回List<TreeNode>对象")
        @RequestMapping(value = "/laboratorystandard-provider/laboratorystandard/tree-data")
        @ResponseBody
        public List selectObjectByTree() throws Exception {
        return laboratoryStandardService.selectObjectByTree();
        }



        /**
        * 删除实验室-标准情况-false
        * @param laboratoryStandardcId
        * @return
        */
    @ApiOperation(value = "伪删除实验室-标准情况信息", notes = "按ID伪删除实验室-标准情况信息,操作成功返回201")
        @RequestMapping(value = "/laboratorystandard-provider/laboratorystandard/del-laboratorystandard/{laboratoryStandardId}")
        public Object deleteLaboratoryStandard(@PathVariable("laboratoryStandardId") String laboratoryStandardcId) {
    return laboratoryStandardService.deleteLaboratoryStandard(laboratoryStandardcId);
        }

        /**
        * 删除实验室-标准情况-true
        * @param laboratoryStandardcId
        * @return
        */
    @ApiOperation(value = "删除实验室-标准情况信息", notes = "按ID删除实验室-标准情况信息,操作成功返回201")
        @RequestMapping(value = "/laboratorystandard-provider/laboratorystandard/del-laboratorystandard-real/{laboratoryStandardId}", method = RequestMethod.POST)
        public Object deleteLaboratoryStandardReal(@PathVariable("laboratoryStandardId") String laboratoryStandardcId) {
    return laboratoryStandardService.deleteLaboratoryStandardReal(laboratoryStandardcId);
        }


        /**
        * 分页查询
        * @param param
        * @return
        */
    @ApiOperation(value = "查询实验室-标准情况信息-分页查询", notes = "查询实验室-标准情况信息-分页查询,Object")
        @RequestMapping(value = "/laboratorystandard-provider/laboratorystandard/laboratorystandard-page")
        public Object selectLaboratoryStandardByPage(@RequestBody LayuiTableParam param) {
            return laboratoryStandardService.findLaboratoryStandardByPage(param);
            }

    /**
    * 保存
    * @param laboratoryStandard
    * @return
    */
    @ApiOperation(value = "新增实验室-标准情况信息", notes = "新增实验室-标准情况信息,操作成功返回500")
    @RequestMapping(value = "/laboratorystandard-provider/laboratorystandard/save_laboratorystandard", method = RequestMethod.POST)
    public int updateOrInsertLaboratoryStandard(@RequestBody LaboratoryStandard laboratoryStandard) {
    try {
        return laboratoryStandardService.updateOrInsertLaboratoryStandard(laboratoryStandard);
    } catch (Exception e) {
    logger.error("[保存信息失败：]", e);
    }
    return 500;
    }
}
