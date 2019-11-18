package com.pcitc.service.trademark;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.trademarkinfo.TrademarkInfo;

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
    int updateOrInsertTrademarkInfo(TrademarkInfo trademarkInfo);

    /**
     * 商标列表分页查询
     *
     * @param param
     * @return
     */
    LayuiTableData queryTrademarkList(LayuiTableParam param);

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
}