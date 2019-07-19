package com.pcitc.service.doc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.elasticsearch.action.admin.cluster.state.ClusterStateResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcitc.es.clientmanager.ClientFactoryBuilder;
import com.pcitc.es.utils.SearchUtil;
import com.pcitc.service.doc.IndexAccessorService;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
@Service("indexAccessorService")
public class IndexAccessorServiceImpl implements IndexAccessorService {
    private static Logger LOG = Logger.getLogger(String.valueOf(IndexAccessorServiceImpl.class));

    private static TransportClient client;
    
    @Autowired
    private ClientFactoryBuilder clientFactoryBuilder;

    public IndexAccessorServiceImpl() {
        try {
            if (client == null) {
            	System.out.println("IndexAccessorServiceImpl:初始化client ");
                client = clientFactoryBuilder.getClient();
            }
        } catch (Exception e) {
            System.out.println("IndexAccessorServiceImpl:连接es客户端异常 ");
//            e.printStackTrace();
        }
    }

    public IndexAccessorServiceImpl(TransportClient cv) {

        client = cv;
    }

    /* 使用系统默认配置创建索引 */
    @Override
    public boolean createIndex(String indexName) {
        boolean bool = client.admin().indices().prepareCreate(indexName).execute().actionGet().isAcknowledged();
        if (bool) {
            LOG.info("使用默认配置创建索引\"" + indexName + "\"成功！");
        } else {
            throw new RuntimeException("创建索引\"" + indexName + "\"失败！");
        }
        return bool;
    }

    /* 创建带有number_of_shards和number_of_replicas配置的索引 */
    @Override
    public boolean createIndex(Class clazz) {
        Settings indexSettings = Settings.builder()
                .put("number_of_shards", SearchUtil.getShards(clazz))
                .put("number_of_replicas", SearchUtil.getReplicas(clazz))
                .build();
        String indexName = SearchUtil.getIndexName(clazz);

        if(this.hasIndex(indexName)){
            return true;
        }
        CreateIndexRequest indexRequest = new CreateIndexRequest(indexName, indexSettings);
        boolean bool = client.admin().indices().create(indexRequest).actionGet().isAcknowledged();
        if (bool) {
            LOG.info("创建索引\"" + indexName + "\"成功");
        } else {
            // LOG.warn("创建索引:" + indexName + "失败！");
            throw new RuntimeException("创建索引\"" + indexName + "\"失败");
        }
        return bool;
    }

    /* 创建索引 */
    @Override
    public boolean createIndexWithSettings(Class clazz) {
        String indexName = SearchUtil.getIndexName(clazz);
        if(this.hasIndex(indexName)){
            return true;
        }
        String settings = SearchUtil.getSettings(clazz);
        if (settings == null) {
            createIndex(clazz);
        } else {
            createIndexWithSettings(indexName, settings);
        }
        return false;
    }


    /* 创建索引 */
    @Override
    public boolean createIndexWithSettings(Class clazz, String json) {
        String indexName = SearchUtil.getIndexName(clazz);
        String settings = json;
        // 如果settings为null(settings.yml文件不存在)，则使用带
        // 有number_of_shards和number_of_replicas配置的创建索引
        if (settings == null) {
            createIndex(clazz);
        } else {
            createIndexWithSettings(indexName, settings);
        }
        return false;
    }

