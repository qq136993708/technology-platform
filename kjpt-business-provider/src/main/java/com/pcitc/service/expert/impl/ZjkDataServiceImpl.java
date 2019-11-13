package com.pcitc.service.expert.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkDataExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkDataMapper;
import com.pcitc.service.expert.ZjkDataService;
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
 * <p>Table: zjk_data - </p>
 *
 * @since 2019-03-16 11:38:42
 */
@Service("zjkDataService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkDataServiceImpl implements ZjkDataService {

    @Autowired
    private ZjkDataMapper zjkDataMapper;

    public List<ZjkData> findZjkDataList(ZjkData zjkData) {
        List<ZjkData> record = zjkDataMapper.findZjkDataList(zjkData);
        return record;
    }

    @Override
    public int updateOrInsertZjkData(ZjkData zjkData) throws Exception {
        int result = 500;
        if (zjkData.getDataId() != null && zjkData.getDataId() != null) {
            zjkDataMapper.updateByPrimaryKeySelective(zjkData);
        } else {
            zjkData.setDataId(IdUtil.createIdByTime());
            zjkDataMapper.insertSelective(zjkData);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkDataById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkDataMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkData getZjkDataInfo(String id) throws Exception {

        return zjkDataMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkDataExample example) {
        return zjkDataMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkDataExample example) {
        return zjkDataMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkDataMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkDataReal(String recordId) {
        return zjkDataMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkData record) {
        record.setDataId(IdUtil.createIdByTime());
        return zjkDataMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkData record) {
        return zjkDataMapper.insertSelective(record);
    }

    public ZjkData insertObject(ZjkData record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkData> selectByExample(ZjkDataExample example) {
        return zjkDataMapper.selectByExample(example);
    }

    @Override
    public ZjkData selectByPrimaryKey(String recordId) {
        return zjkDataMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkData record, @Param("example") ZjkDataExample example) {
        return zjkDataMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkData record, @Param("example") ZjkDataExample example) {
        return zjkDataMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkData record) {
        return zjkDataMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkData record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkDataMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkData(Serializable zjkDataId) {
        try {
            ZjkData record = zjkDataMapper.selectByPrimaryKey(zjkDataId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkDataMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkDataByPage(LayuiTableParam param) {
        ZjkDataExample example = new ZjkDataExample();
        ZjkDataExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkDataExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkDataExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkData> list = zjkDataMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkData> pageInfo = new PageInfo<ZjkData>(list);
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
        ZjkDataExample example = new ZjkDataExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkData> records = zjkDataMapper.selectByExample(example);
        for (ZjkData record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkDataExample zjkDataExample = new ZjkDataExample();
        String strParentId = zjkDataMapper.selectByExample(zjkDataExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}