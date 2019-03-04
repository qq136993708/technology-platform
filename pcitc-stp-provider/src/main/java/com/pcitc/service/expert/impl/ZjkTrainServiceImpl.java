package com.pcitc.service.expert.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkTrainExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkTrainMapper;
import com.pcitc.service.expert.ZjkTrainService;
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
 * <p>Table: zjk_train - 专家培训</p>
 *
 * @since 2019-03-01 09:34:09
 */
@Service("zjkTrainService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkTrainServiceImpl implements ZjkTrainService {

    @Autowired
    private ZjkTrainMapper zjkTrainMapper;

    public List<ZjkTrain> findZjkTrainList(ZjkTrain zjkTrain) {
        List<ZjkTrain> record = zjkTrainMapper.findZjkTrainList(zjkTrain);
        return record;
    }

    @Override
    public int updateOrInsertZjkTrain(ZjkTrain zjkTrain) throws Exception {
        int result = 500;
        if (zjkTrain.getDataId() != null && zjkTrain.getDataId() != null) {
            zjkTrainMapper.updateByPrimaryKeySelective(zjkTrain);
        } else {
            zjkTrain.setDataId(IdUtil.createIdByTime());
            zjkTrainMapper.insertSelective(zjkTrain);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkTrainById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkTrainMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkTrain getZjkTrainInfo(String id) throws Exception {

        return zjkTrainMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkTrainExample example) {
        return zjkTrainMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkTrainExample example) {
        return zjkTrainMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkTrainMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkTrainReal(String recordId) {
        return zjkTrainMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkTrain record) {
        record.setDataId(IdUtil.createIdByTime());
        return zjkTrainMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkTrain record) {
        return zjkTrainMapper.insertSelective(record);
    }

    public ZjkTrain insertObject(ZjkTrain record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkTrain> selectByExample(ZjkTrainExample example) {
        return zjkTrainMapper.selectByExample(example);
    }

    @Override
    public ZjkTrain selectByPrimaryKey(String recordId) {
        return zjkTrainMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkTrain record, @Param("example") ZjkTrainExample example) {
        return zjkTrainMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkTrain record, @Param("example") ZjkTrainExample example) {
        return zjkTrainMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkTrain record) {
        return zjkTrainMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkTrain record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkTrainMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkTrain(Serializable zjkTrainId) {
        try {
            ZjkTrain record = zjkTrainMapper.selectByPrimaryKey(zjkTrainId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkTrainMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkTrainByPage(LayuiTableParam param) {
        ZjkTrainExample example = new ZjkTrainExample();
        ZjkTrainExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkTrainExample.Criteria criteria2 = example.or();
//            criteria2.andParentIdEqualTo(param.getParam().get("fileKind").toString());
//            example.or(criteria2);
        //       }
        Object zjkName = param.getParam().get("zjkName");
        if (!StrUtil.isObjectEmpty(zjkName)) {
            c.andZjkNameLike("%" + zjkName + "%");

        }
        Object trainTheme = param.getParam().get("trainTheme");
        if (!StrUtil.isObjectEmpty(trainTheme)) {
            c.andTrainThemeLike("%" + trainTheme + "%");

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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkTrainExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkTrain> list = zjkTrainMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkTrain> pageInfo = new PageInfo<ZjkTrain>(list);
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
        ZjkTrainExample example = new ZjkTrainExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkTrain> records = zjkTrainMapper.selectByExample(example);
        for (ZjkTrain record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkTrainExample zjkTrainExample = new ZjkTrainExample();
        String strParentId = zjkTrainMapper.selectByExample(zjkTrainExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}