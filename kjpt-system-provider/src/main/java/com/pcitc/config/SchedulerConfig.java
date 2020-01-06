package com.pcitc.config;

import org.quartz.spi.JobFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.pcitc.web.qrtz.AutowiringSpringBeanJobFactory;
@Configuration
public class SchedulerConfig {
	 @Bean
	    public JobFactory jobFactory(ApplicationContext applicationContext)
	    {
	        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
	        jobFactory.setApplicationContext(applicationContext);
	        return jobFactory;
	    }

	    @Bean
	    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory) throws Exception {
	        SchedulerFactoryBean factory = new SchedulerFactoryBean();
	        factory.setOverwriteExistingJobs(true);
	        factory.setJobFactory(jobFactory);
	        factory.afterPropertiesSet();
	        return factory;
	    }

}
