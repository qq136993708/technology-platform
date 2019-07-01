package com.pcitc.web.laboratory;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.laboratory.LaboratoryBase;
import com.pcitc.base.laboratory.LaboratoryBaseExample;
import com.pcitc.service.laboratory.LaboratoryBaseService;
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
* <p>Table: laboratory_base - 实验室-基本情况</p>
*
* @since 2019-07-01 09:11:30
*/
@Api(value = "LaboratoryBaseClient-API", description = "实验室-基本情况服务接口")
@RestController
public class LaboratoryBaseClient
        {
        private final static Logger logger = LoggerFactory.getLogger(LaboratoryBaseClient.class);

        @Autowired
LaboratoryBaseService laboratoryBaseService;


        //参数查询
@ApiOperation(value = "带参实验室-基本情况查询列表", notes = "根据ID查询查询实验室-基本情况信息,返回一个实验室-基本情况的JSONObject对象")
        @RequestMapping(value = "/laboratorybase-provider/laboratorybase/laboratorybase_list_param",method = RequestMethod.POST)
        public JSONObject selectLaboratoryBaseListParam(@RequestParam(value="id", required=false) String id) {
             JSONObject retJson = new JSONObject();
                try {
LaboratoryBase laboratoryBase= new LaboratoryBase();
laboratoryBase.setId(id);
                    List<LaboratoryBase> list = laboratoryBaseService.findLaboratoryBaseList(laboratoryBase);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }

        //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
@ApiOperation(value = "实验室-基本情况查询列表", notes = "自定义对象(条件)查询实验室-基本情况信息,返回存储在JSONObject对象中的实验室-基本情况列表")
        @RequestMapping(value = "/laboratorybase-provider/laboratorybase/laboratorybase_list",method = RequestMethod.POST)
        public JSONObject selectLaboratoryBaseList(@RequestBody LaboratoryBase laboratoryBase) {
             JSONObject retJson = new JSONObject();
                try {
                List<LaboratoryBase> list = laboratoryBaseService.findLaboratoryBaseList(laboratoryBase);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }


@ApiOperation(value = "查询实验室-基本情况树形详情信息", notes = "按ID查询实验室-基本情况详情信息(带父ID),操作成功返回SysFileKind对象")
        @RequestMapping(value = "/laboratorybase-provider/laboratorybase/get-laboratorybase/{id}",method = RequestMethod.POST)
        public LaboratoryBase getLaboratoryBaseInfo(@PathVariable(value = "id", required = true) String id){
        try {
        return laboratoryBaseService.getLaboratoryBaseInfo(id);
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
@ApiOperation(value = "查询(树)实验室-基本情况信息", notes = "查询(树)实验室-基本情况信息,操作成功返回List<TreeNode>对象")
        @RequestMapping(value = "/laboratorybase-provider/laboratorybase/tree-data")
        @ResponseBody
        public List selectObjectByTree() throws Exception {
        return laboratoryBaseService.selectObjectByTree();
        }



        /**
        * 删除实验室-基本情况-false
        * @param laboratoryBasecId
        * @return
        */
    @ApiOperation(value = "伪删除实验室-基本情况信息", notes = "按ID伪删除实验室-基本情况信息,操作成功返回201")
        @RequestMapping(value = "/laboratorybase-provider/laboratorybase/del-laboratorybase/{laboratoryBaseId}")
        public Object deleteLaboratoryBase(@PathVariable("laboratoryBaseId") String laboratoryBasecId) {
    return laboratoryBaseService.deleteLaboratoryBase(laboratoryBasecId);
        }

        /**
        * 删除实验室-基本情况-true
        * @param laboratoryBasecId
        * @return
        */
    @ApiOperation(value = "删除实验室-基本情况信息", notes = "按ID删除实验室-基本情况信息,操作成功返回201")
        @RequestMapping(value = "/laboratorybase-provider/laboratorybase/del-laboratorybase-real/{laboratoryBaseId}", method = RequestMethod.POST)
        public Object deleteLaboratoryBaseReal(@PathVariable("laboratoryBaseId") String laboratoryBasecId) {
    return laboratoryBaseService.deleteLaboratoryBaseReal(laboratoryBasecId);
        }


        /**
        * 分页查询
        * @param param
        * @return
        */
    @ApiOperation(value = "查询实验室-基本情况信息-分页查询", notes = "查询实验室-基本情况信息-分页查询,Object")
        @RequestMapping(value = "/laboratorybase-provider/laboratorybase/laboratorybase-page")
        public Object selectLaboratoryBaseByPage(@RequestBody LayuiTableParam param) {
            return laboratoryBaseService.findLaboratoryBaseByPage(param);
            }

    /**
    * 保存
    * @param laboratoryBase
    * @return
    */
    @ApiOperation(value = "新增实验室-基本情况信息", notes = "新增实验室-基本情况信息,操作成功返回500")
    @RequestMapping(value = "/laboratorybase-provider/laboratorybase/save_laboratorybase", method = RequestMethod.POST)
    public int updateOrInsertLaboratoryBase(@RequestBody LaboratoryBase laboratoryBase) {
    try {
        return laboratoryBaseService.updateOrInsertLaboratoryBase(laboratoryBase);
    } catch (Exception e) {
    logger.error("[保存信息失败：]", e);
    }
    return 500;
    }
}
