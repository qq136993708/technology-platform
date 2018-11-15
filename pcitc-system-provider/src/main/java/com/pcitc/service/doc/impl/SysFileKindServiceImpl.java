package com.pcitc.service.doc.impl;


import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.doc.SysFileKind;
import com.pcitc.base.doc.SysFileKindExample;
import com.pcitc.base.system.SysFile;
import com.pcitc.base.util.IdUtil;
import com.pcitc.mapper.doc.SysFileKindMapper;
import com.pcitc.service.doc.SysFileKindService;
import com.pcitc.service.doc.SysFileShareService;
import com.pcitc.service.system.SysFileService;


/**
 * <p>接口实现类</p>
 * <p>Table: sys_file_kind - </p>
 *
 * @since 2018-06-19 09:24:12
 */
@Service("sysFileKindService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysFileKindServiceImpl implements SysFileKindService {

    @Autowired
    private SysFileKindMapper sysFileKindMapper;

    public List<SysFileKind> findSysFileKindList(SysFileKind sysFileKind) {
        List<SysFileKind> record = sysFileKindMapper.findSysFileKindList(sysFileKind);
        return record;
    }

    @Override
    public int updateOrInsertSysFileKind(SysFileKind sysFileKind) throws Exception {
        int result = 500;
        if (sysFileKind.getId() != null && sysFileKind.getId() != null) {
            sysFileKindMapper.updateByPrimaryKey(sysFileKind);
        } else {
            sysFileKind.setId(IdUtil.createIdByTime());
            sysFileKindMapper.insertSelective(sysFileKind);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteSysFileKindById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            sysFileKindMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public SysFileKind getSysFileKindInfo(String id) throws Exception {

        return sysFileKindMapper.selectByPrimaryKey(id);
    }


    @Override
    public long countByExample(SysFileKindExample example) {
        return sysFileKindMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysFileKindExample example) {
        return sysFileKindMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return sysFileKindMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int deleteSysFileKindReal(String recordId) {
        return sysFileKindMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(SysFileKind record) {
        record.setId(IdUtil.createIdByTime());
        return sysFileKindMapper.insert(record);
    }

    @Override
    public int insertSelective(SysFileKind record) {
        return sysFileKindMapper.insertSelective(record);
    }

    public SysFileKind insertObject(SysFileKind record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<SysFileKind> selectByExample(SysFileKindExample example) {
        return sysFileKindMapper.selectByExample(example);
    }

    @Override
    public SysFileKind selectByPrimaryKey(String recordId) {
        return sysFileKindMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") SysFileKind record, @Param("example") SysFileKindExample example) {
        return sysFileKindMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") SysFileKind record, @Param("example") SysFileKindExample example) {
        return sysFileKindMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysFileKind record) {
        return sysFileKindMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysFileKind record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return sysFileKindMapper.updateByPrimaryKey(record);
    }

    @Override
    public DataOperationStatusEnum deleteSysFileKind(Serializable sysFileKindId) {
        try {
            SysFileKind record = sysFileKindMapper.selectByPrimaryKey(sysFileKindId.toString());
            if (record != null) {
                record.setStatus("0");
                sysFileKindMapper.updateByPrimaryKey(record);
            }
            return DataOperationStatusEnum.DEL_OK;
        } catch (Exception e) {
            return DataOperationStatusEnum.DEL_DATA_ERROR;
        }
    }

    @Override
    public LayuiTableData findSysFileKindByPage(LayuiTableParam param) {
        SysFileKindExample example = new SysFileKindExample();
        SysFileKindExample.Criteria c = example.createCriteria();
        c.andStatusEqualTo("1");
        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
        {
            c.andIdEqualTo(param.getParam().get("fileKind").toString());
//            SysFileKindExample.Criteria criteria2 = example.or();
//            criteria2.andParentIdEqualTo(param.getParam().get("fileKind").toString());
//            example.or(criteria2);
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
    private LayuiTableData findByExample(LayuiTableParam param, SysFileKindExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<SysFileKind> list = sysFileKindMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<SysFileKind> pageInfo = new PageInfo<SysFileKind>(list);
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
//        List<TreeNode> nodes = new ArrayList<TreeNode>();
////        SysFileKindExample example = new SysFileKindExample();
////        example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
////        List<SysFileKind> records = sysFileKindMapper.selectByExample(example);
////        for (SysFileKind record : records) {
////            TreeNode node = new TreeNode();
////            node.setId(record.getId());
////            //            node.setLevelCode(record.getUnitLevel().toString());
////            node.setParentId(record.getParentId());
////            nodes.add(node);
////        }
////        //构建树形结构(从根节点开始的树形结构)
////
////        SysFileKindExample sysFileKindExample = new SysFileKindExample();
////        String strParentId = sysFileKindMapper.selectByExample(sysFileKindExample).get(0).getId();
////        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);
////
////        return orderNodes;
        return null;
    }

    public List<TreeNode> selectTrees() {
        List<TreeNode> list = null;
        try {
            list = sysFileKindMapper.selectTrees();
            for (int i = 0; i < list.size(); i++) {
                TreeNode tree = list.get(i);
                if (tree.getLevelCode() < 10) {
                    tree.setOpen("true");
                } else {
                    tree.setOpen("false");
                }
            }
//            list = TreeNodeUtil.getChildrenNode("1", sysFileKindMapper.selectTrees());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Autowired
    SysFileService sysFileService;
    @Autowired
    SysFileShareService sysFileShareService;

    @Override
    public int updateOrInsertSysFile(SysFileKind sysFileKind) {
        //更新文件表
        int result = 200;
        String strFields = sysFileKind.getFileIds();
        if (strFields==null||strFields.length() == 0) {
            return result;
        }
        String[] arrayFields = strFields.split(",");
        for (int i = 0, j = arrayFields.length; i < j; i++) {

            SysFile sysFile = sysFileService.selectByPrimaryKey(arrayFields[i]);
            try {
                if ("private".equals(sysFile.getBak1()) || "public".equals(sysFile.getBak1())) {
                    sysFileShareService.deleteObjByParam(arrayFields[i]);
                    sysFile.setBak3("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            sysFile.setBak1(sysFileKind.getBak1());
            sysFile.setFilePublish(sysFileKind.getCreatePersonId());
            sysFile.setFileKind(sysFileKind.getParentId());
            sysFile.setBak2(sysFileKind.getCreatePersonName());
            sysFileService.updateByPrimaryKey(sysFile);

        }
        return result;
    }

}