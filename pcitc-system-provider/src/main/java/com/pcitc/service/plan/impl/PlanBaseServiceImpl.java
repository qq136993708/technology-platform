package com.pcitc.service.plan.impl;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.plan.PlanBase;
import com.pcitc.base.plan.PlanBaseExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.plan.PlanBaseMapper;
import com.pcitc.service.plan.PlanBaseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>接口实现类</p>
 * <p>Table: plan_base - 工程签证申请</p>
 *
 * @since 2018-11-12 10:14:54
 */
@Service("planBaseService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PlanBaseServiceImpl implements PlanBaseService {

    @Autowired
    private PlanBaseMapper planBaseMapper;

    public List<PlanBase> findPlanBaseList(PlanBase planBase) {
        List<PlanBase> record = planBaseMapper.findPlanBaseList(planBase);
        return record;
    }

    @Override
    public int updateOrInsertPlanBase(PlanBase planBase) throws Exception {
        int result = 500;
        if (planBase.getId() != null && planBase.getId() != null) {
            planBaseMapper.updateByPrimaryKeySelective(planBase);
        } else {
            planBase.setId(IdUtil.createIdByTime());
            planBaseMapper.insertSelective(planBase);
        }
        result = 200;
        return result;
    }

    @Override
    public int deletePlanBaseById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            planBaseMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public PlanBase getPlanBaseInfo(String id) throws Exception {

        return planBaseMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(PlanBaseExample example) {
        return planBaseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(PlanBaseExample example) {
        return planBaseMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return planBaseMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deletePlanBaseReal(String recordId) {
        return planBaseMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(PlanBase record) {
        record.setId(IdUtil.createIdByTime());
        return planBaseMapper.insert(record);
    }

    @Override
    public int insertSelective(PlanBase record) {
        return planBaseMapper.insertSelective(record);
    }

    public PlanBase insertObject(PlanBase record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<PlanBase> selectByExample(PlanBaseExample example) {
        return planBaseMapper.selectByExample(example);
    }

    @Override
    public PlanBase selectByPrimaryKey(String recordId) {
        return planBaseMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") PlanBase record, @Param("example") PlanBaseExample example) {
        return planBaseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") PlanBase record, @Param("example") PlanBaseExample example) {
        return planBaseMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(PlanBase record) {
        return planBaseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PlanBase record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return planBaseMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deletePlanBase(Serializable planBaseId) {
        try {
            PlanBase record = planBaseMapper.selectByPrimaryKey(planBaseId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                planBaseMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findPlanBaseByPage(LayuiTableParam param) {
        PlanBaseExample example = new PlanBaseExample();
        PlanBaseExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            PlanBaseExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, PlanBaseExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<PlanBase> list = planBaseMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<PlanBase> pageInfo = new PageInfo<PlanBase>(list);
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
        PlanBaseExample example = new PlanBaseExample();
        example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<PlanBase> records = planBaseMapper.selectByExample(example);
        for (PlanBase record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        PlanBaseExample planBaseExample = new PlanBaseExample();
        String strParentId = planBaseMapper.selectByExample(planBaseExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }

    public List<PlanBase> selectSonPlanBasesByCreateUserId(JSONObject jsonObject){
        Map<String, Object> map = new HashMap<>();
        map.put("createUserId",jsonObject.get("createUserId"));
        return planBaseMapper.selectSonPlanBasesByCreateUserId(map);
    }

}