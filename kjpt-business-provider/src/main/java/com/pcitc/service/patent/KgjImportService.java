package com.pcitc.service.patent;


import java.util.List;

/**
 * @author ty
 */
public interface KgjImportService {
    /**
     *科工局Excel数据导入
     * @param dataList
     * @param currentUser
     */
    List kgjImport(List dataList,String currentUser);
}
