package com.pcitc.service.expert.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkProjectExpertExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkProjectExpertMapper;
import com.pcitc.service.expert.ZjkProjectExpertService;
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
 * <p>Table: zjk_project_expert - </p>
 *
 * @since 2019-04-02 04:12:03
 */
@Service("zjkProjectExpertService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkProjectExpertServiceImpl implements ZjkProjectExpertService {

    @Autowired
    private ZjkProjectExpertMapper zjkProjectExpertMapper;

    public List<ZjkProjectExpert> findZjkProjectExpertList(ZjkProjectExpert zjkProjectExpert) {
        List<ZjkProjectExpert> record = zjkProjectExpertMapper.findZjkProjectExpertList(zjkProjectExpert);
        return record;
    }

    @Override
    public int updateOrInsertZjkProjectExpert(ZjkProjectExpert zjkProjectExpert) throws Exception {
        int result = 500;
        if (zjkProjectExpert.getDataId() != null && zjkProjectExpert.getDataId() != null) {
            zjkProjectExpertMapper.updateByPrimaryKeySelective(zjkProjectExpert);
        } else {
            zjkProjectExpert.setDataId(IdUtil.createIdByTime());
            zjkProjectExpertMapper.insertSelective(zjkProjectExpert);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkProjectExpertById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkProjectExpertMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkProjectExpert getZjkProjectExpertInfo(String id) throws Exception {

        return zjkProjectExpertMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkProjectExpertExample example) {
        return zjkProjectExpertMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkProjectExpertExample example) {
        return zjkProjectExpertMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkProjectExpertMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkProjectExpertReal(String recordId) {
        return zjkProjectExpertMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkProjectExpert record) {
        record.setDataId(IdUtil.createIdByTime());
        return zjkProjectExpertMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkProjectExpert record) {
        return zjkProjectExpertMapper.insertSelective(record);
    }

    public ZjkProjectExpert insertObject(ZjkProjectExpert record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkProjectExpert> selectByExample(ZjkProjectExpertExample example) {
        return zjkProjectExpertMapper.selectByExample(example);
    }

    @Override
    public ZjkProjectExpert selectByPrimaryKey(String recordId) {
        return zjkProjectExpertMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkProjectExpert record, @Param("example") ZjkProjectExpertExample example) {
        return zjkProjectExpertMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkProjectExpert record, @Param("example") ZjkProjectExpertExample example) {
        return zjkProjectExpertMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkProjectExpert record) {
        return zjkProjectExpertMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkProjectExpert record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkProjectExpertMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkProjectExpert(Serializable zjkProjectExpertId) {
        try {
            ZjkProjectExpert record = zjkProjectExpertMapper.selectByPrimaryKey(zjkProjectExpertId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkProjectExpertMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkProjectExpertByPage(LayuiTableParam param) {
        ZjkProjectExpertExample example = new ZjkProjectExpertExample();
        ZjkProjectExpertExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkProjectExpertExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkProjectExpertExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkProjectExpert> list = zjkProjectExpertMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkProjectExpert> pageInfo = new PageInfo<ZjkProjectExpert>(list);
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
        ZjkProjectExpertExample example = new ZjkProjectExpertExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkProjectExpert> records = zjkProjectExpertMapper.selectByExample(example);
        for (ZjkProjectExpert record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkProjectExpertExample zjkProjectExpertExample = new ZjkProjectExpertExample();
        String strParentId = zjkProjectExpertMapper.selectByExample(zjkProjectExpertExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}