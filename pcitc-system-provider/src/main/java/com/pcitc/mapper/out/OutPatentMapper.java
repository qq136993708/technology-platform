package com.pcitc.mapper.out;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.stp.out.OutPatent;
import com.pcitc.base.stp.out.OutPatentExample;
import com.pcitc.base.stp.out.OutPatentWithBLOBs;

public interface OutPatentMapper {
    int countByExample(OutPatentExample example);

    int deleteByExample(OutPatentExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutPatentWithBLOBs record);

    int insertSelective(OutPatentWithBLOBs record);

    List<OutPatentWithBLOBs> selectByExampleWithBLOBs(OutPatentExample example);

    List<OutPatent> selectByExample(OutPatentExample example);

    OutPatentWithBLOBs selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutPatentWithBLOBs record, @Param("example") OutPatentExample example);

    int updateByExampleWithBLOBs(@Param("record") OutPatentWithBLOBs record, @Param("example") OutPatentExample example);

    int updateByExample(@Param("record") OutPatent record, @Param("example") OutPatentExample example);

    int updateByPrimaryKeySelective(OutPatentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OutPatentWithBLOBs record);

    int updateByPrimaryKey(OutPatent record);
    
 public void insertOutPatentBatch(List<OutPatentWithBLOBs> list);
    
    public String getMaxImportDate(String remarks);
    
    /**
     * @param nd
     * @return
     * 得到某个年度专利申请/授权数量按专利类型分组
     */
    public List getWXLXInfo(String nd);
    
    /**
     * @param nd
     * @return
     * 得到某个年度各专利类型在各个研究院的分布
     */
    public List getTypeInfoByUnit(String nd);
    
    /**
     * @param nd
     * @return
     * 得到某个年度各专利类型在各个研究院、分公司、集团、外部单位、研发中心的分布
     */
    public List getApplyAgreeCountBySix(String nd);
    
    /**
     * @param nd
     * @return
     * 得到某个年度专利申请/授权数量按专利类型 详情页面
     */
    public List getWXLXDetailsInfo(Map hashmap);
    
    /**
     * @return
     * 得到某个年度各专利类型在各个研究院的分布 详情页面
     */
    public List getTypeInfoByUnitDetails(Map hashmap);
    
    /**
     * @return
     * 领导二级页面，直属研究院，8个院专利申请、授权、发明专利数量
     */
    public List getPatentTypeCountByInstituteForLD(Map hashmap);
    
    
}