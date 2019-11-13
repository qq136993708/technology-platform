package com.pcitc.web.laboratory;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.laboratory.LaboratoryBasicProject;
import com.pcitc.service.laboratory.LaboratoryBasicProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
* <p>服务接口</p>
* <p>Table: laboratory_basic_project - 实验室-基础性前瞻性研究项目</p>
*
* @since 2019-07-01 09:12:14
*/
@Api(value = "LaboratoryBasicProjectClient-API", description = "实验室-基础性前瞻性研究项目服务接口")
@RestController
public class LaboratoryBasicProjectClient
        {
        private final static Logger logger = LoggerFactory.getLogger(LaboratoryBasicProjectClient.class);

        @Autowired
LaboratoryBasicProjectService laboratoryBasicProjectService;


        //参数查询
@ApiOperation(value = "带参实验室-基础性前瞻性研究项目查询列表", notes = "根据ID查询查询实验室-基础性前瞻性研究项目信息,返回一个实验室-基础性前瞻性研究项目的JSONObject对象")
        @RequestMapping(value = "/laboratorybasicproject-provider/laboratorybasicproject/laboratorybasicproject_list_param",method = RequestMethod.POST)
        public JSONObject selectLaboratoryBasicProjectListParam(@RequestParam(value="id", required=false) String id) {
             JSONObject retJson = new JSONObject();
                try {
LaboratoryBasicProject laboratoryBasicProject= new LaboratoryBasicProject();
laboratoryBasicProject.setId(id);
                    List<LaboratoryBasicProject> list = laboratoryBasicProjectService.findLaboratoryBasicProjectList(laboratoryBasicProject);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }

        //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
@ApiOperation(value = "实验室-基础性前瞻性研究项目查询列表", notes = "自定义对象(条件)查询实验室-基础性前瞻性研究项目信息,返回存储在JSONObject对象中的实验室-基础性前瞻性研究项目列表")
        @RequestMapping(value = "/laboratorybasicproject-provider/laboratorybasicproject/laboratorybasicproject_list",method = RequestMethod.POST)
        public JSONObject selectLaboratoryBasicProjectList(@RequestBody LaboratoryBasicProject laboratoryBasicProject) {
             JSONObject retJson = new JSONObject();
                try {
                List<LaboratoryBasicProject> list = laboratoryBasicProjectService.findLaboratoryBasicProjectList(laboratoryBasicProject);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }


@ApiOperation(value = "查询实验室-基础性前瞻性研究项目树形详情信息", notes = "按ID查询实验室-基础性前瞻性研究项目详情信息(带父ID),操作成功返回SysFileKind对象")
        @RequestMapping(value = "/laboratorybasicproject-provider/laboratorybasicproject/get-laboratorybasicproject/{id}",method = RequestMethod.POST)
        public LaboratoryBasicProject getLaboratoryBasicProjectInfo(@PathVariable(value = "id", required = true) String id){
        try {
        return laboratoryBasicProjectService.getLaboratoryBasicProjectInfo(id);
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
		@ApiOperation(value = "查询(树)实验室-基础性前瞻性研究项目信息", notes = "查询(树)实验室-基础性前瞻性研究项目信息,操作成功返回List<TreeNode>对象")
        @RequestMapping(value = "/laboratorybasicproject-provider/laboratorybasicproject/tree-data")
        @ResponseBody
        public List<?> selectObjectByTree() throws Exception {
        return laboratoryBasicProjectService.selectObjectByTree();
        }



        /**
        * 删除实验室-基础性前瞻性研究项目-false
        * @param laboratoryBasicProjectcId
        * @return
        */
    @ApiOperation(value = "伪删除实验室-基础性前瞻性研究项目信息", notes = "按ID伪删除实验室-基础性前瞻性研究项目信息,操作成功返回201")
        @RequestMapping(value = "/laboratorybasicproject-provider/laboratorybasicproject/del-laboratorybasicproject/{laboratoryBasicProjectId}")
        public Object deleteLaboratoryBasicProject(@PathVariable("laboratoryBasicProjectId") String laboratoryBasicProjectcId) {
    return laboratoryBasicProjectService.deleteLaboratoryBasicProject(laboratoryBasicProjectcId);
        }

        /**
        * 删除实验室-基础性前瞻性研究项目-true
        * @param laboratoryBasicProjectcId
        * @return
        */
    @ApiOperation(value = "删除实验室-基础性前瞻性研究项目信息", notes = "按ID删除实验室-基础性前瞻性研究项目信息,操作成功返回201")
        @RequestMapping(value = "/laboratorybasicproject-provider/laboratorybasicproject/del-laboratorybasicproject-real/{laboratoryBasicProjectId}", method = RequestMethod.POST)
        public Object deleteLaboratoryBasicProjectReal(@PathVariable("laboratoryBasicProjectId") String laboratoryBasicProjectcId) {
    return laboratoryBasicProjectService.deleteLaboratoryBasicProjectReal(laboratoryBasicProjectcId);
        }


        /**
        * 分页查询
        * @param param
        * @return
        */
    @ApiOperation(value = "查询实验室-基础性前瞻性研究项目信息-分页查询", notes = "查询实验室-基础性前瞻性研究项目信息-分页查询,Object")
        @RequestMapping(value = "/laboratorybasicproject-provider/laboratorybasicproject/laboratorybasicproject-page")
        public Object selectLaboratoryBasicProjectByPage(@RequestBody LayuiTableParam param) {
            return laboratoryBasicProjectService.findLaboratoryBasicProjectByPage(param);
            }

    /**
    * 保存
    * @param laboratoryBasicProject
    * @return
    */
    @ApiOperation(value = "新增实验室-基础性前瞻性研究项目信息", notes = "新增实验室-基础性前瞻性研究项目信息,操作成功返回500")
    @RequestMapping(value = "/laboratorybasicproject-provider/laboratorybasicproject/save_laboratorybasicproject", method = RequestMethod.POST)
    public int updateOrInsertLaboratoryBasicProject(@RequestBody LaboratoryBasicProject laboratoryBasicProject) {
    try {
        return laboratoryBasicProjectService.updateOrInsertLaboratoryBasicProject(laboratoryBasicProject);
    } catch (Exception e) {
    logger.error("[保存信息失败：]", e);
    }
    return 500;
    }
}
