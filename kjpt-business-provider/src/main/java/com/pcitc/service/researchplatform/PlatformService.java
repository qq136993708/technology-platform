package com.pcitc.service.researchplatform;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformInfoModel;

import java.util.List;
import java.util.Map;

/**
 * 科研平台的增删改查
 * @author ty
 */
public interface PlatformService {

    /**
     * 根据主键获取一个平台的信息
     */
    PlatformInfoModel load(String id);
    /**
     * 保存科研平台
     */
    PlatformInfoModel save(PlatformInfoModel platformInfoModel);
    /**
     * 查询科研平台列表分页
     */
    PageInfo query(Map paramMap);

    /**
     * 查询科研平台列表
     */
    List<PlatformInfoModel> queryNoPage(Map paramMap);

    /**
     * 科研平台删除
     */
    Integer delete(String id);

    List<Map> selectPaltinfoCount(Map param);

    /**
     *excel导入
     * @param dataList
     * @param currentUser
     */
    List excelImport(List dataList,String currentUser);



    /**
     * 查询科技材料统计表
     * @param param
     * @return
     */
    PageInfo scienceStatistics(Map param);


}
