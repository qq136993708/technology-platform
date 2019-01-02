package com.pcitc.service.expert.impl;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkTreeExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkTreeMapper;
import com.pcitc.service.expert.ZjkTreeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>接口实现类</p>
 * <p>Table: zjk_tree - 专家库-树</p>
 *
 * @since 2019-01-02 09:53:32
 */
@Service("zjkTreeService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkTreeServiceImpl implements ZjkTreeService {

    @Resource
    private ZjkTreeMapper zjkTreeMapper;

    public List<ZjkTree> findZjkTreeList(ZjkTree zjkTree) {
        List<ZjkTree> record = zjkTreeMapper.findZjkTreeList(zjkTree);
        return record;
    }

    @Override
    public int updateOrInsertZjkTree(ZjkTree zjkTree) throws Exception {
        int result = 500;
        if (zjkTree.getDataId() != null && zjkTree.getDataId() != null) {
            zjkTreeMapper.updateByPrimaryKeySelective(zjkTree);
        } else {
            zjkTree.setDataId(IdUtil.createIdByTime());
            zjkTreeMapper.insertSelective(zjkTree);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkTreeById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkTreeMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkTree getZjkTreeInfo(String id) throws Exception {

        return zjkTreeMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkTreeExample example) {
        return zjkTreeMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkTreeExample example) {
        return zjkTreeMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkTreeMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkTreeReal(String recordId) {
        return zjkTreeMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkTree record) {
        record.setId(IdUtil.createIdByTime());
        return zjkTreeMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkTree record) {
        return zjkTreeMapper.insertSelective(record);
    }

    public ZjkTree insertObject(ZjkTree record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkTree> selectByExample(ZjkTreeExample example) {
        return zjkTreeMapper.selectByExample(example);
    }

    @Override
    public ZjkTree selectByPrimaryKey(String recordId) {
        return zjkTreeMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkTree record, @Param("example") ZjkTreeExample example) {
        return zjkTreeMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkTree record, @Param("example") ZjkTreeExample example) {
        return zjkTreeMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkTree record) {
        return zjkTreeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkTree record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkTreeMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkTree(Serializable zjkTreeId) {
        try {
            ZjkTree record = zjkTreeMapper.selectByPrimaryKey(zjkTreeId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkTreeMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkTreeByPage(LayuiTableParam param) {
        ZjkTreeExample example = new ZjkTreeExample();
        ZjkTreeExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkTreeExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkTreeExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkTree> list = zjkTreeMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkTree> pageInfo = new PageInfo<ZjkTree>(list);
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
        ZjkTreeExample example = new ZjkTreeExample();
        List<ZjkTree> records = zjkTreeMapper.selectByExample(example);
        for (ZjkTree record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkTreeExample zjkTreeExample = new ZjkTreeExample();
        String strParentId = zjkTreeMapper.selectByExample(zjkTreeExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }

    @Override
    public JSONObject selectTree(JSONObject jsonObject) {
        List<TreeNode> list = null;
        try {
            ZjkTree zjkTree = this.selectByPrimaryKey(jsonObject.get("id").toString());
            String sql =zjkTree.getSqlText();

            Map<String, Object> param = (Map<String, Object>) jsonObject.get("param");

            for (Map.Entry<String, Object> e : param.entrySet()) {
                sql = sql.replace("#{" + e.getKey() + "}", "'" + ((e.getValue()==null)?"":e.getValue()) + "'");
            }

            Map<String, Object> map = new HashMap<>();
            map.put("sqlval", sql);
            list = zjkTreeMapper.selectTree(map);

            for (int i = 0; i < list.size(); i++) {
                TreeNode tree = list.get(i);
                // 前几层默认打开
                if (tree.getLevelCode() < 1) {
                    tree.setOpen("true");
                } else {
                    tree.setOpen("false");
                }

                // 判断节点是否有孩子（异步加载用）
                if (tree.getParentId() !=null) {
                    tree.setIsParent(false);
                } else {
                    tree.setIsParent(true);
                }
//                if (tree.getIsLeaf() == 1) {
//                    tree.setIsParent(false);
//                } else {
//                    tree.setIsParent(true);
//                }
            }
            jsonObject.put("tree",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}