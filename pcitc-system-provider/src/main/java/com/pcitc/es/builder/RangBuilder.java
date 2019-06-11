package com.pcitc.es.builder;

import org.apache.lucene.search.Sort;
import org.elasticsearch.index.query.RangeQueryBuilder;

import java.util.List;
import java.util.Map;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
public class RangBuilder {
    private String fild;

    private List<Map<String, Sort>> range;

    private void deal()
    {
        RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder(this.fild);

        // for (){
        //
        // }
        // rangeQueryBuilder.gt()
    }

    public static class Builder
    {
        private String fild;

        private List<Map<String, Sort>> range;

        private RangBuilder rangBuilder = new RangBuilder();

        public Builder setFild(String fild)
        {
            rangBuilder.fild = fild;
            return this;
        }

        public Builder setRange(List<Map<String, Sort>> range)
        {
            rangBuilder.range = range;
            return this;
        }
    }
}
