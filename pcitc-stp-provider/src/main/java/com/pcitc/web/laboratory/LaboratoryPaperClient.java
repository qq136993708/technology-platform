package com.pcitc.web.laboratory;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.laboratory.LaboratoryPaper;
import com.pcitc.base.laboratory.LaboratoryPaperExample;
import com.pcitc.service.laboratory.LaboratoryPaperService;
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
* <p>Table: laboratory_paper - 实验室-知识产权-论文</p>
*
* @since 2019-07-01 09:12:52
*/
@Api(value = "LaboratoryPaperClient-API", description = "实验室-知识产权-论文服务接口")
@RestController
public class LaboratoryPaperClient
        {
        private final static Logger logger = LoggerFactory.getLogger(LaboratoryPaperClient.class);

        @Autowired
LaboratoryPaperService laboratoryPaperService;


        //参数查询
@ApiOperation(value = "带参实验室-知识产权-论文查询列表", notes = "根据ID查询查询实验室-知识产权-论文信息,返回一个实验室-知识产权-论文的JSONObject对象")
        @RequestMapping(value = "/laboratorypaper-provider/laboratorypaper/laboratorypaper_list_param",method = RequestMethod.POST)
        public JSONObject selectLaboratoryPaperListParam(@RequestParam(value="id", required=false) String id) {
             JSONObject retJson = new JSONObject();
                try {
LaboratoryPaper laboratoryPaper= new LaboratoryPaper();
laboratoryPaper.setId(id);
                    List<LaboratoryPaper> list = laboratoryPaperService.findLaboratoryPaperList(laboratoryPaper);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }

        //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
@ApiOperation(value = "实验室-知识产权-论文查询列表", notes = "自定义对象(条件)查询实验室-知识产权-论文信息,返回存储在JSONObject对象中的实验室-知识产权-论文列表")
        @RequestMapping(value = "/laboratorypaper-provider/laboratorypaper/laboratorypaper_list",method = RequestMethod.POST)
        public JSONObject selectLaboratoryPaperList(@RequestBody LaboratoryPaper laboratoryPaper) {
             JSONObject retJson = new JSONObject();
                try {
                List<LaboratoryPaper> list = laboratoryPaperService.findLaboratoryPaperList(laboratoryPaper);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }


@ApiOperation(value = "查询实验室-知识产权-论文树形详情信息", notes = "按ID查询实验室-知识产权-论文详情信息(带父ID),操作成功返回SysFileKind对象")
        @RequestMapping(value = "/laboratorypaper-provider/laboratorypaper/get-laboratorypaper/{id}",method = RequestMethod.POST)
        public LaboratoryPaper getLaboratoryPaperInfo(@PathVariable(value = "id", required = true) String id){
        try {
        return laboratoryPaperService.getLaboratoryPaperInfo(id);
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
@ApiOperation(value = "查询(树)实验室-知识产权-论文信息", notes = "查询(树)实验室-知识产权-论文信息,操作成功返回List<TreeNode>对象")
        @RequestMapping(value = "/laboratorypaper-provider/laboratorypaper/tree-data")
        @ResponseBody
        public List selectObjectByTree() throws Exception {
        return laboratoryPaperService.selectObjectByTree();
        }



        /**
        * 删除实验室-知识产权-论文-false
        * @param laboratoryPapercId
        * @return
        */
    @ApiOperation(value = "伪删除实验室-知识产权-论文信息", notes = "按ID伪删除实验室-知识产权-论文信息,操作成功返回201")
        @RequestMapping(value = "/laboratorypaper-provider/laboratorypaper/del-laboratorypaper/{laboratoryPaperId}")
        public Object deleteLaboratoryPaper(@PathVariable("laboratoryPaperId") String laboratoryPapercId) {
    return laboratoryPaperService.deleteLaboratoryPaper(laboratoryPapercId);
        }

        /**
        * 删除实验室-知识产权-论文-true
        * @param laboratoryPapercId
        * @return
        */
    @ApiOperation(value = "删除实验室-知识产权-论文信息", notes = "按ID删除实验室-知识产权-论文信息,操作成功返回201")
        @RequestMapping(value = "/laboratorypaper-provider/laboratorypaper/del-laboratorypaper-real/{laboratoryPaperId}", method = RequestMethod.POST)
        public Object deleteLaboratoryPaperReal(@PathVariable("laboratoryPaperId") String laboratoryPapercId) {
    return laboratoryPaperService.deleteLaboratoryPaperReal(laboratoryPapercId);
        }


        /**
        * 分页查询
        * @param param
        * @return
        */
    @ApiOperation(value = "查询实验室-知识产权-论文信息-分页查询", notes = "查询实验室-知识产权-论文信息-分页查询,Object")
        @RequestMapping(value = "/laboratorypaper-provider/laboratorypaper/laboratorypaper-page")
        public Object selectLaboratoryPaperByPage(@RequestBody LayuiTableParam param) {
            return laboratoryPaperService.findLaboratoryPaperByPage(param);
            }

    /**
    * 保存
    * @param laboratoryPaper
    * @return
    */
    @ApiOperation(value = "新增实验室-知识产权-论文信息", notes = "新增实验室-知识产权-论文信息,操作成功返回500")
    @RequestMapping(value = "/laboratorypaper-provider/laboratorypaper/save_laboratorypaper", method = RequestMethod.POST)
    public int updateOrInsertLaboratoryPaper(@RequestBody LaboratoryPaper laboratoryPaper) {
    try {
        return laboratoryPaperService.updateOrInsertLaboratoryPaper(laboratoryPaper);
    } catch (Exception e) {
    logger.error("[保存信息失败：]", e);
    }
    return 500;
    }
}
