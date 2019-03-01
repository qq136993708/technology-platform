package com.pcitc.service.doc.impl;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
import com.pcitc.base.doc.SysFileKindAuth;
import com.pcitc.base.doc.SysFileKindAuthExample;
import com.pcitc.base.doc.SysFileKindExample;
import com.pcitc.base.system.SysFile;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.mapper.doc.SysFileKindAuthMapper;
import com.pcitc.mapper.doc.SysFileKindMapper;
import com.pcitc.service.doc.SysFileKindService;
import com.pcitc.service.doc.SysFileShareService;
import com.pcitc.service.system.SysFileService;
import com.pcitc.utils.StringUtils;


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
    
    @Autowired
    private SysFileKindAuthMapper sysFileKindAuthMapper;

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
            sysFileKind.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            sysFileKind.setBak1(sysFileKind.getBak1()+sysFileKind.getId()+"@");
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
        if(param.getParam().get("fileKind") !=null && !StringUtils.isBlank(param.getParam().get("fileKind")+""))
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
    
    /**
     * 文档分类权限分配查询
     */
    public LayuiTableData getSysFileKindUserListData(LayuiTableParam param) {
    	// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		if (param.getParam().get("userName")!=null&&!StringUtils.isBlank(param.getParam().get("userName")+"")) {
			hashmap.put("userName", param.getParam().get("userName"));
		}
		
		if (param.getParam().get("fileKindId")!=null&&!StringUtils.isBlank(param.getParam().get("fileKindId")+"")) {
			hashmap.put("fileKindId", param.getParam().get("fileKindId"));
		} else {
			hashmap.put("fileKindId", "0");
		}
		
		List<SysUser> list = sysFileKindMapper.getSysFileKindUserListData(hashmap);
		
		PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);
		
		System.out.println("2>>>>>>>>>查询分页结果"+pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
    }
    
    /**
     * 删除当前页人员所有的已分配数据，插入新保存的用户(若干条)
     */
    public int saveFileKindAuthUser(SysFileKindAuth sysFileKindAuth) {
    	// 删除当前页用户数据
    	String pageUser = sysFileKindAuth.getBak1();
    	List<String> userList = new ArrayList<String>();
    	String[] userArr = pageUser.split("\\|");
    	userList = Arrays.asList(userArr);
    	
    	SysFileKindAuthExample sfka = new SysFileKindAuthExample();
    	SysFileKindAuthExample.Criteria cri = sfka.createCriteria();
    	cri.andFileKindIdEqualTo(sysFileKindAuth.getFileKindId());
    	cri.andUserIdIn(userList);
    	sysFileKindAuthMapper.deleteByExample(sfka);
    	
    	// 保存新用户
    	String newUser = sysFileKindAuth.getUserId();
    	String[] newUserArr = newUser.split("\\|");
    	for (int i = 0; i < newUserArr.length; i++) {
    		SysFileKindAuth temSFKA = new SysFileKindAuth();
    		temSFKA.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
    		temSFKA.setFileKindId(sysFileKindAuth.getFileKindId());
    		temSFKA.setUserId(newUserArr[i]);
    		temSFKA.setSts("1");
    		temSFKA.setAuditStatus("1");
    		temSFKA.setUpdateDate(sysFileKindAuth.getUpdateDate());
    		temSFKA.setUpdateUser(sysFileKindAuth.getUpdateUser());
    		temSFKA.setCreateDate(sysFileKindAuth.getCreateDate());
    		temSFKA.setCreateUserId(sysFileKindAuth.getCreateUserId());
    		temSFKA.setCreateUser(sysFileKindAuth.getCreateUser());

    		sysFileKindAuthMapper.insert(temSFKA);
    	}
    	
    	return 1;
    }

}