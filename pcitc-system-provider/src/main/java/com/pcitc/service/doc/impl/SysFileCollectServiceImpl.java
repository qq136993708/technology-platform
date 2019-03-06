package com.pcitc.service.doc.impl;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.doc.SysFileCollect;
import com.pcitc.base.doc.SysFileCollectExample;
import com.pcitc.base.system.SysFile;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.JsonUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.doc.SysFileCollectMapper;
import com.pcitc.service.doc.SysFileCollectService;
import com.pcitc.service.system.SysFileService;


/**
 * <p>接口实现类</p>
 * <p>Table: sys_file_collect - 文件收藏</p>
 *
 * @since 2018-06-22 09:00:03
 */
@Service("sysFileCollectService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysFileCollectServiceImpl implements SysFileCollectService {

    @Autowired
    private SysFileCollectMapper sysFileCollectMapper;
    
    @Autowired
    private SysFileService sysFileService;

    public List<SysFileCollect> findSysFileCollectList(SysFileCollect sysFileCollect) {
        List<SysFileCollect> record = sysFileCollectMapper.findSysFileCollectList(sysFileCollect);
        return record;
    }

    @Override
    public int updateOrInsertSysFileCollect(SysFileCollect sysFileCollect) throws Exception {
        int result = 500;
        String fileIds = sysFileCollect.getFileId();
        String fileKinds = sysFileCollect.getFileKind();
        String bak1s = sysFileCollect.getBak1();
        String[] fileId = fileIds.split(",");
        
        for (int i = 0; i < fileId.length; i++) {
        	String temFileId = fileId[i];
        	String[] fileKind = fileKinds.split(",");
        	String[] bak1 = bak1s.split(",");
        	// 先把此文件之前配置的收藏记录
        	sysFileCollectMapper.deleteObjByParam(temFileId);
        	
        	for (int j = 0; j < fileKind.length; j++) {
        		SysFileCollect sfc = new SysFileCollect();
        		sfc.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        		sfc.setFileId(temFileId);
        		// 保存文件名称（原文件可能删除）
        		SysFile sysFile = sysFileService.selectByPrimaryKey(temFileId);
        		sfc.setFileKind(fileKind[j]);
        		sfc.setBak1(bak1[j]);
        		sfc.setBak2(sysFile.getFileName());
        		sfc.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
        		sfc.setCreatePersonId(sysFileCollect.getCreatePersonId());
        		sysFileCollectMapper.insertSelective(sfc);
        	}
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteSysFileCollectById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            sysFileCollectMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public SysFileCollect getSysFileCollectInfo(String id) throws Exception {

        return sysFileCollectMapper.selectByPrimaryKey(id);
    }


    @Override
    public long countByExample(SysFileCollectExample example) {
        return sysFileCollectMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysFileCollectExample example) {
        return sysFileCollectMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return sysFileCollectMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int deleteSysFileCollectReal(String recordId) {
        return sysFileCollectMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(SysFileCollect record) {
        record.setId(IdUtil.createIdByTime());
        return sysFileCollectMapper.insert(record);
    }

    @Override
    public int insertSelective(SysFileCollect record) {
        return sysFileCollectMapper.insertSelective(record);
    }

    public SysFileCollect insertObject(SysFileCollect record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<SysFileCollect> selectByExample(SysFileCollectExample example) {
        return sysFileCollectMapper.selectByExample(example);
    }

    @Override
    public SysFileCollect selectByPrimaryKey(String recordId) {
        return sysFileCollectMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") SysFileCollect record, @Param("example") SysFileCollectExample example) {
        return sysFileCollectMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") SysFileCollect record, @Param("example") SysFileCollectExample example) {
        return sysFileCollectMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysFileCollect record) {
        return sysFileCollectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysFileCollect record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return sysFileCollectMapper.updateByPrimaryKey(record);
    }

    @Override
    public DataOperationStatusEnum deleteSysFileCollect(Serializable sysFileCollectId) {
        try {
            SysFileCollect record = sysFileCollectMapper.selectByPrimaryKey(sysFileCollectId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                sysFileCollectMapper.updateByPrimaryKey(record);
            }
            return DataOperationStatusEnum.DEL_OK;
        } catch (Exception e) {
            return DataOperationStatusEnum.DEL_DATA_ERROR;
        }
    }

    @Override
    public PageInfo<SysFileCollect> findSysFileCollectByPage(String jsonStr) {
        int pageLength = 10;
        int startPage = 0;
        Map<String, Object> paramMap = JsonUtil.parseJsonToMap(jsonStr);
        if (paramMap.get("iDisplayLength") != null) {
            pageLength = Integer.parseInt(paramMap.get("iDisplayLength").toString());
        }
        if (paramMap.get("iDisplayStart") != null) {
            startPage = Integer.parseInt(paramMap.get("iDisplayStart").toString());
        }


        startPage = startPage / pageLength + 1;
        // 1、设置分页信息，包括当前页数和每页显示的总计数
        PageHelper.startPage(startPage, pageLength);
//
//        TTestExample example = new TTestExample();
//        com.pcitc.base.system.TTestExample.Criteria c = example.createCriteria();
//        System.out.println(paramMap.get("name"));
//        if(!StrUtil.isBlankOrNull(paramMap.get("name")+"")){
//            c.andNameLike("%"+paramMap.get("name")+"%");
//        }
//        List<SysFileCollect> list =sysFileCollectMapper.selectByExample(example);
        List<SysFileCollect> list = sysFileCollectMapper.findSysFileCollectByPage(paramMap);
        PageInfo<SysFileCollect> pageInfo = new PageInfo<SysFileCollect>(list);
        PageHelper.clearPage();
        return pageInfo;

    }

    /**
     * 树形菜单
     *
     * @return
     */
    @Override
    public List<TreeNode> selectObjectByTree() {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        SysFileCollectExample example = new SysFileCollectExample();
        example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<SysFileCollect> records = sysFileCollectMapper.selectByExample(example);
        for (SysFileCollect record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        SysFileCollectExample sysFileCollectExample = new SysFileCollectExample();
        String strParentId = sysFileCollectMapper.selectByExample(sysFileCollectExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }

    public void deleteObjByParam(String strFileId) {
        sysFileCollectMapper.deleteObjByParam(strFileId);
    }

}