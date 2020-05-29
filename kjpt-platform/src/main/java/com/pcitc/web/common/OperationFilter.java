package com.pcitc.web.common;

import java.lang.annotation.*;

/**
 * @author zhanghaifeng
 * @Date: 2018/5/15
 * 数据过滤和日志记录功能
 */
@Retention(RetentionPolicy.RUNTIME)//注解会在class中存在，运行时可通过反射获取
@Target(ElementType.METHOD)//目标是方法
@Documented
public @interface OperationFilter {
    
	/**
     * 模块名字
     */
    String modelName() default "";

    /**
     * 操作类型
     */
    String actionName() default "";
    
    /**
     * 归属菜单code
     */
    String dataFlag() default "";
    
    /**
     * 权限控制flag，标注这个说明要进行菜单功能控制
     */
    String authFlag() default "";

}