package com.pcitc.service.expert.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkExpertProjectExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkExpertProjectMapper;
import com.pcitc.service.expert.ZjkExpertProjectService;
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
 * <p>Table: zjk_expert_project - 专家库-科研项目</p>
 *
 * @since 2019-04-02 04:42:39
 */
@Service("zjkExpertProjectService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkExpertProjectServiceImpl implements ZjkExpertProjectService {

    @Autowired
    private ZjkExpertProjectMapper zjkExpertProjectMapper;

    public List<ZjkExpertProject> findZjkExpertProjectList(ZjkExpertProject zjkExpertProject) {
        List<ZjkExpertProject> record = zjkExpertProjectMapper.findZjkExpertProjectList(zjkExpertProject);
        return record;
    }

    @Override
    public int updateOrInsertZjkExpertProject(ZjkExpertProject zjkExpertProject) throws Exception {
        int result = 500;
        if (zjkExpertProject.getDataId() != null && zjkExpertProject.getDataId() != null) {
            zjkExpertProjectMapper.updateByPrimaryKeySelective(zjkExpertProject);
        } else {
            zjkExpertProject.setDataId(IdUtil.createIdByTime());
            zjkExpertProjectMapper.insertSelective(zjkExpertProject);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkExpertProjectById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkExpertProjectMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkExpertProject getZjkExpertProjectInfo(String id) throws Exception {

        return zjkExpertProjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkExpertProjectExample example) {
        return zjkExpertProjectMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkExpertProjectExample example) {
        return zjkExpertProjectMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkExpertProjectMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkExpertProjectReal(String recordId) {
        return zjkExpertProjectMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkExpertProject record) {
        record.setDataId(IdUtil.createIdByTime());
        return zjkExpertProjectMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkExpertProject record) {
        return zjkExpertProjectMapper.insertSelective(record);
    }

    public ZjkExpertProject insertObject(ZjkExpertProject record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkExpertProject> selectByExample(ZjkExpertProjectExample example) {
        return zjkExpertProjectMapper.selectByExample(example);
    }

    @Override
    public ZjkExpertProject selectByPrimaryKey(String recordId) {
        return zjkExpertProjectMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkExpertProject record, @Param("example") ZjkExpertProjectExample example) {
        return zjkExpertProjectMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkExpertProject record, @Param("example") ZjkExpertProjectExample example) {
        return zjkExpertProjectMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkExpertProject record) {
        return zjkExpertProjectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkExpertProject record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkExpertProjectMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkExpertProject(Serializable zjkExpertProjectId) {
        try {
            ZjkExpertProject record = zjkExpertProjectMapper.selectByPrimaryKey(zjkExpertProjectId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkExpertProjectMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkExpertProjectByPage(LayuiTableParam param) {
        ZjkExpertProjectExample example = new ZjkExpertProjectExample();
        ZjkExpertProjectExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkExpertProjectExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkExpertProjectExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkExpertProject> list = zjkExpertProjectMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkExpertProject> pageInfo = new PageInfo<ZjkExpertProject>(list);
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
        ZjkExpertProjectExample example = new ZjkExpertProjectExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkExpertProject> records = zjkExpertProjectMapper.selectByExample(example);
        for (ZjkExpertProject record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkExpertProjectExample zjkExpertProjectExample = new ZjkExpertProjectExample();
        String strParentId = zjkExpertProjectMapper.selectByExample(zjkExpertProjectExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}