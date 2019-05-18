package com.pcitc.config;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.pcitc.listener.TaskAssignedListener;
import com.pcitc.listener.TaskCompletedListener;
import com.pcitc.listener.TaskCreatedListener;


/**
 * 工作流配置类
 * @author zhf
 * 2018-11-28
 *
 */
@Configuration
@EnableAutoConfiguration
public class ActivitiConfig {
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	@Autowired
	DruidDataSource druidDataSource;
	
	@Autowired
	TaskCreatedListener taskCreatedListener;
	
	@Autowired
	TaskCompletedListener taskCompletedListener;
	
	@Autowired
	TaskAssignedListener taskAssignedListener;
	
	@Bean
    public SpringProcessEngineConfiguration processEngineConfiguration() throws IOException {
		System.out.println("开始配置activiti的配置");
		SpringProcessEngineConfiguration configuration = new SpringProcessEngineConfiguration();
		Map<String, List<ActivitiEventListener>> typedListeners = new HashMap<>();
		configuration.setDataSource(druidDataSource);
		configuration.setTransactionManager(transactionManager);
		configuration.setDatabaseType("mysql");
		configuration.setDatabaseSchemaUpdate("true");
		configuration.setLabelFontName("SimSun");
		configuration.setActivityFontName("SimSun");
		configuration.setAnnotationFontName("SimSun");
		
		// 不使用activiti自动的四个表（ACT_ID_*），用四个视图表代替
		configuration.setDbIdentityUsed(false);
		// TaskCreatedListener taskCreatedListener = new TaskCreatedListener();
		// System.out.println("======="+taskCreatedListener);
		// typedListeners.put("ENTITY_CREATED", Collections.singletonList(taskAssignedListener));
		typedListeners.put("TASK_CREATED", Collections.singletonList(taskCreatedListener));
		//typedListeners.put("TASK_COMPLETED", Collections.singletonList(taskCompletedListener));
        configuration.setTypedEventListeners(typedListeners);
        System.out.println("结束配置activiti的配置");
        return configuration;
	}
	
	@Bean
    public ProcessEngineFactoryBean processEngine() throws IOException {
        ProcessEngineFactoryBean factoryBean = new ProcessEngineFactoryBean();
        factoryBean.setProcessEngineConfiguration(processEngineConfiguration());
        return factoryBean;
    }
    @Bean
    public RuntimeService runtimeService(ProcessEngine processEngine) {
        return processEngine.getRuntimeService();
    }
    @Bean
    public RepositoryService repositoryService(ProcessEngine processEngine) {
        return processEngine.getRepositoryService();
    }
    @Bean
    public TaskService taskService(ProcessEngine processEngine) {
        return processEngine.getTaskService();
    }
    @Bean
    public HistoryService historyService(ProcessEngine processEngine) {
        return processEngine.getHistoryService();
    }
    @Bean
    public ManagementService managementService(ProcessEngine processEngine) {
        return processEngine.getManagementService();
    }
    @Bean
    public IdentityService identityService(ProcessEngine processEngine) {
        return processEngine.getIdentityService();
    }
	
	
}
