package com.pcitc.service.system;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysAddress;
import com.pcitc.base.system.SysAddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: sys_address - 省市县地址表</p>
 *
 * @since 2019-02-14 11:01:09
 */
public interface SysAddressService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<SysAddress> findSysAddressList(SysAddress record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertSysAddress(SysAddress record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteSysAddressById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    SysAddress getSysAddressInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(SysAddressExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(SysAddressExample example);

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
    int insert(SysAddress record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    SysAddress insertObject(SysAddress record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(SysAddress record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<SysAddress> selectByExample(SysAddressExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    SysAddress selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") SysAddress record, @Param("example") SysAddressExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") SysAddress record, @Param("example") SysAddressExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysAddress record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysAddress record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteSysAddress(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findSysAddressByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteSysAddressReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}