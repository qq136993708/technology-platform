package com.pcitc.service;

import com.pcitc.Application;
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
public class MysqlDbServiceTest {

    @Autowired
    MysqlDbService mysqlDbService;



    @Test
    public void getSql() {
        try {
            String strsql = 	"SELECT column_name DIMENSION_NAME,  data_type COLUMN_SQL_TYPE,  column_comment DIMENSION_CAPTION, column_key columnKey,  extra FROM information_schema.COLUMNS WHERE table_name = 'temp_hana_appraisal_project'";
            String[] tables = new String[]{"out_patent","out_appraisal","out_reward","temp_hana_appraisal_project"};//
            String[] tablesName = new String[]{"专利","成果","奖励","成果立项"};//
//            for (int i = 0; i < tables.length; i++) {

                Map<String, Object> map = new HashMap<>();
//                strsql = (i==(tables.length-1)?strunion:strsql);
                System.out.println("strsql = " + strsql);
                map.put("value", strsql);
                List<Map<String, Object>> maps = mysqlDbService.getSql(map);
                String str = "CREATE VIEW hana_temp_hana_appraisal_project" + " AS select ";
            System.out.println("maps = " + maps);
            for (int i = 0; i < maps.size(); i++) {
                Object key = maps.get(i).get("DIMENSION_NAME");
                str = str + " " + key + " AS G0_" + key.toString().toUpperCase() + (i < (maps.size()-1) ? "," : "");
            }
                str = str + " from temp_hana_appraisal_project";
                System.out.println("结果"+"  \n  " + str);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}