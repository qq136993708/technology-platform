package com.pcitc.service.excelimport.impl;

import com.pcitc.base.common.ExcelImportConfig;
import com.pcitc.mapper.excelimport.ExcelImportMapper;
import com.pcitc.service.excelimport.ExcelData2DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author ty
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ExcelData2DbServiceImpl implements ExcelData2DbService {

    @Autowired
    private ExcelImportMapper em;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void excelData2Db(String creator,String pid,String importType, List<List<Object>> dataList) {
        ExcelImportConfig eic = em.getConfig(importType);
        //当前导入数据集合的标识
        String batchId = UUID.randomUUID().toString().replaceAll("-","");
        List excelColList = Arrays.asList(eic.getExcelColNameDb().split(","));
        List dbColList = new ArrayList(Arrays.asList(eic.getDbColNameDb().split(",")));
        eic.setExcelColName(excelColList);
        eic.setDbColName(dbColList);
        eic.getDbColName().add("batch_id");

        for (int i = 0; i < dataList.size(); i++) {
            List list = dataList.get(i);
            list.add(batchId);
            eic.setDataList(list);
            em.excelData2Db(eic);
        }
        em.handlerData(eic.getProcessName(),batchId,pid,creator,new Date());
    }

}
