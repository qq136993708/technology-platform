package com.pcitc.service.doc;

import com.pcitc.base.common.HotWord;

import java.util.List;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
public interface IndexAccessorService {

    /* 创建索引 */
    boolean createIndex(String indexName);

    /* 创建带有number_of_shards和number_of_replicas配置的索引 */
    boolean createIndex(Class clazz);

    /* 创建索引 */
    boolean createIndexWithSettings(Class clazz);

    /* 创建索引 */
    boolean createIndexWithSettings(Class clazz, String json);

    /* 删除索引 */
    boolean deleteIndex(String indexName);

    /* 删除索引 */
    boolean deleteIndex(Class clazz);

    /* 删除type */
    boolean deleteType(String indexName, String typeName);

    boolean deleteType(Class<?> clazz);

    /* 判断索引是否存在 */
    boolean hasIndex(String indexName);


    /* 创建相关表对应的mapping */
    boolean createMapping(Class clazz);
    /* 创建相关表对应的mapping XContentBuilder */
    boolean createMappingXContentBuilder(Class clazz);

    /* 判断相关表对应的mapping是否存在 */
    boolean hasMapping(Class clazz);

    boolean hasMapping(String indexName, String typeName);

    /**
     * 保存查询日志到ES
     * @param obj 对象
     * @param methodName 自定义方法名称,默认为空
     */
    public void saveObjToEs(Object obj,String methodName);
    /**
     * 查询出现的热点词汇
     */
    public List<String> selectHotWord(HotWord hotWord);
}
