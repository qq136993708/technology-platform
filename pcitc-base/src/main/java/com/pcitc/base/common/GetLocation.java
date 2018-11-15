package com.pcitc.base.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.net.URL;

/**
 * @author:Administrator
 * @date:2018/10/10
 */
//java根据经纬度获取地址
public class GetLocation {
    public static void main(String[] args) {
        String strlong = ("116° 25' 57.25\"");
        String strlat = ("39° 55' 20.02\"");
        System.out.println(getLocationPosition(strlong,strlat));
    }

    public static String getLocationPosition(String strlong, String strlat) {
        if (strlong==null||strlat==null||"null".equals(strlat)||"null".equals(strlong)){
            return "";
        }
        String add = getAdd(dssConvertlonglat(strlong), dssConvertlonglat(strlat));
        JSONObject jsonObject = JSONObject.parseObject(add);
        JSONArray jsonArray = JSONArray.parseArray(jsonObject.getString("addrList"));
        JSONObject j_2 = (JSONObject) jsonArray.get(0);
        String allAdd = j_2.getString("admName");
        String arr[] = allAdd.split(",");
//        System.out.println("省：" + arr[0] + "\n市：" + arr[1] + "\n区：" + arr[2]);
        return arr[0]+","+arr[1];
    }

    public static double degree(double v1, double v2, double v3) {
        return v1 / 1.0 + v2 / 60.0 + v3 / 3600.0;
    }

    /**
     * 经纬度转换
     *
     * @param strLongLat 经度 纬度
     * @return
     */
    public static String dssConvertlonglat(String strLongLat) {
        double result = 0;
        try {
            String strD = strLongLat.substring(0, strLongLat.indexOf("°"));
            String strM = strLongLat.substring(strLongLat.indexOf(" ") + 1, strLongLat.indexOf("'"));
            String strS = strLongLat.substring(strLongLat.lastIndexOf(" ") + 1, strLongLat.length() - 1);
            result = degree(Double.parseDouble(strD), Double.parseDouble(strM), Double.parseDouble(strS));
            System.out.println("result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result + "";
    }

    public static String getAdd(String log, String lat) {
        //lat 小  log  大
        //参数解释: 纬度,经度 type 001 (100代表道路，010代表POI，001代表门址，111可以同时显示前三项)
        String urlString = "http://gc.ditu.aliyun.com/regeocoding?l=" + lat + "," + log + "&type=010";
        String res = "";
        try {
            URL url = new URL(urlString);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                res += line + "\n";
            }
            in.close();
        } catch (Exception e) {
            System.out.println("error in wapaction,and e is " + e.getMessage());
        }
        System.out.println(res);
        return res;
    }

}


