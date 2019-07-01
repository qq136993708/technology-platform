package com.pcitc.service.laboratory.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.*;
import com.pcitc.base.laboratory.LaboratoryLeadingTalentsExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.laboratory.LaboratoryLeadingTalentsMapper;
import com.pcitc.service.laboratory.LaboratoryLeadingTalentsService;
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
 * <p>Table: laboratory_leading_talents - 实验室-领军人才</p>
 *
 * @since 2019-07-01 09:12:35
 */
@Service("laboratoryLeadingTalentsService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class LaboratoryLeadingTalentsServiceImpl implements LaboratoryLeadingTalentsService {

    @Autowired
    private LaboratoryLeadingTalentsMapper laboratoryLeadingTalentsMapper;

    public List<LaboratoryLeadingTalents> findLaboratoryLeadingTalentsList(LaboratoryLeadingTalents laboratoryLeadingTalents) {
        List<LaboratoryLeadingTalents> record = laboratoryLeadingTalentsMapper.findLaboratoryLeadingTalentsList(laboratoryLeadingTalents);
        return record;
    }

    @Override
    public int updateOrInsertLaboratoryLeadingTalents(LaboratoryLeadingTalents laboratoryLeadingTalents) throws Exception {
        int result = 500;
        if (laboratoryLeadingTalents.getDataId() != null && laboratoryLeadingTalents.getDataId() != null) {
            laboratoryLeadingTalentsMapper.updateByPrimaryKeySelective(laboratoryLeadingTalents);
        } else {
            laboratoryLeadingTalents.setDataId(IdUtil.createIdByTime());
            laboratoryLeadingTalentsMapper.insertSelective(laboratoryLeadingTalents);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteLaboratoryLeadingTalentsById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            laboratoryLeadingTalentsMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public LaboratoryLeadingTalents getLaboratoryLeadingTalentsInfo(String id) throws Exception {

        return laboratoryLeadingTalentsMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(LaboratoryLeadingTalentsExample example) {
        return laboratoryLeadingTalentsMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(LaboratoryLeadingTalentsExample example) {
        return laboratoryLeadingTalentsMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return laboratoryLeadingTalentsMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteLaboratoryLeadingTalentsReal(String recordId) {
        return laboratoryLeadingTalentsMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(LaboratoryLeadingTalents record) {
        record.setDataId(IdUtil.createIdByTime());
        return laboratoryLeadingTalentsMapper.insert(record);
    }

    @Override
    public int insertSelective(LaboratoryLeadingTalents record) {
        return laboratoryLeadingTalentsMapper.insertSelective(record);
    }

    public LaboratoryLeadingTalents insertObject(LaboratoryLeadingTalents record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<LaboratoryLeadingTalents> selectByExample(LaboratoryLeadingTalentsExample example) {
        return laboratoryLeadingTalentsMapper.selectByExample(example);
    }

    @Override
    public LaboratoryLeadingTalents selectByPrimaryKey(String recordId) {
        return laboratoryLeadingTalentsMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") LaboratoryLeadingTalents record, @Param("example") LaboratoryLeadingTalentsExample example) {
        return laboratoryLeadingTalentsMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") LaboratoryLeadingTalents record, @Param("example") LaboratoryLeadingTalentsExample example) {
        return laboratoryLeadingTalentsMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(LaboratoryLeadingTalents record) {
        return laboratoryLeadingTalentsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LaboratoryLeadingTalents record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return laboratoryLeadingTalentsMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteLaboratoryLeadingTalents(Serializable laboratoryLeadingTalentsId) {
        try {
            LaboratoryLeadingTalents record = laboratoryLeadingTalentsMapper.selectByPrimaryKey(laboratoryLeadingTalentsId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                laboratoryLeadingTalentsMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findLaboratoryLeadingTalentsByPage(LayuiTableParam param) {
        LaboratoryLeadingTalentsExample example = new LaboratoryLeadingTalentsExample();
        LaboratoryLeadingTalentsExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            LaboratoryLeadingTalentsExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, LaboratoryLeadingTalentsExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<LaboratoryLeadingTalents> list = laboratoryLeadingTalentsMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<LaboratoryLeadingTalents> pageInfo = new PageInfo<LaboratoryLeadingTalents>(list);
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
        LaboratoryLeadingTalentsExample example = new LaboratoryLeadingTalentsExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<LaboratoryLeadingTalents> records = laboratoryLeadingTalentsMapper.selectByExample(example);
        for (LaboratoryLeadingTalents record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        LaboratoryLeadingTalentsExample laboratoryLeadingTalentsExample = new LaboratoryLeadingTalentsExample();
        String strParentId = laboratoryLeadingTalentsMapper.selectByExample(laboratoryLeadingTalentsExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}