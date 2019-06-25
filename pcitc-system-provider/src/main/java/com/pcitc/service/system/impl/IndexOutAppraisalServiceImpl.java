package com.pcitc.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.*;
import com.pcitc.base.system.IndexOutAppraisalExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.system.IndexOutAppraisalMapper;
import com.pcitc.service.system.IndexOutAppraisalService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;

/**
 * <p>接口实现类</p>
 * <p>Table: index_out_appraisal - </p>
 *
 * @since 2019-05-23 07:13:47
 */
@Service("indexOutAppraisalService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class IndexOutAppraisalServiceImpl implements IndexOutAppraisalService {

    @Autowired
    private IndexOutAppraisalMapper indexOutAppraisalMapper;

    public List<IndexOutAppraisal> findIndexOutAppraisalList(IndexOutAppraisal indexOutAppraisal) {
        List<IndexOutAppraisal> record = indexOutAppraisalMapper.findIndexOutAppraisalList(indexOutAppraisal);
        return record;
    }

    @Override
    public int updateOrInsertIndexOutAppraisal(IndexOutAppraisal indexOutAppraisal) throws Exception {
        int result = 500;
        if (indexOutAppraisal.getDataId() != null && indexOutAppraisal.getDataId() != null) {
            indexOutAppraisalMapper.updateByPrimaryKeySelective(indexOutAppraisal);
        } else {
            indexOutAppraisal.setDataId(IdUtil.createIdByTime());
            indexOutAppraisalMapper.insertSelective(indexOutAppraisal);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteIndexOutAppraisalById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            indexOutAppraisalMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public IndexOutAppraisal getIndexOutAppraisalInfo(String id) throws Exception {

        return indexOutAppraisalMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(IndexOutAppraisalExample example) {
        return indexOutAppraisalMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(IndexOutAppraisalExample example) {
        return indexOutAppraisalMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return indexOutAppraisalMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteIndexOutAppraisalReal(String recordId) {
        return indexOutAppraisalMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(IndexOutAppraisal record) {
        record.setDataId(IdUtil.createIdByTime());
        return indexOutAppraisalMapper.insert(record);
    }

    @Override
    public int insertSelective(IndexOutAppraisal record) {
        return indexOutAppraisalMapper.insertSelective(record);
    }

    public IndexOutAppraisal insertObject(IndexOutAppraisal record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<IndexOutAppraisal> selectByExample(IndexOutAppraisalExample example) {
        return indexOutAppraisalMapper.selectByExample(example);
    }

    @Override
    public IndexOutAppraisal selectByPrimaryKey(String recordId) {
        return indexOutAppraisalMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") IndexOutAppraisal record, @Param("example") IndexOutAppraisalExample example) {
        return indexOutAppraisalMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") IndexOutAppraisal record, @Param("example") IndexOutAppraisalExample example) {
        return indexOutAppraisalMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(IndexOutAppraisal record) {
        return indexOutAppraisalMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(IndexOutAppraisal record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return indexOutAppraisalMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteIndexOutAppraisal(Serializable indexOutAppraisalId) {
        try {
            IndexOutAppraisal record = indexOutAppraisalMapper.selectByPrimaryKey(indexOutAppraisalId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                indexOutAppraisalMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findIndexOutAppraisalByPage(LayuiTableParam param) {
        IndexOutAppraisalExample example = new IndexOutAppraisalExample();
        IndexOutAppraisalExample.Criteria c = example.createCriteria();
        Object typeIndex = param.getParam().get("typeIndex");
        if (typeIndex != null) {
            c.andTypeIndexLike(typeIndex + "%");
        }
        Object cgmc = param.getParam().get("cgmc");
        if (cgmc != null) {
            c.andCgmcLike(cgmc + "%");
        }
        Object dataId = param.getParam().get("dataId");
        if (dataId != null) {
            c.andDataIdIn(Arrays.asList(dataId.toString().split(",")));
        }
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
    private LayuiTableData findByExample(LayuiTableParam param, IndexOutAppraisalExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<IndexOutAppraisal> list = indexOutAppraisalMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<IndexOutAppraisal> pageInfo = new PageInfo<IndexOutAppraisal>(list);
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
        IndexOutAppraisalExample example = new IndexOutAppraisalExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<IndexOutAppraisal> records = indexOutAppraisalMapper.selectByExample(example);
        for (IndexOutAppraisal record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        IndexOutAppraisalExample indexOutAppraisalExample = new IndexOutAppraisalExample();
        String strParentId = indexOutAppraisalMapper.selectByExample(indexOutAppraisalExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}