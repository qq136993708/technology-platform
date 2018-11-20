package com.pcitc.service.out;

import java.util.List;

public interface OutDecisionService {

    
    /**
     * @param nd
     * @return
     * 预算分配,经费预算分析,股份公司总部科技经费预算（建议稿）
     */
	public List getStockCompanyMoneyTable(String nd);
	
}
