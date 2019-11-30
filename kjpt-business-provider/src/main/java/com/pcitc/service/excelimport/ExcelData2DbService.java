package com.pcitc.service.excelimport;

import java.util.List;

/**
 * @author ty
 */
public interface ExcelData2DbService {
    List excelData2Db(String creator,String pid,String importType, List<List<Object>> dataList);
}
