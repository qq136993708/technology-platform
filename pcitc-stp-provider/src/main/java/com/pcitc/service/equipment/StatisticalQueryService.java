package com.pcitc.service.equipment;

import com.netflix.discovery.converters.Auto;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import org.springframework.beans.factory.annotation.Autowired;

public interface StatisticalQueryService {
    LayuiTableData getPurchaseEquipmenList(LayuiTableParam paramsJson) throws Exception;
}
