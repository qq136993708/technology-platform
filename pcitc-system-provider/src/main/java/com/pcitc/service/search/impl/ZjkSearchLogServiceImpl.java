package com.pcitc.service.search.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.HotWord;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.search.*;
import com.pcitc.base.search.ZjkSearchLogExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.search.ZjkSearchLogMapper;
import com.pcitc.mapper.system.SysFileMapper;
import com.pcitc.service.doc.IndexAccessorService;
import com.pcitc.service.search.ZjkSearchLogService;
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
import java.util.stream.Collectors;

/**
 * <p>接口实现类</p>
 * <p>Table: zjk_search_log - 专家库-搜索关键字日志</p>
 *
 * @since 2019-07-20 10:11:09
 */
@Service("zjkSearchLogService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkSearchLogServiceImpl implements ZjkSearchLogService {

    @Autowired
    private ZjkSearchLogMapper zjkSearchLogMapper;
    @Autowired
    private IndexAccessorService indexAccessorService;

    public List<ZjkSearchLog> findZjkSearchLogList(ZjkSearchLog zjkSearchLog) {
        List<ZjkSearchLog> record = zjkSearchLogMapper.findZjkSearchLogList(zjkSearchLog);
        return record;
    }
    @Override
    public int updateOrInsertZjkSearchLog(ZjkSearchLog zjkSearchLog)  {
        int result = 500;
        try {
            if (zjkSearchLog.getDataId() != null && zjkSearchLog.getDataId() != null) {
                zjkSearchLogMapper.updateByPrimaryKeySelective(zjkSearchLog);
            } else {
                zjkSearchLog.setDataId(IdUtil.createIdByTime());
                zjkSearchLogMapper.insertSelective(zjkSearchLog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            //插入ES
//            int leng = selectByExample(new ZjkSearchLogExample()).size()+1;
//            zjkSearchLog.setEsId(leng);
//            indexAccessorService.saveObjToEs(zjkSearchLog,"");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return result;
    }

    @Override
    public int deleteZjkSearchLogById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkSearchLogMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkSearchLog getZjkSearchLogInfo(String id) throws Exception {

        return zjkSearchLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkSearchLogExample example) {
        return zjkSearchLogMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkSearchLogExample example) {
        return zjkSearchLogMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkSearchLogMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkSearchLogReal(String recordId) {
        return zjkSearchLogMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkSearchLog record) {
        record.setDataId(IdUtil.createIdByTime());
        return zjkSearchLogMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkSearchLog record) {
        return zjkSearchLogMapper.insertSelective(record);
    }

    public ZjkSearchLog insertObject(ZjkSearchLog record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkSearchLog> selectByExample(ZjkSearchLogExample example) {
        return zjkSearchLogMapper.selectByExample(example);
    }

    @Override
    public ZjkSearchLog selectByPrimaryKey(String recordId) {
        return zjkSearchLogMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkSearchLog record, @Param("example") ZjkSearchLogExample example) {
        return zjkSearchLogMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkSearchLog record, @Param("example") ZjkSearchLogExample example) {
        return zjkSearchLogMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkSearchLog record) {
        return zjkSearchLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkSearchLog record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkSearchLogMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkSearchLog(Serializable zjkSearchLogId) {
        try {
            ZjkSearchLog record = zjkSearchLogMapper.selectByPrimaryKey(zjkSearchLogId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkSearchLogMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkSearchLogByPage(LayuiTableParam param) {
        ZjkSearchLogExample example = new ZjkSearchLogExample();
        ZjkSearchLogExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkSearchLogExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkSearchLogExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkSearchLog> list = zjkSearchLogMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkSearchLog> pageInfo = new PageInfo<ZjkSearchLog>(list);
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
        ZjkSearchLogExample example = new ZjkSearchLogExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkSearchLog> records = zjkSearchLogMapper.selectByExample(example);
        for (ZjkSearchLog record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkSearchLogExample zjkSearchLogExample = new ZjkSearchLogExample();
        String strParentId = zjkSearchLogMapper.selectByExample(zjkSearchLogExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }

    @Override
    public List<String> getListEs(HotWord hotWord) {
        List<ZjkSearchLog> listTopHost = zjkSearchLogMapper.getListTopHost();
        return listTopHost.stream().map(e->e.getKeyword()).collect(Collectors.toList());

//        return indexAccessorService.selectHotWord(hotWord);
    }
}