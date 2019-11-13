package com.pcitc.service.expert;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.ZjkExpertProject;
import com.pcitc.base.expert.ZjkExpertProjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: zjk_expert_project - 专家库-科研项目</p>
 *
 * @since 2019-04-02 04:42:39
 */
public interface ZjkExpertProjectService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<ZjkExpertProject> findZjkExpertProjectList(ZjkExpertProject record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertZjkExpertProject(ZjkExpertProject record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteZjkExpertProjectById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ZjkExpertProject getZjkExpertProjectInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(ZjkExpertProjectExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(ZjkExpertProjectExample example);

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
    int insert(ZjkExpertProject record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    ZjkExpertProject insertObject(ZjkExpertProject record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(ZjkExpertProject record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<ZjkExpertProject> selectByExample(ZjkExpertProjectExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    ZjkExpertProject selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") ZjkExpertProject record, @Param("example") ZjkExpertProjectExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") ZjkExpertProject record, @Param("example") ZjkExpertProjectExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ZjkExpertProject record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(ZjkExpertProject record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteZjkExpertProject(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findZjkExpertProjectByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteZjkExpertProjectReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}