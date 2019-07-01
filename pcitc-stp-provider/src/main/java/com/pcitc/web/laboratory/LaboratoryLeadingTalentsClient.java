package com.pcitc.web.laboratory;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.laboratory.LaboratoryLeadingTalents;
import com.pcitc.base.laboratory.LaboratoryLeadingTalentsExample;
import com.pcitc.service.laboratory.LaboratoryLeadingTalentsService;
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
* <p>Table: laboratory_leading_talents - 实验室-领军人才</p>
*
* @since 2019-07-01 09:12:35
*/
@Api(value = "LaboratoryLeadingTalentsClient-API", description = "实验室-领军人才服务接口")
@RestController
public class LaboratoryLeadingTalentsClient
        {
        private final static Logger logger = LoggerFactory.getLogger(LaboratoryLeadingTalentsClient.class);

        @Autowired
LaboratoryLeadingTalentsService laboratoryLeadingTalentsService;


        //参数查询
@ApiOperation(value = "带参实验室-领军人才查询列表", notes = "根据ID查询查询实验室-领军人才信息,返回一个实验室-领军人才的JSONObject对象")
        @RequestMapping(value = "/laboratoryleadingtalents-provider/laboratoryleadingtalents/laboratoryleadingtalents_list_param",method = RequestMethod.POST)
        public JSONObject selectLaboratoryLeadingTalentsListParam(@RequestParam(value="id", required=false) String id) {
             JSONObject retJson = new JSONObject();
                try {
LaboratoryLeadingTalents laboratoryLeadingTalents= new LaboratoryLeadingTalents();
laboratoryLeadingTalents.setId(id);
                    List<LaboratoryLeadingTalents> list = laboratoryLeadingTalentsService.findLaboratoryLeadingTalentsList(laboratoryLeadingTalents);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }

        //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
@ApiOperation(value = "实验室-领军人才查询列表", notes = "自定义对象(条件)查询实验室-领军人才信息,返回存储在JSONObject对象中的实验室-领军人才列表")
        @RequestMapping(value = "/laboratoryleadingtalents-provider/laboratoryleadingtalents/laboratoryleadingtalents_list",method = RequestMethod.POST)
        public JSONObject selectLaboratoryLeadingTalentsList(@RequestBody LaboratoryLeadingTalents laboratoryLeadingTalents) {
             JSONObject retJson = new JSONObject();
                try {
                List<LaboratoryLeadingTalents> list = laboratoryLeadingTalentsService.findLaboratoryLeadingTalentsList(laboratoryLeadingTalents);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }


@ApiOperation(value = "查询实验室-领军人才树形详情信息", notes = "按ID查询实验室-领军人才详情信息(带父ID),操作成功返回SysFileKind对象")
        @RequestMapping(value = "/laboratoryleadingtalents-provider/laboratoryleadingtalents/get-laboratoryleadingtalents/{id}",method = RequestMethod.POST)
        public LaboratoryLeadingTalents getLaboratoryLeadingTalentsInfo(@PathVariable(value = "id", required = true) String id){
        try {
        return laboratoryLeadingTalentsService.getLaboratoryLeadingTalentsInfo(id);
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
@ApiOperation(value = "查询(树)实验室-领军人才信息", notes = "查询(树)实验室-领军人才信息,操作成功返回List<TreeNode>对象")
        @RequestMapping(value = "/laboratoryleadingtalents-provider/laboratoryleadingtalents/tree-data")
        @ResponseBody
        public List selectObjectByTree() throws Exception {
        return laboratoryLeadingTalentsService.selectObjectByTree();
        }



        /**
        * 删除实验室-领军人才-false
        * @param laboratoryLeadingTalentscId
        * @return
        */
    @ApiOperation(value = "伪删除实验室-领军人才信息", notes = "按ID伪删除实验室-领军人才信息,操作成功返回201")
        @RequestMapping(value = "/laboratoryleadingtalents-provider/laboratoryleadingtalents/del-laboratoryleadingtalents/{laboratoryLeadingTalentsId}")
        public Object deleteLaboratoryLeadingTalents(@PathVariable("laboratoryLeadingTalentsId") String laboratoryLeadingTalentscId) {
    return laboratoryLeadingTalentsService.deleteLaboratoryLeadingTalents(laboratoryLeadingTalentscId);
        }

        /**
        * 删除实验室-领军人才-true
        * @param laboratoryLeadingTalentscId
        * @return
        */
    @ApiOperation(value = "删除实验室-领军人才信息", notes = "按ID删除实验室-领军人才信息,操作成功返回201")
        @RequestMapping(value = "/laboratoryleadingtalents-provider/laboratoryleadingtalents/del-laboratoryleadingtalents-real/{laboratoryLeadingTalentsId}", method = RequestMethod.POST)
        public Object deleteLaboratoryLeadingTalentsReal(@PathVariable("laboratoryLeadingTalentsId") String laboratoryLeadingTalentscId) {
    return laboratoryLeadingTalentsService.deleteLaboratoryLeadingTalentsReal(laboratoryLeadingTalentscId);
        }


        /**
        * 分页查询
        * @param param
        * @return
        */
    @ApiOperation(value = "查询实验室-领军人才信息-分页查询", notes = "查询实验室-领军人才信息-分页查询,Object")
        @RequestMapping(value = "/laboratoryleadingtalents-provider/laboratoryleadingtalents/laboratoryleadingtalents-page")
        public Object selectLaboratoryLeadingTalentsByPage(@RequestBody LayuiTableParam param) {
            return laboratoryLeadingTalentsService.findLaboratoryLeadingTalentsByPage(param);
            }

    /**
    * 保存
    * @param laboratoryLeadingTalents
    * @return
    */
    @ApiOperation(value = "新增实验室-领军人才信息", notes = "新增实验室-领军人才信息,操作成功返回500")
    @RequestMapping(value = "/laboratoryleadingtalents-provider/laboratoryleadingtalents/save_laboratoryleadingtalents", method = RequestMethod.POST)
    public int updateOrInsertLaboratoryLeadingTalents(@RequestBody LaboratoryLeadingTalents laboratoryLeadingTalents) {
    try {
        return laboratoryLeadingTalentsService.updateOrInsertLaboratoryLeadingTalents(laboratoryLeadingTalents);
    } catch (Exception e) {
    logger.error("[保存信息失败：]", e);
    }
    return 500;
    }
}
