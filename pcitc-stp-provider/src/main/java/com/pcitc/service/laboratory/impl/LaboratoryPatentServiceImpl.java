package com.pcitc.service.laboratory.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.*;
import com.pcitc.base.laboratory.LaboratoryPatentExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.laboratory.LaboratoryPatentMapper;
import com.pcitc.service.laboratory.LaboratoryPatentService;
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
 * <p>Table: laboratory_patent - 实验室-知识产权-专利</p>
 *
 * @since 2019-07-01 09:13:14
 */
@Service("laboratoryPatentService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class LaboratoryPatentServiceImpl implements LaboratoryPatentService {

    @Autowired
    private LaboratoryPatentMapper laboratoryPatentMapper;

    public List<LaboratoryPatent> findLaboratoryPatentList(LaboratoryPatent laboratoryPatent) {
        List<LaboratoryPatent> record = laboratoryPatentMapper.findLaboratoryPatentList(laboratoryPatent);
        return record;
    }

    @Override
    public int updateOrInsertLaboratoryPatent(LaboratoryPatent laboratoryPatent) throws Exception {
        int result = 500;
        if (laboratoryPatent.getDataId() != null && laboratoryPatent.getDataId() != null) {
            laboratoryPatentMapper.updateByPrimaryKeySelective(laboratoryPatent);
        } else {
            laboratoryPatent.setDataId(IdUtil.createIdByTime());
            laboratoryPatentMapper.insertSelective(laboratoryPatent);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteLaboratoryPatentById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            laboratoryPatentMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public LaboratoryPatent getLaboratoryPatentInfo(String id) throws Exception {

        return laboratoryPatentMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(LaboratoryPatentExample example) {
        return laboratoryPatentMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(LaboratoryPatentExample example) {
        return laboratoryPatentMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return laboratoryPatentMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteLaboratoryPatentReal(String recordId) {
        return laboratoryPatentMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(LaboratoryPatent record) {
        record.setDataId(IdUtil.createIdByTime());
        return laboratoryPatentMapper.insert(record);
    }

    @Override
    public int insertSelective(LaboratoryPatent record) {
        return laboratoryPatentMapper.insertSelective(record);
    }

    public LaboratoryPatent insertObject(LaboratoryPatent record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<LaboratoryPatent> selectByExample(LaboratoryPatentExample example) {
        return laboratoryPatentMapper.selectByExample(example);
    }

    @Override
    public LaboratoryPatent selectByPrimaryKey(String recordId) {
        return laboratoryPatentMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") LaboratoryPatent record, @Param("example") LaboratoryPatentExample example) {
        return laboratoryPatentMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") LaboratoryPatent record, @Param("example") LaboratoryPatentExample example) {
        return laboratoryPatentMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(LaboratoryPatent record) {
        return laboratoryPatentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LaboratoryPatent record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return laboratoryPatentMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteLaboratoryPatent(Serializable laboratoryPatentId) {
        try {
            LaboratoryPatent record = laboratoryPatentMapper.selectByPrimaryKey(laboratoryPatentId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                laboratoryPatentMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findLaboratoryPatentByPage(LayuiTableParam param) {
        LaboratoryPatentExample example = new LaboratoryPatentExample();
        LaboratoryPatentExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            LaboratoryPatentExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, LaboratoryPatentExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<LaboratoryPatent> list = laboratoryPatentMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<LaboratoryPatent> pageInfo = new PageInfo<LaboratoryPatent>(list);
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
        LaboratoryPatentExample example = new LaboratoryPatentExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<LaboratoryPatent> records = laboratoryPatentMapper.selectByExample(example);
        for (LaboratoryPatent record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        LaboratoryPatentExample laboratoryPatentExample = new LaboratoryPatentExample();
        String strParentId = laboratoryPatentMapper.selectByExample(laboratoryPatentExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}