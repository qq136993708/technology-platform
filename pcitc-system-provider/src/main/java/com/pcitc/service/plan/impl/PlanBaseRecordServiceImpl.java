package com.pcitc.service.plan.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.plan.PlanBaseRecord;
import com.pcitc.base.plan.PlanBaseRecordExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.plan.PlanBaseRecordMapper;
import com.pcitc.service.plan.PlanBaseRecordService;
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
 * <p>Table: plan_base_record - </p>
 *
 * @since 2018-11-12 10:15:05
 */
@Service("planBaseRecordService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PlanBaseRecordServiceImpl implements PlanBaseRecordService {

    @Autowired
    private PlanBaseRecordMapper planBaseRecordMapper;

    public List<PlanBaseRecord> findPlanBaseRecordList(PlanBaseRecord planBaseRecord) {
        List<PlanBaseRecord> record = planBaseRecordMapper.findPlanBaseRecordList(planBaseRecord);
        return record;
    }

    @Override
    public int updateOrInsertPlanBaseRecord(PlanBaseRecord planBaseRecord) throws Exception {
        int result = 500;
        if (planBaseRecord.getId() != null && planBaseRecord.getId() != null) {
            planBaseRecordMapper.updateByPrimaryKeySelective(planBaseRecord);
        } else {
            planBaseRecord.setId(IdUtil.createIdByTime());
            planBaseRecordMapper.insertSelective(planBaseRecord);
        }
        result = 200;
        return result;
    }

    @Override
    public int deletePlanBaseRecordById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            planBaseRecordMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public PlanBaseRecord getPlanBaseRecordInfo(String id) throws Exception {

        return planBaseRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(PlanBaseRecordExample example) {
        return planBaseRecordMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(PlanBaseRecordExample example) {
        return planBaseRecordMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return planBaseRecordMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deletePlanBaseRecordReal(String recordId) {
        return planBaseRecordMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(PlanBaseRecord record) {
        record.setId(IdUtil.createIdByTime());
        return planBaseRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(PlanBaseRecord record) {
        return planBaseRecordMapper.insertSelective(record);
    }

    public PlanBaseRecord insertObject(PlanBaseRecord record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<PlanBaseRecord> selectByExample(PlanBaseRecordExample example) {
        return planBaseRecordMapper.selectByExample(example);
    }

    @Override
    public PlanBaseRecord selectByPrimaryKey(String recordId) {
        return planBaseRecordMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") PlanBaseRecord record, @Param("example") PlanBaseRecordExample example) {
        return planBaseRecordMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") PlanBaseRecord record, @Param("example") PlanBaseRecordExample example) {
        return planBaseRecordMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(PlanBaseRecord record) {
        return planBaseRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PlanBaseRecord record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return planBaseRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deletePlanBaseRecord(Serializable planBaseRecordId) {
        try {
            PlanBaseRecord record = planBaseRecordMapper.selectByPrimaryKey(planBaseRecordId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                planBaseRecordMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findPlanBaseRecordByPage(LayuiTableParam param) {
        PlanBaseRecordExample example = new PlanBaseRecordExample();
        PlanBaseRecordExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            PlanBaseRecordExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, PlanBaseRecordExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<PlanBaseRecord> list = planBaseRecordMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<PlanBaseRecord> pageInfo = new PageInfo<PlanBaseRecord>(list);
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
        PlanBaseRecordExample example = new PlanBaseRecordExample();
        example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<PlanBaseRecord> records = planBaseRecordMapper.selectByExample(example);
        for (PlanBaseRecord record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        PlanBaseRecordExample planBaseRecordExample = new PlanBaseRecordExample();
        String strParentId = planBaseRecordMapper.selectByExample(planBaseRecordExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}