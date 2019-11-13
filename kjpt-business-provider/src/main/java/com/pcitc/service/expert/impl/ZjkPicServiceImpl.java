package com.pcitc.service.expert.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkPicExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkPicMapper;
import com.pcitc.service.expert.ZjkPicService;
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
 * <p>Table: zjk_pic - </p>
 *
 * @since 2018-12-12 02:58:24
 */
@Service("zjkPicService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkPicServiceImpl implements ZjkPicService {

    @Autowired
    private ZjkPicMapper zjkPicMapper;

    public List<ZjkPic> findZjkPicList(ZjkPic zjkPic) {
        List<ZjkPic> record = zjkPicMapper.findZjkPicList(zjkPic);
        return record;
    }

    @Override
    public int updateOrInsertZjkPic(ZjkPic zjkPic) throws Exception {
        int result = 500;
        if (zjkPic.getId() != null && zjkPic.getId() != null) {
            zjkPicMapper.updateByPrimaryKeySelective(zjkPic);
        } else {
            zjkPic.setId(IdUtil.createIdByTime());
            zjkPicMapper.insertSelective(zjkPic);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkPicById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkPicMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkPic getZjkPicInfo(String id) throws Exception {

        return zjkPicMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkPicExample example) {
        return zjkPicMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkPicExample example) {
        return zjkPicMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkPicMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkPicReal(String recordId) {
        return zjkPicMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkPic record) {
        record.setId(IdUtil.createIdByTime());
        return zjkPicMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkPic record) {
        return zjkPicMapper.insertSelective(record);
    }

    public ZjkPic insertObject(ZjkPic record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkPic> selectByExample(ZjkPicExample example) {
        return zjkPicMapper.selectByExample(example);
    }

    @Override
    public ZjkPic selectByPrimaryKey(String recordId) {
        return zjkPicMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkPic record, @Param("example") ZjkPicExample example) {
        return zjkPicMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkPic record, @Param("example") ZjkPicExample example) {
        return zjkPicMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkPic record) {
        return zjkPicMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkPic record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkPicMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkPic(Serializable zjkPicId) {
        try {
            ZjkPic record = zjkPicMapper.selectByPrimaryKey(zjkPicId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkPicMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkPicByPage(LayuiTableParam param) {
        ZjkPicExample example = new ZjkPicExample();
        ZjkPicExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkPicExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkPicExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkPic> list = zjkPicMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkPic> pageInfo = new PageInfo<ZjkPic>(list);
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
        ZjkPicExample example = new ZjkPicExample();
//        example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkPic> records = zjkPicMapper.selectByExample(example);
        for (ZjkPic record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkPicExample zjkPicExample = new ZjkPicExample();
        String strParentId = zjkPicMapper.selectByExample(zjkPicExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}