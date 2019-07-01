package com.pcitc.web.laboratory;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.laboratory.LaboratoryScientificTask;
import com.pcitc.base.laboratory.LaboratoryScientificTaskExample;
import com.pcitc.service.laboratory.LaboratoryScientificTaskService;
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
* <p>Table: laboratory_scientific_task - 实验室-重大科研任务</p>
*
* @since 2019-07-01 09:13:29
*/
@Api(value = "LaboratoryScientificTaskClient-API", description = "实验室-重大科研任务服务接口")
@RestController
public class LaboratoryScientificTaskClient
        {
        private final static Logger logger = LoggerFactory.getLogger(LaboratoryScientificTaskClient.class);

        @Autowired
LaboratoryScientificTaskService laboratoryScientificTaskService;


        //参数查询
@ApiOperation(value = "带参实验室-重大科研任务查询列表", notes = "根据ID查询查询实验室-重大科研任务信息,返回一个实验室-重大科研任务的JSONObject对象")
        @RequestMapping(value = "/laboratoryscientifictask-provider/laboratoryscientifictask/laboratoryscientifictask_list_param",method = RequestMethod.POST)
        public JSONObject selectLaboratoryScientificTaskListParam(@RequestParam(value="id", required=false) String id) {
             JSONObject retJson = new JSONObject();
                try {
LaboratoryScientificTask laboratoryScientificTask= new LaboratoryScientificTask();
laboratoryScientificTask.setId(id);
                    List<LaboratoryScientificTask> list = laboratoryScientificTaskService.findLaboratoryScientificTaskList(laboratoryScientificTask);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }

        //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
@ApiOperation(value = "实验室-重大科研任务查询列表", notes = "自定义对象(条件)查询实验室-重大科研任务信息,返回存储在JSONObject对象中的实验室-重大科研任务列表")
        @RequestMapping(value = "/laboratoryscientifictask-provider/laboratoryscientifictask/laboratoryscientifictask_list",method = RequestMethod.POST)
        public JSONObject selectLaboratoryScientificTaskList(@RequestBody LaboratoryScientificTask laboratoryScientificTask) {
             JSONObject retJson = new JSONObject();
                try {
                List<LaboratoryScientificTask> list = laboratoryScientificTaskService.findLaboratoryScientificTaskList(laboratoryScientificTask);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }


@ApiOperation(value = "查询实验室-重大科研任务树形详情信息", notes = "按ID查询实验室-重大科研任务详情信息(带父ID),操作成功返回SysFileKind对象")
        @RequestMapping(value = "/laboratoryscientifictask-provider/laboratoryscientifictask/get-laboratoryscientifictask/{id}",method = RequestMethod.POST)
        public LaboratoryScientificTask getLaboratoryScientificTaskInfo(@PathVariable(value = "id", required = true) String id){
        try {
        return laboratoryScientificTaskService.getLaboratoryScientificTaskInfo(id);
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
@ApiOperation(value = "查询(树)实验室-重大科研任务信息", notes = "查询(树)实验室-重大科研任务信息,操作成功返回List<TreeNode>对象")
        @RequestMapping(value = "/laboratoryscientifictask-provider/laboratoryscientifictask/tree-data")
        @ResponseBody
        public List selectObjectByTree() throws Exception {
        return laboratoryScientificTaskService.selectObjectByTree();
        }



        /**
        * 删除实验室-重大科研任务-false
        * @param laboratoryScientificTaskcId
        * @return
        */
    @ApiOperation(value = "伪删除实验室-重大科研任务信息", notes = "按ID伪删除实验室-重大科研任务信息,操作成功返回201")
        @RequestMapping(value = "/laboratoryscientifictask-provider/laboratoryscientifictask/del-laboratoryscientifictask/{laboratoryScientificTaskId}")
        public Object deleteLaboratoryScientificTask(@PathVariable("laboratoryScientificTaskId") String laboratoryScientificTaskcId) {
    return laboratoryScientificTaskService.deleteLaboratoryScientificTask(laboratoryScientificTaskcId);
        }

        /**
        * 删除实验室-重大科研任务-true
        * @param laboratoryScientificTaskcId
        * @return
        */
    @ApiOperation(value = "删除实验室-重大科研任务信息", notes = "按ID删除实验室-重大科研任务信息,操作成功返回201")
        @RequestMapping(value = "/laboratoryscientifictask-provider/laboratoryscientifictask/del-laboratoryscientifictask-real/{laboratoryScientificTaskId}", method = RequestMethod.POST)
        public Object deleteLaboratoryScientificTaskReal(@PathVariable("laboratoryScientificTaskId") String laboratoryScientificTaskcId) {
    return laboratoryScientificTaskService.deleteLaboratoryScientificTaskReal(laboratoryScientificTaskcId);
        }


        /**
        * 分页查询
        * @param param
        * @return
        */
    @ApiOperation(value = "查询实验室-重大科研任务信息-分页查询", notes = "查询实验室-重大科研任务信息-分页查询,Object")
        @RequestMapping(value = "/laboratoryscientifictask-provider/laboratoryscientifictask/laboratoryscientifictask-page")
        public Object selectLaboratoryScientificTaskByPage(@RequestBody LayuiTableParam param) {
            return laboratoryScientificTaskService.findLaboratoryScientificTaskByPage(param);
            }

    /**
    * 保存
    * @param laboratoryScientificTask
    * @return
    */
    @ApiOperation(value = "新增实验室-重大科研任务信息", notes = "新增实验室-重大科研任务信息,操作成功返回500")
    @RequestMapping(value = "/laboratoryscientifictask-provider/laboratoryscientifictask/save_laboratoryscientifictask", method = RequestMethod.POST)
    public int updateOrInsertLaboratoryScientificTask(@RequestBody LaboratoryScientificTask laboratoryScientificTask) {
    try {
        return laboratoryScientificTaskService.updateOrInsertLaboratoryScientificTask(laboratoryScientificTask);
    } catch (Exception e) {
    logger.error("[保存信息失败：]", e);
    }
    return 500;
    }
}
