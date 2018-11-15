package com.pcitc.service.system;

import com.pcitc.base.system.SysJob;

import java.util.List;
import java.util.Map;

/**
 * package: com.pcitc.service.system
 * describe: 维护系统作业
 * user: yyl
 * date: 2018/5/23
 **/
public interface SysJobService {

    /**
     * 按条件查询
     * @param map
     * @return
     */
    List<SysJob> findSysJob(Map<String, Object> map);

    /**
     * 按id查询
     * @param id
     * @return
     */
    SysJob findSysJobById(String id);
    /**
     * 保存作业
     * @param job
     * @return
     */
    Integer saveSysJob(SysJob job);

    /**
     * 删除一条记录
     * @param dataId
     * @return
     */
    Integer deleteSysJob(String dataId);

    /**
     * 终止作业
     * @param dataId
     * @return
     */
    Integer pauseJob(String dataId);

    /**
     * 继续作业
     * @param dataId
     * @return
     */
    Integer resumeJob(String dataId);

    /**
     * 执行作业
     * @param dataId
     * @return
     */
    Integer executeJob(String dataId);

    /**
     * 启动作业队列
     */
    public void startJobs();
}
