package com.pcitc.web.laboratory;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.laboratory.LaboratoryPatent;
import com.pcitc.base.laboratory.LaboratoryPatentExample;
import com.pcitc.service.laboratory.LaboratoryPatentService;
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
* <p>Table: laboratory_patent - 实验室-知识产权-专利</p>
*
* @since 2019-07-01 09:13:14
*/
@Api(value = "LaboratoryPatentClient-API", description = "实验室-知识产权-专利服务接口")
@RestController
public class LaboratoryPatentClient
        {
        private final static Logger logger = LoggerFactory.getLogger(LaboratoryPatentClient.class);

        @Autowired
LaboratoryPatentService laboratoryPatentService;


        //参数查询
@ApiOperation(value = "带参实验室-知识产权-专利查询列表", notes = "根据ID查询查询实验室-知识产权-专利信息,返回一个实验室-知识产权-专利的JSONObject对象")
        @RequestMapping(value = "/laboratorypatent-provider/laboratorypatent/laboratorypatent_list_param",method = RequestMethod.POST)
        public JSONObject selectLaboratoryPatentListParam(@RequestParam(value="id", required=false) String id) {
             JSONObject retJson = new JSONObject();
                try {
LaboratoryPatent laboratoryPatent= new LaboratoryPatent();
laboratoryPatent.setId(id);
                    List<LaboratoryPatent> list = laboratoryPatentService.findLaboratoryPatentList(laboratoryPatent);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }

        //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
@ApiOperation(value = "实验室-知识产权-专利查询列表", notes = "自定义对象(条件)查询实验室-知识产权-专利信息,返回存储在JSONObject对象中的实验室-知识产权-专利列表")
        @RequestMapping(value = "/laboratorypatent-provider/laboratorypatent/laboratorypatent_list",method = RequestMethod.POST)
        public JSONObject selectLaboratoryPatentList(@RequestBody LaboratoryPatent laboratoryPatent) {
             JSONObject retJson = new JSONObject();
                try {
                List<LaboratoryPatent> list = laboratoryPatentService.findLaboratoryPatentList(laboratoryPatent);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }


@ApiOperation(value = "查询实验室-知识产权-专利树形详情信息", notes = "按ID查询实验室-知识产权-专利详情信息(带父ID),操作成功返回SysFileKind对象")
        @RequestMapping(value = "/laboratorypatent-provider/laboratorypatent/get-laboratorypatent/{id}",method = RequestMethod.POST)
        public LaboratoryPatent getLaboratoryPatentInfo(@PathVariable(value = "id", required = true) String id){
        try {
        return laboratoryPatentService.getLaboratoryPatentInfo(id);
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
@ApiOperation(value = "查询(树)实验室-知识产权-专利信息", notes = "查询(树)实验室-知识产权-专利信息,操作成功返回List<TreeNode>对象")
        @RequestMapping(value = "/laboratorypatent-provider/laboratorypatent/tree-data")
        @ResponseBody
        public List selectObjectByTree() throws Exception {
        return laboratoryPatentService.selectObjectByTree();
        }



        /**
        * 删除实验室-知识产权-专利-false
        * @param laboratoryPatentcId
        * @return
        */
    @ApiOperation(value = "伪删除实验室-知识产权-专利信息", notes = "按ID伪删除实验室-知识产权-专利信息,操作成功返回201")
        @RequestMapping(value = "/laboratorypatent-provider/laboratorypatent/del-laboratorypatent/{laboratoryPatentId}")
        public Object deleteLaboratoryPatent(@PathVariable("laboratoryPatentId") String laboratoryPatentcId) {
    return laboratoryPatentService.deleteLaboratoryPatent(laboratoryPatentcId);
        }

        /**
        * 删除实验室-知识产权-专利-true
        * @param laboratoryPatentcId
        * @return
        */
    @ApiOperation(value = "删除实验室-知识产权-专利信息", notes = "按ID删除实验室-知识产权-专利信息,操作成功返回201")
        @RequestMapping(value = "/laboratorypatent-provider/laboratorypatent/del-laboratorypatent-real/{laboratoryPatentId}", method = RequestMethod.POST)
        public Object deleteLaboratoryPatentReal(@PathVariable("laboratoryPatentId") String laboratoryPatentcId) {
    return laboratoryPatentService.deleteLaboratoryPatentReal(laboratoryPatentcId);
        }


        /**
        * 分页查询
        * @param param
        * @return
        */
    @ApiOperation(value = "查询实验室-知识产权-专利信息-分页查询", notes = "查询实验室-知识产权-专利信息-分页查询,Object")
        @RequestMapping(value = "/laboratorypatent-provider/laboratorypatent/laboratorypatent-page")
        public Object selectLaboratoryPatentByPage(@RequestBody LayuiTableParam param) {
            return laboratoryPatentService.findLaboratoryPatentByPage(param);
            }

    /**
    * 保存
    * @param laboratoryPatent
    * @return
    */
    @ApiOperation(value = "新增实验室-知识产权-专利信息", notes = "新增实验室-知识产权-专利信息,操作成功返回500")
    @RequestMapping(value = "/laboratorypatent-provider/laboratorypatent/save_laboratorypatent", method = RequestMethod.POST)
    public int updateOrInsertLaboratoryPatent(@RequestBody LaboratoryPatent laboratoryPatent) {
    try {
        return laboratoryPatentService.updateOrInsertLaboratoryPatent(laboratoryPatent);
    } catch (Exception e) {
    logger.error("[保存信息失败：]", e);
    }
    return 500;
    }
}
