package com.pcitc.service.expert;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.ZjkChoice;
import com.pcitc.base.expert.ZjkChoiceExample;
import com.pcitc.base.expert.ZjkExpert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: zjk_choice - 专家-人员选择</p>
 *
 * @since 2018-12-08 04:10:47
 */
public interface ZjkChoiceService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<ZjkChoice> findZjkChoiceList(ZjkChoice record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertZjkChoice(ZjkChoice record) throws Exception;

    int updateOrInsertZjkChoiceUpdate(ZjkChoice record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteZjkChoiceById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ZjkChoice getZjkChoiceInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(ZjkChoiceExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(ZjkChoiceExample example);

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
    int insert(ZjkChoice record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    ZjkChoice insertObject(ZjkChoice record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(ZjkChoice record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<ZjkChoice> selectByExample(ZjkChoiceExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    ZjkChoice selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") ZjkChoice record, @Param("example") ZjkChoiceExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") ZjkChoice record, @Param("example") ZjkChoiceExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ZjkChoice record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(ZjkChoice record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteZjkChoice(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findZjkChoiceByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteZjkChoiceReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();

    /**
     * 根据IDS查询专家信息
     *
     * @param ids
     * @return
     */
    public List<ZjkExpert> findZjkBaseInofList(List<String> ids);
}