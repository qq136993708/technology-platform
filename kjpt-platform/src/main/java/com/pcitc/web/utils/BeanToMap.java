package com.pcitc.web.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class BeanToMap<T> {
	  public Map<String,Object> getMap(T entity){
	        //Field[] fields = entity.getClass().getFields();

		  	List<Field> fields = new ArrayList<>() ;
		  	Class tempClass = entity.getClass();
		  	while (tempClass != null){
				fields.addAll(Arrays.asList(tempClass .getDeclaredFields()));
				tempClass = tempClass.getSuperclass();
			}


	        Map<String,Object> map = new HashMap<String,Object>();
	        for (int i = 0; i < fields.size(); i++) {
	            String methodName = getMethodName(fields.get(i).getName());
	            try {
	                Method method = entity.getClass().getMethod(methodName);
	                map.put(fields.get(i).getName(),method.invoke(entity));
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        return map;
	    }

	    public String getMethodName(String fieldName){
	        byte[] buffer = fieldName.getBytes();
	        buffer[0] = (byte)(buffer[0]-32);
	        String name = new String(buffer);
	        return "get"+name;
	    }
}
