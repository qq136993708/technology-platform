package com.pcitc.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.system.SysPostFunction;
import com.pcitc.base.system.SysPostFunctionExample;

public interface SysPostFunctionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_post_function
     *
     * @mbg.generated Wed Jun 20 16:42:28 CST 2018
     */
    long countByExample(SysPostFunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_post_function
     *
     * @mbg.generated Wed Jun 20 16:42:28 CST 2018
     */
    int deleteByExample(SysPostFunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_post_function
     *
     * @mbg.generated Wed Jun 20 16:42:28 CST 2018
     */
    int deleteByPrimaryKey(String relId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_post_function
     *
     * @mbg.generated Wed Jun 20 16:42:28 CST 2018
     */
    int insert(SysPostFunction record);
    /**
     * 
     * @param list
     * @return
     */
    int insertBatch(List<SysPostFunction> list);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_post_function
     *
     * @mbg.generated Wed Jun 20 16:42:28 CST 2018
     */
    int insertSelective(SysPostFunction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_post_function
     *
     * @mbg.generated Wed Jun 20 16:42:28 CST 2018
     */
    List<SysPostFunction> selectByExample(SysPostFunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_post_function
     *
     * @mbg.generated Wed Jun 20 16:42:28 CST 2018
     */
    SysPostFunction selectByPrimaryKey(String relId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_post_function
     *
     * @mbg.generated Wed Jun 20 16:42:28 CST 2018
     */
    int updateByExampleSelective(@Param("record") SysPostFunction record, @Param("example") SysPostFunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_post_function
     *
     * @mbg.generated Wed Jun 20 16:42:28 CST 2018
     */
    int updateByExample(@Param("record") SysPostFunction record, @Param("example") SysPostFunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_post_function
     *
     * @mbg.generated Wed Jun 20 16:42:28 CST 2018
     */
    int updateByPrimaryKeySelective(SysPostFunction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_post_function
     *
     * @mbg.generated Wed Jun 20 16:42:28 CST 2018
     */
    int updateByPrimaryKey(SysPostFunction record);
}