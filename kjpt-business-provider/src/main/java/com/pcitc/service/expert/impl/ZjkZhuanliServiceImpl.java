package com.pcitc.service.expert.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkPatentExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.expert.ZjkPatentMapper;
import com.pcitc.service.expert.ZjkZhuanliService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;

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
    private ZjkPatentMapper zjkZhuanliMapper;

    public List<ZjkPatent> findZjkZhuanliList(ZjkPatent zjkZhuanli) {
        List<ZjkPatent> record = zjkZhuanliMapper.findZjkPatentList(zjkZhuanli);
        return record;
    }

    @Override
    public int updateOrInsertZjkZhuanli(ZjkPatent zjkZhuanli) throws Exception {
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
    public ZjkPatent getZjkZhuanliInfo(String id) throws Exception {

        return zjkZhuanliMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkPatentExample example) {
        return zjkZhuanliMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkPatentExample example) {
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
    public int insert(ZjkPatent record) {
        record.setId(IdUtil.createIdByTime());
        return zjkZhuanliMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkPatent record) {
        return zjkZhuanliMapper.insertSelective(record);
    }

    public ZjkPatent insertObject(ZjkPatent record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkPatent> selectByExample(ZjkPatentExample example) {
        return zjkZhuanliMapper.selectByExample(example);
    }

    @Override
    public ZjkPatent selectByPrimaryKey(String recordId) {
        return zjkZhuanliMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkPatent record, @Param("example") ZjkPatentExample example) {
        return zjkZhuanliMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkPatent record, @Param("example") ZjkPatentExample example) {
        return zjkZhuanliMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkPatent record) {
        return zjkZhuanliMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkPatent record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkZhuanliMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkZhuanli(Serializable zjkZhuanliId) {
        try {
            ZjkPatent record = zjkZhuanliMapper.selectByPrimaryKey(zjkZhuanliId.toString());
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
        ZjkPatentExample example = new ZjkPatentExample();
        ZjkPatentExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkPatentExample.Criteria criteria2 = example.or();
//            criteria2.andParentIdEqualTo(param.getParam().get("fileKind").toString());
//            example.or(criteria2);
        //       }
        LayuiTableData data = new LayuiTableData();
        Object keywords = param.getParam().get("keyword");
        if (keywords != null && !"".equals(keywords)) {
            example.or().andPatentNameLike("%"+keywords+"%");
            example.or().andPatentDescLike("%"+keywords+"%");
            example.or().andPatentKeysLike("%"+keywords+"%");
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
    private LayuiTableData findByExample(LayuiTableParam param, ZjkPatentExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkPatent> list = zjkZhuanliMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkPatent> pageInfo = new PageInfo<ZjkPatent>(list);
        LayuiTableData data = new LayuiTableData();
        Object keywords = param.getParam().get("keyword");
        if (keywords != null && !"".equals(keywords)) {
            data.setData(setKeyWordCss(pageInfo, keywords.toString()));
        } else {
            data.setData(pageInfo.getList());
        }        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());
        return data;
    }
    public List<Map<String, Object>> setKeyWordCss(PageInfo<?> pageInfo, String keywords) {
        List<Map<String, Object>> maps = new ArrayList<>();
        for (int i = 0; i < pageInfo.getSize(); i++) {
            Object obj = pageInfo.getList().get(i);
            Map<String, Object> map = MyBeanUtils.transBean2Map(obj);
            Set<Map.Entry<String, Object>> entrys = map.entrySet();  //此行可省略，直接将map.entrySet()写在for-each循环的条件中

            Map<String, Object> objectMap = new HashMap<>();
            for (Map.Entry<String, Object> entry : entrys) {
                Object val = entry.getValue();
                if (val != null && !"".equals(val) && val.toString().contains(keywords.toString())) {
                    objectMap.put(entry.getKey(), val.toString().replace(keywords.toString(), "<span style=\"color:red\">" + keywords.toString() + "</span>"));
                } else {
                    objectMap.put(entry.getKey(), entry.getValue());
                }
            }
            maps.add(objectMap);

        }
        return maps;
    }

    /**
     * 树形菜单
     *
     * @return
     */
    @Override
    public List<TreeNode> selectObjectByTree() {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        ZjkPatentExample example = new ZjkPatentExample();
        List<ZjkPatent> records = zjkZhuanliMapper.selectByExample(example);
        for (ZjkPatent record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkPatentExample zjkZhuanliExample = new ZjkPatentExample();
        String strParentId = zjkZhuanliMapper.selectByExample(zjkZhuanliExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}