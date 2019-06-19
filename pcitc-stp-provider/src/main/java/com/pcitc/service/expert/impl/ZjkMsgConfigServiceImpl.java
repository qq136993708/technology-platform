package com.pcitc.service.expert.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkMsgConfigExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkMsgConfigMapper;
import com.pcitc.mapper.expert.ZjkMsgMapper;
import com.pcitc.service.expert.ZjkMsgConfigService;
import net.sf.json.JSONArray;
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
 * <p>Table: zjk_msg_config - 专家回复消息配置表</p>
 *
 * @since 2019-02-25 03:04:53
 */
@Service("zjkMsgConfigService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkMsgConfigServiceImpl implements ZjkMsgConfigService {

    @Autowired
    private ZjkMsgConfigMapper zjkMsgConfigMapper;
    @Autowired
    private ZjkMsgMapper zjkMsgMapper;

    public List<ZjkMsgConfig> findZjkMsgConfigList(ZjkMsgConfig zjkMsgConfig) {
        List<ZjkMsgConfig> record = zjkMsgConfigMapper.findZjkMsgConfigList(zjkMsgConfig);
        return record;
    }

    @Override
    public int updateOrInsertZjkMsgConfig(ZjkMsgConfig zjkMsgConfig) throws Exception {
        int result = 500;
        if (zjkMsgConfig.getDataId() != null && zjkMsgConfig.getDataId() != null) {
            zjkMsgConfigMapper.updateByPrimaryKeySelective(zjkMsgConfig);
        } else {
            zjkMsgConfig.setDataId(IdUtil.createIdByTime());
            zjkMsgConfigMapper.insertSelective(zjkMsgConfig);
        }
        result = 200;
        return result;
    }

    public static void main(String[] args) {
        String str = "[{xmSteps=null}]";

        Object parse = JSON.parse(JSONObject.toJSONString(str));
        System.out.println(parse);

        com.alibaba.fastjson.JSONArray jsonArray = com.alibaba.fastjson.JSONArray.parseArray(str);
//        List<ZjkMsg> list = JSONObject.parseArray(JSONObject.toJSONString(str),ZjkMsg.class);


    }

    @Override
    public int updateOrInsertZjkMsgConfigBat(JSONObject jsonObject) {
        int result = 500;
        String str = jsonObject.getString("obj");
        ZjkMsg ZjkMsg = JSONObject.parseObject(str, com.pcitc.base.expert.ZjkMsg.class);
        String[] array = ZjkMsg.getDataId().split(",");
        for (int i = 0; i < array.length; i++) {
            ZjkMsg.setDataId(array[i]);
            zjkMsgMapper.updateByPrimaryKeySelective(ZjkMsg);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkMsgConfigById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkMsgConfigMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkMsgConfig getZjkMsgConfigInfo(String id) throws Exception {

        return zjkMsgConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkMsgConfigExample example) {
        return zjkMsgConfigMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkMsgConfigExample example) {
        return zjkMsgConfigMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkMsgConfigMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkMsgConfigReal(String recordId) {
        return zjkMsgConfigMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkMsgConfig record) {
        record.setDataId(IdUtil.createIdByTime());
        return zjkMsgConfigMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkMsgConfig record) {
        return zjkMsgConfigMapper.insertSelective(record);
    }

    public ZjkMsgConfig insertObject(ZjkMsgConfig record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkMsgConfig> selectByExample(ZjkMsgConfigExample example) {
        return zjkMsgConfigMapper.selectByExample(example);
    }

    @Override
    public ZjkMsgConfig selectByPrimaryKey(String recordId) {
        return zjkMsgConfigMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkMsgConfig record, @Param("example") ZjkMsgConfigExample example) {
        return zjkMsgConfigMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkMsgConfig record, @Param("example") ZjkMsgConfigExample example) {
        return zjkMsgConfigMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkMsgConfig record) {
        return zjkMsgConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkMsgConfig record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkMsgConfigMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkMsgConfig(Serializable zjkMsgConfigId) {
        try {
            ZjkMsgConfig record = zjkMsgConfigMapper.selectByPrimaryKey(zjkMsgConfigId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkMsgConfigMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkMsgConfigByPage(LayuiTableParam param) {
        ZjkMsgConfigExample example = new ZjkMsgConfigExample();
        ZjkMsgConfigExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkMsgConfigExample.Criteria criteria2 = example.or();
//            criteria2.andParentIdEqualTo(param.getParam().get("fileKind").toString());
//            example.or(criteria2);
        //       }
//        example.setOrderByClause("create_date desc");
        return this.findByExample(param, example);

    }

    /**
     * 根据条件分页搜索
     *
     * @param param
     * @param example
     * @return
     */
    private LayuiTableData findByExample(LayuiTableParam param, ZjkMsgConfigExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkMsgConfig> list = zjkMsgConfigMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkMsgConfig> pageInfo = new PageInfo<ZjkMsgConfig>(list);
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
        ZjkMsgConfigExample example = new ZjkMsgConfigExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkMsgConfig> records = zjkMsgConfigMapper.selectByExample(example);
        for (ZjkMsgConfig record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkMsgConfigExample zjkMsgConfigExample = new ZjkMsgConfigExample();
        String strParentId = zjkMsgConfigMapper.selectByExample(zjkMsgConfigExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}