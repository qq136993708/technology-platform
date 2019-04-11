package com.pcitc.service.system;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysNews;
import com.pcitc.base.system.SysNewsExample;
import com.pcitc.base.system.SysNewsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: sys_news - 系统新闻表</p>
 *
 * @since 2019-04-04 10:25:32
 */
public interface SysNewsService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<SysNews> findSysNewsList(SysNews record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertSysNews(SysNews record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteSysNewsById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    SysNews getSysNewsInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(SysNewsExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(SysNewsExample example);

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入信息
     *
     * @param record
     * @return
     */
    int insert(SysNews record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    SysNews insertObject(SysNews record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(SysNews record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<SysNews> selectByExample(SysNewsExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    SysNews selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") SysNews record, @Param("example") SysNewsExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") SysNews record, @Param("example") SysNewsExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysNews record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysNews record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteSysNews(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findSysNewsByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteSysNewsReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();

    public List<SysNewsVo> selectNewsMain(SysNewsVo news) throws Exception;

    List<SysNews> getNewsIndexType(SysNews sysNews);
}