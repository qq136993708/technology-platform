package com.pcitc.web.expert;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.ZjkExpert;
import com.pcitc.base.expert.ZjkExpertExample;
import com.pcitc.service.expert.ZjkBaseInfoService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * <p>服务接口</p>
 * <p>Table: zjk_base_info - 专家-基本信息</p>
 *
 * @since 2018-12-08 04:10:36
 */
@Api(value = "ZjkBaseInfoClient-API", description = "专家-基本信息服务接口")
@RestController
public class ZjkBaseInfoClient {
    private final static Logger logger = LoggerFactory.getLogger(ZjkBaseInfoClient.class);

    @Autowired
    ZjkBaseInfoService zjkBaseInfoService;

    //参数查询
    @ApiOperation(value = "带参专家-基本信息查询列表", notes = "根据ID查询查询专家-基本信息信息,返回一个专家-基本信息的JSONObject对象")
    @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo_list_param", method = RequestMethod.POST)
    public JSONObject selectZjkBaseInfoListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            ZjkExpert zjkBaseInfo = new ZjkExpert();
            zjkBaseInfo.setId(id);
            List<ZjkExpert> list = zjkBaseInfoService.findZjkBaseInfoList(zjkBaseInfo);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "专家-基本信息查询列表", notes = "自定义对象(条件)查询专家-基本信息信息,返回存储在JSONObject对象中的专家-基本信息列表")
    @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo_list", method = RequestMethod.POST)
    public JSONObject selectZjkBaseInfoList(@RequestBody ZjkExpert zjkBaseInfo) {
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkExpert> list = zjkBaseInfoService.findZjkBaseInfoList(zjkBaseInfo);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
            return retJson;
        }

    @ApiOperation(value = "专家-根据类型更新专家信息", notes = "根据类型更新专家信息-基本信息信息,返回JSONObject")
    @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/updateExpertByType", method = RequestMethod.POST)
    public JSONObject updateExpertByType(@RequestBody ZjkExpert zjkBaseInfo) {
        JSONObject retJson = new JSONObject();
        try {
            zjkBaseInfoService.updateExpertByType(zjkBaseInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
            return retJson;
        }
    @ApiOperation(value = "专家-基本信息查询列表随机", notes = "自定义对象(条件)查询专家-基本信息信息,返回存储在JSONObject对象中的专家-基本信息列表")
    @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo_list_random", method = RequestMethod.POST)
    public JSONObject selectZjkBaseInfoListRandom (@RequestBody ZjkExpert zjkBaseInfo){
        JSONObject retJson = new JSONObject();
        try {
            List<ZjkExpert> list = zjkBaseInfoService.findZjkBaseInfoListRandom(zjkBaseInfo);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }
        @ApiOperation(value = "专家-基本信息查询列表", notes = "自定义对象(条件)查询专家-基本信息信息,返回存储在JSONObject对象中的专家-基本信息列表")
        @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo_list_example", method = RequestMethod.POST)
        public JSONObject selectZjkBaseInfoListExample (@RequestBody JSONObject jsonObject){
            JSONObject retJson = new JSONObject();
            try {
                ZjkExpertExample zjkBaseInfoExample = new ZjkExpertExample();
                zjkBaseInfoExample.createCriteria().andExpertProfessionalFieldIn(Arrays.asList(jsonObject.get("strHyly").toString().split(",")));
                List<ZjkExpert> list = zjkBaseInfoService.selectByExample(zjkBaseInfoExample);
                retJson.put("list", list);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return retJson;
        }

        @ApiOperation(value = "查询专家-基本信息树形详情信息", notes = "按ID查询专家-基本信息详情信息(带父ID),操作成功返回SysFileKind对象")
        @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/get-zjkbaseinfo/{id}", method = RequestMethod.POST)
        public ZjkExpert getZjkBaseInfoInfo (@PathVariable(value = "id", required = true) String id){
            try {
                return zjkBaseInfoService.getZjkBaseInfoInfo(id);
            } catch (Exception e) {
                logger.error("[初始化信息失败：]", e);
            }
            return null;
        }

        /**
         * 树形展示
         *
         * @return
         * @throws Exception
         */
        @ApiOperation(value = "查询(树)专家-基本信息信息", notes = "查询(树)专家-基本信息信息,操作成功返回List<TreeNode>对象")
        @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/tree-data")
        @ResponseBody
        public List selectObjectByTree () throws Exception {
            return zjkBaseInfoService.selectObjectByTree();
        }

        /**
         * 删除专家-基本信息-false
         *
         * @param zjkBaseInfocId
         * @return
         */
        @ApiOperation(value = "伪删除专家-基本信息信息", notes = "按ID伪删除专家-基本信息信息,操作成功返回201")
        @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/del-zjkbaseinfo/{zjkBaseInfoId}")
        public Object deleteZjkBaseInfo (@PathVariable("zjkBaseInfoId") String zjkBaseInfocId){
            return zjkBaseInfoService.deleteZjkBaseInfo(zjkBaseInfocId);
        }

        /**
         * 删除专家-基本信息-false
         *
         * @param dataId
         * @return
         */
        @ApiOperation(value = "更新专家审批状态-基本信息信息", notes = "按ID更新专家审批状态-基本信息信息,操作成功返回201")
        @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/updateAuditStatus")
        public Object updateAuditStatus (@RequestParam(value = "dataId", required = true) String dataId){
            return zjkBaseInfoService.updateAuditStatus(dataId);
        }

        /**
         * 删除专家-基本信息-true
         *
         * @param zjkBaseInfocId
         * @return
         */
        @ApiOperation(value = "删除专家-基本信息信息", notes = "按ID删除专家-基本信息信息,操作成功返回201")
        @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/del-zjkbaseinfo-real/{zjkBaseInfoId}", method = RequestMethod.POST)
        public Object deleteZjkBaseInfoReal (@PathVariable("zjkBaseInfoId") String zjkBaseInfocId){
            return zjkBaseInfoService.deleteZjkBaseInfoReal(zjkBaseInfocId);
        }

        /**
         * 分页查询
         *
         * @param param
         * @return
         */
        @ApiOperation(value = "查询专家-基本信息信息-分页查询", notes = "查询专家-基本信息信息-分页查询,Object")
        @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo-page")
        public LayuiTableData selectZjkBaseInfoByPage (@RequestBody LayuiTableParam param){
            return zjkBaseInfoService.findZjkBaseInfoByPage(param);
        }

        @ApiOperation(value = "查询专家-基本信息信息-分页查询", notes = "查询专家-基本信息信息-分页查询,Object")
        @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/showExpertPageTableData")
        public LayuiTableData showExpertPageTableData (@RequestBody LayuiTableParam param){
            return zjkBaseInfoService.showExpertPageTableData(param);
        }

        /**
         * 分页查询
         *
         * @param param
         * @return
         */
        @ApiOperation(value = "查询专家-基本信息信息-分页查询", notes = "查询专家-基本信息信息-分页查询,Object")
        @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo-pageIndex")
        public Object selectZjkBaseInfoByPageIndex (@RequestBody LayuiTableParam param){
            return zjkBaseInfoService.findZjkBaseInfoByPageIndex(param);
        }

        /**
         * 保存
         *
         * @param zjkBaseInfo
         * @return
         */
        @ApiOperation(value = "新增专家-基本信息信息", notes = "新增专家-基本信息信息,操作成功返回500")
        @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/save_zjkbaseinfo", method = RequestMethod.POST)
        public int updateOrInsertZjkBaseInfo (@RequestBody ZjkExpert zjkBaseInfo){
            try {
                return zjkBaseInfoService.updateOrInsertZjkBaseInfo(zjkBaseInfo);
            } catch (Exception e) {
                logger.error("[保存信息失败：]", e);
            }
            return 500;
        }

        @ApiOperation(value = "首页-图形展示", notes = "图形展示,返回Result")
        @RequestMapping(value = "/zjkbaseinfo-provider/zjkbaseinfo/echarts", method = RequestMethod.POST)
        public JSONObject echarts (@RequestBody JSONObject jsonObject){
            JSONObject retJson = new JSONObject();
            try {
                retJson = zjkBaseInfoService.echarts(jsonObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return retJson;
        }

    }
