package com.pcitc.service.expert.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkEvaluateExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkEvaluateMapper;
import com.pcitc.service.expert.ZjkEvaluateService;
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
 * <p>Table: zjk_evaluate - 专家库-专家评价</p>
 *
 * @since 2019-02-28 02:27:36
 */
@Service("zjkEvaluateService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkEvaluateServiceImpl implements ZjkEvaluateService {

    @Autowired
    private ZjkEvaluateMapper zjkEvaluateMapper;

    public List<ZjkEvaluate> findZjkEvaluateList(ZjkEvaluate zjkEvaluate) {
        List<ZjkEvaluate> record = zjkEvaluateMapper.findZjkEvaluateList(zjkEvaluate);
        return record;
    }

    @Override
    public int updateOrInsertZjkEvaluate(ZjkEvaluate zjkEvaluate) throws Exception {
        int result = 500;
        if (zjkEvaluate.getDataId() != null && zjkEvaluate.getDataId() != null) {
            zjkEvaluateMapper.updateByPrimaryKeySelective(zjkEvaluate);
        } else {
            zjkEvaluate.setDataId(IdUtil.createIdByTime());
            zjkEvaluateMapper.insertSelective(zjkEvaluate);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkEvaluateById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkEvaluateMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkEvaluate getZjkEvaluateInfo(String id) throws Exception {

        return zjkEvaluateMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkEvaluateExample example) {
        return zjkEvaluateMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkEvaluateExample example) {
        return zjkEvaluateMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkEvaluateMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkEvaluateReal(String recordId) {
        return zjkEvaluateMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkEvaluate record) {
        record.setDataId(IdUtil.createIdByTime());
        return zjkEvaluateMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkEvaluate record) {
        return zjkEvaluateMapper.insertSelective(record);
    }

    public ZjkEvaluate insertObject(ZjkEvaluate record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkEvaluate> selectByExample(ZjkEvaluateExample example) {
        return zjkEvaluateMapper.selectByExample(example);
    }

    @Override
    public ZjkEvaluate selectByPrimaryKey(String recordId) {
        return zjkEvaluateMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkEvaluate record, @Param("example") ZjkEvaluateExample example) {
        return zjkEvaluateMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkEvaluate record, @Param("example") ZjkEvaluateExample example) {
        return zjkEvaluateMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkEvaluate record) {
        return zjkEvaluateMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkEvaluate record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkEvaluateMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkEvaluate(Serializable zjkEvaluateId) {
        try {
            ZjkEvaluate record = zjkEvaluateMapper.selectByPrimaryKey(zjkEvaluateId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkEvaluateMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkEvaluateByPage(LayuiTableParam param) {
        ZjkEvaluateExample example = new ZjkEvaluateExample();
        ZjkEvaluateExample.Criteria c = example.createCriteria();
        Object zjkName = param.getParam().get("zjkName");
        if (!StrUtil.isObjectEmpty(zjkName)) {
            c.andZjkNameLike("%" + zjkName + "%");

        }
        Object xmName = param.getParam().get("xmName");
        if (!StrUtil.isObjectEmpty(xmName)) {
            c.andXmNameLike("%" + xmName + "%");

        }
        Object xmSteps = param.getParam().get("xmSteps");
        if (!StrUtil.isObjectEmpty(xmSteps)) {
            c.andXmStepsLike("%" + xmSteps + "%");

        }
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkEvaluateExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkEvaluateExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkEvaluate> list = zjkEvaluateMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkEvaluate> pageInfo = new PageInfo<ZjkEvaluate>(list);
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
        ZjkEvaluateExample example = new ZjkEvaluateExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkEvaluate> records = zjkEvaluateMapper.selectByExample(example);
        for (ZjkEvaluate record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkEvaluateExample zjkEvaluateExample = new ZjkEvaluateExample();
        String strParentId = zjkEvaluateMapper.selectByExample(zjkEvaluateExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}