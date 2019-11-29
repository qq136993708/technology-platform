package com.pcitc.base.common;

import java.util.List;

/**
 * Excel统一导入配置
 * @author
 */
public class ExcelImportConfig {

    /**
     * 导入类型
     */
    private String importType;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 过程名
     */
    private String processName;
    /**
     * Excel的列名
     */
    private List<String> excelColName;

    /**
     * 数据库存储的内容
     */
    private String excelColNameDb;
    /**
     * 数据库列名
     */
    private List<String> dbColName;
    /**
     * 数据库存储的内容
     */
    private String dbColNameDb;

    /**
     * 数据
     */
    private List<Object> dataList;

    public String getImportType() {
        return importType;
    }

    public void setImportType(String importType) {
        this.importType = importType;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public List<String> getExcelColName() {
        return excelColName;
    }

    public void setExcelColName(List<String> excelColName) {
        this.excelColName = excelColName;
    }

    public List<String> getDbColName() {
        return dbColName;
    }

    public void setDbColName(List<String> dbColName) {
        this.dbColName = dbColName;
    }

    public List<Object> getDataList() {
        return dataList;
    }

    public void setDataList(List<Object> dataList) {
        this.dataList = dataList;
    }

    public String getExcelColNameDb() {
        return excelColNameDb;
    }

    public void setExcelColNameDb(String excelColNameDb) {
        this.excelColNameDb = excelColNameDb;
    }

    public String getDbColNameDb() {
        return dbColNameDb;
    }

    public void setDbColNameDb(String dbColNameDb) {
        this.dbColNameDb = dbColNameDb;
    }
}
