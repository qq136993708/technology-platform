package com.pcitc.web.expert;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.expert.ZjkPic;
import com.pcitc.base.expert.ZjkPicExample;
import com.pcitc.service.expert.ZjkPicService;
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
* <p>Table: zjk_pic - </p>
*
* @since 2018-12-12 02:58:24
*/
@Api(value = "ZjkPicClient-API", description = "服务接口")
@RestController
public class ZjkPicClient
        {
        private final static Logger logger = LoggerFactory.getLogger(ZjkPicClient.class);

        @Autowired
ZjkPicService zjkPicService;


        //参数查询
@ApiOperation(value = "带参查询列表", notes = "根据ID查询查询信息,返回一个的JSONObject对象")
        @RequestMapping(value = "/zjkpic-provider/zjkpic/zjkpic_list_param",method = RequestMethod.POST)
        public JSONObject selectZjkPicListParam(@RequestParam(value="id", required=false) String id) {
             JSONObject retJson = new JSONObject();
                try {
ZjkPic zjkPic= new ZjkPic();
zjkPic.setId(id);
                    List<ZjkPic> list = zjkPicService.findZjkPicList(zjkPic);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }

        //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
@ApiOperation(value = "查询列表", notes = "自定义对象(条件)查询信息,返回存储在JSONObject对象中的列表")
        @RequestMapping(value = "/zjkpic-provider/zjkpic/zjkpic_list",method = RequestMethod.POST)
        public JSONObject selectZjkPicList(@RequestBody ZjkPic zjkPic) {
             JSONObject retJson = new JSONObject();
                try {
                List<ZjkPic> list = zjkPicService.findZjkPicList(zjkPic);
                    retJson.put("list", list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retJson;
        }


@ApiOperation(value = "查询树形详情信息", notes = "按ID查询详情信息(带父ID),操作成功返回SysFileKind对象")
        @RequestMapping(value = "/zjkpic-provider/zjkpic/get-zjkpic/{id}",method = RequestMethod.POST)
        public ZjkPic getZjkPicInfo(@PathVariable(value = "id", required = true) String id){
        try {
        return zjkPicService.getZjkPicInfo(id);
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
        @RequestMapping(value = "/zjkpic-provider/zjkpic/tree-data")
        @ResponseBody
        public List selectObjectByTree() throws Exception {
        return zjkPicService.selectObjectByTree();
        }



        /**
        * 删除-false
        * @param zjkPiccId
        * @return
        */
    @ApiOperation(value = "伪删除信息", notes = "按ID伪删除信息,操作成功返回201")
        @RequestMapping(value = "/zjkpic-provider/zjkpic/del-zjkpic/{zjkPicId}")
        public Object deleteZjkPic(@PathVariable("zjkPicId") String zjkPiccId) {
    return zjkPicService.deleteZjkPic(zjkPiccId);
        }

        /**
        * 删除-true
        * @param zjkPiccId
        * @return
        */
    @ApiOperation(value = "删除信息", notes = "按ID删除信息,操作成功返回201")
        @RequestMapping(value = "/zjkpic-provider/zjkpic/del-zjkpic-real/{zjkPicId}", method = RequestMethod.POST)
        public Object deleteZjkPicReal(@PathVariable("zjkPicId") String zjkPiccId) {
    return zjkPicService.deleteZjkPicReal(zjkPiccId);
        }


        /**
        * 分页查询
        * @param param
        * @return
        */
    @ApiOperation(value = "查询信息-分页查询", notes = "查询信息-分页查询,Object")
        @RequestMapping(value = "/zjkpic-provider/zjkpic/zjkpic-page")
        public Object selectZjkPicByPage(@RequestBody LayuiTableParam param) {
            return zjkPicService.findZjkPicByPage(param);
            }

    /**
    * 保存
    * @param zjkPic
    * @return
    */
    @ApiOperation(value = "新增信息", notes = "新增信息,操作成功返回500")
    @RequestMapping(value = "/zjkpic-provider/zjkpic/save_zjkpic", method = RequestMethod.POST)
    public int updateOrInsertZjkPic(@RequestBody ZjkPic zjkPic) {
    try {
        return zjkPicService.updateOrInsertZjkPic(zjkPic);
    } catch (Exception e) {
    logger.error("[保存信息失败：]", e);
    }
    return 500;
    }
}
