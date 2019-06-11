package com.pcitc.service.expert.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkSkmTypeExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkSkmTypeMapper;
import com.pcitc.service.expert.ZjkSkmTypeService;
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
 * <p>Table: zjk_skm_type - </p>
 *
 * @since 2019-01-23 02:39:13
 */
@Service("zjkSkmTypeService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkSkmTypeServiceImpl implements ZjkSkmTypeService {

    @Autowired
    private ZjkSkmTypeMapper zjkSkmTypeMapper;

    public List<ZjkSkmType> findZjkSkmTypeList(ZjkSkmType zjkSkmType) {
        List<ZjkSkmType> record = zjkSkmTypeMapper.findZjkSkmTypeList(zjkSkmType);
        return record;
    }

    @Override
    public int updateOrInsertZjkSkmType(ZjkSkmType zjkSkmType) throws Exception {
        int result = 500;
        if (zjkSkmType.getDataId() != null && zjkSkmType.getDataId() != null) {
            zjkSkmTypeMapper.updateByPrimaryKeySelective(zjkSkmType);
        } else {
            zjkSkmType.setDataId(IdUtil.createIdByTime());
            zjkSkmTypeMapper.insertSelective(zjkSkmType);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkSkmTypeById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkSkmTypeMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkSkmType getZjkSkmTypeInfo(String id) throws Exception {

        return zjkSkmTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkSkmTypeExample example) {
        return zjkSkmTypeMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkSkmTypeExample example) {
        return zjkSkmTypeMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkSkmTypeMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkSkmTypeReal(String recordId) {
        return zjkSkmTypeMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkSkmType record) {
        record.setDataId(IdUtil.createIdByTime());
        return zjkSkmTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkSkmType record) {
        return zjkSkmTypeMapper.insertSelective(record);
    }

    public ZjkSkmType insertObject(ZjkSkmType record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkSkmType> selectByExample(ZjkSkmTypeExample example) {
        return zjkSkmTypeMapper.selectByExample(example);
    }

    @Override
    public ZjkSkmType selectByPrimaryKey(String recordId) {
        return zjkSkmTypeMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkSkmType record, @Param("example") ZjkSkmTypeExample example) {
        return zjkSkmTypeMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkSkmType record, @Param("example") ZjkSkmTypeExample example) {
        return zjkSkmTypeMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkSkmType record) {
        return zjkSkmTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkSkmType record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkSkmTypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkSkmType(Serializable zjkSkmTypeId) {
        try {
            ZjkSkmType record = zjkSkmTypeMapper.selectByPrimaryKey(zjkSkmTypeId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkSkmTypeMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkSkmTypeByPage(LayuiTableParam param) {
        ZjkSkmTypeExample example = new ZjkSkmTypeExample();
        ZjkSkmTypeExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkSkmTypeExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkSkmTypeExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkSkmType> list = zjkSkmTypeMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkSkmType> pageInfo = new PageInfo<ZjkSkmType>(list);
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
        ZjkSkmTypeExample example = new ZjkSkmTypeExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkSkmType> records = zjkSkmTypeMapper.selectByExample(example);
        for (ZjkSkmType record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkSkmTypeExample zjkSkmTypeExample = new ZjkSkmTypeExample();
        String strParentId = zjkSkmTypeMapper.selectByExample(zjkSkmTypeExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}