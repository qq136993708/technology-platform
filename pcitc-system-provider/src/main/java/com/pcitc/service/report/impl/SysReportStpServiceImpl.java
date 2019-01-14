package com.pcitc.service.report.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.report.*;
import com.pcitc.base.report.SysReportStpExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.report.SysReportStpMapper;
import com.pcitc.service.report.SysReportStpService;
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
 * <p>Table: sys_report_stp - </p>
 *
 * @since 2019-01-11 10:46:19
 */
@Service("sysReportStpService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysReportStpServiceImpl implements SysReportStpService {

    @Autowired
    private SysReportStpMapper sysReportStpMapper;

    public List<SysReportStp> findSysReportStpList(SysReportStp sysReportStp) {
        List<SysReportStp> record = sysReportStpMapper.findSysReportStpList(sysReportStp);
        return record;
    }

    @Override
    public int updateOrInsertSysReportStp(SysReportStp sysReportStp) throws Exception {
        int result = 500;
        if (sysReportStp.getDataId() != null && sysReportStp.getDataId() != null) {
            sysReportStpMapper.updateByPrimaryKeySelective(sysReportStp);
        } else {
            sysReportStp.setDataId(IdUtil.createIdByTime());
            sysReportStpMapper.insertSelective(sysReportStp);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteSysReportStpById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            sysReportStpMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public SysReportStp getSysReportStpInfo(String id) throws Exception {

        return sysReportStpMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(SysReportStpExample example) {
        return sysReportStpMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysReportStpExample example) {
        return sysReportStpMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return sysReportStpMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteSysReportStpReal(String recordId) {
        return sysReportStpMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(SysReportStp record) {
        record.setDataId(IdUtil.createIdByTime());
        return sysReportStpMapper.insert(record);
    }

    @Override
    public int insertSelective(SysReportStp record) {
        return sysReportStpMapper.insertSelective(record);
    }

    public SysReportStp insertObject(SysReportStp record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<SysReportStp> selectByExample(SysReportStpExample example) {
        return sysReportStpMapper.selectByExample(example);
    }

    @Override
    public SysReportStp selectByPrimaryKey(String recordId) {
        return sysReportStpMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") SysReportStp record, @Param("example") SysReportStpExample example) {
        return sysReportStpMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") SysReportStp record, @Param("example") SysReportStpExample example) {
        return sysReportStpMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysReportStp record) {
        return sysReportStpMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysReportStp record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return sysReportStpMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteSysReportStp(Serializable sysReportStpId) {
        try {
            SysReportStp record = sysReportStpMapper.selectByPrimaryKey(sysReportStpId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                sysReportStpMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findSysReportStpByPage(LayuiTableParam param) {
        SysReportStpExample example = new SysReportStpExample();
        SysReportStpExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            SysReportStpExample.Criteria criteria2 = example.or();
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
    public LayuiTableData findByExample(LayuiTableParam param, SysReportStpExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<SysReportStp> list = sysReportStpMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<SysReportStp> pageInfo = new PageInfo<SysReportStp>(list);
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
        SysReportStpExample example = new SysReportStpExample();
//        example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<SysReportStp> records = sysReportStpMapper.selectByExample(example);
        for (SysReportStp record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        SysReportStpExample sysReportStpExample = new SysReportStpExample();
        String strParentId = sysReportStpMapper.selectByExample(sysReportStpExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}