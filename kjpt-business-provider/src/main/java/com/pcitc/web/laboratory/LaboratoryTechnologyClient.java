package com.pcitc.web.laboratory;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.laboratory.LaboratoryTechnology;
import com.pcitc.base.laboratory.LaboratoryTechnologyExample;
import com.pcitc.service.laboratory.LaboratoryTechnologyService;
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
* <p>Table: laboratory_technology - 实验室-知识产权-专有技术</p>
*
* @since 2019-07-01 09:14:45
*/
@Api(value = "LaboratoryTechnologyClient-API", description = "实验室-知识产权-专有技术服务接口")
@RestController
public class LaboratoryTechnologyClient
        {
        private final static Logger logger = LoggerFactory.getLogger(LaboratoryTechnologyClient.class);

        @Autowired
LaboratoryTechnologyService laboratoryTechnologyService;


        //参数查询
@ApiOperation(value = "带参实验室-知识产权-专有技术查询列表", notes = "根据ID查询查询实验室-知识产权-专有技术信息,返回一个实验室-知识产权-专有技术的JSONObject对象")
        @RequestMapping(value = "/laboratorytechnology-provider/laboratorytechnology/laboratorytechnology_list_param",method = RequestMethod.POST)
        public JSONObject selectLaboratoryTechnologyListParam(@RequestParam(value="id", required=false) String id) {
             JSONObject retJson = new JSONObject();
                try {
LaboratoryTechnology laboratoryTechnology= new LaboratoryTechnology();
laboratoryTechnology.setId(id);
                    List<LaboratoryTechnology> list = laboratoryTechnologyService.findLaboratoryTechnologyList(laboratoryTechnology);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }

        //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
@ApiOperation(value = "实验室-知识产权-专有技术查询列表", notes = "自定义对象(条件)查询实验室-知识产权-专有技术信息,返回存储在JSONObject对象中的实验室-知识产权-专有技术列表")
        @RequestMapping(value = "/laboratorytechnology-provider/laboratorytechnology/laboratorytechnology_list",method = RequestMethod.POST)
        public JSONObject selectLaboratoryTechnologyList(@RequestBody LaboratoryTechnology laboratoryTechnology) {
             JSONObject retJson = new JSONObject();
                try {
                List<LaboratoryTechnology> list = laboratoryTechnologyService.findLaboratoryTechnologyList(laboratoryTechnology);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }


@ApiOperation(value = "查询实验室-知识产权-专有技术树形详情信息", notes = "按ID查询实验室-知识产权-专有技术详情信息(带父ID),操作成功返回SysFileKind对象")
        @RequestMapping(value = "/laboratorytechnology-provider/laboratorytechnology/get-laboratorytechnology/{id}",method = RequestMethod.POST)
        public LaboratoryTechnology getLaboratoryTechnologyInfo(@PathVariable(value = "id", required = true) String id){
        try {
        return laboratoryTechnologyService.getLaboratoryTechnologyInfo(id);
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
@ApiOperation(value = "查询(树)实验室-知识产权-专有技术信息", notes = "查询(树)实验室-知识产权-专有技术信息,操作成功返回List<TreeNode>对象")
        @RequestMapping(value = "/laboratorytechnology-provider/laboratorytechnology/tree-data")
        @ResponseBody
        public List selectObjectByTree() throws Exception {
        return laboratoryTechnologyService.selectObjectByTree();
        }



        /**
        * 删除实验室-知识产权-专有技术-false
        * @param laboratoryTechnologycId
        * @return
        */
    @ApiOperation(value = "伪删除实验室-知识产权-专有技术信息", notes = "按ID伪删除实验室-知识产权-专有技术信息,操作成功返回201")
        @RequestMapping(value = "/laboratorytechnology-provider/laboratorytechnology/del-laboratorytechnology/{laboratoryTechnologyId}")
        public Object deleteLaboratoryTechnology(@PathVariable("laboratoryTechnologyId") String laboratoryTechnologycId) {
    return laboratoryTechnologyService.deleteLaboratoryTechnology(laboratoryTechnologycId);
        }

        /**
        * 删除实验室-知识产权-专有技术-true
        * @param laboratoryTechnologycId
        * @return
        */
    @ApiOperation(value = "删除实验室-知识产权-专有技术信息", notes = "按ID删除实验室-知识产权-专有技术信息,操作成功返回201")
        @RequestMapping(value = "/laboratorytechnology-provider/laboratorytechnology/del-laboratorytechnology-real/{laboratoryTechnologyId}", method = RequestMethod.POST)
        public Object deleteLaboratoryTechnologyReal(@PathVariable("laboratoryTechnologyId") String laboratoryTechnologycId) {
    return laboratoryTechnologyService.deleteLaboratoryTechnologyReal(laboratoryTechnologycId);
        }


        /**
        * 分页查询
        * @param param
        * @return
        */
    @ApiOperation(value = "查询实验室-知识产权-专有技术信息-分页查询", notes = "查询实验室-知识产权-专有技术信息-分页查询,Object")
        @RequestMapping(value = "/laboratorytechnology-provider/laboratorytechnology/laboratorytechnology-page")
        public Object selectLaboratoryTechnologyByPage(@RequestBody LayuiTableParam param) {
            return laboratoryTechnologyService.findLaboratoryTechnologyByPage(param);
            }

    /**
    * 保存
    * @param laboratoryTechnology
    * @return
    */
    @ApiOperation(value = "新增实验室-知识产权-专有技术信息", notes = "新增实验室-知识产权-专有技术信息,操作成功返回500")
    @RequestMapping(value = "/laboratorytechnology-provider/laboratorytechnology/save_laboratorytechnology", method = RequestMethod.POST)
    public int updateOrInsertLaboratoryTechnology(@RequestBody LaboratoryTechnology laboratoryTechnology) {
    try {
        return laboratoryTechnologyService.updateOrInsertLaboratoryTechnology(laboratoryTechnology);
    } catch (Exception e) {
    logger.error("[保存信息失败：]", e);
    }
    return 500;
    }
}
