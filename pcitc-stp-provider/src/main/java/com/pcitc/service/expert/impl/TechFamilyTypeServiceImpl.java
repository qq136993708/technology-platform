package com.pcitc.service.expert.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.TechFamilyTypeExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.TechFamilyTypeMapper;
import com.pcitc.service.expert.TechFamilyTypeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * <p>接口实现类</p>
 * <p>Table: tech_family_type - 技术族-分类</p>
 *
 * @since 2018-12-29 11:34:35
 */
@Service("techFamilyTypeService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class TechFamilyTypeServiceImpl implements TechFamilyTypeService {

    @Resource
    private TechFamilyTypeMapper techFamilyTypeMapper;

    public List<TechFamilyType> findTechFamilyTypeList(TechFamilyType techFamilyType) {
        List<TechFamilyType> record = techFamilyTypeMapper.findTechFamilyTypeList(techFamilyType);
        return record;
    }

    @Override
    public int updateOrInsertTechFamilyType(TechFamilyType techFamilyType) throws Exception {
        int result = 500;
        if (techFamilyType.getDataId() != null && techFamilyType.getDataId() != null) {
            techFamilyTypeMapper.updateByPrimaryKeySelective(techFamilyType);
        } else {
            techFamilyType.setDataId(IdUtil.createIdByTime());
            techFamilyTypeMapper.insertSelective(techFamilyType);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteTechFamilyTypeById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            techFamilyTypeMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public TechFamilyType getTechFamilyTypeInfo(String id) throws Exception {

        return techFamilyTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(TechFamilyTypeExample example) {
        return techFamilyTypeMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TechFamilyTypeExample example) {
        return techFamilyTypeMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return techFamilyTypeMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteTechFamilyTypeReal(String recordId) {
        return techFamilyTypeMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(TechFamilyType record) {
        record.setId(IdUtil.createIdByTime());
        return techFamilyTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(TechFamilyType record) {
        return techFamilyTypeMapper.insertSelective(record);
    }

    public TechFamilyType insertObject(TechFamilyType record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<TechFamilyType> selectByExample(TechFamilyTypeExample example) {
        return techFamilyTypeMapper.selectByExample(example);
    }

    @Override
    public TechFamilyType selectByPrimaryKey(String recordId) {
        return techFamilyTypeMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") TechFamilyType record, @Param("example") TechFamilyTypeExample example) {
        return techFamilyTypeMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") TechFamilyType record, @Param("example") TechFamilyTypeExample example) {
        return techFamilyTypeMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(TechFamilyType record) {
        return techFamilyTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TechFamilyType record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return techFamilyTypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteTechFamilyType(Serializable techFamilyTypeId) {
        try {
            TechFamilyType record = techFamilyTypeMapper.selectByPrimaryKey(techFamilyTypeId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                techFamilyTypeMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findTechFamilyTypeByPage(LayuiTableParam param) {
        TechFamilyTypeExample example = new TechFamilyTypeExample();
        TechFamilyTypeExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            TechFamilyTypeExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, TechFamilyTypeExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<TechFamilyType> list = techFamilyTypeMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<TechFamilyType> pageInfo = new PageInfo<TechFamilyType>(list);
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
        TechFamilyTypeExample example = new TechFamilyTypeExample();
        example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<TechFamilyType> records = techFamilyTypeMapper.selectByExample(example);
        for (TechFamilyType record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        TechFamilyTypeExample techFamilyTypeExample = new TechFamilyTypeExample();
        String strParentId = techFamilyTypeMapper.selectByExample(techFamilyTypeExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}