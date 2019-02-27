package com.pcitc.service.expert.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkMsgExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkMsgMapper;
import com.pcitc.service.expert.ZjkMsgService;
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
 * <p>Table: zjk_msg - 专家-回复管理</p>
 *
 * @since 2019-02-25 03:45:21
 */
@Service("zjkMsgService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkMsgServiceImpl implements ZjkMsgService {

    @Autowired
    private ZjkMsgMapper zjkMsgMapper;

    public List<ZjkMsg> findZjkMsgList(ZjkMsg zjkMsg) {
        List<ZjkMsg> record = zjkMsgMapper.findZjkMsgList(zjkMsg);
        return record;
    }

    @Override
    public int updateOrInsertZjkMsg(ZjkMsg zjkMsg) throws Exception {
        int result = 500;
        if (zjkMsg.getDataId() != null && zjkMsg.getDataId() != null) {
            zjkMsgMapper.updateByPrimaryKeySelective(zjkMsg);
        } else {
            zjkMsg.setDataId(IdUtil.createIdByTime());
            zjkMsgMapper.insertSelective(zjkMsg);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkMsgById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkMsgMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkMsg getZjkMsgInfo(String id) throws Exception {

        return zjkMsgMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkMsgExample example) {
        return zjkMsgMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkMsgExample example) {
        return zjkMsgMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkMsgMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkMsgReal(String recordId) {
        return zjkMsgMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkMsg record) {
        record.setDataId(IdUtil.createIdByTime());
        return zjkMsgMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkMsg record) {
        return zjkMsgMapper.insertSelective(record);
    }

    public ZjkMsg insertObject(ZjkMsg record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkMsg> selectByExample(ZjkMsgExample example) {
        return zjkMsgMapper.selectByExample(example);
    }

    @Override
    public ZjkMsg selectByPrimaryKey(String recordId) {
        return zjkMsgMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkMsg record, @Param("example") ZjkMsgExample example) {
        return zjkMsgMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkMsg record, @Param("example") ZjkMsgExample example) {
        return zjkMsgMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkMsg record) {
        return zjkMsgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkMsg record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkMsgMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkMsg(Serializable zjkMsgId) {
        try {
            ZjkMsg record = zjkMsgMapper.selectByPrimaryKey(zjkMsgId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkMsgMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkMsgByPage(LayuiTableParam param) {
        ZjkMsgExample example = new ZjkMsgExample();
        ZjkMsgExample.Criteria c = example.createCriteria();

        Object xmName = param.getParam().get("xmName");
        if (!StrUtil.isObjectEmpty(xmName)) {
            c.andXmNameLike("%" + xmName + "%");
        }

        Object xmSteps = param.getParam().get("xmSteps");
        if (!StrUtil.isObjectEmpty(xmSteps)) {
//            c.andXmStepsLike("%" + xmSteps + "%");
            c.andXmStepsEqualTo(xmSteps.toString());
        }
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkMsgExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkMsgExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkMsg> list = zjkMsgMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkMsg> pageInfo = new PageInfo<ZjkMsg>(list);
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
        ZjkMsgExample example = new ZjkMsgExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkMsg> records = zjkMsgMapper.selectByExample(example);
        for (ZjkMsg record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkMsgExample zjkMsgExample = new ZjkMsgExample();
        String strParentId = zjkMsgMapper.selectByExample(zjkMsgExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}