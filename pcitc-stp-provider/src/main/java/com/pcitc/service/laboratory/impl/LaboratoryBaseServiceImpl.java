package com.pcitc.service.laboratory.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.*;
import com.pcitc.base.laboratory.LaboratoryBaseExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.laboratory.LaboratoryBaseMapper;
import com.pcitc.service.laboratory.LaboratoryBaseService;
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
 * <p>Table: laboratory_base - 实验室-基本情况</p>
 *
 * @since 2019-07-01 09:11:30
 */
@Service("laboratoryBaseService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class LaboratoryBaseServiceImpl implements LaboratoryBaseService {

    @Autowired
    private LaboratoryBaseMapper laboratoryBaseMapper;

    public List<LaboratoryBase> findLaboratoryBaseList(LaboratoryBase laboratoryBase) {
        List<LaboratoryBase> record = laboratoryBaseMapper.findLaboratoryBaseList(laboratoryBase);
        return record;
    }

    @Override
    public int updateOrInsertLaboratoryBase(LaboratoryBase laboratoryBase) throws Exception {
        int result = 500;
        if (laboratoryBase.getDataId() != null && laboratoryBase.getDataId() != null) {
            laboratoryBaseMapper.updateByPrimaryKeySelective(laboratoryBase);
        } else {
            laboratoryBase.setDataId(IdUtil.createIdByTime());
            laboratoryBaseMapper.insertSelective(laboratoryBase);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteLaboratoryBaseById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            laboratoryBaseMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public LaboratoryBase getLaboratoryBaseInfo(String id) throws Exception {

        return laboratoryBaseMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(LaboratoryBaseExample example) {
        return laboratoryBaseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(LaboratoryBaseExample example) {
        return laboratoryBaseMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return laboratoryBaseMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteLaboratoryBaseReal(String recordId) {
        return laboratoryBaseMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(LaboratoryBase record) {
        record.setDataId(IdUtil.createIdByTime());
        return laboratoryBaseMapper.insert(record);
    }

    @Override
    public int insertSelective(LaboratoryBase record) {
        return laboratoryBaseMapper.insertSelective(record);
    }

    public LaboratoryBase insertObject(LaboratoryBase record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<LaboratoryBase> selectByExample(LaboratoryBaseExample example) {
        return laboratoryBaseMapper.selectByExample(example);
    }

    @Override
    public LaboratoryBase selectByPrimaryKey(String recordId) {
        return laboratoryBaseMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") LaboratoryBase record, @Param("example") LaboratoryBaseExample example) {
        return laboratoryBaseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") LaboratoryBase record, @Param("example") LaboratoryBaseExample example) {
        return laboratoryBaseMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(LaboratoryBase record) {
        return laboratoryBaseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LaboratoryBase record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return laboratoryBaseMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteLaboratoryBase(Serializable laboratoryBaseId) {
        try {
            LaboratoryBase record = laboratoryBaseMapper.selectByPrimaryKey(laboratoryBaseId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                laboratoryBaseMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findLaboratoryBaseByPage(LayuiTableParam param) {
        LaboratoryBaseExample example = new LaboratoryBaseExample();
        LaboratoryBaseExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            LaboratoryBaseExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, LaboratoryBaseExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<LaboratoryBase> list = laboratoryBaseMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<LaboratoryBase> pageInfo = new PageInfo<LaboratoryBase>(list);
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
        LaboratoryBaseExample example = new LaboratoryBaseExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<LaboratoryBase> records = laboratoryBaseMapper.selectByExample(example);
        for (LaboratoryBase record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        LaboratoryBaseExample laboratoryBaseExample = new LaboratoryBaseExample();
        String strParentId = laboratoryBaseMapper.selectByExample(laboratoryBaseExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}