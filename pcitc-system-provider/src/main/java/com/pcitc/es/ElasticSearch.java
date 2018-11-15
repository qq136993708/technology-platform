package com.pcitc.es;

/**
 * @author:Administrator
 * @date:2018/6/22
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.pcitc.base.doc.es.Article;
import com.pcitc.base.system.SysFile;
import com.pcitc.es.utils.SearchUtil;
import com.thoughtworks.xstream.converters.reflection.ImmutableFieldKeySorter;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
//import org.elasticsearch.search.highlight.HighlightField;
import org.elasticsearch.search.*;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;

// ElasticSearch 测试程序
public class ElasticSearch {

    // 直接在ElasticSearch中建立文档，自动创建索引
    @Test
    public void demo1() throws IOException {
        // 创建ElasticSearch连接对象
        Client client = getElasticSearchClient();
        // 创建对象要添加对象的JSON格式字符串
//        XContentBuilder builder1 = XContentFactory.jsonBuilder();
//                builder1.startObject()
//                .startObject("properties")
//                .startObject("id").field("type","integer").endObject()
//                .startObject("title").field("type","text").field("analyzer","ik_max_word").endObject()
//                .startObject("content").field("type","text").field("analyzer","ik_max_word").endObject()
//                .endObject()
//                .endObject();

//        XContentBuilder builder = XContentFactory.jsonBuilder().startObject()
//                .field("title", "中华人民共和国国歌")
//                .field("content", "它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的，并作为Apache许可条款下的开放源码发布，是当前流行的企业级搜索引擎。设计用于云计算中，能够达到实时搜索，稳定，可靠，快速，安装使用方便。")
//                .endObject();

//        System.out.println(builder1);
//        client.admin().indices().prepareCreate("blog4").get();
//        PutMappingRequest mappingRequest =
//                Requests.putMappingRequest("blog4").type("article").source(builder1);
//        try {
//            client.admin().indices().putMapping(mappingRequest).get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        // 建立文档对象
//        client.prepareIndex("blog4", "article", "2").setSource(builder).get();

        // 关闭连接
        client.close();
    }



    // 搜索在ElasticSearch中创建的文档对象，使用QueryBuilders.matchAllQuery()查询所有
    @Test
    public void demo2() throws UnknownHostException {
        // 创建ElasticSearch连接对象
        Client client = getElasticSearchClient();
        // 手册数据
        SearchResponse searchResponse = client
                .prepareSearch("blog1")
                .setTypes("article")
                .setQuery(QueryBuilders.matchAllQuery()).get();

        printSearchResponse(searchResponse);
        // 关闭连接
        client.close();
    }

    // 使用QueryBuilders.queryStringQuery(搜索内容)进行分词内容查询
    @Test
    public void demo3() throws UnknownHostException {
        // 创建ElasticSearch连接对象
        Client client = getElasticSearchClient();

        // 搜索数据
        SearchResponse searchResponse = client
                .prepareSearch("blog4")
                .setTypes("article")
                .setQuery(QueryBuilders.queryStringQuery("人民")).get();

        printSearchResponse(searchResponse);

        // 关闭连接
        client.close();
    }

    // 使用QueryBuilders.wildcardQuery("搜索范围:如title|content","查询内容")进行范围分词模糊查询
    // *表示任意字符串     ?表示任意字符
    // 查询结果为0条，说明没有词条包含"全文"
    @Test
    public void demo4() throws UnknownHostException {
        // 创建ElasticSearch连接对象
        Client client = getElasticSearchClient();

        // 搜索数据
        SearchResponse searchResponse = client
                .prepareSearch("blog1")
                .setTypes("article")
                .setQuery(QueryBuilders.wildcardQuery("title|content", "全文")).get();

        printSearchResponse(searchResponse);

        // 关闭连接
        client.close();
    }

    // 使用QueryBuilders.termQuery("搜索范围:如title|content","查询内容")进行范围词条查询
    // 查询结果为0条，说明没有"搜索"这个词条
    @Test
    public void demo5() throws UnknownHostException {
        // 创建ElasticSearch连接对象
        Client client = getElasticSearchClient();
        // 搜索数据
        SearchResponse searchResponse = client
                .prepareSearch("blog1")
                .setTypes("article")
                .setQuery(QueryBuilders.termQuery("content", "搜索引擎")).get();
        printSearchResponse(searchResponse);
        // 关闭连接
        client.close();
    }

    // 索引操作 --- 创建与删除
    @Test
    public void demo6() throws UnknownHostException {
        // 创建ElasticSearch连接对象
        Client client = getElasticSearchClient();
        // 创建索引
//        client.admin().indices().prepareCreate("blog2").get();
        // 删除索引
        client.admin().indices().prepareDelete("files").get();
        // 关闭连接
        client.close();
    }

    // 映射操作 --- 创建
    @Test
    public void demo7() throws IOException, ExecutionException, InterruptedException {
        // 创建ElasticSearch连接对象
        Client client = getElasticSearchClient();
        // 添加映射
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .startObject("article")
                .startObject("properties")
                .startObject("id").field("type", "integer").field("store", "yes").endObject()
                .startObject("title").field("type", "string").field("store", "yes").field("analyzer", "ik").endObject()
                .startObject("content").field("type", "string").field("store", "yes").field("analyzer", "ik").endObject()
                .endObject()
                .endObject()
                .endObject();
        PutMappingRequest mapping = Requests.putMappingRequest("blog2")
                .type("article").source(builder);
        client.admin().indices().putMapping(mapping).get();
        // 关闭连接
        client.close();
    }

    // 文档操作 --- 创建
    @Test
    public void demo8() throws IOException, ExecutionException, InterruptedException {
        // 创建ElasticSearch连接对象
        Client client = getElasticSearchClient();

        // 创建jackson解析对象
        ObjectMapper objectMapper = new ObjectMapper();

        for (int i = 1; i <= 100; i++) {
            // 描述json 数据
            /*
             * {id:xxx, title:xxx, content:xxx}
             */
            Article article = new Article();
            article.setId(i);
            article.setTitle(i + "搜索工作其实很难的");
            article.setContent(i + "我们希望我们的搜索解决方案要快，我们希望有一个零配置和一个完全免费的搜索模式，我们希望能够简单地使用JSON通过HTTP的索引数据，我们希望我们的搜索服务器始终可用，我们希望能够一台开始并扩展到数百，我们要实时搜索，我们要简单的多租户，我们希望建立一个云的解决方案。Elasticsearch旨在解决所有这些问题和更多的问题。");

            // 建立文档
            client.prepareIndex("blog2", "article", article.getId().toString())
                    .setSource(objectMapper.writeValueAsString(article)).get();
        }

        // 关闭连接
        client.close();
    }

    // 分页搜索
    @Test
    public void demo11() throws UnknownHostException {
        // 创建ElasticSearch连接对象
        Client client = getElasticSearchClient();

        // 搜索数据
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("blog2")
                .setTypes("article")
                .setQuery(QueryBuilders.matchAllQuery());

        // 通过SearchRequestBuilder的setFrom和setSize方法实现分页
        // 显示第二页的数据，每页显示20条
        searchRequestBuilder.setFrom(2);
        searchRequestBuilder.setSize(20);

        SearchResponse searchResponse = searchRequestBuilder.get();

        printSearchResponse(searchResponse);

        // 关闭连接
        client.close();
    }

    @Test
    public void demo111() throws Exception{
        Client client = getElasticSearchClient();
        SearchResponse response = client.prepareSearch("blog2")
                .setTypes("article")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery("title", "搜索"))                 // Query
