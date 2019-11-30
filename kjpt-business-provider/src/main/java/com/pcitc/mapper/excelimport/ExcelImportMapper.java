package com.pcitc.mapper.excelimport;

import com.pcitc.base.common.ExcelImportConfig;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author ty
 */
public interface ExcelImportMapper {
    /**
     * excel导入数据进库
     * @param ec
     */
    void excelData2Db(ExcelImportConfig ec);

    /**
     * 获取配置类
     * @param configType
     */
    ExcelImportConfig getConfig(String configType);

    /**
     * 获取配置类
     * @param processName
     * @param batchId
     */
    List handlerData(@Param("processName") String processName,@Param("batchId") String batchId,@Param("pid") String pid,@Param("creatUser") String creatUser,@Param("currentDate") Date currentDate);

}
