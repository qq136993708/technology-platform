package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

public interface ErpOrderMapper {
	
	
	List getErpOrderListByG0PROJCODE(Map map);
	int getErpOrderCountByG0PROJCODE(Map map);
	


}
