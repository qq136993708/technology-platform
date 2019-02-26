package com.pcitc.web.expert;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.ZjkProjectExpert;
import com.pcitc.base.expert.ZjkProjectExpertExample;
import com.pcitc.service.expert.ZjkProjectExpertService;
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
* <p>Table: zjk_project_expert - </p>
*
* @since 2019-02-21 03:28:04
*/
@Api(value = "ZjkProjectExpertClient-API", description = "服务接口")
@RestController
public class ZjkProjectExpertClient
        {
        private final static Logger logger = LoggerFactory.getLogger(ZjkProjectExpertClient.class);

        @Autowired
ZjkProjectExpertService zjkProjectExpertService;


        //参数查询
@ApiOperation(value = "带参查询列表", notes = "根据ID查询查询信息,返回一个的JSONObject对象")
        @RequestMapping(value = "/zjkprojectexpert-provider/zjkprojectexpert/zjkprojectexpert_list_param",method = RequestMethod.POST)
        public JSONObject selectZjkProjectExpertListParam(@RequestParam(value="id", required=false) String id) {
             JSONObject retJson = new JSONObject();
                try {
ZjkProjectExpert zjkProjectExpert= new ZjkProjectExpert();
zjkProjectExpert.setId(id);
                    List<ZjkProjectExpert> list = zjkProjectExpertService.findZjkProjectExpertList(zjkProjectExpert);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }

        //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
@ApiOperation(value = "查询列表", notes = "自定义对象(条件)查询信息,返回存储在JSONObject对象中的列表")
        @RequestMapping(value = "/zjkprojectexpert-provider/zjkprojectexpert/zjkprojectexpert_list",method = RequestMethod.POST)
        public JSONObject selectZjkProjectExpertList(@RequestBody ZjkProjectExpert zjkProjectExpert) {
             JSONObject retJson = new JSONObject();
                try {
                List<ZjkProjectExpert> list = zjkProjectExpertService.findZjkProjectExpertList(zjkProjectExpert);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }


@ApiOperation(value = "查询树形详情信息", notes = "按ID查询详情信息(带父ID),操作成功返回SysFileKind对象")
        @RequestMapping(value = "/zjkprojectexpert-provider/zjkprojectexpert/get-zjkprojectexpert/{id}",method = RequestMethod.POST)
        public ZjkProjectExpert getZjkProjectExpertInfo(@PathVariable(value = "id", required = true) String id){
        try {
        return zjkProjectExpertService.getZjkProjectExpertInfo(id);
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
@ApiOperation(value = "查询(树)信息", notes = "查询(树)信息,操作成功返回List<TreeNode>对象")
        @RequestMapping(value = "/zjkprojectexpert-provider/zjkprojectexpert/tree-data")
        @ResponseBody
        public List selectObjectByTree() throws Exception {
        return zjkProjectExpertService.selectObjectByTree();
        }



        /**
        * 删除-false
        * @param zjkProjectExpertcId
        * @return
        */
    @ApiOperation(value = "伪删除信息", notes = "按ID伪删除信息,操作成功返回201")
        @RequestMapping(value = "/zjkprojectexpert-provider/zjkprojectexpert/del-zjkprojectexpert/{zjkProjectExpertId}")
        public Object deleteZjkProjectExpert(@PathVariable("zjkProjectExpertId") String zjkProjectExpertcId) {
    return zjkProjectExpertService.deleteZjkProjectExpert(zjkProjectExpertcId);
        }

        /**
        * 删除-true
        * @param zjkProjectExpertcId
        * @return
        */
    @ApiOperation(value = "删除信息", notes = "按ID删除信息,操作成功返回201")
        @RequestMapping(value = "/zjkprojectexpert-provider/zjkprojectexpert/del-zjkprojectexpert-real/{zjkProjectExpertId}", method = RequestMethod.POST)
        public Object deleteZjkProjectExpertReal(@PathVariable("zjkProjectExpertId") String zjkProjectExpertcId) {
    return zjkProjectExpertService.deleteZjkProjectExpertReal(zjkProjectExpertcId);
        }


        /**
        * 分页查询
        * @param param
        * @return
        */
    @ApiOperation(value = "查询信息-分页查询", notes = "查询信息-分页查询,Object")
        @RequestMapping(value = "/zjkprojectexpert-provider/zjkprojectexpert/zjkprojectexpert-page")
        public Object selectZjkProjectExpertByPage(@RequestBody LayuiTableParam param) {
            return zjkProjectExpertService.findZjkProjectExpertByPage(param);
            }

    /**
    * 保存
    * @param zjkProjectExpert
    * @return
    */
    @ApiOperation(value = "新增信息", notes = "新增信息,操作成功返回500")
    @RequestMapping(value = "/zjkprojectexpert-provider/zjkprojectexpert/save_zjkprojectexpert", method = RequestMethod.POST)
    public int updateOrInsertZjkProjectExpert(@RequestBody ZjkProjectExpert zjkProjectExpert) {
    try {
        return zjkProjectExpertService.updateOrInsertZjkProjectExpert(zjkProjectExpert);
    } catch (Exception e) {
    logger.error("[保存信息失败：]", e);
    }
    return 500;
    }
}
