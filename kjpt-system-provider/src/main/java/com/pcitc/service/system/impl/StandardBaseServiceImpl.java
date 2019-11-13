package com.pcitc.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.*;
import com.pcitc.base.system.StandardBaseExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.system.StandardBaseMapper;
import com.pcitc.service.system.StandardBaseService;
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
 * <p>Table: standard_base - 标准化</p>
 *
 * @since 2019-05-10 03:07:51
 */
@Service("standardBaseService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class StandardBaseServiceImpl implements StandardBaseService {

    @Autowired
    private StandardBaseMapper standardBaseMapper;

    public List<StandardBase> findStandardBaseList(StandardBase standardBase) {
        List<StandardBase> record = standardBaseMapper.findStandardBaseList(standardBase);
        return record;
    }

    @Override
    public int updateOrInsertStandardBase(StandardBase standardBase) throws Exception {
        int result = 500;
        if (standardBase.getDataId() != null && standardBase.getDataId() != null) {
            standardBaseMapper.updateByPrimaryKeySelective(standardBase);
        } else {
            standardBase.setDataId(IdUtil.createIdByTime());
            standardBaseMapper.insertSelective(standardBase);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteStandardBaseById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            standardBaseMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public StandardBase getStandardBaseInfo(String id) throws Exception {

        return standardBaseMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(StandardBaseExample example) {
        return standardBaseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(StandardBaseExample example) {
        return standardBaseMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return standardBaseMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteStandardBaseReal(String recordId) {
        return standardBaseMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(StandardBase record) {
        record.setDataId(IdUtil.createIdByTime());
        return standardBaseMapper.insert(record);
    }

    @Override
    public int insertSelective(StandardBase record) {
        return standardBaseMapper.insertSelective(record);
    }

    public StandardBase insertObject(StandardBase record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<StandardBase> selectByExample(StandardBaseExample example) {
        return standardBaseMapper.selectByExample(example);
    }

    @Override
    public StandardBase selectByPrimaryKey(String recordId) {
        return standardBaseMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") StandardBase record, @Param("example") StandardBaseExample example) {
        return standardBaseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") StandardBase record, @Param("example") StandardBaseExample example) {
        return standardBaseMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(StandardBase record) {
        return standardBaseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(StandardBase record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return standardBaseMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteStandardBase(Serializable standardBaseId) {
        try {
            StandardBase record = standardBaseMapper.selectByPrimaryKey(standardBaseId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                standardBaseMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findStandardBaseByPage(LayuiTableParam param) {
        StandardBaseExample example = new StandardBaseExample();
        StandardBaseExample.Criteria c = example.createCriteria();
        Object standardName = param.getParam().get("standardName");
        if (!StrUtil.isObjectEmpty(standardName)) {
            c.andStandardNameLike("%" + standardName + "%");

        }
        Object standardKeys = param.getParam().get("standardKeys");
        if (!StrUtil.isObjectEmpty(standardKeys)) {
            c.andStandardKeysLike("%" + standardKeys + "%");

        }
        Object standardNum = param.getParam().get("standardNum");
        if (!StrUtil.isObjectEmpty(standardNum)) {
            c.andStandardNumLike("%" + standardNum + "%");

        }
        Object standardStatus = param.getParam().get("standardStatus");
        if (!StrUtil.isObjectEmpty(standardStatus)) {
            c.andStandardStatusLike("%" + standardStatus + "%");
        }

        Object orgType = param.getParam().get("orgType");
        if (!StrUtil.isObjectEmpty(orgType)) {
            c.andOrgTypeLike("%" + orgType + "%");
        }

        Object icsType = param.getParam().get("icsType");
        if (!StrUtil.isObjectEmpty(icsType)) {
            c.andIcsTypeLike("%" + icsType + "%");
        }
        Object choiceType = param.getParam().get("choiceType");
        if (!StrUtil.isObjectEmpty(choiceType)) {
            c.andChoiceTypeLike("%" + choiceType + "%");
        }

//        Object bak3 = param.getParam().get("bak3");
//        if (!StrUtil.isObjectEmpty(bak3)) {
//            c.andBak3EqualTo(bak3.toString());
//        }
//
//        Object bak1 = param.getParam().get("bak1");
//        if (!StrUtil.isObjectEmpty(bak1)) {
//            c.andBak1EqualTo(bak1.toString());
//        }
//        Object bak2 = param.getParam().get("bak2");
//        if (!StrUtil.isObjectEmpty(bak2)) {
//            c.andBak2EqualTo(bak2.toString());
//        }


//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            StandardBaseExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, StandardBaseExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<StandardBase> list = standardBaseMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<StandardBase> pageInfo = new PageInfo<StandardBase>(list);
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
        StandardBaseExample example = new StandardBaseExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<StandardBase> records = standardBaseMapper.selectByExample(example);
        for (StandardBase record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        StandardBaseExample standardBaseExample = new StandardBaseExample();
        String strParentId = standardBaseMapper.selectByExample(standardBaseExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}