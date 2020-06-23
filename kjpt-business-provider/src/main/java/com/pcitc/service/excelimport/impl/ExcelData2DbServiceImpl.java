package com.pcitc.service.excelimport.impl;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ExcelImportConfig;
import com.pcitc.mapper.excelimport.ExcelImportMapper;
import com.pcitc.service.excelimport.ExcelData2DbService;
import org.apache.commons.lang3.StringUtils;
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
    public List excelData2Db(String creator,String pid,String importType, List<List<Object>> dataList) {
        ExcelImportConfig eic = em.getConfig(importType);
        //当前导入数据集合的标识
        String batchId = UUID.randomUUID().toString().replaceAll("-","");
        List excelColList = Arrays.asList(eic.getExcelColNameDb().split(","));
        List dbColList = new ArrayList(Arrays.asList(eic.getDbColNameDb().split(",")));
        eic.setExcelColName(excelColList);
        eic.setDbColName(dbColList);
        //eic.getDbColName().add("batch_id");

        int count = 0;
        //过滤空数据
        List<List<Object>> realList = new ArrayList<List<Object>>();
        for(List<Object> tmp : dataList){
            if("international_standardImp".equals(importType) || "standardImp".equals(importType)){ //国际、国际标准维护
                if((tmp.get(0)==null || "".equals(tmp.get(0))) && (tmp.get(1)==null || "".equals(tmp.get(1))) && (tmp.get(2)==null || "".equals(tmp.get(2))) && (tmp.get(3)==null || "".equals(tmp.get(3)))){
                    continue;
                }else{
                    realList.add(tmp);
                }
            }else{
                realList.add(tmp);
            }
        }


        for (int i = 0; i < realList.size(); i++) {
            List list = realList.get(i);
            list.add(batchId);
            list.add(i+1);
            eic.setDataList(list);
            System.out.println("excel row============================================================="+JSONObject.toJSONString(list));

            count++;
            if(count > 200 || i == realList.size() -1) {
                List<List<Object>> listData = realList.subList(i - count + 1, i + 1);
                eic.setDataList(listData);
                em.excelData2Db(eic);
                count = 0;
            }


           // em.excelData2Db(eic);
        }
         return em.handlerData(eic.getProcessName(),batchId,pid,creator,new Date());
    }

}