//                .setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
                .setFrom(0).setSize(60).setExplain(true)
                .get();
        printSearchResponse(response);
    }

    // 高亮显示
    @Test
    public void demo12() throws IOException {
        // 创建ElasticSearch连接对象
        Client client = getElasticSearchClient();

        ObjectMapper objectMapper = new ObjectMapper();

        // 搜索数据
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("blog1")
                .setTypes("article")
                .setQuery(QueryBuilders.termQuery("title", "服"));

        // 高亮应用的内容
//        searchRequestBuilder.addHighlightedField("title"); // 对title字段进行高亮
//        searchRequestBuilder.setHighlighterPreTags("<em>"); // 前置元素
//        searchRequestBuilder.setHighlighterPostTags("</em>"); // 后置元素

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title");
//        highlightBuilder.preTags("<span style=\"color:red\">");
//        highlightBuilder.postTags("</span>");
        searchRequestBuilder.highlighter(highlightBuilder);

        // 通过SearchRequestBuilder的setFrom和setSize方法实现分页
        // 显示第二页的数据，每页显示20条
        searchRequestBuilder.setFrom(0).setSize(20);

        SearchResponse searchResponse = searchRequestBuilder.get();

        // 获取命中次数，查询结果又多少对象
        SearchHits hits = searchResponse.getHits();
        System.out.println("查询结果有:" + hits.getTotalHits() + "条");
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()) {
            SearchHit searchHit = iterator.next(); //每个查询对象

            // 将高亮处理后的内容，替换原有高亮内容(原有内容，可能会出现显示不全)
            Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
            HighlightField titleField = highlightFields.get("title");
            // 获取到原有内容中的每个高亮显示的集中的位置，fragment就是高亮片段
            Text[] fragments = titleField.fragments();
            String title = "";
            for (Text text : fragments) {
                System.out.println(text);
                title += text;
            }
            // 通过ObjectMapper的readVallue将查询结果转换成Article对象
            System.out.println("searchHit.getSourceAsString() = " + searchHit.getSourceAsString());
            Article article = objectMapper.readValue(searchHit.getSourceAsString(), Article.class);
            // 用高亮后内容，替换原有内容
            article.setTitle(title);
            System.out.println(article);
        }

        // 关闭连接
        client.close();
    }

    // 文档操作 --- 修改
    @Test
    public void demo9() throws IOException, ExecutionException, InterruptedException {
        // 创建ElasticSearch连接对象
        Client client = getElasticSearchClient();

        // 描述json 数据
        /*
         * {id:xxx, title:xxx, content:xxx}
         */
        Article article = new Article();
        article.setId(2);
        article.setTitle("搜索工作其实也不难");
        article.setContent("我们希望我们的搜索解决方案要快，我们希望有一个零配置和一个完全免费的搜索模式，我们希望能够简单地使用JSON通过HTTP的索引数据，我们希望我们的搜索服务器始终可用，我们希望能够一台开始并扩展到数百，我们要实时搜索，我们要简单的多租户，我们希望建立一个云的解决方案。Elasticsearch旨在解决所有这些问题和更多的问题。");

        // 创建jackson解析对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 修改文档 --- 方式一
        //client.prepareUpdate("blog2", "article", article.getId().toString())
        //        .setDoc(objectMapper.writeValueAsString(article)).get();

        // 修改文档 --- 方式二
        client.update(
                new UpdateRequest("blog2", "article", article.getId().toString())
                        .doc(objectMapper.writeValueAsString(article))
        ).get();

        // 关闭连接
        client.close();
    }

    // 文档操作 --- 删除
    @Test
    public void demo10() throws IOException, ExecutionException, InterruptedException {
        // 创建ElasticSearch连接对象
        Client client = getElasticSearchClient();

        Article article = new Article();
        article.setId(2);

        // 删除文档 --- 方式一
        //client.prepareDelete("blog2", "article", article.getId().toString()).get();

        // 删除文档 --- 方式二
        client.delete(
                new DeleteRequest("files", "sysfiletype", article.getId().toString())
        ).get();

        // 关闭连接
        client.close();
    }

    // 遍历打印查询后的结果
    private void printSearchResponse(SearchResponse searchResponse) {
        // 获取命中次数，查询结果又多少对象
        SearchHits hits = searchResponse.getHits();
        System.out.println("查询结果有:" + hits.getTotalHits() + "条");
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()) {
            SearchHit searchHit = iterator.next(); //每个查询对象
            System.out.println(searchHit.getSourceAsString()); //获取字符串格式并打印
//            System.out.println("title:" + searchHit.getSource().get("title"));
            System.out.println("title:" + searchHit.getSourceAsMap().get("title"));
        }
    }

    // 获取ElasticSearcch Client对象
    private Client getElasticSearchClient() throws UnknownHostException {
//        1使用与“elasticsearch”不同的名称，则必须设置群集名称
//        Settings settings = Settings.builder()
//                .put("cluster.name", "elasticsearch").build();
//        TransportClient client = new PreBuiltTransportClient(settings);
//        2启用嗅探，请将client.transport.sniff设置为true
//        Settings settings = Settings.builder()
//                .put("client.transport.sniff", true).build();
//        TransportClient client = new PreBuiltTransportClient(settings);
//        return TransportClient.builder().build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        return client;
    }

    // 高亮显示
    @Test
    public void demo121() throws IOException {
        // 创建ElasticSearch连接对象
        Client client = getElasticSearchClient();
        ObjectMapper objectMapper = new ObjectMapper();
        // 搜索数据

        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("files")
                .setTypes("sysfiletype")
//                .setQuery(QueryBuilders.queryStringQuery("16416ac42d0_eae8965f"));
                .setQuery(QueryBuilders.termQuery("bak4", "教"));

//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.field("bak4");
//        highlightBuilder.preTags("<span style=\"color:red\">");
//        highlightBuilder.postTags("</span>");
//        searchRequestBuilder.highlighter(highlightBuilder);

        // 显示第二页的数据，每页显示20条
        searchRequestBuilder.setFrom(0).setSize(20);
        SearchResponse searchResponse = searchRequestBuilder.get();
        // 获取命中次数，查询结果又多少对象
        SearchHits hits = searchResponse.getHits();
        System.out.println("查询结果有:" + hits.getTotalHits() + "条");
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()) {
            SearchHit searchHit = iterator.next(); //每个查询对象
            // 将高亮处理后的内容，替换原有高亮内容(原有内容，可能会出现显示不全)
            Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
            HighlightField titleField = highlightFields.get("title");
            // 通过ObjectMapper的readVallue将查询结果转换成Article对象
            SysFile sysFile = objectMapper.readValue(searchHit.getSourceAsString(), SysFile.class);
            // 用高亮后内容，替换原有内容
            System.out.println(sysFile);
        }
        // 关闭连接
        client.close();
    }
}