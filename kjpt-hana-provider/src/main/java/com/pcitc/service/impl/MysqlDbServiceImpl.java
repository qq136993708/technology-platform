package com.pcitc.service.impl;

import com.pcitc.mysqlMapper.mysql.ReportMysqlMapper;
import com.pcitc.service.MysqlDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author:Administrator
 * @date:2018/11/6
 */
@Service("mysqlDbService")
public class MysqlDbServiceImpl implements MysqlDbService {

    @Autowired
    ReportMysqlMapper reportMysqlMapper;

    @Override
    public List getReportListStpDb(Map<String, Object> map) {
        return reportMysqlMapper.getReportListStpDb(map);
    }

    public List getSql(Map<String, Object> map) {
        return reportMysqlMapper.getSql(map);
    }

}
