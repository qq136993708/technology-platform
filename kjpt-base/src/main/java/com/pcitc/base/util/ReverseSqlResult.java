package com.pcitc.base.util;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.collections.list.TreeList;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author:Administrator
 * @date:2018/12/12
 */
public class ReverseSqlResult {
    public static void main(String[] args) throws Exception {
        List<Map<String, Object>> maps = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        maps.add(map);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("a", "11");
        map1.put("b", "12");
        maps.add(map1);

        String[][] data = listToArray(maps);
//
//        String data[][] = new String[][]{{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        System.out.println("原数组:");
        print(data);
        System.out.println("置换后的数组:");
        print(reverdraSort(data));
    }

    public static String[][] listToArray(List<Map<String, Object>> maps) {
        if (maps == null || maps.size() == 0) {
            return null;
        }
        int j = 0;
        String data[][] = new String[maps.size()][maps.get(0).size()];
        for (int i = 0; i < maps.size(); i++) {
            Map<String, Object> map = maps.get(i);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                data[i][j] = (entry.getValue() == null ? "" : entry.getValue().toString());
                j++;
            }
            j = 0;
        }
        return  data;
    }


    // 二维数组列行倒置排序法
    public static String[][] reverdraSort(String arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[i].length; j++) {
                if (i != j) {
                    String temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }
        return arr;
    }

    // 打印方法
    public static void print(String arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "、");
            }
            System.out.println();
        }
        System.out.println();
    }
    /**
     * <获取参数map>
     *
     * @return 参数map
     * @throws Exception
     */
    public static Map<String, Object> getParameterMap(HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, String[]> tempMap = request.getParameterMap();
        Set<String> keys = tempMap.keySet();
        for (String key : keys) {
            byte source [] = request.getParameter(key).getBytes("iso8859-1");
            String modelname = new String (source,"UTF-8");
            resultMap.put(key,(modelname==null)?"":modelname);
        }
        return resultMap;
    }

}
