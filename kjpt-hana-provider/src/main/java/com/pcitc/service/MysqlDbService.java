package com.pcitc.service;

import java.util.List;
import java.util.Map;

/**
 * @author:Administrator
 * @date:2018/11/6
 */
public interface MysqlDbService {

    List getSql(Map<String, Object> map);

    List getReportListStpDb(Map<String, Object> map);
}
