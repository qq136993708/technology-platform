package com.pcitc.service.expert.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkAchievementExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkAchievementMapper;
import com.pcitc.service.expert.ZjkChengguoService;
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
 * <p>Table: zjk_chengguo - 专家-成果信息</p>
 *
 * @since 2018-12-08 04:10:41
 */
@Service("zjkChengguoService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkChengguoServiceImpl implements ZjkChengguoService {

    @Autowired
    private ZjkAchievementMapper zjkChengguoMapper;

    public List<ZjkAchievement> findZjkChengguoList(ZjkAchievement zjkChengguo) {
        List<ZjkAchievement> record = zjkChengguoMapper.findZjkAchievementList(zjkChengguo);
        return record;
    }

    @Override
    public int updateOrInsertZjkChengguo(ZjkAchievement zjkChengguo) throws Exception {
        int result = 500;
        if (zjkChengguo.getId() != null && zjkChengguo.getId() != null) {
            zjkChengguoMapper.updateByPrimaryKeySelective(zjkChengguo);
        } else {
            zjkChengguo.setId(IdUtil.createIdByTime());
            zjkChengguoMapper.insertSelective(zjkChengguo);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkChengguoById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkChengguoMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkAchievement getZjkChengguoInfo(String id) throws Exception {

        return zjkChengguoMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkAchievementExample example) {
        return zjkChengguoMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkAchievementExample example) {
        return zjkChengguoMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkChengguoMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkChengguoReal(String recordId) {
        return zjkChengguoMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkAchievement record) {
        record.setId(IdUtil.createIdByTime());
        return zjkChengguoMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkAchievement record) {
        return zjkChengguoMapper.insertSelective(record);
    }

    public ZjkAchievement insertObject(ZjkAchievement record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkAchievement> selectByExample(ZjkAchievementExample example) {
        return zjkChengguoMapper.selectByExample(example);
    }

    @Override
    public ZjkAchievement selectByPrimaryKey(String recordId) {
        return zjkChengguoMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkAchievement record, @Param("example") ZjkAchievementExample example) {
        return zjkChengguoMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkAchievement record, @Param("example") ZjkAchievementExample example) {
        return zjkChengguoMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkAchievement record) {
        return zjkChengguoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkAchievement record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkChengguoMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkChengguo(Serializable zjkChengguoId) {
        try {
            ZjkAchievement record = zjkChengguoMapper.selectByPrimaryKey(zjkChengguoId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkChengguoMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkChengguoByPage(LayuiTableParam param) {
        ZjkAchievementExample example = new ZjkAchievementExample();
        ZjkAchievementExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkAchievementExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkAchievementExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkAchievement> list = zjkChengguoMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkAchievement> pageInfo = new PageInfo<ZjkAchievement>(list);
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
        ZjkAchievementExample example = new ZjkAchievementExample();
        List<ZjkAchievement> records = zjkChengguoMapper.selectByExample(example);
        for (ZjkAchievement record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkAchievementExample zjkChengguoExample = new ZjkAchievementExample();
        String strParentId = zjkChengguoMapper.selectByExample(zjkChengguoExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}