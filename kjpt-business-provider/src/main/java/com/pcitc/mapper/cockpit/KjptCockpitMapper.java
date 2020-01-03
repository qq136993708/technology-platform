package com.pcitc.mapper.cockpit;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

public interface KjptCockpitMapper {

    /**
     * 知识产权-专利数量按专利类型占比分析
     */
    List<Map> knowledgeNumOrType(Map<String, Object> param);


    /**
     * 知识产权-专利数量年度趋势分析
     */
    List<Map> knowledgeNumYearTrend(Map<String, Object> param);


    /**
     * 知识产权-专利数量按单位同比分析
     */
    List<Map> knowledgeNumOrUnit(Map<String, Object> param);

    /**
     * 科研平台-4大类别
     */
    List<Map> numScientificType(Map<String, Object> param);

    /**
     * 科研平台-科研平台数量按技术领域
     */
    List<Map> numScientificTechnology(Map<String, Object> param);

    /**
     * 首页-知识产权
     */
    List<Map> knowledgeRightCount(Map<String, Object> param);

    /**
     * 首页-汇总
     */
    List<Map> allSummaryCount(Map<String, Object> param);

    /**
     * 科技人才-数量按年龄
     */
    List<Map> personCountAge(Map<String, Object> param);

    /**
     * 科技人才-数量按职称
     */
    List<Map> personCountTitle(Map<String, Object> param);

    /**
     * 科技人才-数量按学历
     */
    List<Map> personCountEducation(Map<String, Object> param);

    /**
     * 科技人才-数量按学历
     */
    List<Map> personCountCompany(Map<String, Object> param);

    /**
     * 成果信息-成果转化-各单位成果转化激励人数
     */
    List<Map> numberIncentive(Map<String, Object> param);

    /**
     * 成果信息-成果转化-成果转化数量按成果类型分析
     */
    List<Map> numByResultsType(Map<String, Object> param);

    /**
     * 成果信息-成果转化-各单位成果转化金额/激励金额
     */
    List<Map> numByIncentiveAmount(Map<String, Object> param);

    /**
     * BI数据灌入
     */
    void dataToBi();
}
