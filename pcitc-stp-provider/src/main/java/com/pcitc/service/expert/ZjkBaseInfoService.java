package com.pcitc.service.expert;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.ZjkExpert;
import com.pcitc.base.expert.ZjkExpertExample;
import com.pcitc.base.system.SysDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>接口类</p>
 * <p>Table: zjk_base_info - 专家-基本信息</p>
 *
 * @since 2018-12-08 04:10:36
 */
public interface ZjkBaseInfoService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<ZjkExpert> findZjkBaseInfoList(ZjkExpert record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertZjkBaseInfo(ZjkExpert record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteZjkBaseInfoById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ZjkExpert getZjkBaseInfoInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(ZjkExpertExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(ZjkExpertExample example);

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
    int insert(ZjkExpert record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    ZjkExpert insertObject(ZjkExpert record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(ZjkExpert record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<ZjkExpert> selectByExample(ZjkExpertExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    ZjkExpert selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") ZjkExpert record, @Param("example") ZjkExpertExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") ZjkExpert record, @Param("example") ZjkExpertExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ZjkExpert record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(ZjkExpert record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteZjkBaseInfo(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findZjkBaseInfoByPage(LayuiTableParam param);

    LayuiTableData findZjkBaseInfoByPageIndex(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteZjkBaseInfoReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();

    public LayuiTableData findByExample(LayuiTableParam param, ZjkExpertExample example);

    /**
     * 图表
     *
     * @param jsonObject
     * @return
     */
    JSONObject echarts(JSONObject jsonObject);

    public Map<String,Object> getResult(Map<String,Object> param);

    /**
     * 获取下一级字典集合
     * @param strParentCode
     * @return
     */
    public List<SysDictionary> getDicSon(String strParentCode);

    public String getDicSonVal(List<SysDictionary> list, String val);

    JSONObject SaveSKMExpert(JSONObject jsonObject);

    JSONObject SaveSKMType(JSONObject jsonObject);

    JSONObject savePatent(JSONObject jsonObject);

    JSONObject saveSKMAchievement(JSONObject jsonObject);
}