package com.pcitc.web.laboratory;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.laboratory.LaboratoryScientificTeam;
import com.pcitc.base.laboratory.LaboratoryScientificTeamExample;
import com.pcitc.service.laboratory.LaboratoryScientificTeamService;
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
* <p>Table: laboratory_scientific_team - 实验室-科研团队</p>
*
* @since 2019-07-01 09:14:00
*/
@Api(value = "LaboratoryScientificTeamClient-API", description = "实验室-科研团队服务接口")
@RestController
public class LaboratoryScientificTeamClient
        {
        private final static Logger logger = LoggerFactory.getLogger(LaboratoryScientificTeamClient.class);

        @Autowired
LaboratoryScientificTeamService laboratoryScientificTeamService;


        //参数查询
@ApiOperation(value = "带参实验室-科研团队查询列表", notes = "根据ID查询查询实验室-科研团队信息,返回一个实验室-科研团队的JSONObject对象")
        @RequestMapping(value = "/laboratoryscientificteam-provider/laboratoryscientificteam/laboratoryscientificteam_list_param",method = RequestMethod.POST)
        public JSONObject selectLaboratoryScientificTeamListParam(@RequestParam(value="id", required=false) String id) {
             JSONObject retJson = new JSONObject();
                try {
LaboratoryScientificTeam laboratoryScientificTeam= new LaboratoryScientificTeam();
laboratoryScientificTeam.setId(id);
                    List<LaboratoryScientificTeam> list = laboratoryScientificTeamService.findLaboratoryScientificTeamList(laboratoryScientificTeam);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }

        //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
@ApiOperation(value = "实验室-科研团队查询列表", notes = "自定义对象(条件)查询实验室-科研团队信息,返回存储在JSONObject对象中的实验室-科研团队列表")
        @RequestMapping(value = "/laboratoryscientificteam-provider/laboratoryscientificteam/laboratoryscientificteam_list",method = RequestMethod.POST)
        public JSONObject selectLaboratoryScientificTeamList(@RequestBody LaboratoryScientificTeam laboratoryScientificTeam) {
             JSONObject retJson = new JSONObject();
                try {
                List<LaboratoryScientificTeam> list = laboratoryScientificTeamService.findLaboratoryScientificTeamList(laboratoryScientificTeam);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }


@ApiOperation(value = "查询实验室-科研团队树形详情信息", notes = "按ID查询实验室-科研团队详情信息(带父ID),操作成功返回SysFileKind对象")
        @RequestMapping(value = "/laboratoryscientificteam-provider/laboratoryscientificteam/get-laboratoryscientificteam/{id}",method = RequestMethod.POST)
        public LaboratoryScientificTeam getLaboratoryScientificTeamInfo(@PathVariable(value = "id", required = true) String id){
        try {
        return laboratoryScientificTeamService.getLaboratoryScientificTeamInfo(id);
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
@ApiOperation(value = "查询(树)实验室-科研团队信息", notes = "查询(树)实验室-科研团队信息,操作成功返回List<TreeNode>对象")
        @RequestMapping(value = "/laboratoryscientificteam-provider/laboratoryscientificteam/tree-data")
        @ResponseBody
        public List selectObjectByTree() throws Exception {
        return laboratoryScientificTeamService.selectObjectByTree();
        }



        /**
        * 删除实验室-科研团队-false
        * @param laboratoryScientificTeamcId
        * @return
        */
    @ApiOperation(value = "伪删除实验室-科研团队信息", notes = "按ID伪删除实验室-科研团队信息,操作成功返回201")
        @RequestMapping(value = "/laboratoryscientificteam-provider/laboratoryscientificteam/del-laboratoryscientificteam/{laboratoryScientificTeamId}")
        public Object deleteLaboratoryScientificTeam(@PathVariable("laboratoryScientificTeamId") String laboratoryScientificTeamcId) {
    return laboratoryScientificTeamService.deleteLaboratoryScientificTeam(laboratoryScientificTeamcId);
        }

        /**
        * 删除实验室-科研团队-true
        * @param laboratoryScientificTeamcId
        * @return
        */
    @ApiOperation(value = "删除实验室-科研团队信息", notes = "按ID删除实验室-科研团队信息,操作成功返回201")
        @RequestMapping(value = "/laboratoryscientificteam-provider/laboratoryscientificteam/del-laboratoryscientificteam-real/{laboratoryScientificTeamId}", method = RequestMethod.POST)
        public Object deleteLaboratoryScientificTeamReal(@PathVariable("laboratoryScientificTeamId") String laboratoryScientificTeamcId) {
    return laboratoryScientificTeamService.deleteLaboratoryScientificTeamReal(laboratoryScientificTeamcId);
        }


        /**
        * 分页查询
        * @param param
        * @return
        */
    @ApiOperation(value = "查询实验室-科研团队信息-分页查询", notes = "查询实验室-科研团队信息-分页查询,Object")
        @RequestMapping(value = "/laboratoryscientificteam-provider/laboratoryscientificteam/laboratoryscientificteam-page")
        public Object selectLaboratoryScientificTeamByPage(@RequestBody LayuiTableParam param) {
            return laboratoryScientificTeamService.findLaboratoryScientificTeamByPage(param);
            }

    /**
    * 保存
    * @param laboratoryScientificTeam
    * @return
    */
    @ApiOperation(value = "新增实验室-科研团队信息", notes = "新增实验室-科研团队信息,操作成功返回500")
    @RequestMapping(value = "/laboratoryscientificteam-provider/laboratoryscientificteam/save_laboratoryscientificteam", method = RequestMethod.POST)
    public int updateOrInsertLaboratoryScientificTeam(@RequestBody LaboratoryScientificTeam laboratoryScientificTeam) {
    try {
        return laboratoryScientificTeamService.updateOrInsertLaboratoryScientificTeam(laboratoryScientificTeam);
    } catch (Exception e) {
    logger.error("[保存信息失败：]", e);
    }
    return 500;
    }
}
