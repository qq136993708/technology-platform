package com.pcitc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * @author zhuyl
 * @version 2019-06-17
 */

@Component
public class MockCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        String isMock = environment.getProperty("isMock");
        if("true".equals(isMock)) {
            return true;
        } else {
            return false;
        }
    }
}
