package com.pcitc.listener;

import com.pcitc.service.system.SysJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * package: com.pcitc.listener
 * describe: TODO
 * user: yyl
 * date: 2018/5/30
 **/
@Component
public class AppListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private SysJobService sysJobService;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        sysJobService.startJobs();
    }
}
