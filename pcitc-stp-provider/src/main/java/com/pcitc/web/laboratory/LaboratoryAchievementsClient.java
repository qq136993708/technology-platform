package com.pcitc.web.laboratory;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.laboratory.LaboratoryAchievements;
import com.pcitc.base.laboratory.LaboratoryAchievementsExample;
import com.pcitc.service.laboratory.LaboratoryAchievementsService;
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
* <p>Table: laboratory_achievements - 实验室-研究成果</p>
*
* @since 2019-07-01 09:11:59
*/
@Api(value = "LaboratoryAchievementsClient-API", description = "实验室-研究成果服务接口")
@RestController
public class LaboratoryAchievementsClient
        {
        private final static Logger logger = LoggerFactory.getLogger(LaboratoryAchievementsClient.class);

        @Autowired
LaboratoryAchievementsService laboratoryAchievementsService;


        //参数查询
@ApiOperation(value = "带参实验室-研究成果查询列表", notes = "根据ID查询查询实验室-研究成果信息,返回一个实验室-研究成果的JSONObject对象")
        @RequestMapping(value = "/laboratoryachievements-provider/laboratoryachievements/laboratoryachievements_list_param",method = RequestMethod.POST)
        public JSONObject selectLaboratoryAchievementsListParam(@RequestParam(value="id", required=false) String id) {
             JSONObject retJson = new JSONObject();
                try {
LaboratoryAchievements laboratoryAchievements= new LaboratoryAchievements();
laboratoryAchievements.setId(id);
                    List<LaboratoryAchievements> list = laboratoryAchievementsService.findLaboratoryAchievementsList(laboratoryAchievements);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }

        //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
@ApiOperation(value = "实验室-研究成果查询列表", notes = "自定义对象(条件)查询实验室-研究成果信息,返回存储在JSONObject对象中的实验室-研究成果列表")
        @RequestMapping(value = "/laboratoryachievements-provider/laboratoryachievements/laboratoryachievements_list",method = RequestMethod.POST)
        public JSONObject selectLaboratoryAchievementsList(@RequestBody LaboratoryAchievements laboratoryAchievements) {
             JSONObject retJson = new JSONObject();
                try {
                List<LaboratoryAchievements> list = laboratoryAchievementsService.findLaboratoryAchievementsList(laboratoryAchievements);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }


@ApiOperation(value = "查询实验室-研究成果树形详情信息", notes = "按ID查询实验室-研究成果详情信息(带父ID),操作成功返回SysFileKind对象")
        @RequestMapping(value = "/laboratoryachievements-provider/laboratoryachievements/get-laboratoryachievements/{id}",method = RequestMethod.POST)
        public LaboratoryAchievements getLaboratoryAchievementsInfo(@PathVariable(value = "id", required = true) String id){
        try {
        return laboratoryAchievementsService.getLaboratoryAchievementsInfo(id);
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
@ApiOperation(value = "查询(树)实验室-研究成果信息", notes = "查询(树)实验室-研究成果信息,操作成功返回List<TreeNode>对象")
        @RequestMapping(value = "/laboratoryachievements-provider/laboratoryachievements/tree-data")
        @ResponseBody
        public List selectObjectByTree() throws Exception {
        return laboratoryAchievementsService.selectObjectByTree();
        }



        /**
        * 删除实验室-研究成果-false
        * @param laboratoryAchievementscId
        * @return
        */
    @ApiOperation(value = "伪删除实验室-研究成果信息", notes = "按ID伪删除实验室-研究成果信息,操作成功返回201")
        @RequestMapping(value = "/laboratoryachievements-provider/laboratoryachievements/del-laboratoryachievements/{laboratoryAchievementsId}")
        public Object deleteLaboratoryAchievements(@PathVariable("laboratoryAchievementsId") String laboratoryAchievementscId) {
    return laboratoryAchievementsService.deleteLaboratoryAchievements(laboratoryAchievementscId);
        }

        /**
        * 删除实验室-研究成果-true
        * @param laboratoryAchievementscId
        * @return
        */
    @ApiOperation(value = "删除实验室-研究成果信息", notes = "按ID删除实验室-研究成果信息,操作成功返回201")
        @RequestMapping(value = "/laboratoryachievements-provider/laboratoryachievements/del-laboratoryachievements-real/{laboratoryAchievementsId}", method = RequestMethod.POST)
        public Object deleteLaboratoryAchievementsReal(@PathVariable("laboratoryAchievementsId") String laboratoryAchievementscId) {
    return laboratoryAchievementsService.deleteLaboratoryAchievementsReal(laboratoryAchievementscId);
        }


        /**
        * 分页查询
        * @param param
        * @return
        */
    @ApiOperation(value = "查询实验室-研究成果信息-分页查询", notes = "查询实验室-研究成果信息-分页查询,Object")
        @RequestMapping(value = "/laboratoryachievements-provider/laboratoryachievements/laboratoryachievements-page")
        public Object selectLaboratoryAchievementsByPage(@RequestBody LayuiTableParam param) {
            return laboratoryAchievementsService.findLaboratoryAchievementsByPage(param);
            }

    /**
    * 保存
    * @param laboratoryAchievements
    * @return
    */
    @ApiOperation(value = "新增实验室-研究成果信息", notes = "新增实验室-研究成果信息,操作成功返回500")
    @RequestMapping(value = "/laboratoryachievements-provider/laboratoryachievements/save_laboratoryachievements", method = RequestMethod.POST)
    public int updateOrInsertLaboratoryAchievements(@RequestBody LaboratoryAchievements laboratoryAchievements) {
    try {
        return laboratoryAchievementsService.updateOrInsertLaboratoryAchievements(laboratoryAchievements);
    } catch (Exception e) {
    logger.error("[保存信息失败：]", e);
    }
    return 500;
    }
}
