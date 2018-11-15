package com.pcitc.service;

import com.pcitc.Application;
import com.pcitc.mysqlMapper.mysql.ReportMysqlMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author:Administrator
 * @date:2018/11/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)// 指定spring-boot的启动类
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
public class ReportServiceTest {

//    @Autowired
//    ReportService reportService;
    @Autowired
    MysqlDbService mysqlDbService;



    @Test
    public void getSql() {
        try {
            String[] tables = new String[]{"out_appraisal","out_reward"};//"out_patent",
            for (int i = 0; i < tables.length; i++) {
                Map<String, Object> map = new HashMap<>();
                System.out.println(tables[i]);
                String strsql = "select * from "+tables[i]+" limit 10";
                System.out.println("strsql = " + strsql);
                map.put("value", strsql);
                List<Map<String, Object>> maps = mysqlDbService.getSql(map);
                String str = "CREATE VIEW hana_"+tables[i]+" AS select ";
                Iterator iter = maps.get(0).entrySet().iterator();
                int leng_column = maps.get(0).entrySet().size();
                int index= 0;
                while (iter.hasNext()) {
                    index++;
                    Map.Entry entry = (Map.Entry) iter.next();
                    Object key = entry.getKey();
                    Object val = entry.getValue();
                    System.out.println("key = " + key);
                    str = str+" "+key+" AS G0_"+key+(index<leng_column?",":"");
                }
                str = str+ " from out_appraisal";
                System.out.println(tables[i]+"    "+str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void generatorCode() {
//        try {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("tableNames","hse_check");
//            sysGeneratorService.generatorCode(jsonObject);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}