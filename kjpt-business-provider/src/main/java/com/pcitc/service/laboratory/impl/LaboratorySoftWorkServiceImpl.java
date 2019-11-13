package com.pcitc.service.laboratory.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.*;
import com.pcitc.base.laboratory.LaboratorySoftWorkExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.laboratory.LaboratorySoftWorkMapper;
import com.pcitc.service.laboratory.LaboratorySoftWorkService;
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
 * <p>Table: laboratory_soft_work - 实验室-知识产权-软著</p>
 *
 * @since 2019-07-01 09:14:14
 */
@Service("laboratorySoftWorkService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class LaboratorySoftWorkServiceImpl implements LaboratorySoftWorkService {

    @Autowired
    private LaboratorySoftWorkMapper laboratorySoftWorkMapper;

    public List<LaboratorySoftWork> findLaboratorySoftWorkList(LaboratorySoftWork laboratorySoftWork) {
        List<LaboratorySoftWork> record = laboratorySoftWorkMapper.findLaboratorySoftWorkList(laboratorySoftWork);
        return record;
    }

    @Override
    public int updateOrInsertLaboratorySoftWork(LaboratorySoftWork laboratorySoftWork) throws Exception {
        int result = 500;
        if (laboratorySoftWork.getDataId() != null && laboratorySoftWork.getDataId() != null) {
            laboratorySoftWorkMapper.updateByPrimaryKeySelective(laboratorySoftWork);
        } else {
            laboratorySoftWork.setDataId(IdUtil.createIdByTime());
            laboratorySoftWorkMapper.insertSelective(laboratorySoftWork);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteLaboratorySoftWorkById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            laboratorySoftWorkMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public LaboratorySoftWork getLaboratorySoftWorkInfo(String id) throws Exception {

        return laboratorySoftWorkMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(LaboratorySoftWorkExample example) {
        return laboratorySoftWorkMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(LaboratorySoftWorkExample example) {
        return laboratorySoftWorkMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return laboratorySoftWorkMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteLaboratorySoftWorkReal(String recordId) {
        return laboratorySoftWorkMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(LaboratorySoftWork record) {
        record.setDataId(IdUtil.createIdByTime());
        return laboratorySoftWorkMapper.insert(record);
    }

    @Override
    public int insertSelective(LaboratorySoftWork record) {
        return laboratorySoftWorkMapper.insertSelective(record);
    }

    public LaboratorySoftWork insertObject(LaboratorySoftWork record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<LaboratorySoftWork> selectByExample(LaboratorySoftWorkExample example) {
        return laboratorySoftWorkMapper.selectByExample(example);
    }

    @Override
    public LaboratorySoftWork selectByPrimaryKey(String recordId) {
        return laboratorySoftWorkMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") LaboratorySoftWork record, @Param("example") LaboratorySoftWorkExample example) {
        return laboratorySoftWorkMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") LaboratorySoftWork record, @Param("example") LaboratorySoftWorkExample example) {
        return laboratorySoftWorkMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(LaboratorySoftWork record) {
        return laboratorySoftWorkMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LaboratorySoftWork record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return laboratorySoftWorkMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteLaboratorySoftWork(Serializable laboratorySoftWorkId) {
        try {
            LaboratorySoftWork record = laboratorySoftWorkMapper.selectByPrimaryKey(laboratorySoftWorkId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                laboratorySoftWorkMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findLaboratorySoftWorkByPage(LayuiTableParam param) {
        LaboratorySoftWorkExample example = new LaboratorySoftWorkExample();
        LaboratorySoftWorkExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            LaboratorySoftWorkExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, LaboratorySoftWorkExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<LaboratorySoftWork> list = laboratorySoftWorkMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<LaboratorySoftWork> pageInfo = new PageInfo<LaboratorySoftWork>(list);
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
        LaboratorySoftWorkExample example = new LaboratorySoftWorkExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<LaboratorySoftWork> records = laboratorySoftWorkMapper.selectByExample(example);
        for (LaboratorySoftWork record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        LaboratorySoftWorkExample laboratorySoftWorkExample = new LaboratorySoftWorkExample();
        String strParentId = laboratorySoftWorkMapper.selectByExample(laboratorySoftWorkExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}