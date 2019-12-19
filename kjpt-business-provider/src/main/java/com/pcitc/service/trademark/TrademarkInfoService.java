package com.pcitc.service.trademark;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.trademarkinfo.TrademarkInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>接口类</p>
 * <p>Table: trademark_info - 商标信息</p>
 *
 * @since 2019-11-16 04:10:36
 */
public interface TrademarkInfoService {

    /**
     * 插入商标信息
     *
     * @param trademarkInfo
     * @return
     */
    TrademarkInfo updateOrInsertTrademarkInfo(TrademarkInfo trademarkInfo);

    /**
     * 商标列表分页查询
     *
     * @param param
     * @return
     */
    PageInfo queryTrademarkList(Map param);

    /**
     * 根据id查询商标信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    TrademarkInfo getTrademarkInfo(String id) throws Exception;

    /**
     * 根据id删除商标
     *
     * @param id
     * @return
     */
    Integer deleteTrademark(String id);


    /**
     * 商标列表查询
     * @param param
     * @return
     */
    List queryNoPage(Map param);


}