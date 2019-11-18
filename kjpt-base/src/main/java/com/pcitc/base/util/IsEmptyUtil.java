package com.pcitc.base.util;

import com.pcitc.base.exception.SysException;

import java.util.*;

/**
 * 数据非空校验
 * @author ty
 */
public class IsEmptyUtil {

    //验证为空
    public static <T> void isEmpty(T obj) {
        if(!isNotEmpty(obj)){
            SysException s = new SysException("argument is null");
            s.setCode("101");
            throw s;
        }
    }

    //验证非空
    public static <T> boolean isNotEmpty(T obj){
        if(obj != null){
            if(obj instanceof String){
                //字符串
                return  String.valueOf(obj).trim().length() > 0;
            }else if(obj instanceof ArrayList){
                //集合
                return ((List) obj).size() > 0;
            }else if(obj instanceof HashMap){
                //Map
                return !((Map) obj).isEmpty();
            }else if(obj instanceof HashSet){
                //Set
                return ((Set) obj).size() > 0;
            }else if(obj instanceof byte[]){
                //byte[]
                return ((byte[]) obj).length > 0;
            }else if(obj instanceof short[]){
                //short[]
                return ((short[]) obj).length > 0;
            }else if(obj instanceof int[]){
                //int[]
                return ((int[]) obj).length > 0;
            }else if(obj instanceof long[]){
                //long[]
                return ((long[]) obj).length > 0;
            }else if(obj instanceof String[]){
                //String[]
                return ((String[]) obj).length > 0;
            }else if(obj instanceof Object[]){
                //Object[]
                return ((Object[]) obj).length > 0;
            }else if(obj instanceof Object){
                System.out.println("Object");
                return !"".equals(obj) && !"null".equals(obj);
            }
        }
        return false;
    }

}
