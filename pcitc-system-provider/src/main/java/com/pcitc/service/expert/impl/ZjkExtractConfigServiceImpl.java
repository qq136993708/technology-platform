package com.pcitc.service.expert.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkExtractConfigExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkExtractConfigMapper;
import com.pcitc.service.expert.ZjkExtractConfigService;
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
 * <p>Table: zjk_extract_config - 专家抽取逻辑配置</p>
 *
 * @since 2019-01-29 04:04:35
 */
@Service("zjkExtractConfigService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkExtractConfigServiceImpl implements ZjkExtractConfigService {

    @Autowired
    private ZjkExtractConfigMapper zjkExtractConfigMapper;

    public List<ZjkExtractConfig> findZjkExtractConfigList(ZjkExtractConfig zjkExtractConfig) {
        List<ZjkExtractConfig> record = zjkExtractConfigMapper.findZjkExtractConfigList(zjkExtractConfig);
        return record;
    }

    @Override
    public int updateOrInsertZjkExtractConfig(ZjkExtractConfig zjkExtractConfig) throws Exception {
        int result = 500;
        if (zjkExtractConfig.getDataId() != null && zjkExtractConfig.getDataId() != null) {
            zjkExtractConfigMapper.updateByPrimaryKeySelective(zjkExtractConfig);
        } else {
            zjkExtractConfig.setDataId(IdUtil.createIdByTime());
            zjkExtractConfigMapper.insertSelective(zjkExtractConfig);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkExtractConfigById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkExtractConfigMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkExtractConfig getZjkExtractConfigInfo(String id) throws Exception {

        return zjkExtractConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkExtractConfigExample example) {
        return zjkExtractConfigMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkExtractConfigExample example) {
        return zjkExtractConfigMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkExtractConfigMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkExtractConfigReal(String recordId) {
        return zjkExtractConfigMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkExtractConfig record) {
        record.setDataId(IdUtil.createIdByTime());
        return zjkExtractConfigMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkExtractConfig record) {
        return zjkExtractConfigMapper.insertSelective(record);
    }

    public ZjkExtractConfig insertObject(ZjkExtractConfig record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkExtractConfig> selectByExample(ZjkExtractConfigExample example) {
        return zjkExtractConfigMapper.selectByExample(example);
    }

    @Override
    public ZjkExtractConfig selectByPrimaryKey(String recordId) {
        return zjkExtractConfigMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkExtractConfig record, @Param("example") ZjkExtractConfigExample example) {
        return zjkExtractConfigMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkExtractConfig record, @Param("example") ZjkExtractConfigExample example) {
        return zjkExtractConfigMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkExtractConfig record) {
        return zjkExtractConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkExtractConfig record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkExtractConfigMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkExtractConfig(Serializable zjkExtractConfigId) {
        try {
            ZjkExtractConfig record = zjkExtractConfigMapper.selectByPrimaryKey(zjkExtractConfigId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkExtractConfigMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkExtractConfigByPage(LayuiTableParam param) {
        ZjkExtractConfigExample example = new ZjkExtractConfigExample();
        ZjkExtractConfigExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkExtractConfigExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkExtractConfigExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkExtractConfig> list = zjkExtractConfigMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkExtractConfig> pageInfo = new PageInfo<ZjkExtractConfig>(list);
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
        ZjkExtractConfigExample example = new ZjkExtractConfigExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkExtractConfig> records = zjkExtractConfigMapper.selectByExample(example);
        for (ZjkExtractConfig record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkExtractConfigExample zjkExtractConfigExample = new ZjkExtractConfigExample();
        String strParentId = zjkExtractConfigMapper.selectByExample(zjkExtractConfigExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}