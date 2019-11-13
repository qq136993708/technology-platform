package com.pcitc.web.laboratory;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.laboratory.LaboratorySoftWork;
import com.pcitc.base.laboratory.LaboratorySoftWorkExample;
import com.pcitc.service.laboratory.LaboratorySoftWorkService;
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
* <p>Table: laboratory_soft_work - 实验室-知识产权-软著</p>
*
* @since 2019-07-01 09:14:14
*/
@Api(value = "LaboratorySoftWorkClient-API", description = "实验室-知识产权-软著服务接口")
@RestController
public class LaboratorySoftWorkClient
        {
        private final static Logger logger = LoggerFactory.getLogger(LaboratorySoftWorkClient.class);

        @Autowired
LaboratorySoftWorkService laboratorySoftWorkService;


        //参数查询
@ApiOperation(value = "带参实验室-知识产权-软著查询列表", notes = "根据ID查询查询实验室-知识产权-软著信息,返回一个实验室-知识产权-软著的JSONObject对象")
        @RequestMapping(value = "/laboratorysoftwork-provider/laboratorysoftwork/laboratorysoftwork_list_param",method = RequestMethod.POST)
        public JSONObject selectLaboratorySoftWorkListParam(@RequestParam(value="id", required=false) String id) {
             JSONObject retJson = new JSONObject();
                try {
LaboratorySoftWork laboratorySoftWork= new LaboratorySoftWork();
laboratorySoftWork.setId(id);
                    List<LaboratorySoftWork> list = laboratorySoftWorkService.findLaboratorySoftWorkList(laboratorySoftWork);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }

        //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
@ApiOperation(value = "实验室-知识产权-软著查询列表", notes = "自定义对象(条件)查询实验室-知识产权-软著信息,返回存储在JSONObject对象中的实验室-知识产权-软著列表")
        @RequestMapping(value = "/laboratorysoftwork-provider/laboratorysoftwork/laboratorysoftwork_list",method = RequestMethod.POST)
        public JSONObject selectLaboratorySoftWorkList(@RequestBody LaboratorySoftWork laboratorySoftWork) {
             JSONObject retJson = new JSONObject();
                try {
                List<LaboratorySoftWork> list = laboratorySoftWorkService.findLaboratorySoftWorkList(laboratorySoftWork);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }


@ApiOperation(value = "查询实验室-知识产权-软著树形详情信息", notes = "按ID查询实验室-知识产权-软著详情信息(带父ID),操作成功返回SysFileKind对象")
        @RequestMapping(value = "/laboratorysoftwork-provider/laboratorysoftwork/get-laboratorysoftwork/{id}",method = RequestMethod.POST)
        public LaboratorySoftWork getLaboratorySoftWorkInfo(@PathVariable(value = "id", required = true) String id){
        try {
        return laboratorySoftWorkService.getLaboratorySoftWorkInfo(id);
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
@ApiOperation(value = "查询(树)实验室-知识产权-软著信息", notes = "查询(树)实验室-知识产权-软著信息,操作成功返回List<TreeNode>对象")
        @RequestMapping(value = "/laboratorysoftwork-provider/laboratorysoftwork/tree-data")
        @ResponseBody
        public List selectObjectByTree() throws Exception {
        return laboratorySoftWorkService.selectObjectByTree();
        }



        /**
        * 删除实验室-知识产权-软著-false
        * @param laboratorySoftWorkcId
        * @return
        */
    @ApiOperation(value = "伪删除实验室-知识产权-软著信息", notes = "按ID伪删除实验室-知识产权-软著信息,操作成功返回201")
        @RequestMapping(value = "/laboratorysoftwork-provider/laboratorysoftwork/del-laboratorysoftwork/{laboratorySoftWorkId}")
        public Object deleteLaboratorySoftWork(@PathVariable("laboratorySoftWorkId") String laboratorySoftWorkcId) {
    return laboratorySoftWorkService.deleteLaboratorySoftWork(laboratorySoftWorkcId);
        }

        /**
        * 删除实验室-知识产权-软著-true
        * @param laboratorySoftWorkcId
        * @return
        */
    @ApiOperation(value = "删除实验室-知识产权-软著信息", notes = "按ID删除实验室-知识产权-软著信息,操作成功返回201")
        @RequestMapping(value = "/laboratorysoftwork-provider/laboratorysoftwork/del-laboratorysoftwork-real/{laboratorySoftWorkId}", method = RequestMethod.POST)
        public Object deleteLaboratorySoftWorkReal(@PathVariable("laboratorySoftWorkId") String laboratorySoftWorkcId) {
    return laboratorySoftWorkService.deleteLaboratorySoftWorkReal(laboratorySoftWorkcId);
        }


        /**
        * 分页查询
        * @param param
        * @return
        */
    @ApiOperation(value = "查询实验室-知识产权-软著信息-分页查询", notes = "查询实验室-知识产权-软著信息-分页查询,Object")
        @RequestMapping(value = "/laboratorysoftwork-provider/laboratorysoftwork/laboratorysoftwork-page")
        public Object selectLaboratorySoftWorkByPage(@RequestBody LayuiTableParam param) {
            return laboratorySoftWorkService.findLaboratorySoftWorkByPage(param);
            }

    /**
    * 保存
    * @param laboratorySoftWork
    * @return
    */
    @ApiOperation(value = "新增实验室-知识产权-软著信息", notes = "新增实验室-知识产权-软著信息,操作成功返回500")
    @RequestMapping(value = "/laboratorysoftwork-provider/laboratorysoftwork/save_laboratorysoftwork", method = RequestMethod.POST)
    public int updateOrInsertLaboratorySoftWork(@RequestBody LaboratorySoftWork laboratorySoftWork) {
    try {
        return laboratorySoftWorkService.updateOrInsertLaboratorySoftWork(laboratorySoftWork);
    } catch (Exception e) {
    logger.error("[保存信息失败：]", e);
    }
    return 500;
    }
}
