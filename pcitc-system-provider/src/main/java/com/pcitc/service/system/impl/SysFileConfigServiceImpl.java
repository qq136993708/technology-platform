package com.pcitc.service.system.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.system.SysFileConfig;
import com.pcitc.base.system.SysFileConfigExample;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.JsonUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.system.SysFileConfigMapper;
import com.pcitc.service.system.SysFileConfigService;

/**
 * <p>接口实现类</p>
 * <p>Table: sys_file_config - InnoDB free: 5120 kB</p>
 *
 * @since 2018-05-12 09:49:59
 */
@Service("sysFileConfig")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysFileConfigServiceImpl implements SysFileConfigService {

    @Autowired
    private SysFileConfigMapper sysFileConfigMapper;

    @Override
    public long countByExample(SysFileConfigExample example) {
        return sysFileConfigMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysFileConfigExample example) {
        return sysFileConfigMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String menuId) {
        return sysFileConfigMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public int deleteSysFileConfigReal(String menuId) {
        return sysFileConfigMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public int insert(SysFileConfig record) {
        if(record.getId()==null||"".equals(record.getId())){
            record.setId(IdUtil.createIdByTime());
        }
        return sysFileConfigMapper.insert(record);
    }

    @Override
    public int insertSelective(SysFileConfig record) {
        return sysFileConfigMapper.insertSelective(record);
    }

    public SysFileConfig insertObject(SysFileConfig record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<SysFileConfig> selectByExample(SysFileConfigExample example) {
        return sysFileConfigMapper.selectByExample(example);
    }

    @Override
    public SysFileConfig selectByPrimaryKey(String menuId) {
        return sysFileConfigMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") SysFileConfig record, @Param("example") SysFileConfigExample example) {
        return sysFileConfigMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") SysFileConfig record, @Param("example") SysFileConfigExample example) {
        return sysFileConfigMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysFileConfig record) {
        return sysFileConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysFileConfig record) {
        return sysFileConfigMapper.updateByPrimaryKey(record);
    }

    @Override
    public DataOperationStatusEnum deleteSysFileConfig(Serializable sysFileConfigId) {
        try {
            SysFileConfig menu = sysFileConfigMapper.selectByPrimaryKey(sysFileConfigId.toString());
            if (menu != null) {
                sysFileConfigMapper.updateByPrimaryKey(menu);
            }
            return DataOperationStatusEnum.DEL_OK;
        } catch (Exception e) {
            return DataOperationStatusEnum.DEL_DATA_ERROR;
        }
    }

    @Override
    public PageInfo<SysFileConfig> findSysFileConfigByPage(String jsonStr) {
        int pageLength = 10;
        int startPage = 0;
        Map<String, Object> paramMap = JsonUtil.parseJsonToMap(jsonStr);
        if (paramMap.get("iDisplayLength") != null) {
            pageLength = Integer.parseInt(paramMap.get("iDisplayLength").toString());
        }
        if (paramMap.get("iDisplayStart") != null) {
            startPage = Integer.parseInt(paramMap.get("iDisplayStart").toString());
        }
        String menuName = (String) paramMap.get("menuName");
        startPage = startPage / pageLength + 1;
        PageHelper.startPage(startPage, pageLength);
        SysFileConfigExample example = new SysFileConfigExample();

        List<SysFileConfig> list = sysFileConfigMapper.selectByExample(example);
        return new PageInfo<SysFileConfig>(list);
    }

    /**
     * 树形菜单
     *
     * @return
     */
    @Override
    public List<TreeNode> selectObjectByTree() {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        SysFileConfigExample example = new SysFileConfigExample();
        List<SysFileConfig> menus = sysFileConfigMapper.selectByExample(example);
        for (SysFileConfig menu : menus) {
            TreeNode node = new TreeNode();
            node.setId(menu.getMenuId());
            //            node.setLevelCode(menu.getUnitLevel().toString());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        SysFileConfigExample sysFileConfigExample = new SysFileConfigExample();
        String strParentId = sysFileConfigMapper.selectByExample(sysFileConfigExample).get(0).getMenuId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }
}