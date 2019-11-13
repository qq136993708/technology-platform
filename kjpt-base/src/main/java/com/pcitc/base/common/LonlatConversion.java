package com.pcitc.base.common;

import sun.reflect.annotation.TypeAnnotation;

/**
 * @author:Administrator
 * @date:2018/10/11
 */
public class LonlatConversion {
    /**
     * * @param dms 坐标 * @param type 坐标类型 * @return String 解析后的经纬度
     */
    public static String xypase(String dms, String type) {
        if (dms == null || dms.equals("")) {
            return "0.0";
        }
        double result = 0.0D;
        String temp = "";
        if (type.equals("E")) {
            //经度
            String e1 = dms.substring(0, 3);
            //截取3位数字,经度共3位,最多180度//经度是一伦敦为点作南北两极的线为0度,所有往西和往东各180度
            String e2 = dms.substring(3, dms.length());
            //需要运算的小数
            result = Double.parseDouble(e1);
            result += (Double.parseDouble(e2) / 60.0D);
            temp = String.valueOf(result);
            if (temp.length() > 9) {
                temp = e1 + temp.substring(temp.indexOf("."), 9);
            }
        } else if (type.equals("N")) {
//            纬度,纬度是以赤道为基准,相当于把地球分两半,两个半球面上的点和平面夹角0~90度
            String n1 = dms.substring(0, 2);
            //截取2位,纬度共2位,最多90度
            String n2 = dms.substring(2, dms.length());
            result = Double.parseDouble(n1);
            result += Double.parseDouble(n2) / 60.0D;
            temp = String.valueOf(result);
            if (temp.length() > 8) {
                temp = n1 + temp.substring(temp.indexOf("."), 8);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        String info = "(ONE072457A3641.2220N11706.2569E000.000240309C0000400)";
//        info = info.substring(11, info.length() - 13);
//        //纬度
//        String N = info.substring(0, info.indexOf("N"));
//        // 经度
//        String E = info.substring(info.indexOf("N") + 1, info.indexOf("E"));
//        // 请求gis,获取地理信息描述
//        double x = Double.parseDouble(CoordConversion.xypase(E, "E"));
//        double y = Double.parseDouble(CoordConversion.xypase(N, "N"));
//        String result = TypeAnnotation.LocationInfo.getLocationInfo("test", x, y);
//        System.out.println("径度:" + x + "," + "纬度:" + y);
//        System.out.println(result);
    }
}
