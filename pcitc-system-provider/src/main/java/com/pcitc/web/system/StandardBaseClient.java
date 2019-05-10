package com.pcitc.web.system;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.system.StandardBase;
import com.pcitc.base.system.StandardBaseExample;
import com.pcitc.service.system.StandardBaseService;
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
* <p>Table: standard_base - 标准化</p>
*
* @since 2019-05-10 03:07:51
*/
@Api(value = "StandardBaseClient-API", description = "标准化服务接口")
@RestController
public class StandardBaseClient
        {
        private final static Logger logger = LoggerFactory.getLogger(StandardBaseClient.class);

        @Autowired
StandardBaseService standardBaseService;


        //参数查询
@ApiOperation(value = "带参标准化查询列表", notes = "根据ID查询查询标准化信息,返回一个标准化的JSONObject对象")
        @RequestMapping(value = "/standardbase-provider/standardbase/standardbase_list_param",method = RequestMethod.POST)
        public JSONObject selectStandardBaseListParam(@RequestParam(value="id", required=false) String id) {
             JSONObject retJson = new JSONObject();
                try {
StandardBase standardBase= new StandardBase();
standardBase.setId(id);
                    List<StandardBase> list = standardBaseService.findStandardBaseList(standardBase);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }

        //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
@ApiOperation(value = "标准化查询列表", notes = "自定义对象(条件)查询标准化信息,返回存储在JSONObject对象中的标准化列表")
        @RequestMapping(value = "/standardbase-provider/standardbase/standardbase_list",method = RequestMethod.POST)
        public JSONObject selectStandardBaseList(@RequestBody StandardBase standardBase) {
             JSONObject retJson = new JSONObject();
                try {
                List<StandardBase> list = standardBaseService.findStandardBaseList(standardBase);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }


@ApiOperation(value = "查询标准化树形详情信息", notes = "按ID查询标准化详情信息(带父ID),操作成功返回SysFileKind对象")
        @RequestMapping(value = "/standardbase-provider/standardbase/get-standardbase/{id}",method = RequestMethod.POST)
        public StandardBase getStandardBaseInfo(@PathVariable(value = "id", required = true) String id){
        try {
        return standardBaseService.getStandardBaseInfo(id);
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
@ApiOperation(value = "查询(树)标准化信息", notes = "查询(树)标准化信息,操作成功返回List<TreeNode>对象")
        @RequestMapping(value = "/standardbase-provider/standardbase/tree-data")
        @ResponseBody
        public List selectObjectByTree() throws Exception {
        return standardBaseService.selectObjectByTree();
        }



        /**
        * 删除标准化-false
        * @param standardBasecId
        * @return
        */
    @ApiOperation(value = "伪删除标准化信息", notes = "按ID伪删除标准化信息,操作成功返回201")
        @RequestMapping(value = "/standardbase-provider/standardbase/del-standardbase/{standardBaseId}")
        public Object deleteStandardBase(@PathVariable("standardBaseId") String standardBasecId) {
    return standardBaseService.deleteStandardBase(standardBasecId);
        }

        /**
        * 删除标准化-true
        * @param standardBasecId
        * @return
        */
    @ApiOperation(value = "删除标准化信息", notes = "按ID删除标准化信息,操作成功返回201")
        @RequestMapping(value = "/standardbase-provider/standardbase/del-standardbase-real/{standardBaseId}", method = RequestMethod.POST)
        public Object deleteStandardBaseReal(@PathVariable("standardBaseId") String standardBasecId) {
    return standardBaseService.deleteStandardBaseReal(standardBasecId);
        }


        /**
        * 分页查询
        * @param param
        * @return
        */
    @ApiOperation(value = "查询标准化信息-分页查询", notes = "查询标准化信息-分页查询,Object")
        @RequestMapping(value = "/standardbase-provider/standardbase/standardbase-page")
        public Object selectStandardBaseByPage(@RequestBody LayuiTableParam param) {
            return standardBaseService.findStandardBaseByPage(param);
            }

    /**
    * 保存
    * @param standardBase
    * @return
    */
    @ApiOperation(value = "新增标准化信息", notes = "新增标准化信息,操作成功返回500")
    @RequestMapping(value = "/standardbase-provider/standardbase/save_standardbase", method = RequestMethod.POST)
    public int updateOrInsertStandardBase(@RequestBody StandardBase standardBase) {
    try {
        return standardBaseService.updateOrInsertStandardBase(standardBase);
    } catch (Exception e) {
    logger.error("[保存信息失败：]", e);
    }
    return 500;
    }
}
