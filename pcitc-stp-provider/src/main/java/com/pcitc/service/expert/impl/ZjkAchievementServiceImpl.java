package com.pcitc.service.expert.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.expert.ZjkAchievement;
import com.pcitc.base.expert.ZjkAchievementExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkAchievementMapper;
import com.pcitc.service.expert.ZjkAchievementService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>接口实现类</p>
 * <p>Table: zjk_achievement - 专家-成果信息</p>
 *
 * @since 2019-06-21 09:57:54
 */
@Service("zjkAchievementService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkAchievementServiceImpl implements ZjkAchievementService {

    @Autowired
    private ZjkAchievementMapper zjkAchievementMapper;

    public List<ZjkAchievement> findZjkAchievementList(ZjkAchievement zjkAchievement) {
        List<ZjkAchievement> record = zjkAchievementMapper.findZjkAchievementList(zjkAchievement);
        return record;
    }

    @Override
    public int updateOrInsertZjkAchievement(ZjkAchievement zjkAchievement) throws Exception {
        int result = 500;
        if (zjkAchievement.getDataId() != null && zjkAchievement.getDataId() != null) {
            zjkAchievementMapper.updateByPrimaryKeySelective(zjkAchievement);
        } else {
            zjkAchievement.setDataId(IdUtil.createIdByTime());
            zjkAchievementMapper.insertSelective(zjkAchievement);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkAchievementById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkAchievementMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkAchievement getZjkAchievementInfo(String id) throws Exception {

        return zjkAchievementMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkAchievementExample example) {
        return zjkAchievementMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkAchievementExample example) {
        return zjkAchievementMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkAchievementMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkAchievementReal(String recordId) {
        return zjkAchievementMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkAchievement record) {
        record.setDataId(IdUtil.createIdByTime());
        return zjkAchievementMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkAchievement record) {
        return zjkAchievementMapper.insertSelective(record);
    }

    public ZjkAchievement insertObject(ZjkAchievement record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkAchievement> selectByExample(ZjkAchievementExample example) {
        return zjkAchievementMapper.selectByExample(example);
    }

    @Override
    public ZjkAchievement selectByPrimaryKey(String recordId) {
        return zjkAchievementMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkAchievement record, @Param("example") ZjkAchievementExample example) {
        return zjkAchievementMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkAchievement record, @Param("example") ZjkAchievementExample example) {
        return zjkAchievementMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkAchievement record) {
        return zjkAchievementMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkAchievement record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkAchievementMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkAchievement(Serializable zjkAchievementId) {
        try {
            ZjkAchievement record = zjkAchievementMapper.selectByPrimaryKey(zjkAchievementId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkAchievementMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkAchievementByPage(LayuiTableParam param) {
        ZjkAchievementExample example = new ZjkAchievementExample();
        ZjkAchievementExample.Criteria c = example.createCriteria();
        Object expertId = param.getParam().get("expertId");
        if (!StrUtil.isObjectEmpty(expertId)) {
            c.andExpertIdEqualTo( expertId.toString());

        }
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
        List<ZjkAchievement> list = zjkAchievementMapper.selectByExample(example);
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
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkAchievement> records = zjkAchievementMapper.selectByExample(example);
        for (ZjkAchievement record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkAchievementExample zjkAchievementExample = new ZjkAchievementExample();
        String strParentId = zjkAchievementMapper.selectByExample(zjkAchievementExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}