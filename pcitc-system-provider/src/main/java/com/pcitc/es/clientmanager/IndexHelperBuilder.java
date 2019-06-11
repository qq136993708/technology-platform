package com.pcitc.es.clientmanager;

import com.pcitc.service.doc.IndexAccessorService;
import com.pcitc.service.doc.impl.IndexAccessorServiceImpl;
import org.elasticsearch.client.transport.TransportClient;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
public class IndexHelperBuilder {
    private static TransportClient client;

    public static class Builder {
        private IndexHelperBuilder builder;


        public Builder withClient(TransportClient client) {
            IndexHelperBuilder.client = client;
            return this;
        }


        public IndexAccessorService creatAccessor() {
            return new IndexAccessorServiceImpl(client);
        }

    }
}
