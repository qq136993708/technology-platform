package com.pcitc.service.report.impl;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.report.ReportColumn;
import com.pcitc.base.report.ReportColumnExample;
import com.pcitc.base.report.ReportConfig;
import com.pcitc.base.report.ReportConfigExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.report.ReportConfigMapper;
import com.pcitc.service.report.ReportColumnService;
import com.pcitc.service.report.ReportConfigService;
import com.pcitc.utils.StringUtils;


/**
 * <p>接口实现类</p>
 * <p>Table: report_config - 报表配置</p>
 *
 * @since 2018-08-02 02:27:15
 */
@Service("reportConfigService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ReportConfigServiceImpl implements ReportConfigService {

    @Autowired
    private ReportConfigMapper reportConfigMapper;
    @Autowired
    private ReportColumnService reportColumnService;

    public List<ReportConfig> findReportConfigList(ReportConfig reportConfig) {
        List<ReportConfig> record = reportConfigMapper.findReportConfigList(reportConfig);
        return record;
    }

    @Override
    public int updateOrInsertReportConfig(ReportConfig reportConfig) throws Exception {
        int result = 500;
        if (reportConfig.getId() != null && reportConfig.getId() != null) {
            reportConfigMapper.updateByPrimaryKeySelective(reportConfig);
        } else {
            reportConfig.setId(IdUtil.createIdByTime());
            reportConfigMapper.insertSelective(reportConfig);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteReportConfigById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            reportConfigMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ReportConfig getReportConfigInfo(String id) throws Exception {

        return reportConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ReportConfigExample example) {
        return reportConfigMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ReportConfigExample example) {
        return reportConfigMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return reportConfigMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteReportConfigReal(String recordId) {

        //根据配置ID查询字段表
        ReportColumnExample ex = new ReportColumnExample();
        ex.createCriteria().andReportConfigIdEqualTo(recordId);
        List<ReportColumn> reportColumns = reportColumnService.selectByExample(ex);
        //判断数量
        if(reportColumns==null||reportColumns.size()==0){
            reportConfigMapper.deleteByPrimaryKey(recordId);
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK.getStatusCode()));
        }else {
            for (int i = 0; i < reportColumns.size(); i++) {
                reportColumnService.deleteReportColumnReal(reportColumns.get(i).getId());
            }
            reportConfigMapper.deleteByPrimaryKey(recordId);
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR.getStatusCode()));
        }
    }

    @Override
    public int insert(ReportConfig record) {
        record.setId(IdUtil.createIdByTime());
        return reportConfigMapper.insert(record);
    }

    @Override
    public int insertSelective(ReportConfig record) {
        return reportConfigMapper.insertSelective(record);
    }

    public ReportConfig insertObject(ReportConfig record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ReportConfig> selectByExample(ReportConfigExample example) {
        return reportConfigMapper.selectByExample(example);
    }

    @Override
    public ReportConfig selectByPrimaryKey(String recordId) {
        return reportConfigMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ReportConfig record, @Param("example") ReportConfigExample example) {
        return reportConfigMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ReportConfig record, @Param("example") ReportConfigExample example) {
        return reportConfigMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ReportConfig record) {
        return reportConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ReportConfig record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return reportConfigMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteReportConfig(Serializable reportConfigId) {
        try {
            ReportConfig record = reportConfigMapper.selectByPrimaryKey(reportConfigId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                reportConfigMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findReportConfigByPage(LayuiTableParam param) {
        ReportConfigExample example = new ReportConfigExample();
        ReportConfigExample.Criteria c = example.createCriteria();
        if (param.getParam().get("name") != null && !StringUtils.isBlank(param.getParam().get("name") + "")) {
            System.out.println("param.getParam().get(\"name\").toString() = " + param.getParam().get("name").toString());
            c.andNameLike("%" + param.getParam().get("name").toString() + "%");
        }
//        c.andBak1Like("%1%");
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ReportConfigExample.Criteria criteria2 = example.or();
//            criteria2.andParentIdEqualTo(param.getParam().get("fileKind").toString());
//            example.or(criteria2);
        //       }
        example.setOrderByClause("create_date desc");
        return this.findByExample(param, example);

    }

    /**
     * 根据条件分页搜索
     *
     * @param param
     * @param example
     * @return
     */
    private LayuiTableData findByExample(LayuiTableParam param, ReportConfigExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ReportConfig> list = reportConfigMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ReportConfig> pageInfo = new PageInfo<ReportConfig>(list);
        LayuiTableData data = new LayuiTableData();
        data.setData(pageInfo.getList());
        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());
        return data;
    }

    /**
     * 树形菜单
     *
     * @return
     */
    @Override
    public List<TreeNode> selectObjectByTree() {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        ReportConfigExample example = new ReportConfigExample();
        example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ReportConfig> records = reportConfigMapper.selectByExample(example);
        for (ReportConfig record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ReportConfigExample reportConfigExample = new ReportConfigExample();
        String strParentId = reportConfigMapper.selectByExample(reportConfigExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}