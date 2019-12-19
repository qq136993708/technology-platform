package com.pcitc.web.trademark;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.trademarkinfo.TrademarkInfo;
import com.pcitc.service.trademark.TrademarkInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>服务接口</p>
 * <p>Table: trademark_info - 商标信息</p>
 *
 * @since 2019-11-16 04:10:36
 */
@Api(value = "TrademarkInfoClient-API", description = "商标信息服务接口")
@RestController
public class TrademarkInfoClient {
    private final static Logger logger = LoggerFactory.getLogger(TrademarkInfoClient.class);

    @Autowired
    TrademarkInfoService trademarkInfoService;


    /**
     * 保存
     *
     * @param trademarkInfo
     * @return
     */
    @ApiOperation(value = "新增或者更新专利信息", notes = "新增或者更新专利信息,操作成功返回商标对象")
    @RequestMapping(value = "/trademark-provider/trademarkInfo/trademarkInfo_save", method = RequestMethod.POST)
    public TrademarkInfo updateOrInsertTrademarkInfo(@RequestBody TrademarkInfo trademarkInfo) {
        return trademarkInfoService.updateOrInsertTrademarkInfo(trademarkInfo);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "商标列表-分页查询", notes = "商标列表-分页查询,Object")
    @RequestMapping(value = "/trademark-provider/trademarkInfo/trademarkInfo_query")
    public PageInfo queryTrademarkListByPage(@RequestBody Map param) {
        return trademarkInfoService.queryTrademarkList(param);
    }

    @ApiOperation(value = "查询商标详细信息", notes = "按ID查询查询商标详细信息,操作成功返回SysFileKind对象")
    @RequestMapping(value = "/trademark-provider/trademarkInfo/trademarkInfo_load/{id}", method = RequestMethod.GET)
    public TrademarkInfo getTrademarkInfo(@PathVariable String id) {
        try {
            return trademarkInfoService.getTrademarkInfo(id);
        } catch (Exception e) {
            logger.error("[初始化信息失败：]", e);
        }
        return null;
    }

    /**
     * 逻辑删除商标信息
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "逻辑删除商标信息", notes = "逻辑删除商标信息")
    @RequestMapping(value = "/trademark-provider/trademarkInfo/trademarkInfo_delete/{id}",method=RequestMethod.DELETE)
    public Object deleteTrademark(@PathVariable String id) {
        return trademarkInfoService.deleteTrademark(id);
    }

    @ApiOperation(value = "查询商标列表", notes = "查询商标列表")
    @RequestMapping(value = "/trademark-provider/trademarkInfo/queryNoPage", method = RequestMethod.POST)
    public JSONArray queryNoPage(@RequestBody(required = false) Map param){
        List list=trademarkInfoService.queryNoPage(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }

}
