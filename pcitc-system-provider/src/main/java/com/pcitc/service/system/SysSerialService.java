package com.pcitc.service.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysSerial;
import com.pcitc.base.system.SysSerialExample;

/**
 * <p>接口类</p>
 * <p>Table: sys_serial - 文件上传-取号</p>
 *
 * @since 2018-08-15 03:34:45
 */
public interface SysSerialService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<SysSerial> findSysSerialList(SysSerial record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertSysSerial(SysSerial record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteSysSerialById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    SysSerial getSysSerialInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(SysSerialExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(SysSerialExample example);

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
    int insert(SysSerial record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    SysSerial insertObject(SysSerial record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(SysSerial record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<SysSerial> selectByExample(SysSerialExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    SysSerial selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") SysSerial record, @Param("example") SysSerialExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") SysSerial record, @Param("example") SysSerialExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysSerial record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysSerial record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteSysSerial(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findSysSerialByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteSysSerialReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();

    /**
     * 取号
     * @param flag
     * @return
     */
    public  String getSerialNumber(String flag);
}