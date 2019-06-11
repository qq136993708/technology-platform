package com.pcitc.web.system;

import com.pcitc.base.system.SysJob;
import com.pcitc.service.system.SysJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * package: com.pcitc.controller
 * describe: TODO
 * user: yyl
 * date: 2018/5/30
 **/
@RestController
@RequestMapping(value = "/job-provider")
public class SysJobProviderClient {
    private final static Logger logger = LoggerFactory.getLogger(SysJobProviderClient.class);

    @Autowired
    private SysJobService sysJobService;

    /**
     * 查询作业列表
     * @param job
     * @return
     */
    @RequestMapping(value = "/findSysJob")
    public List<SysJob> findSysJob(@RequestBody SysJob job){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jobName", job.getJobName());

        return sysJobService.findSysJob(map);
    }

    /**
     * 保存作业
     * @param job
     * @return
     */
    @RequestMapping(value = "/saveSysJob", method = RequestMethod.POST)
    public int saveSysJob(@RequestBody SysJob job){
        int result = 1;
        try {
            sysJobService.saveSysJob(job);
        } catch (Exception ex) {
            result = -1;
            logger.error("保存失败，错误信息："+ex.getMessage());
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * 根据id查询作业
     * @param dataId
     * @return
     */
    @RequestMapping(value = "/getSysJob/{dataId}", method = RequestMethod.POST)
    public SysJob getSysJob(@PathVariable(value = "dataId", required = true) String dataId){
        SysJob job = null;
        try {
            job = sysJobService.findSysJobById(dataId);
        } catch (Exception ex) {
            logger.error("查询失败，错误信息："+ex.getMessage());
            ex.printStackTrace();
        }
        return job;
    }

    /**
     * 删除作业
     * @param dataId
     * @return
     */
    @RequestMapping(value = "/deleteSysJob/{dataId}", method = RequestMethod.POST)
    public Integer deleteSysJob(@PathVariable(value = "dataId", required = true) String dataId){
        return sysJobService.deleteSysJob(dataId);
    }

    /**
     * 终止作业
     * @param dataId
     * @return
     */
    @RequestMapping(value = "/pauseJob/{dataId}", method = RequestMethod.POST)
    public Integer pauseJob(@PathVariable(value = "dataId", required = true) String dataId){
        return sysJobService.pauseJob(dataId);
    }

    /**
     * 继续作业
     * @param dataId
     * @return
     */
    @RequestMapping(value = "/resumeJob/{dataId}", method = RequestMethod.POST)
    public Integer resumeJob(@PathVariable(value = "dataId", required = true) String dataId){
        return sysJobService.resumeJob(dataId);
    }

    /**
     * 执行作业
     * @param dataId
     * @return
     */
    @RequestMapping(value = "/executeJob/{dataId}", method = RequestMethod.POST)
    public Integer executeJob(@PathVariable(value = "dataId", required = true) String dataId){
        return sysJobService.executeJob(dataId);
    }

}
