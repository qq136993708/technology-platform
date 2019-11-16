package com.pcitc.service.patent;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.ZjkExpert;
import com.pcitc.base.expert.ZjkExpertExample;
import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.system.SysDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>接口类</p>
 * <p>Table: patent_info - 专利信息</p>
 *
 * @since 2019-11-16 04:10:36
 */
public interface PatentInfoService {

    /**
     * 插入专利信息
     *
     * @param patentInfo
     * @return
     */
    int updateOrInsertPatentInfo(PatentInfo patentInfo);

    /**
     * 专利列表分页查询
     * @param param
     * @return
     */
    LayuiTableData queryPatentList(LayuiTableParam param);

    /**
     * 根据id查询专利信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    PatentInfo getPatentInfo(String id) throws Exception;

    /**
     * 根据id删除专利
     *
     * @param id
     * @return
     */
    Integer deletePatent(String id);
}