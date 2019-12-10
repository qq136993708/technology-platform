package com.pcitc.service.achieve;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveRecord;
import com.pcitc.base.achieve.AchieveSubmit;
import com.pcitc.base.common.Result;

import java.util.Map;

/**
 * @author
 */
public interface AchieveRecordService {
    AchieveRecord load(String id);
    void save(AchieveSubmit as);
    void simpleSave(AchieveSubmit as);
    Integer delete(String ids);
    PageInfo query(Map param);
    
    Integer saveAchieveRecord(AchieveRecord as);
    public Result dealWorkFlow(String id, Map map) throws Exception;
}
