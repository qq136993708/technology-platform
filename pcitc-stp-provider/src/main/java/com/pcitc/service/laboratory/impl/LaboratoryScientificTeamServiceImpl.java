package com.pcitc.service.laboratory.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.*;
import com.pcitc.base.laboratory.LaboratoryScientificTeamExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.laboratory.LaboratoryScientificTeamMapper;
import com.pcitc.service.laboratory.LaboratoryScientificTeamService;
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
 * <p>Table: laboratory_scientific_team - 实验室-科研团队</p>
 *
 * @since 2019-07-01 09:14:00
 */
@Service("laboratoryScientificTeamService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class LaboratoryScientificTeamServiceImpl implements LaboratoryScientificTeamService {

    @Autowired
    private LaboratoryScientificTeamMapper laboratoryScientificTeamMapper;

    public List<LaboratoryScientificTeam> findLaboratoryScientificTeamList(LaboratoryScientificTeam laboratoryScientificTeam) {
        List<LaboratoryScientificTeam> record = laboratoryScientificTeamMapper.findLaboratoryScientificTeamList(laboratoryScientificTeam);
        return record;
    }

    @Override
    public int updateOrInsertLaboratoryScientificTeam(LaboratoryScientificTeam laboratoryScientificTeam) throws Exception {
        int result = 500;
        if (laboratoryScientificTeam.getDataId() != null && laboratoryScientificTeam.getDataId() != null) {
            laboratoryScientificTeamMapper.updateByPrimaryKeySelective(laboratoryScientificTeam);
        } else {
            laboratoryScientificTeam.setDataId(IdUtil.createIdByTime());
            laboratoryScientificTeamMapper.insertSelective(laboratoryScientificTeam);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteLaboratoryScientificTeamById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            laboratoryScientificTeamMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public LaboratoryScientificTeam getLaboratoryScientificTeamInfo(String id) throws Exception {

        return laboratoryScientificTeamMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(LaboratoryScientificTeamExample example) {
        return laboratoryScientificTeamMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(LaboratoryScientificTeamExample example) {
        return laboratoryScientificTeamMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return laboratoryScientificTeamMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteLaboratoryScientificTeamReal(String recordId) {
        return laboratoryScientificTeamMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(LaboratoryScientificTeam record) {
        record.setDataId(IdUtil.createIdByTime());
        return laboratoryScientificTeamMapper.insert(record);
    }

    @Override
    public int insertSelective(LaboratoryScientificTeam record) {
        return laboratoryScientificTeamMapper.insertSelective(record);
    }

    public LaboratoryScientificTeam insertObject(LaboratoryScientificTeam record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<LaboratoryScientificTeam> selectByExample(LaboratoryScientificTeamExample example) {
        return laboratoryScientificTeamMapper.selectByExample(example);
    }

    @Override
    public LaboratoryScientificTeam selectByPrimaryKey(String recordId) {
        return laboratoryScientificTeamMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") LaboratoryScientificTeam record, @Param("example") LaboratoryScientificTeamExample example) {
        return laboratoryScientificTeamMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") LaboratoryScientificTeam record, @Param("example") LaboratoryScientificTeamExample example) {
        return laboratoryScientificTeamMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(LaboratoryScientificTeam record) {
        return laboratoryScientificTeamMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LaboratoryScientificTeam record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return laboratoryScientificTeamMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteLaboratoryScientificTeam(Serializable laboratoryScientificTeamId) {
        try {
            LaboratoryScientificTeam record = laboratoryScientificTeamMapper.selectByPrimaryKey(laboratoryScientificTeamId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                laboratoryScientificTeamMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findLaboratoryScientificTeamByPage(LayuiTableParam param) {
        LaboratoryScientificTeamExample example = new LaboratoryScientificTeamExample();
        LaboratoryScientificTeamExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            LaboratoryScientificTeamExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, LaboratoryScientificTeamExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<LaboratoryScientificTeam> list = laboratoryScientificTeamMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<LaboratoryScientificTeam> pageInfo = new PageInfo<LaboratoryScientificTeam>(list);
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
        LaboratoryScientificTeamExample example = new LaboratoryScientificTeamExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<LaboratoryScientificTeam> records = laboratoryScientificTeamMapper.selectByExample(example);
        for (LaboratoryScientificTeam record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        LaboratoryScientificTeamExample laboratoryScientificTeamExample = new LaboratoryScientificTeamExample();
        String strParentId = laboratoryScientificTeamMapper.selectByExample(laboratoryScientificTeamExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}