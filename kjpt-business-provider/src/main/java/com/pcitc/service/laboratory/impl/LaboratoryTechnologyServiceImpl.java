package com.pcitc.service.laboratory.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.*;
import com.pcitc.base.laboratory.LaboratoryTechnologyExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.laboratory.LaboratoryTechnologyMapper;
import com.pcitc.service.laboratory.LaboratoryTechnologyService;
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
 * <p>Table: laboratory_technology - 实验室-知识产权-专有技术</p>
 *
 * @since 2019-07-01 09:14:45
 */
@Service("laboratoryTechnologyService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class LaboratoryTechnologyServiceImpl implements LaboratoryTechnologyService {

    @Autowired
    private LaboratoryTechnologyMapper laboratoryTechnologyMapper;

    public List<LaboratoryTechnology> findLaboratoryTechnologyList(LaboratoryTechnology laboratoryTechnology) {
        List<LaboratoryTechnology> record = laboratoryTechnologyMapper.findLaboratoryTechnologyList(laboratoryTechnology);
        return record;
    }

    @Override
    public int updateOrInsertLaboratoryTechnology(LaboratoryTechnology laboratoryTechnology) throws Exception {
        int result = 500;
        if (laboratoryTechnology.getDataId() != null && laboratoryTechnology.getDataId() != null) {
            laboratoryTechnologyMapper.updateByPrimaryKeySelective(laboratoryTechnology);
        } else {
            laboratoryTechnology.setDataId(IdUtil.createIdByTime());
            laboratoryTechnologyMapper.insertSelective(laboratoryTechnology);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteLaboratoryTechnologyById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            laboratoryTechnologyMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public LaboratoryTechnology getLaboratoryTechnologyInfo(String id) throws Exception {

        return laboratoryTechnologyMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(LaboratoryTechnologyExample example) {
        return laboratoryTechnologyMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(LaboratoryTechnologyExample example) {
        return laboratoryTechnologyMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return laboratoryTechnologyMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteLaboratoryTechnologyReal(String recordId) {
        return laboratoryTechnologyMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(LaboratoryTechnology record) {
        record.setDataId(IdUtil.createIdByTime());
        return laboratoryTechnologyMapper.insert(record);
    }

    @Override
    public int insertSelective(LaboratoryTechnology record) {
        return laboratoryTechnologyMapper.insertSelective(record);
    }

    public LaboratoryTechnology insertObject(LaboratoryTechnology record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<LaboratoryTechnology> selectByExample(LaboratoryTechnologyExample example) {
        return laboratoryTechnologyMapper.selectByExample(example);
    }

    @Override
    public LaboratoryTechnology selectByPrimaryKey(String recordId) {
        return laboratoryTechnologyMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") LaboratoryTechnology record, @Param("example") LaboratoryTechnologyExample example) {
        return laboratoryTechnologyMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") LaboratoryTechnology record, @Param("example") LaboratoryTechnologyExample example) {
        return laboratoryTechnologyMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(LaboratoryTechnology record) {
        return laboratoryTechnologyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LaboratoryTechnology record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return laboratoryTechnologyMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteLaboratoryTechnology(Serializable laboratoryTechnologyId) {
        try {
            LaboratoryTechnology record = laboratoryTechnologyMapper.selectByPrimaryKey(laboratoryTechnologyId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                laboratoryTechnologyMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findLaboratoryTechnologyByPage(LayuiTableParam param) {
        LaboratoryTechnologyExample example = new LaboratoryTechnologyExample();
        LaboratoryTechnologyExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            LaboratoryTechnologyExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, LaboratoryTechnologyExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<LaboratoryTechnology> list = laboratoryTechnologyMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<LaboratoryTechnology> pageInfo = new PageInfo<LaboratoryTechnology>(list);
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
        LaboratoryTechnologyExample example = new LaboratoryTechnologyExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<LaboratoryTechnology> records = laboratoryTechnologyMapper.selectByExample(example);
        for (LaboratoryTechnology record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        LaboratoryTechnologyExample laboratoryTechnologyExample = new LaboratoryTechnologyExample();
        String strParentId = laboratoryTechnologyMapper.selectByExample(laboratoryTechnologyExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}