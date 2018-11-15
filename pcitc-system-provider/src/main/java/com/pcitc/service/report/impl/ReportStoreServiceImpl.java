package com.pcitc.service.report.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.system.ReportStore;
import com.pcitc.base.system.ReportStoreExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.report.ReportStoreMapper;
import com.pcitc.service.report.ReportConfigService;
import com.pcitc.service.report.ReportStoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>接口实现类</p>
 * <p>Table: report_store - 报表收藏</p>
 *
 * @since 2018-09-27 11:15:36
 */
@Service("reportStoreService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ReportStoreServiceImpl implements ReportStoreService {

    @Autowired
    private ReportStoreMapper reportStoreMapper;

    @Autowired
    private ReportConfigService reportConfigService;

    public List<ReportStore> findReportStoreList(ReportStore reportStore) {
        List<ReportStore> record = reportStoreMapper.findReportStoreList(reportStore);
        return record;
    }

    @Override
    public int updateOrInsertReportStore(ReportStore reportStore) throws Exception {
        if("DEL".equals(reportStore.getParentName())){
            ReportStoreExample example = new ReportStoreExample();
            ReportStoreExample.Criteria criteria = example.createCriteria();
            criteria.andModelConfigIdEqualTo(reportStore.getModelConfigId());
//            criteria.andUserIdEqualTo(reportStore.getUserId());
            this.deleteByExample(example);
        }
        int result = 500;
        if (reportStore.getId() != null && reportStore.getId() != null) {
            reportStoreMapper.updateByPrimaryKeySelective(reportStore);
        } else {
            reportStore.setId(IdUtil.createIdByTime());
            reportStoreMapper.insertSelective(reportStore);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteReportStoreById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            reportStoreMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ReportStore getReportStoreInfo(String id) throws Exception {

        return reportStoreMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ReportStoreExample example) {
        return reportStoreMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ReportStoreExample example) {
        return reportStoreMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return reportStoreMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteReportStoreReal(String recordId) {
        return reportStoreMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ReportStore record) {
        record.setId(IdUtil.createIdByTime());
        return reportStoreMapper.insert(record);
    }

    @Override
    public int insertSelective(ReportStore record) {
        return reportStoreMapper.insertSelective(record);
    }

    public ReportStore insertObject(ReportStore record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ReportStore> selectByExample(ReportStoreExample example) {
        return reportStoreMapper.selectByExample(example);
    }

    @Override
    public ReportStore selectByPrimaryKey(String recordId) {
        return reportStoreMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ReportStore record, @Param("example") ReportStoreExample example) {
        return reportStoreMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ReportStore record, @Param("example") ReportStoreExample example) {
        return reportStoreMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ReportStore record) {
        return reportStoreMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ReportStore record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return reportStoreMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteReportStore(Serializable reportStoreId) {
        try {
            ReportStore record = reportStoreMapper.selectByPrimaryKey(reportStoreId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                reportStoreMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findReportStoreByPage(LayuiTableParam param) {
        ReportStoreExample example = new ReportStoreExample();
        ReportStoreExample.Criteria c = example.createCriteria();
        if (param.getParam().get("modelId") != null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("modelId") + "")) {
            c.andModelIdLike("%" + param.getParam().get("modelId") + "%");
        }
        if (param.getParam().get("modelConfigId") != null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("modelConfigId") + "")) {
            c.andModelConfigIdLike("%" + param.getParam().get("modelConfigId") + "%");
        }
        if (param.getParam().get("userName") != null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("userName") + "")) {
            c.andUserNameLike("%" + param.getParam().get("userName") + "%");
        }
        if (param.getParam().get("userId") != null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("userId") + "")) {
            c.andUserIdEqualTo(param.getParam().get("userId").toString());
        }
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ReportStoreExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, ReportStoreExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ReportStore> list = reportStoreMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ReportStore> pageInfo = new PageInfo<ReportStore>(list);
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
        ReportStoreExample example = new ReportStoreExample();
        example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ReportStore> records = reportStoreMapper.selectByExample(example);
        for (ReportStore record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ReportStoreExample reportStoreExample = new ReportStoreExample();
        String strParentId = reportStoreMapper.selectByExample(reportStoreExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}