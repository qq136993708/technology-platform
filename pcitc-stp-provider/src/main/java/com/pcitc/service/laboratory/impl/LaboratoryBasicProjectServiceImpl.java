package com.pcitc.service.laboratory.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.laboratory.LaboratoryBasicProject;
import com.pcitc.base.laboratory.LaboratoryBasicProjectExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.laboratory.LaboratoryBasicProjectMapper;
import com.pcitc.service.laboratory.LaboratoryBasicProjectService;

/**
 * <p>接口实现类</p>
 * <p>Table: laboratory_basic_project - 实验室-基础性前瞻性研究项目</p>
 *
 * @since 2019-07-01 09:12:14
 */
@Service("laboratoryBasicProjectService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class LaboratoryBasicProjectServiceImpl implements LaboratoryBasicProjectService {

    @Autowired
    private LaboratoryBasicProjectMapper laboratoryBasicProjectMapper;

    public List<LaboratoryBasicProject> findLaboratoryBasicProjectList(LaboratoryBasicProject laboratoryBasicProject) {
        List<LaboratoryBasicProject> record = laboratoryBasicProjectMapper.findLaboratoryBasicProjectList(laboratoryBasicProject);
        return record;
    }

    @Override
    public int updateOrInsertLaboratoryBasicProject(LaboratoryBasicProject laboratoryBasicProject) throws Exception {
        int result = 500;
        if (laboratoryBasicProject.getDataId() != null && laboratoryBasicProject.getDataId() != null) {
            laboratoryBasicProjectMapper.updateByPrimaryKeySelective(laboratoryBasicProject);
        } else {
            laboratoryBasicProject.setDataId(IdUtil.createIdByTime());
            laboratoryBasicProjectMapper.insertSelective(laboratoryBasicProject);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteLaboratoryBasicProjectById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            laboratoryBasicProjectMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public LaboratoryBasicProject getLaboratoryBasicProjectInfo(String id) throws Exception {

        return laboratoryBasicProjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(LaboratoryBasicProjectExample example) {
        return laboratoryBasicProjectMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(LaboratoryBasicProjectExample example) {
        return laboratoryBasicProjectMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return laboratoryBasicProjectMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteLaboratoryBasicProjectReal(String recordId) {
        return laboratoryBasicProjectMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(LaboratoryBasicProject record) {
        record.setDataId(IdUtil.createIdByTime());
        return laboratoryBasicProjectMapper.insert(record);
    }

    @Override
    public int insertSelective(LaboratoryBasicProject record) {
        return laboratoryBasicProjectMapper.insertSelective(record);
    }

    public LaboratoryBasicProject insertObject(LaboratoryBasicProject record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<LaboratoryBasicProject> selectByExample(LaboratoryBasicProjectExample example) {
        return laboratoryBasicProjectMapper.selectByExample(example);
    }

    @Override
    public LaboratoryBasicProject selectByPrimaryKey(String recordId) {
        return laboratoryBasicProjectMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") LaboratoryBasicProject record, @Param("example") LaboratoryBasicProjectExample example) {
        return laboratoryBasicProjectMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") LaboratoryBasicProject record, @Param("example") LaboratoryBasicProjectExample example) {
        return laboratoryBasicProjectMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(LaboratoryBasicProject record) {
        return laboratoryBasicProjectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LaboratoryBasicProject record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return laboratoryBasicProjectMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteLaboratoryBasicProject(Serializable laboratoryBasicProjectId) {
        try {
            LaboratoryBasicProject record = laboratoryBasicProjectMapper.selectByPrimaryKey(laboratoryBasicProjectId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                laboratoryBasicProjectMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findLaboratoryBasicProjectByPage(LayuiTableParam param) {
        LaboratoryBasicProjectExample example = new LaboratoryBasicProjectExample();
        LaboratoryBasicProjectExample.Criteria c = example.createCriteria();
        if(param.getParam().get("baseId") != null)
        {
        	c.andBaseIdEqualTo(param.getParam().get("baseId").toString());
        }
        System.out.println("------------------------"+param.getParam().get("baseId"));
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
    private LayuiTableData findByExample(LayuiTableParam param, LaboratoryBasicProjectExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<LaboratoryBasicProject> list = laboratoryBasicProjectMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<LaboratoryBasicProject> pageInfo = new PageInfo<LaboratoryBasicProject>(list);
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
        LaboratoryBasicProjectExample example = new LaboratoryBasicProjectExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<LaboratoryBasicProject> records = laboratoryBasicProjectMapper.selectByExample(example);
        for (LaboratoryBasicProject record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        LaboratoryBasicProjectExample laboratoryBasicProjectExample = new LaboratoryBasicProjectExample();
        String strParentId = laboratoryBasicProjectMapper.selectByExample(laboratoryBasicProjectExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}