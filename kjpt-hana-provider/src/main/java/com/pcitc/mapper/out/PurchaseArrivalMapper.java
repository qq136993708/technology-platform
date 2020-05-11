package com.pcitc.mapper.out;

import java.util.HashMap;
import java.util.List;

import com.pcitc.base.stp.equipment.SrePurchaseArrival;

public interface PurchaseArrivalMapper {

    List<SrePurchaseArrival> getPurchaseArrivalList(HashMap<String, String> map);
}
