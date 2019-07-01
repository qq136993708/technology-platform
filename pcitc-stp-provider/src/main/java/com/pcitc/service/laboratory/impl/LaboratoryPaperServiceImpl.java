package com.pcitc.service.laboratory.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.*;
import com.pcitc.base.laboratory.LaboratoryPaperExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.laboratory.LaboratoryPaperMapper;
import com.pcitc.service.laboratory.LaboratoryPaperService;
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
 * <p>Table: laboratory_paper - 实验室-知识产权-论文</p>
 *
 * @since 2019-07-01 09:12:52
 */
@Service("laboratoryPaperService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class LaboratoryPaperServiceImpl implements LaboratoryPaperService {

    @Autowired
    private LaboratoryPaperMapper laboratoryPaperMapper;

    public List<LaboratoryPaper> findLaboratoryPaperList(LaboratoryPaper laboratoryPaper) {
        List<LaboratoryPaper> record = laboratoryPaperMapper.findLaboratoryPaperList(laboratoryPaper);
        return record;
    }

    @Override
    public int updateOrInsertLaboratoryPaper(LaboratoryPaper laboratoryPaper) throws Exception {
        int result = 500;
        if (laboratoryPaper.getDataId() != null && laboratoryPaper.getDataId() != null) {
            laboratoryPaperMapper.updateByPrimaryKeySelective(laboratoryPaper);
        } else {
            laboratoryPaper.setDataId(IdUtil.createIdByTime());
            laboratoryPaperMapper.insertSelective(laboratoryPaper);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteLaboratoryPaperById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            laboratoryPaperMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public LaboratoryPaper getLaboratoryPaperInfo(String id) throws Exception {

        return laboratoryPaperMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(LaboratoryPaperExample example) {
        return laboratoryPaperMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(LaboratoryPaperExample example) {
        return laboratoryPaperMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return laboratoryPaperMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteLaboratoryPaperReal(String recordId) {
        return laboratoryPaperMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(LaboratoryPaper record) {
        record.setDataId(IdUtil.createIdByTime());
        return laboratoryPaperMapper.insert(record);
    }

    @Override
    public int insertSelective(LaboratoryPaper record) {
        return laboratoryPaperMapper.insertSelective(record);
    }

    public LaboratoryPaper insertObject(LaboratoryPaper record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<LaboratoryPaper> selectByExample(LaboratoryPaperExample example) {
        return laboratoryPaperMapper.selectByExample(example);
    }

    @Override
    public LaboratoryPaper selectByPrimaryKey(String recordId) {
        return laboratoryPaperMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") LaboratoryPaper record, @Param("example") LaboratoryPaperExample example) {
        return laboratoryPaperMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") LaboratoryPaper record, @Param("example") LaboratoryPaperExample example) {
        return laboratoryPaperMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(LaboratoryPaper record) {
        return laboratoryPaperMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LaboratoryPaper record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return laboratoryPaperMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteLaboratoryPaper(Serializable laboratoryPaperId) {
        try {
            LaboratoryPaper record = laboratoryPaperMapper.selectByPrimaryKey(laboratoryPaperId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                laboratoryPaperMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findLaboratoryPaperByPage(LayuiTableParam param) {
        LaboratoryPaperExample example = new LaboratoryPaperExample();
        LaboratoryPaperExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            LaboratoryPaperExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, LaboratoryPaperExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<LaboratoryPaper> list = laboratoryPaperMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<LaboratoryPaper> pageInfo = new PageInfo<LaboratoryPaper>(list);
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
        LaboratoryPaperExample example = new LaboratoryPaperExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<LaboratoryPaper> records = laboratoryPaperMapper.selectByExample(example);
        for (LaboratoryPaper record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        LaboratoryPaperExample laboratoryPaperExample = new LaboratoryPaperExample();
        String strParentId = laboratoryPaperMapper.selectByExample(laboratoryPaperExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}