package com.pcitc.base.annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Document {

    String index();// 索引名

    String type();// 类型名

    boolean init() default true;// 是否允被许初始化

    short shards() default 5;// number_of_shards y

    short replicas() default 1;// number_of_replicas

    String settings() default "";// setting文件
    // Index in() default @Index(name=""); //在model中使用，eg:in =
    // @Index(name="school",replicas=1,shards=5,setting="school"))
}
