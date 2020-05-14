package com.pcitc.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

public class SpringContextUtil {
	  //spring上下文
	
	@Autowired
    private static ApplicationContext applicationContext;
    
    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     * @param applicationContext
     */
    public static void setApplicationContext(ApplicationContext applicationContext){
        if(null==SpringContextUtil.applicationContext)
            SpringContextUtil.applicationContext=applicationContext;
    }
    
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
     /**
     * 通过name获取 Bean.
     *
     * @param name
     * @return
     */
    public static Object getBean(String name) {
    	
    	 System.out.println("----------getApplicationContext------------"+getApplicationContext());
    	 
        return getApplicationContext().getBean(name);
    }
}
