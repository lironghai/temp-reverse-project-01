package com.flow.aop;

import com.flow.dbsource.DynamicDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 数据源切面，拦截Service层方法，根据注解或参数切换数据源。
 */
@Aspect
@Component
public class DataSourceAspect {
    @Before("execution(* com.flow.service..*.*(..))")
    public void beforeService(JoinPoint joinPoint) {
        // TODO: 根据注解或参数切换数据源
        // 示例：DynamicDataSource.setDataSource("dataSourceKey");
    }
} 
