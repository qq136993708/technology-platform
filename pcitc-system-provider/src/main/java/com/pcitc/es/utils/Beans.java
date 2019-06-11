package com.pcitc.es.utils;

import com.pcitc.service.doc.AccessorService;
import com.pcitc.service.doc.impl.AccessorServiceImpl;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
public class Beans {

    private static AccessorService accessorService = new AccessorServiceImpl();

    public static AccessorService getAccessor()
    {
        return accessorService;
    }
}
