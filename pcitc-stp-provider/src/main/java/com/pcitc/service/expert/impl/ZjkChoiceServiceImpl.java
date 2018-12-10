package com.pcitc.service.expert.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkChoiceExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkChoiceMapper;
import com.pcitc.service.expert.ZjkChoiceService;
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
 * <p>Table: zjk_choice - 专家-人员选择</p>
 *
 * @since 2018-12-08 04:10:47
 */
@Service("zjkChoiceService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkChoiceServiceImpl implements ZjkChoiceService {

    @Autowired
    private ZjkChoiceMapper zjkChoiceMapper;

    public List<ZjkChoice> findZjkChoiceList(ZjkChoice zjkChoice) {
        List<ZjkChoice> record = zjkChoiceMapper.findZjkChoiceList(zjkChoice);
        return record;
    }

    @Override
    public int updateOrInsertZjkChoice(ZjkChoice zjkChoice) throws Exception {
        int result = 500;
        if (zjkChoice.getId() != null && zjkChoice.getId() != null) {
            zjkChoiceMapper.updateByPrimaryKeySelective(zjkChoice);
        } else {
            zjkChoice.setId(IdUtil.createIdByTime());
            zjkChoiceMapper.insertSelective(zjkChoice);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkChoiceById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkChoiceMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkChoice getZjkChoiceInfo(String id) throws Exception {

        return zjkChoiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkChoiceExample example) {
        return zjkChoiceMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkChoiceExample example) {
        return zjkChoiceMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkChoiceMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkChoiceReal(String recordId) {
        return zjkChoiceMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkChoice record) {
        record.setId(IdUtil.createIdByTime());
        return zjkChoiceMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkChoice record) {
        return zjkChoiceMapper.insertSelective(record);
    }

    public ZjkChoice insertObject(ZjkChoice record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkChoice> selectByExample(ZjkChoiceExample example) {
        return zjkChoiceMapper.selectByExample(example);
    }

    @Override
    public ZjkChoice selectByPrimaryKey(String recordId) {
        return zjkChoiceMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkChoice record, @Param("example") ZjkChoiceExample example) {
        return zjkChoiceMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkChoice record, @Param("example") ZjkChoiceExample example) {
        return zjkChoiceMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkChoice record) {
        return zjkChoiceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkChoice record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkChoiceMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkChoice(Serializable zjkChoiceId) {
        try {
            ZjkChoice record = zjkChoiceMapper.selectByPrimaryKey(zjkChoiceId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkChoiceMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkChoiceByPage(LayuiTableParam param) {
        ZjkChoiceExample example = new ZjkChoiceExample();
        ZjkChoiceExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkChoiceExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkChoiceExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkChoice> list = zjkChoiceMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkChoice> pageInfo = new PageInfo<ZjkChoice>(list);
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
        ZjkChoiceExample example = new ZjkChoiceExample();
        example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkChoice> records = zjkChoiceMapper.selectByExample(example);
        for (ZjkChoice record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkChoiceExample zjkChoiceExample = new ZjkChoiceExample();
        String strParentId = zjkChoiceMapper.selectByExample(zjkChoiceExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}