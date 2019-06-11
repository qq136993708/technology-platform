package com.pcitc.base.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.JsonKvBean;
import com.pcitc.base.common.enums.DataVersionEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.enums.FlowStatusEnum;

public class MyBeanUtils extends BeanUtils {

    /**
     * 忽略值为空的属性
     *
     * @param src
     * @param target
     */
    public static void copyPropertiesIgnoreNull(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    /**
     * 获得对象中值为空的属性列表
     *
     * @param source
     * @return
     */
    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 为指定对象的属性赋值
     *
     * @param entity
     * @param pro
     * @param val
     */
    public static void setPropertyVal(Object entity, String pro, Object val) {
        try {
            Field f = entity.getClass().getDeclaredField(pro);
            f.setAccessible(true);
            f.set(entity, val);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    /**
     * 根据类创建对象
     *
     * @param c
     * @return
     */
    public static <T> Object createBean(Class<?> c) {
        Constructor<?> constructor;
        try {
            constructor = c.getConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 创建一个默认对象，包含UUID，数据版本，删除状态，创建时间，更新时间
     *
     * @param c
     * @return
     */
    public static Object createDefaultModel(Class<?> c) {
        Object obj = null;
        try {
            obj = createBean(c);
            setDefaultModel(obj);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return obj;
    }

    /**
     * 创建一个默认对象，包含UUID，数据版本，删除状态，创建时间，更新时间
     *
     * @param c
     * @return
     */
    public static void setDefaultModel(Object obj) {
        try {
            //基础数据
        	setPropertyVal(obj, "dataId", IdUtil.createIdByTime());
            setPropertyVal(obj, "dataUuid", UUID.randomUUID().toString());
            setPropertyVal(obj, "delFlag", DelFlagEnum.STATUS_NORMAL.getCode());
            setPropertyVal(obj, "dataVersion", DataVersionEnum.DATA_VERSION_1_0.getVersion());
            setPropertyVal(obj, "createTime", DateUtil.format(new Date(), DateUtil.FMT_SS));
            setPropertyVal(obj, "updateTime", DateUtil.format(new Date(), DateUtil.FMT_SS));
            //工作流开始状态
            setPropertyVal(obj, "flowStartStatus", FlowStatusEnum.FLOW_START_STATUS_NO.getCode());
            setPropertyVal(obj, "flowEndStatus", FlowStatusEnum.FLOW_END_STATUS_NO.getCode());
            setPropertyVal(obj, "flowCurrentStatus", FlowStatusEnum.FLOW_CURRENT_STATUS_ON.getCode());
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    /**
     * 将类型如{name:"aa",value:"bb"} 格式的json对象转换为Map<"aa","bb">
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> priseKVJSONToMap(List<Object> obj) {
        JSONArray array = JSONArray.parseArray(JSONArray.toJSONString(obj));
        Map<String, Object> map = new HashMap<String, Object>();
        for (java.util.Iterator<?> iter = array.iterator(); iter.hasNext(); ) {
            Object k_v = iter.next();
            JSON jsonObje = JSON.parseObject(k_v.toString());
            JsonKvBean bean = JSON.toJavaObject(jsonObje, JsonKvBean.class);
            map.put(bean.getName(), bean.getValue());
        }
        return map;
    }

    public static void transMap2Bean(Map<String, Object> map, Object obj) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    // 得到property对应的setter方法
                    Method setter = property.getWriteMethod();
                    try {
                        setter.invoke(obj, value);
                    } catch (Exception e) {
                        System.out.println("transMap2Bean Error " + e+key);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("transMap2Bean Error " + e);
        }
        return;
    }

    public static Map<String, Object> transBean2Map(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                try {
                    String key = property.getName();
                    if (!key.equals("class")) {
                        Method getter = property.getReadMethod();
                        Object value = getter.invoke(obj);
                        map.put(key, value);
                    }
                } catch (Exception e) {
                    System.out.println("transMap2Bean Error " + e);
                }
            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }
        return map;
    }

    public static Map<?, ?> listToMap(String property, List<?> list) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        for (Object obj : list) {
            Map<String, Object> mp = transBean2Map(obj);
            map.put(mp.get(property), obj);
        }
        return map;
    }

    /**
     * javabean为true，返回java2Map，否则把javabean强制转义为map
     * @param javaBean
     * @return
     */
    @SuppressWarnings("unchecked")
	public static Map<String,Object> java2Map(Object javaBean) {
        Map<String,Object> map = transBean2Map(javaBean);
        return map.containsKey("empty") ? (Map<String,Object>)javaBean : map;
    }
}
