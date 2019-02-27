package com.pcitc.service.expert.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkComplaintExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkComplaintMapper;
import com.pcitc.service.expert.ZjkComplaintService;
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
 * <p>Table: zjk_complaint - 专家-投诉管理</p>
 *
 * @since 2019-02-26 10:33:37
 */
@Service("zjkComplaintService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkComplaintServiceImpl implements ZjkComplaintService {

    @Autowired
    private ZjkComplaintMapper zjkComplaintMapper;

    public List<ZjkComplaint> findZjkComplaintList(ZjkComplaint zjkComplaint) {
        List<ZjkComplaint> record = zjkComplaintMapper.findZjkComplaintList(zjkComplaint);
        return record;
    }

    @Override
    public int updateOrInsertZjkComplaint(ZjkComplaint zjkComplaint) throws Exception {
        int result = 500;
        if (zjkComplaint.getDataId() != null && zjkComplaint.getDataId() != null) {
            zjkComplaintMapper.updateByPrimaryKeySelective(zjkComplaint);
        } else {
            zjkComplaint.setDataId(IdUtil.createIdByTime());
            zjkComplaintMapper.insertSelective(zjkComplaint);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkComplaintById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkComplaintMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkComplaint getZjkComplaintInfo(String id) throws Exception {

        return zjkComplaintMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkComplaintExample example) {
        return zjkComplaintMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkComplaintExample example) {
        return zjkComplaintMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkComplaintMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkComplaintReal(String recordId) {
        return zjkComplaintMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkComplaint record) {
        record.setDataId(IdUtil.createIdByTime());
        return zjkComplaintMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkComplaint record) {
        return zjkComplaintMapper.insertSelective(record);
    }

    public ZjkComplaint insertObject(ZjkComplaint record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkComplaint> selectByExample(ZjkComplaintExample example) {
        return zjkComplaintMapper.selectByExample(example);
    }

    @Override
    public ZjkComplaint selectByPrimaryKey(String recordId) {
        return zjkComplaintMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkComplaint record, @Param("example") ZjkComplaintExample example) {
        return zjkComplaintMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkComplaint record, @Param("example") ZjkComplaintExample example) {
        return zjkComplaintMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkComplaint record) {
        return zjkComplaintMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkComplaint record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkComplaintMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkComplaint(Serializable zjkComplaintId) {
        try {
            ZjkComplaint record = zjkComplaintMapper.selectByPrimaryKey(zjkComplaintId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkComplaintMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkComplaintByPage(LayuiTableParam param) {
        ZjkComplaintExample example = new ZjkComplaintExample();
        ZjkComplaintExample.Criteria c = example.createCriteria();
        Object zjkName = param.getParam().get("zjkName");
        if (!StrUtil.isObjectEmpty(zjkName)) {
            c.andZjkNameLike("%" + zjkName + "%");

        }
        Object xmName = param.getParam().get("xmName");
        if (!StrUtil.isObjectEmpty(xmName)) {
            c.andXmNameLike("%" + xmName + "%");

        }
        Object xmSteps = param.getParam().get("xmSteps");
        if (!StrUtil.isObjectEmpty(xmSteps)) {
            c.andXmStepsLike("%" + xmSteps + "%");

        }
        Object complaintType = param.getParam().get("complaintType");
        if (!StrUtil.isObjectEmpty(complaintType)) {
            c.andComplaintTypeLike("%" + complaintType + "%");

        }
        Object complaintUserName = param.getParam().get("complaintUserName");
        if (!StrUtil.isObjectEmpty(complaintUserName)) {
            c.andComplaintUserNameLike("%" + complaintUserName + "%");

        }
        Object isComplet = param.getParam().get("isComplet");
        if (!StrUtil.isObjectEmpty(isComplet)) {
            c.andIsCompletLike("%" + isComplet + "%");

        }
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkComplaintExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkComplaintExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkComplaint> list = zjkComplaintMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkComplaint> pageInfo = new PageInfo<ZjkComplaint>(list);
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
        ZjkComplaintExample example = new ZjkComplaintExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkComplaint> records = zjkComplaintMapper.selectByExample(example);
        for (ZjkComplaint record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkComplaintExample zjkComplaintExample = new ZjkComplaintExample();
        String strParentId = zjkComplaintMapper.selectByExample(zjkComplaintExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}