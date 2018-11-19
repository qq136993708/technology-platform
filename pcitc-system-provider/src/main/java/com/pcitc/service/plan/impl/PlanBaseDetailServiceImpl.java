package com.pcitc.service.plan.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.plan.PlanBaseDetail;
import com.pcitc.base.plan.PlanBaseDetailExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.plan.PlanBaseDetailMapper;
import com.pcitc.service.plan.PlanBaseDetailService;
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
 * <p>Table: plan_base_detail - 工程签证申请</p>
 *
 * @since 2018-11-12 10:15:00
 */
@Service("planBaseDetailService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PlanBaseDetailServiceImpl implements PlanBaseDetailService {

    @Autowired
    private PlanBaseDetailMapper planBaseDetailMapper;

    public List<PlanBaseDetail> findPlanBaseDetailList(PlanBaseDetail planBaseDetail) {
        List<PlanBaseDetail> record = planBaseDetailMapper.findPlanBaseDetailList(planBaseDetail);
        return record;
    }

    @Override
    public int updateOrInsertPlanBaseDetail(PlanBaseDetail planBaseDetail) throws Exception {
        int result = 500;
        if (planBaseDetail.getId() != null && planBaseDetail.getId() != null) {
            planBaseDetailMapper.updateByPrimaryKeySelective(planBaseDetail);
        } else {
            planBaseDetail.setId(IdUtil.createIdByTime());
            planBaseDetailMapper.insertSelective(planBaseDetail);
        }
        result = 200;
        return result;
    }

    @Override
    public int deletePlanBaseDetailById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            planBaseDetailMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public PlanBaseDetail getPlanBaseDetailInfo(String id) throws Exception {

        return planBaseDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(PlanBaseDetailExample example) {
        return planBaseDetailMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(PlanBaseDetailExample example) {
        return planBaseDetailMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return planBaseDetailMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deletePlanBaseDetailReal(String recordId) {
        return planBaseDetailMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(PlanBaseDetail record) {
        record.setId(IdUtil.createIdByTime());
        return planBaseDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(PlanBaseDetail record) {
        return planBaseDetailMapper.insertSelective(record);
    }

    public PlanBaseDetail insertObject(PlanBaseDetail record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<PlanBaseDetail> selectByExample(PlanBaseDetailExample example) {
        return planBaseDetailMapper.selectByExample(example);
    }

    @Override
    public PlanBaseDetail selectByPrimaryKey(String recordId) {
        return planBaseDetailMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") PlanBaseDetail record, @Param("example") PlanBaseDetailExample example) {
        return planBaseDetailMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") PlanBaseDetail record, @Param("example") PlanBaseDetailExample example) {
        return planBaseDetailMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(PlanBaseDetail record) {
        return planBaseDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PlanBaseDetail record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return planBaseDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deletePlanBaseDetail(Serializable planBaseDetailId) {
        try {
            PlanBaseDetail record = planBaseDetailMapper.selectByPrimaryKey(planBaseDetailId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                planBaseDetailMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findPlanBaseDetailByPage(LayuiTableParam param) {
        PlanBaseDetailExample example = new PlanBaseDetailExample();
        PlanBaseDetailExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            PlanBaseDetailExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, PlanBaseDetailExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<PlanBaseDetail> list = planBaseDetailMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<PlanBaseDetail> pageInfo = new PageInfo<PlanBaseDetail>(list);
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
        PlanBaseDetailExample example = new PlanBaseDetailExample();
        example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<PlanBaseDetail> records = planBaseDetailMapper.selectByExample(example);
        for (PlanBaseDetail record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        PlanBaseDetailExample planBaseDetailExample = new PlanBaseDetailExample();
        String strParentId = planBaseDetailMapper.selectByExample(planBaseDetailExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}