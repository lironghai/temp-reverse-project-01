package com.flow.aop;

import com.flow.core.annotation.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 日志切面，拦截带@Log注解的方法，记录方法调用日志。
 */
@Aspect
@Component
public class LogAspect {
    @Around("@annotation(log)")
    public Object logAround(ProceedingJoinPoint joinPoint, Log log) throws Throwable {
        // TODO: 记录方法调用前日志
        Object result = joinPoint.proceed();
        // TODO: 记录方法调用后日志
        return result;
    }
} 