    private boolean createIndexWithSettings(String indexName, String settings) {
        LOG.info("settings内容：" + settings);
        if(this.hasIndex(indexName)){
            return true;
        }
        boolean bool = false;
        try {
            bool = client.admin()
                    .indices()
                    .prepareCreate(indexName)
                    .setSettings(Settings.builder().build().getAsSettings(settings))
                    .execute()
                    .actionGet()
                    .isAcknowledged();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (bool) {
            LOG.info("使用settings创建索引\"" + indexName + "\"成功！");
        } else {
            // LOG.warn("创建索引:" + indexName + "失败！");
            throw new RuntimeException("创建索引\"" + indexName + "\"失败,可能的问题：您的settings配置不正确！");
        }
        return bool;
    }


    /* 删除索引 */
    @Override
    public boolean deleteIndex(String indexName) {
        return deleteIndexByName(indexName);
    }

    /**
     * @Author cyy
     * @Date 2018/4/12 16:38
     * @Description 通过index 删除索引
     */
    private boolean deleteIndexByName(String indexName) {
        try {
            boolean bool = client.admin().indices().prepareDelete(indexName).execute().actionGet().isAcknowledged();
            LOG.info("删除索引\"" + (bool ? indexName + "\"成功" : "失败"));
            return bool;
        } catch (Exception e) {
            LOG.warning("没有要删除的索引\"" + indexName + "\"");
            return false;
        }

    }

    @Override
    public boolean deleteIndex(Class clazz) {

        String indexName = SearchUtil.getIndexName(clazz);
        return deleteIndexByName(indexName);
    }

    @Override
    public boolean deleteType(String indexName, String typeName) {
        return false;
    }

    /* 判断索引是否存在 */
    @Override
    public boolean hasIndex(String indexName) {
        boolean indexExists = client.admin().indices().prepareExists(indexName).execute().actionGet().isExists();
        LOG.info("存在性检测====>索引\"" + indexName + (indexExists ? "\"存在" : "\"不存在"));
        return indexExists;
    }

    @Override
    public boolean createMapping(Class clazz) {
        try {
            String indexName = SearchUtil.getIndexName(clazz);
            String typeName = SearchUtil.getTypeName((clazz));
            String mapping = SearchUtil.getMapping(clazz);

//            RestHighLevelClient client = new RestHighLevelClient(
//                    RestClient.builder(
//                            new HttpHost("localhost", 9200, "http"),
//                            new HttpHost("localhost", 9201, "http")));
//            CreateIndexRequest request = new CreateIndexRequest(indexName);//创建索引
//            request.settings(Settings.builder()
//                    .put("index.number_of_shards", 3)
//                    .put("index.number_of_replicas", 2)
//            );
//            request.mapping(typeName,//类型定义
//                    SearchUtil.getMapping(clazz),//类型映射，需要的是一个JSON字符串
//                    XContentType.JSON);
//            try {
//                CreateIndexResponse createIndexResponse = client.indices().create(request);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            client.close();
            //创建映射
            PutMappingRequest mappingRequest =Requests.putMappingRequest(indexName).type(typeName).source(mapping);
            client.admin().indices().putMapping(mappingRequest).get();
            LOG.info("创建mapping\"" + typeName + "\"成功");
            return true;
        } catch (Exception e) {
            LOG.info("创建mapping 发生异常：异常信息" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean createMappingXContentBuilder(Class clazz) {
        try {
            String indexName = SearchUtil.getIndexName(clazz);
            String typeName = SearchUtil.getTypeName((clazz));
            XContentBuilder mapping = SearchUtil.getMappingXContentBuilder(clazz);
            //创建映射
            PutMappingRequest mappingRequest =Requests.putMappingRequest(indexName).type(typeName).source(mapping);
            client.admin().indices().putMapping(mappingRequest).get();
            LOG.info("创建XContentBuilder-mapping\"" + typeName + "\"成功");
            return true;
        } catch (Exception e) {
            LOG.info("创建创建XContentBuilder-mapping 发生异常：异常信息" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean hasMapping(Class clazz) {
        String indexName = SearchUtil.getIndexName(clazz);
        String typeName = SearchUtil.getTypeName((clazz));
        return hasMapping(indexName, typeName);
    }

    @Override
    public boolean hasMapping(String indexName, String typeName) {
        ClusterStateResponse clusterStateResponse = client.admin().cluster().prepareState().execute().actionGet();
        MappingMetaData mappingMetaData =
                clusterStateResponse.getState().getMetaData().index(indexName).getMappings().get(typeName);
        boolean mappingExists = mappingMetaData != null ? true : false;
        LOG.info("存在性检测====>" + (mappingExists ? "mapping \"" + indexName + "/" + typeName + "\"存在"
                : "mapping：" + indexName + "/" + typeName + "不存在！"));
        return mappingExists;
    }

    @Override
    public boolean deleteType(Class clazz) {
        return deleteType(SearchUtil.getIndexName(clazz), SearchUtil.getTypeName(clazz));
    }

    /**
     * 查询出现的热点词汇
     */
    public void selectHotWord(){
        //获取搜索日志
        TransportClient client = clientFactoryBuilder.getClient();
        SearchRequestBuilder requestBuilder = client.prepareSearch("files").setTypes("sysfiletype").setQuery(QueryBuilders.matchAllQuery());

        String source = "{\"sysfiletype\":{\"properties\":{\"filePath\":{\"type\":\"text\",\"fielddata\":true}}}}";
        client.admin().indices().preparePutMapping("files")
                .setType("sysfiletype")
                .setSource(source, XContentType.JSON)
                .get();

        //聚合分析查询出现次数最多的10个词汇
        SearchResponse actionGet = requestBuilder.addAggregation(AggregationBuilders.terms("hotWord").field("fileName").size(10)).execute().actionGet();
        //获取分析后的数据
        Aggregations aggregations = actionGet.getAggregations();
        Terms trem = aggregations.get("hotWord");
        List<Terms.Bucket> buckets = (List<Terms.Bucket>) trem.getBuckets();
//        List<Terms.Bucket> buckets = trem.getBuckets();
        List<String> hotWords = new ArrayList<>();
        for (Terms.Bucket bucket : buckets) {
            String key = (String) bucket.getKey();
            hotWords.add(key);
            System.out.println("热点:"+key);
        }
        System.out.println("完成");
        System.out.println(hotWords);
    }
}
