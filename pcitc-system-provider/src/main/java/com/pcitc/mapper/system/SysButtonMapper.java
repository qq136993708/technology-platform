package com.pcitc.mapper.system;

import com.pcitc.base.system.SysButton;
import com.pcitc.base.system.SysButtonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysButtonMapper {
    int countByExample(SysButtonExample example);

    int deleteByExample(SysButtonExample example);

    int insert(SysButton record);

    int insertSelective(SysButton record);

    List<SysButton> selectByExample(SysButtonExample example);

    int updateByExampleSelective(@Param("record") SysButton record, @Param("example") SysButtonExample example);

    int updateByExample(@Param("record") SysButton record, @Param("example") SysButtonExample example);
    
    /**
     * 查询菜单的按钮列表
     * @param button
     * @return
     */
    List<SysButton> selectButtonList(SysButton button);
    
    /**
     * 按钮详情
     * @param id
     * @return
     */
    SysButton getButtonInfoById(String id);
    
    /**
     * 删除
     * @param id
     * @return
     */
    int deleteById(String id);
    
    /**
     * 查询已知菜单数量
     * @param functionId
     * @param name
     * @return
     */
    int selectCountSameName(@Param("functionId") String functionId,@Param("name") String name,@Param("id") String id);
    
    /**
     * 按钮绑定菜单id
     * @param functionId
     * @return
     */
    int updateByFunctionId(@Param("functionId") String functionId);
}