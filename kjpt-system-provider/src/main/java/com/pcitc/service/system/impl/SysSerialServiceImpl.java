package com.pcitc.service.system.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.*;
import com.pcitc.base.system.SysSerialExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.system.SysSerialMapper;
import com.pcitc.service.system.SysSerialService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>接口实现类</p>
 * <p>Table: sys_serial - 文件上传-取号</p>
 *
 * @since 2018-08-15 03:34:45
 */
@Service("sysSerialService")
public class SysSerialServiceImpl implements SysSerialService {

    @Autowired
    private SysSerialMapper sysSerialMapper;

    public List<SysSerial> findSysSerialList(SysSerial sysSerial) {
        List<SysSerial> record = sysSerialMapper.findSysSerialList(sysSerial);
        return record;
    }

    @Override
    public int updateOrInsertSysSerial(SysSerial sysSerial) throws Exception {
        int result = 500;
        if (sysSerial.getId() != null && sysSerial.getId() != null) {
            sysSerialMapper.updateByPrimaryKeySelective(sysSerial);
        } else {
            sysSerial.setId(IdUtil.createIdByTime());
            sysSerialMapper.insertSelective(sysSerial);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteSysSerialById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            sysSerialMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public SysSerial getSysSerialInfo(String id) throws Exception {

        return sysSerialMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(SysSerialExample example) {
        return sysSerialMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysSerialExample example) {
        return sysSerialMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return sysSerialMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteSysSerialReal(String recordId) {
        return sysSerialMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(SysSerial record) {
        record.setId(IdUtil.createIdByTime());
        return sysSerialMapper.insert(record);
    }

    @Override
    public int insertSelective(SysSerial record) {
        return sysSerialMapper.insertSelective(record);
    }

    public SysSerial insertObject(SysSerial record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<SysSerial> selectByExample(SysSerialExample example) {
        return sysSerialMapper.selectByExample(example);
    }

    @Override
    public SysSerial selectByPrimaryKey(String recordId) {
        return sysSerialMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") SysSerial record, @Param("example") SysSerialExample example) {
        return sysSerialMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") SysSerial record, @Param("example") SysSerialExample example) {
        return sysSerialMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysSerial record) {
        return sysSerialMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysSerial record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return sysSerialMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteSysSerial(Serializable sysSerialId) {
        try {
            SysSerial record = sysSerialMapper.selectByPrimaryKey(sysSerialId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                sysSerialMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findSysSerialByPage(LayuiTableParam param) {
        SysSerialExample example = new SysSerialExample();
        SysSerialExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            SysSerialExample.Criteria criteria2 = example.or();
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
    private LayuiTableData findByExample(LayuiTableParam param, SysSerialExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<SysSerial> list = sysSerialMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<SysSerial> pageInfo = new PageInfo<SysSerial>(list);
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
        SysSerialExample example = new SysSerialExample();
        List<SysSerial> records = sysSerialMapper.selectByExample(example);
        for (SysSerial record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        SysSerialExample sysSerialExample = new SysSerialExample();
        String strParentId = sysSerialMapper.selectByExample(sysSerialExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }

    /**
     * 取号
     *
     * @param flag
     * @return
     */
    public synchronized String getSerialNumber(String flag) {
        String strNum = "";
        //查询
        SysSerialExample example = new SysSerialExample();
//        example.createCriteria().andFlagEqualTo(flag);
        example.setOrderByClause("id asc");

        List<SysSerial> sysSerials = selectByExample(example);
        //取最小值;删除
        if (sysSerials != null && sysSerials.size() > 1) {
            strNum = sysSerials.get(0).getSerialNumber();
            deleteByPrimaryKey(sysSerials.get(0).getId());
        } else if (sysSerials == null || sysSerials.size() == 0) {
            Long l = 1L;
            strNum = l + "";
            //批量插入1000条
            for (int i = 1; i < 20; i++) {
                SysSerial sysSerial = new SysSerial();
                sysSerial.setSerialNumber((l + i) + "");
                insert(sysSerial);
            }
        } else {
            Long l = Long.parseLong(sysSerials.get(0).getSerialNumber());
            strNum = l + "";
            deleteByPrimaryKey(sysSerials.get(0).getId());
            //批量插入1000条
            for (int i = 1; i < 20; i++) {
                SysSerial sysSerial = new SysSerial();
                sysSerial.setSerialNumber((l + i) + "");
                insert(sysSerial);
            }
        }
        return strNum;
    }
}