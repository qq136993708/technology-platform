package com.pcitc.service.expert;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.expert.ZjkPatentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>接口类</p>
 * <p>Table: zjk_zhuanli - 专家-专利信息</p>
 *
 * @since 2018-12-08 04:10:52
 */
public interface ZjkZhuanliService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<ZjkPatent> findZjkZhuanliList(ZjkPatent record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertZjkZhuanli(ZjkPatent record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteZjkZhuanliById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ZjkPatent getZjkZhuanliInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(ZjkPatentExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(ZjkPatentExample example);

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
    int insert(ZjkPatent record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    ZjkPatent insertObject(ZjkPatent record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(ZjkPatent record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<ZjkPatent> selectByExample(ZjkPatentExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    ZjkPatent selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") ZjkPatent record, @Param("example") ZjkPatentExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") ZjkPatent record, @Param("example") ZjkPatentExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ZjkPatent record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(ZjkPatent record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteZjkZhuanli(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findZjkZhuanliByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteZjkZhuanliReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();

    public List<Map<String, Object>> setKeyWordCss(PageInfo<?> pageInfo, String keywords);
}