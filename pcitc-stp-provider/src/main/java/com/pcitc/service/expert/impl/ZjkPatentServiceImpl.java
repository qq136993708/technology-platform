package com.pcitc.service.expert.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.expert.ZjkPatentExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkPatentMapper;
import com.pcitc.service.expert.ZjkPatentService;
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
 * <p>Table: zjk_patent - 专家-专利信息</p>
 *
 * @since 2019-06-21 09:32:24
 */
@Service("zjkPatentService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkPatentServiceImpl implements ZjkPatentService {

    @Autowired
    private ZjkPatentMapper zjkPatentMapper;

    public List<ZjkPatent> findZjkPatentList(ZjkPatent zjkPatent) {
        List<ZjkPatent> record = zjkPatentMapper.findZjkPatentList(zjkPatent);
        return record;
    }

    @Override
    public int updateOrInsertZjkPatent(ZjkPatent zjkPatent) throws Exception {
        int result = 500;
        if (zjkPatent.getDataId() != null && zjkPatent.getDataId() != null) {
            zjkPatentMapper.updateByPrimaryKeySelective(zjkPatent);
        } else {
            zjkPatent.setDataId(IdUtil.createIdByTime());
            zjkPatentMapper.insertSelective(zjkPatent);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkPatentById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkPatentMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkPatent getZjkPatentInfo(String id) throws Exception {

        return zjkPatentMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkPatentExample example) {
        return zjkPatentMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkPatentExample example) {
        return zjkPatentMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkPatentMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkPatentReal(String recordId) {
        return zjkPatentMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkPatent record) {
        record.setDataId(IdUtil.createIdByTime());
        return zjkPatentMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkPatent record) {
        return zjkPatentMapper.insertSelective(record);
    }

    public ZjkPatent insertObject(ZjkPatent record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkPatent> selectByExample(ZjkPatentExample example) {
        return zjkPatentMapper.selectByExample(example);
    }

    @Override
    public ZjkPatent selectByPrimaryKey(String recordId) {
        return zjkPatentMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkPatent record, @Param("example") ZjkPatentExample example) {
        return zjkPatentMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkPatent record, @Param("example") ZjkPatentExample example) {
        return zjkPatentMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkPatent record) {
        return zjkPatentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkPatent record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkPatentMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkPatent(Serializable zjkPatentId) {
        try {
            ZjkPatent record = zjkPatentMapper.selectByPrimaryKey(zjkPatentId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkPatentMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkPatentByPage(LayuiTableParam param) {
        ZjkPatentExample example = new ZjkPatentExample();
        ZjkPatentExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
        if (param.getParam().get("expertId") != null&&!"".equals(param.getParam().get("expertId"))) {
            c.andExpertIdEqualTo(param.getParam().get("expertId").toString());
        }
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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkPatentExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkPatent> list = zjkPatentMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkPatent> pageInfo = new PageInfo<ZjkPatent>(list);
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
        ZjkPatentExample example = new ZjkPatentExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkPatent> records = zjkPatentMapper.selectByExample(example);
        for (ZjkPatent record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkPatentExample zjkPatentExample = new ZjkPatentExample();
        String strParentId = zjkPatentMapper.selectByExample(zjkPatentExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}