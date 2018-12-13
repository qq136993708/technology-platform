package com.pcitc.service.expert.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkZhuanliExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkZhuanliMapper;
import com.pcitc.service.expert.ZjkZhuanliService;
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
 * <p>Table: zjk_zhuanli - 专家-专利信息</p>
 *
 * @since 2018-12-08 04:10:52
 */
@Service("zjkZhuanliService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkZhuanliServiceImpl implements ZjkZhuanliService {

    @Autowired
    private ZjkZhuanliMapper zjkZhuanliMapper;

    public List<ZjkZhuanli> findZjkZhuanliList(ZjkZhuanli zjkZhuanli) {
        List<ZjkZhuanli> record = zjkZhuanliMapper.findZjkZhuanliList(zjkZhuanli);
        return record;
    }

    @Override
    public int updateOrInsertZjkZhuanli(ZjkZhuanli zjkZhuanli) throws Exception {
        int result = 500;
        if (zjkZhuanli.getId() != null && zjkZhuanli.getId() != null) {
            zjkZhuanliMapper.updateByPrimaryKeySelective(zjkZhuanli);
        } else {
            zjkZhuanli.setId(IdUtil.createIdByTime());
            zjkZhuanliMapper.insertSelective(zjkZhuanli);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkZhuanliById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkZhuanliMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkZhuanli getZjkZhuanliInfo(String id) throws Exception {

        return zjkZhuanliMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkZhuanliExample example) {
        return zjkZhuanliMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkZhuanliExample example) {
        return zjkZhuanliMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkZhuanliMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkZhuanliReal(String recordId) {
        return zjkZhuanliMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkZhuanli record) {
        record.setId(IdUtil.createIdByTime());
        return zjkZhuanliMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkZhuanli record) {
        return zjkZhuanliMapper.insertSelective(record);
    }

    public ZjkZhuanli insertObject(ZjkZhuanli record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkZhuanli> selectByExample(ZjkZhuanliExample example) {
        return zjkZhuanliMapper.selectByExample(example);
    }

    @Override
    public ZjkZhuanli selectByPrimaryKey(String recordId) {
        return zjkZhuanliMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkZhuanli record, @Param("example") ZjkZhuanliExample example) {
        return zjkZhuanliMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkZhuanli record, @Param("example") ZjkZhuanliExample example) {
        return zjkZhuanliMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkZhuanli record) {
        return zjkZhuanliMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkZhuanli record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkZhuanliMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkZhuanli(Serializable zjkZhuanliId) {
        try {
            ZjkZhuanli record = zjkZhuanliMapper.selectByPrimaryKey(zjkZhuanliId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkZhuanliMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkZhuanliByPage(LayuiTableParam param) {
        ZjkZhuanliExample example = new ZjkZhuanliExample();
        ZjkZhuanliExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkZhuanliExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkZhuanliExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkZhuanli> list = zjkZhuanliMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkZhuanli> pageInfo = new PageInfo<ZjkZhuanli>(list);
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
        ZjkZhuanliExample example = new ZjkZhuanliExample();
        example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkZhuanli> records = zjkZhuanliMapper.selectByExample(example);
        for (ZjkZhuanli record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkZhuanliExample zjkZhuanliExample = new ZjkZhuanliExample();
        String strParentId = zjkZhuanliMapper.selectByExample(zjkZhuanliExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}