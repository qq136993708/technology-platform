package com.pcitc.service.laboratory.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.*;
import com.pcitc.base.laboratory.LaboratoryScientificTaskExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.laboratory.LaboratoryScientificTaskMapper;
import com.pcitc.service.laboratory.LaboratoryScientificTaskService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>接口实现类</p>
 * <p>Table: laboratory_scientific_task - 实验室-重大科研任务</p>
 *
 * @since 2019-07-01 09:13:29
 */
@Service("laboratoryScientificTaskService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class LaboratoryScientificTaskServiceImpl implements LaboratoryScientificTaskService {

    @Autowired
    private LaboratoryScientificTaskMapper laboratoryScientificTaskMapper;

    public List<LaboratoryScientificTask> findLaboratoryScientificTaskList(LaboratoryScientificTask laboratoryScientificTask) {
        List<LaboratoryScientificTask> record = laboratoryScientificTaskMapper.findLaboratoryScientificTaskList(laboratoryScientificTask);
        return record;
    }

    @Override
    public int updateOrInsertLaboratoryScientificTask(LaboratoryScientificTask laboratoryScientificTask) throws Exception {
        int result = 500;
        if (laboratoryScientificTask.getDataId() != null && laboratoryScientificTask.getDataId() != null) {
            laboratoryScientificTaskMapper.updateByPrimaryKeySelective(laboratoryScientificTask);
        } else {
            laboratoryScientificTask.setDataId(IdUtil.createIdByTime());
            laboratoryScientificTaskMapper.insertSelective(laboratoryScientificTask);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteLaboratoryScientificTaskById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            laboratoryScientificTaskMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public LaboratoryScientificTask getLaboratoryScientificTaskInfo(String id) throws Exception {

        return laboratoryScientificTaskMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(LaboratoryScientificTaskExample example) {
        return laboratoryScientificTaskMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(LaboratoryScientificTaskExample example) {
        return laboratoryScientificTaskMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return laboratoryScientificTaskMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteLaboratoryScientificTaskReal(String recordId) {
        return laboratoryScientificTaskMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(LaboratoryScientificTask record) {
        record.setDataId(IdUtil.createIdByTime());
        return laboratoryScientificTaskMapper.insert(record);
    }

    @Override
    public int insertSelective(LaboratoryScientificTask record) {
        return laboratoryScientificTaskMapper.insertSelective(record);
    }

    public LaboratoryScientificTask insertObject(LaboratoryScientificTask record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<LaboratoryScientificTask> selectByExample(LaboratoryScientificTaskExample example) {
        return laboratoryScientificTaskMapper.selectByExample(example);
    }

    @Override
    public LaboratoryScientificTask selectByPrimaryKey(String recordId) {
        return laboratoryScientificTaskMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") LaboratoryScientificTask record, @Param("example") LaboratoryScientificTaskExample example) {
        return laboratoryScientificTaskMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") LaboratoryScientificTask record, @Param("example") LaboratoryScientificTaskExample example) {
        return laboratoryScientificTaskMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(LaboratoryScientificTask record) {
        return laboratoryScientificTaskMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LaboratoryScientificTask record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return laboratoryScientificTaskMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteLaboratoryScientificTask(Serializable laboratoryScientificTaskId) {
        try {
            LaboratoryScientificTask record = laboratoryScientificTaskMapper.selectByPrimaryKey(laboratoryScientificTaskId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                laboratoryScientificTaskMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findLaboratoryScientificTaskByPage(LayuiTableParam param) {
        LaboratoryScientificTaskExample example = new LaboratoryScientificTaskExample();
        LaboratoryScientificTaskExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            LaboratoryScientificTaskExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, LaboratoryScientificTaskExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<LaboratoryScientificTask> list = laboratoryScientificTaskMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<LaboratoryScientificTask> pageInfo = new PageInfo<LaboratoryScientificTask>(list);
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
        LaboratoryScientificTaskExample example = new LaboratoryScientificTaskExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<LaboratoryScientificTask> records = laboratoryScientificTaskMapper.selectByExample(example);
        for (LaboratoryScientificTask record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        LaboratoryScientificTaskExample laboratoryScientificTaskExample = new LaboratoryScientificTaskExample();
        String strParentId = laboratoryScientificTaskMapper.selectByExample(laboratoryScientificTaskExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}