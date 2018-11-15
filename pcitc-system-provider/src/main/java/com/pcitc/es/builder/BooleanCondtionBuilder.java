package com.pcitc.es.builder;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.util.List;
import java.util.Map;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
public class BooleanCondtionBuilder {
    // and
    private Map<String, String> queryMap;

    // and
    private Map<String, String> mustMap;

    // and
    private Map<String, List<Object>> mustMapObj;

    // or
    private Map<String, String> mustNotMap;

    // not
    private Map<String, String> shouldMap;

    // paixu
    private Map<String, SortOrder> sortMap;

    private BoolQueryBuilder boolQueryBuilder = null;

    //高亮
    private Map<String, String> highLightFileds;

    private int start = 0;

    private int row;

    public Map<String, String> getHighLightFileds()
    {
        return highLightFileds;
    }
    public Map<String, String> getMustMap()
    {
        return mustMap;
    }

    public Map<String, String> getMustNotMap()
    {
        return mustNotMap;
    }

    public Map<String, String> getShouldMap()
    {
        return shouldMap;
    }

    public Map<String, SortOrder> getSortMap()
    {
        return sortMap;
    }

    public BoolQueryBuilder getBoolQueryBuilder()
    {
        return boolQueryBuilder;
    }

    public int getStart()
    {
        return start;
    }

    public int getRow()
    {
        return row;
    }

    public BooleanCondtionBuilder deal()
    {
        boolQueryBuilder = QueryBuilders.boolQuery();
        if (this.queryMap != null && this.queryMap.size() > 0)
        {
            BoolQueryBuilder boolQueryBuilder = null;
            boolQueryBuilder = QueryBuilders.boolQuery();
            for (Map.Entry<String, String> entry : this.queryMap.entrySet())
            {
                QueryStringQueryBuilder queryFilterBuilder = new QueryStringQueryBuilder(entry.getValue());
                queryFilterBuilder.defaultField(entry.getKey());
                boolQueryBuilder.should(queryFilterBuilder);
            }
            this.boolQueryBuilder.must(boolQueryBuilder);
        }

        if (this.mustMap != null && this.mustMap.size() > 0)
        {
            BoolQueryBuilder mustTagsBuilder = QueryBuilders.boolQuery();

            for (Map.Entry<String, String> entry : this.mustMap.entrySet())
            {
                mustTagsBuilder.must(QueryBuilders.termQuery(entry.getKey(), entry.getValue()));
            }
            this.boolQueryBuilder.must(mustTagsBuilder);
        }

        if (this.mustMapObj != null && this.mustMapObj.size() > 0)
        {
            BoolQueryBuilder mustTagsBuilder = QueryBuilders.boolQuery();

            for (Map.Entry<String, List<Object>> entry : this.mustMapObj.entrySet())
            {
                mustTagsBuilder.must(QueryBuilders.termsQuery(entry.getKey(), entry.getValue()));

            }
            this.boolQueryBuilder.must(mustTagsBuilder);
        }

        if (this.mustNotMap != null && this.mustNotMap.size() > 0)
        {
            BoolQueryBuilder mustNotTagsBuilder = QueryBuilders.boolQuery();

            for (Map.Entry<String, String> entry : this.mustNotMap.entrySet())
            {
                mustNotTagsBuilder.mustNot(QueryBuilders.termQuery(entry.getKey(), entry.getValue()));

            }
            this.boolQueryBuilder.must(mustNotTagsBuilder);
        }

        if (this.shouldMap != null && this.shouldMap.size() > 0)
        {
            BoolQueryBuilder shoudlTagsBuilder = QueryBuilders.boolQuery();

            for (Map.Entry<String, String> entry : this.shouldMap.entrySet())
            {
                shoudlTagsBuilder.should(QueryBuilders.termQuery(entry.getKey(), entry.getValue()));

            }
            this.boolQueryBuilder.must(shoudlTagsBuilder);
        }

        return this;
    }

    public static class Builder
    {
        private BooleanCondtionBuilder condtionBuilder = new BooleanCondtionBuilder();

        public Builder setSortMap(Map<String, SortOrder> sortMap)
        {
            condtionBuilder.sortMap = sortMap;
            return this;
        }

        public Builder setMustMap(Map<String, String> mustMap)
        {
            condtionBuilder.mustMap = mustMap;
            return this;
        }

        public Builder setMustMapList(Map<String, List<Object>> mustMap)
        {
            condtionBuilder.mustMapObj = mustMap;
            return this;
        }

        public Builder setQueryMap(Map<String, String> queryMap)
        {
            condtionBuilder.queryMap = queryMap;
            return this;
        }

        public Builder setMustNotMap(Map<String, String> mustNotMap)
        {
            condtionBuilder.mustNotMap = mustNotMap;
            return this;
        }

        public Builder setShouldMap(Map<String, String> shouldMap)
        {
            condtionBuilder.shouldMap = shouldMap;
            return this;
        }

        public Builder setStart(int start)
        {
            condtionBuilder.start = start;
            return this;
        }

        public Builder setRow(int row)
        {
            condtionBuilder.row = row;
            return this;
        }

        public Builder setHighLightFileds(Map<String, String> highLightFileds)
        {
            condtionBuilder.highLightFileds = highLightFileds;
            return this;
        }

        public BooleanCondtionBuilder builder()
        {
            return condtionBuilder.deal();
        }

    }

}
