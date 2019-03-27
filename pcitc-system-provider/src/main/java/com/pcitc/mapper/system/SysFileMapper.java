package com.pcitc.mapper.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysFile;
import com.pcitc.base.system.SysFileExample;

public interface SysFileMapper {
    long countByExample(SysFileExample example);

    int deleteByExample(SysFileExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(SysFile record);

    int insertSelective(SysFile record);

    List<SysFile> selectByExample(SysFileExample example);

    SysFile selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") SysFile record, @Param("example") SysFileExample example);

    int updateByExample(@Param("record") SysFile record, @Param("example") SysFileExample example);

    int updateByPrimaryKeySelective(SysFile record);

    int updateByPrimaryKey(SysFile record);

    String selectMaxEsId();

    void updateSysFileFlag(Map<String,String> map);

    void deleteSysFileByDataId(Map<String,String> map);
    
    /**
     * 文档管理的查询方法，查询公共的和分享给自己文件
     */
    public List<SysFile> selectFileListForPublic(HashMap<String, Object> hashmap);
    
    /**
     * 文档收藏的查询方法
     */
    public List<SysFile> selectFileListForCollect(HashMap<String, Object> hashmap);
    
    /**
     * 复制文件数据到sys_file_version中
     */
    public void copySysFile(SysFile record);
    
    /**
     * 获取文件历史版本信息
     */
    public List<SysFile> selectFileHistoryList(HashMap<String, Object> hashmap);
    
    /**
     * 把文件地址、文件名称等信息替换到文档历史版本
     */
    public int updateSysFileHistoryErrorVersion(SysFile sysFile);
}