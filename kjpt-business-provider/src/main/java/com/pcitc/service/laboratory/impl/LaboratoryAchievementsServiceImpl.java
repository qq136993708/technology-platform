package com.pcitc.service.laboratory.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.*;
import com.pcitc.base.laboratory.LaboratoryAchievementsExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.laboratory.LaboratoryAchievementsMapper;
import com.pcitc.service.laboratory.LaboratoryAchievementsService;
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
 * <p>Table: laboratory_achievements - 实验室-研究成果</p>
 *
 * @since 2019-07-01 09:11:59
 */
@Service("laboratoryAchievementsService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class LaboratoryAchievementsServiceImpl implements LaboratoryAchievementsService {

    @Autowired
    private LaboratoryAchievementsMapper laboratoryAchievementsMapper;

    public List<LaboratoryAchievements> findLaboratoryAchievementsList(LaboratoryAchievements laboratoryAchievements) {
        List<LaboratoryAchievements> record = laboratoryAchievementsMapper.findLaboratoryAchievementsList(laboratoryAchievements);
        return record;
    }

    @Override
    public int updateOrInsertLaboratoryAchievements(LaboratoryAchievements laboratoryAchievements) throws Exception {
        int result = 500;
        if (laboratoryAchievements.getDataId() != null && laboratoryAchievements.getDataId() != null) {
            laboratoryAchievementsMapper.updateByPrimaryKeySelective(laboratoryAchievements);
        } else {
            laboratoryAchievements.setDataId(IdUtil.createIdByTime());
            laboratoryAchievementsMapper.insertSelective(laboratoryAchievements);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteLaboratoryAchievementsById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            laboratoryAchievementsMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public LaboratoryAchievements getLaboratoryAchievementsInfo(String id) throws Exception {

        return laboratoryAchievementsMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(LaboratoryAchievementsExample example) {
        return laboratoryAchievementsMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(LaboratoryAchievementsExample example) {
        return laboratoryAchievementsMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return laboratoryAchievementsMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteLaboratoryAchievementsReal(String recordId) {
        return laboratoryAchievementsMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(LaboratoryAchievements record) {
        record.setDataId(IdUtil.createIdByTime());
        return laboratoryAchievementsMapper.insert(record);
    }

    @Override
    public int insertSelective(LaboratoryAchievements record) {
        return laboratoryAchievementsMapper.insertSelective(record);
    }

    public LaboratoryAchievements insertObject(LaboratoryAchievements record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<LaboratoryAchievements> selectByExample(LaboratoryAchievementsExample example) {
        return laboratoryAchievementsMapper.selectByExample(example);
    }

    @Override
    public LaboratoryAchievements selectByPrimaryKey(String recordId) {
        return laboratoryAchievementsMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") LaboratoryAchievements record, @Param("example") LaboratoryAchievementsExample example) {
        return laboratoryAchievementsMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") LaboratoryAchievements record, @Param("example") LaboratoryAchievementsExample example) {
        return laboratoryAchievementsMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(LaboratoryAchievements record) {
        return laboratoryAchievementsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LaboratoryAchievements record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return laboratoryAchievementsMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteLaboratoryAchievements(Serializable laboratoryAchievementsId) {
        try {
            LaboratoryAchievements record = laboratoryAchievementsMapper.selectByPrimaryKey(laboratoryAchievementsId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                laboratoryAchievementsMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findLaboratoryAchievementsByPage(LayuiTableParam param) {
        LaboratoryAchievementsExample example = new LaboratoryAchievementsExample();
        LaboratoryAchievementsExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            LaboratoryAchievementsExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, LaboratoryAchievementsExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<LaboratoryAchievements> list = laboratoryAchievementsMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<LaboratoryAchievements> pageInfo = new PageInfo<LaboratoryAchievements>(list);
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
        LaboratoryAchievementsExample example = new LaboratoryAchievementsExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<LaboratoryAchievements> records = laboratoryAchievementsMapper.selectByExample(example);
        for (LaboratoryAchievements record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        LaboratoryAchievementsExample laboratoryAchievementsExample = new LaboratoryAchievementsExample();
        String strParentId = laboratoryAchievementsMapper.selectByExample(laboratoryAchievementsExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}