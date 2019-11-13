package com.pcitc.service.laboratory.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.*;
import com.pcitc.base.laboratory.LaboratoryStandardExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.laboratory.LaboratoryStandardMapper;
import com.pcitc.service.laboratory.LaboratoryStandardService;
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
 * <p>Table: laboratory_standard - 实验室-标准情况</p>
 *
 * @since 2019-07-01 09:14:31
 */
@Service("laboratoryStandardService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class LaboratoryStandardServiceImpl implements LaboratoryStandardService {

    @Autowired
    private LaboratoryStandardMapper laboratoryStandardMapper;

    public List<LaboratoryStandard> findLaboratoryStandardList(LaboratoryStandard laboratoryStandard) {
        List<LaboratoryStandard> record = laboratoryStandardMapper.findLaboratoryStandardList(laboratoryStandard);
        return record;
    }

    @Override
    public int updateOrInsertLaboratoryStandard(LaboratoryStandard laboratoryStandard) throws Exception {
        int result = 500;
        if (laboratoryStandard.getDataId() != null && laboratoryStandard.getDataId() != null) {
            laboratoryStandardMapper.updateByPrimaryKeySelective(laboratoryStandard);
        } else {
            laboratoryStandard.setDataId(IdUtil.createIdByTime());
            laboratoryStandardMapper.insertSelective(laboratoryStandard);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteLaboratoryStandardById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            laboratoryStandardMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public LaboratoryStandard getLaboratoryStandardInfo(String id) throws Exception {

        return laboratoryStandardMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(LaboratoryStandardExample example) {
        return laboratoryStandardMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(LaboratoryStandardExample example) {
        return laboratoryStandardMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return laboratoryStandardMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteLaboratoryStandardReal(String recordId) {
        return laboratoryStandardMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(LaboratoryStandard record) {
        record.setDataId(IdUtil.createIdByTime());
        return laboratoryStandardMapper.insert(record);
    }

    @Override
    public int insertSelective(LaboratoryStandard record) {
        return laboratoryStandardMapper.insertSelective(record);
    }

    public LaboratoryStandard insertObject(LaboratoryStandard record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<LaboratoryStandard> selectByExample(LaboratoryStandardExample example) {
        return laboratoryStandardMapper.selectByExample(example);
    }

    @Override
    public LaboratoryStandard selectByPrimaryKey(String recordId) {
        return laboratoryStandardMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") LaboratoryStandard record, @Param("example") LaboratoryStandardExample example) {
        return laboratoryStandardMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") LaboratoryStandard record, @Param("example") LaboratoryStandardExample example) {
        return laboratoryStandardMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(LaboratoryStandard record) {
        return laboratoryStandardMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LaboratoryStandard record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return laboratoryStandardMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteLaboratoryStandard(Serializable laboratoryStandardId) {
        try {
            LaboratoryStandard record = laboratoryStandardMapper.selectByPrimaryKey(laboratoryStandardId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                laboratoryStandardMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findLaboratoryStandardByPage(LayuiTableParam param) {
        LaboratoryStandardExample example = new LaboratoryStandardExample();
        LaboratoryStandardExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            LaboratoryStandardExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, LaboratoryStandardExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<LaboratoryStandard> list = laboratoryStandardMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<LaboratoryStandard> pageInfo = new PageInfo<LaboratoryStandard>(list);
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
        LaboratoryStandardExample example = new LaboratoryStandardExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<LaboratoryStandard> records = laboratoryStandardMapper.selectByExample(example);
        for (LaboratoryStandard record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        LaboratoryStandardExample laboratoryStandardExample = new LaboratoryStandardExample();
        String strParentId = laboratoryStandardMapper.selectByExample(laboratoryStandardExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}