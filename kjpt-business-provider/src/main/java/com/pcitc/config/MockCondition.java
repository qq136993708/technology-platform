package com.pcitc.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

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
