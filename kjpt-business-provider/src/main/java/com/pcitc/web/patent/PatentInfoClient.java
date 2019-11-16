package com.pcitc.web.patent;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.patent.PatentInfo;
import com.pcitc.service.patent.PatentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>服务接口</p>
 * <p>Table: patent_info - 专利信息</p>
 *
 * @since 2019-11-16 04:10:36
 */
@Api(value = "PatentInfoClient-API", description = "专利信息服务接口")
@RestController
public class PatentInfoClient {
    private final static Logger logger = LoggerFactory.getLogger(PatentInfoClient.class);

    @Autowired
    PatentInfoService patentInfoService;


    /**
     * 保存
     *
     * @param patentInfo
     * @return
     */
    @ApiOperation(value = "新增或者更新专利信息", notes = "新增或者更新专利信息,操作成功返回500")
    @RequestMapping(value = "/patent-provider/patentInfo/patentInfo_save", method = RequestMethod.POST)
    public int updateOrInsertPatentInfo(@RequestBody PatentInfo patentInfo) {
        try {
            return patentInfoService.updateOrInsertPatentInfo(patentInfo);
        } catch (Exception e) {
            logger.error("[保存信息失败：]", e);
        }
        return 500;
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查利列表-分页查询", notes = "查利列表-分页查询,Object")
    @RequestMapping(value = "/patent-provider/patentInfo/patentInfo-query")
    public LayuiTableData queryPatentListByPage(@RequestBody LayuiTableParam param) {
        return patentInfoService.queryPatentList(param);
    }

    @ApiOperation(value = "查询专利详细信息", notes = "按ID查询查询专利详细信息详情信息,操作成功返回SysFileKind对象")
    @RequestMapping(value = "/patent-provider/patentInfo/patentInfo_load/{id}", method = RequestMethod.POST)
    public PatentInfo getPatentInfo(@PathVariable(value = "id", required = true) String id) {
        try {
            return patentInfoService.getPatentInfo(id);
        } catch (Exception e) {
            logger.error("[初始化信息失败：]", e);
        }
        return null;
    }

    /**
     * 逻辑删除专利信息
     *
     * @param patentId
     * @return
     */
    @ApiOperation(value = "逻辑删除专利信息", notes = "逻辑删除专利信息")
    @RequestMapping(value = "/patent-provider/patentInfo/patentInfo_delete/{id}")
    public Object deletePatent(@PathVariable("id") String patentId) {
        return patentInfoService.deletePatent(patentId);
    }

}
