package com.pcitc.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.*;
import com.pcitc.base.system.SysAddressExample;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.system.SysAddressMapper;
import com.pcitc.service.system.SysAddressService;
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
 * <p>Table: sys_address - 省市县地址表</p>
 *
 * @since 2019-02-14 11:01:09
 */
@Service("sysAddressService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysAddressServiceImpl implements SysAddressService {

    @Autowired
    private SysAddressMapper sysAddressMapper;

    public List<SysAddress> findSysAddressList(SysAddress sysAddress) {
        List<SysAddress> record = sysAddressMapper.findSysAddressList(sysAddress);
        return record;
    }

    @Override
    public int updateOrInsertSysAddress(SysAddress sysAddress) throws Exception {
        int result = 500;
        SysAddress address = sysAddressMapper.selectByPrimaryKey(sysAddress.getDataId()+"");
        if (address != null) {
            sysAddressMapper.updateByPrimaryKeySelective(sysAddress);
        } else {
            sysAddressMapper.insertSelective(sysAddress);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteSysAddressById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            sysAddressMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public SysAddress getSysAddressInfo(String id) throws Exception {

        return sysAddressMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(SysAddressExample example) {
        return sysAddressMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysAddressExample example) {
        return sysAddressMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return sysAddressMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteSysAddressReal(String recordId) {
        return sysAddressMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(SysAddress record) {
        return sysAddressMapper.insert(record);
    }

    @Override
    public int insertSelective(SysAddress record) {
        return sysAddressMapper.insertSelective(record);
    }

    public SysAddress insertObject(SysAddress record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<SysAddress> selectByExample(SysAddressExample example) {
        return sysAddressMapper.selectByExample(example);
    }

    @Override
    public SysAddress selectByPrimaryKey(String recordId) {
        return sysAddressMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") SysAddress record, @Param("example") SysAddressExample example) {
        return sysAddressMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") SysAddress record, @Param("example") SysAddressExample example) {
        return sysAddressMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysAddress record) {
        return sysAddressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysAddress record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return sysAddressMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteSysAddress(Serializable sysAddressId) {
        try {
            SysAddress record = sysAddressMapper.selectByPrimaryKey(sysAddressId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                sysAddressMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findSysAddressByPage(LayuiTableParam param) {
        SysAddressExample example = new SysAddressExample();
        SysAddressExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            SysAddressExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, SysAddressExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<SysAddress> list = sysAddressMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<SysAddress> pageInfo = new PageInfo<SysAddress>(list);
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
        SysAddressExample example = new SysAddressExample();
        //example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<SysAddress> records = sysAddressMapper.selectByExample(example);
        for (SysAddress record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        SysAddressExample sysAddressExample = new SysAddressExample();
        String strParentId = sysAddressMapper.selectByExample(sysAddressExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}