package com.pcitc.mapper.researchplatform;

import com.pcitc.base.researchplatform.PlatformInfoModel;

import java.util.List;
import java.util.Map;

public interface PlatformMapper {

    /**
     * 根据主键获取一个平台的信息
     */
    PlatformInfoModel load(String id);
    /**
     * 保存科研平台
     */
    int add(PlatformInfoModel platformInfoModel);
    /**
     * 查询科研平台列表
     */
    List<PlatformInfoModel> query(Map paramMap);
    List<PlatformInfoModel> queryPlatformListApi(Map paramMap);
    List<PlatformInfoModel> getKyptInfoGrupCountList();
    
    /**
     * 修改科研平台
     */
    int update(PlatformInfoModel platformInfoModel);

    /**
     * 逻辑删
     */
    int delete(String id);

    /**
     * 平台相关项目条数
     */
    List<Map> selectPaltinfoCount(Map param);


    void excelData2MemoryDB(List<PlatformInfoModel> dataList);

    List handlerKyptInfoImport(String batchId);

    /**
     * 查询科技材料统计表
     * @param param
     * @return
     */
    List scienceStatistics(Map param);
    
    List<PlatformInfoModel> getPlatFormList(Map param);
    
    

}
