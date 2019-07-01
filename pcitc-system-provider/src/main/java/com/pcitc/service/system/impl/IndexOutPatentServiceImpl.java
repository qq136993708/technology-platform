package com.pcitc.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.*;
import com.pcitc.base.system.IndexOutPatentExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.system.IndexOutPatentMapper;
import com.pcitc.service.system.IndexOutPatentService;
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
 * <p>Table: index_out_patent - </p>
 *
 * @since 2019-05-23 07:13:54
 */
@Service("indexOutPatentService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class IndexOutPatentServiceImpl implements IndexOutPatentService {

    @Autowired
    private IndexOutPatentMapper indexOutPatentMapper;

    public List<IndexOutPatent> findIndexOutPatentList(IndexOutPatent indexOutPatent) {
        List<IndexOutPatent> record = indexOutPatentMapper.findIndexOutPatentList(indexOutPatent);
        return record;
    }

    @Override
    public int updateOrInsertIndexOutPatent(IndexOutPatent indexOutPatent) throws Exception {
        int result = 500;
        if (indexOutPatent.getDataId() != null && indexOutPatent.getDataId() != null) {
            indexOutPatentMapper.updateByPrimaryKeySelective(indexOutPatent);
        } else {
            indexOutPatent.setDataId(IdUtil.createIdByTime());
            indexOutPatentMapper.insertSelective(indexOutPatent);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteIndexOutPatentById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            indexOutPatentMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public IndexOutPatent getIndexOutPatentInfo(String id) throws Exception {

        return indexOutPatentMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(IndexOutPatentExample example) {
        return indexOutPatentMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(IndexOutPatentExample example) {
        return indexOutPatentMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return indexOutPatentMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteIndexOutPatentReal(String recordId) {
        return indexOutPatentMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(IndexOutPatent record) {
        record.setDataId(IdUtil.createIdByTime());
        return indexOutPatentMapper.insert(record);
    }

    @Override
    public int insertSelective(IndexOutPatent record) {
        return indexOutPatentMapper.insertSelective(record);
    }

    public IndexOutPatent insertObject(IndexOutPatent record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<IndexOutPatent> selectByExample(IndexOutPatentExample example) {
        return indexOutPatentMapper.selectByExample(example);
    }

    @Override
    public IndexOutPatent selectByPrimaryKey(String recordId) {
        return indexOutPatentMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") IndexOutPatent record, @Param("example") IndexOutPatentExample example) {
        return indexOutPatentMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") IndexOutPatent record, @Param("example") IndexOutPatentExample example) {
        return indexOutPatentMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(IndexOutPatent record) {
        return indexOutPatentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(IndexOutPatent record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return indexOutPatentMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteIndexOutPatent(Serializable indexOutPatentId) {
        try {
            IndexOutPatent record = indexOutPatentMapper.selectByPrimaryKey(indexOutPatentId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                indexOutPatentMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findIndexOutPatentByPage(LayuiTableParam param) {
        IndexOutPatentExample example = new IndexOutPatentExample();
        IndexOutPatentExample.Criteria c = example.createCriteria();
        Object typeIndex = param.getParam().get("typeIndex");
        if (typeIndex != null) {
            c.andTypeIndexLike(typeIndex + "%");
        }
        Object fmmc = param.getParam().get("fmmc");
        if (fmmc != null) {
            c.andFmmcLike("%"+fmmc + "%");
        }
        Object fmh = param.getParam().get("fmh");
        if (fmh != null) {
            c.andZlhLike("%"+fmh + "%");
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
    private LayuiTableData findByExample(LayuiTableParam param, IndexOutPatentExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<IndexOutPatent> list = indexOutPatentMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<IndexOutPatent> pageInfo = new PageInfo<IndexOutPatent>(list);
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
        IndexOutPatentExample example = new IndexOutPatentExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<IndexOutPatent> records = indexOutPatentMapper.selectByExample(example);
        for (IndexOutPatent record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        IndexOutPatentExample indexOutPatentExample = new IndexOutPatentExample();
        String strParentId = indexOutPatentMapper.selectByExample(indexOutPatentExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}