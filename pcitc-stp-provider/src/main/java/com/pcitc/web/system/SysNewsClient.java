package com.pcitc.web.system;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.system.SysNews;
import com.pcitc.base.system.SysNewsExample;
import com.pcitc.service.system.SysNewsService;
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
 * <p>Table: sys_news - 系统新闻表</p>
 *
 * @since 2019-04-04 10:25:32
 */
@Api(value = "SysNewsClient-API", description = "系统新闻表服务接口")
@RestController
public class SysNewsClient {
    private final static Logger logger = LoggerFactory.getLogger(SysNewsClient.class);

    @Autowired
    SysNewsService sysNewsService;

    //参数查询
    @ApiOperation(value = "带参系统新闻表查询列表", notes = "根据ID查询查询系统新闻表信息,返回一个系统新闻表的JSONObject对象")
    @RequestMapping(value = "/sysnews-provider/sysnews/sysnews_list_param", method = RequestMethod.POST)
    public JSONObject selectSysNewsListParam(@RequestParam(value = "id", required = false) String id) {
        JSONObject retJson = new JSONObject();
        try {
            SysNews sysNews = new SysNews();
            sysNews.setId(id);
            List<SysNews> list = sysNewsService.findSysNewsList(sysNews);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    //对象查询,js需要JSON.stringify({id:"1"},转换之后,才能自动赋值
    @ApiOperation(value = "系统新闻表查询列表", notes = "自定义对象(条件)查询系统新闻表信息,返回存储在JSONObject对象中的系统新闻表列表")
    @RequestMapping(value = "/sysnews-provider/sysnews/sysnews_list", method = RequestMethod.POST)
    public JSONObject selectSysNewsList(@RequestBody SysNews sysNews) {
        JSONObject retJson = new JSONObject();
        try {
            List<SysNews> list = sysNewsService.findSysNewsList(sysNews);
            retJson.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retJson;
    }

    @ApiOperation(value = "查询系统新闻表树形详情信息", notes = "按ID查询系统新闻表详情信息(带父ID),操作成功返回SysFileKind对象")
    @RequestMapping(value = "/sysnews-provider/sysnews/get-sysnews/{id}", method = RequestMethod.POST)
    public SysNews getSysNewsInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return sysNewsService.getSysNewsInfo(id);
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
    @ApiOperation(value = "查询(树)系统新闻表信息", notes = "查询(树)系统新闻表信息,操作成功返回List<TreeNode>对象")
    @RequestMapping(value = "/sysnews-provider/sysnews/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return sysNewsService.selectObjectByTree();
    }

    /**
     * 删除系统新闻表-false
     *
     * @param sysNewscId
     * @return
     */
    @ApiOperation(value = "伪删除系统新闻表信息", notes = "按ID伪删除系统新闻表信息,操作成功返回201")
    @RequestMapping(value = "/sysnews-provider/sysnews/del-sysnews/{sysNewsId}")
    public Object deleteSysNews(@PathVariable("sysNewsId") String sysNewscId) {
        return sysNewsService.deleteSysNews(sysNewscId);
    }

    /**
     * 删除系统新闻表-true
     *
     * @param sysNewscId
     * @return
     */
    @ApiOperation(value = "删除系统新闻表信息", notes = "按ID删除系统新闻表信息,操作成功返回201")
    @RequestMapping(value = "/sysnews-provider/sysnews/del-sysnews-real/{sysNewsId}", method = RequestMethod.POST)
    public Object deleteSysNewsReal(@PathVariable("sysNewsId") String sysNewscId) {
        return sysNewsService.deleteSysNewsReal(sysNewscId);
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询系统新闻表信息-分页查询", notes = "查询系统新闻表信息-分页查询,Object")
    @RequestMapping(value = "/sysnews-provider/sysnews/sysnews-page")
    public Object selectSysNewsByPage(@RequestBody LayuiTableParam param) {
        return sysNewsService.findSysNewsByPage(param);
    }

    /**
     * 保存
     *
     * @param sysNews
     * @return
     */
    @ApiOperation(value = "新增系统新闻表信息", notes = "新增系统新闻表信息,操作成功返回500")
    @RequestMapping(value = "/sysnews-provider/sysnews/save_sysnews", method = RequestMethod.POST)
    public int updateOrInsertSysNews(@RequestBody SysNews sysNews) {
        try {
            return sysNewsService.updateOrInsertSysNews(sysNews);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }
}
