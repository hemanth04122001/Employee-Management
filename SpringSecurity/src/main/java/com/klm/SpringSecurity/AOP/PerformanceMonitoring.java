package com.klm.SpringSecurity.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoring {

    public static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitoring.class);

    @Around("execution(* com.klm.SpringSecurity.service.EmployeeService.*(..))")
    public Object MonitorTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {


        long startTime = System.currentTimeMillis();

        Object object =proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();

        LOGGER.info("Time taken for executing {}is {} ms" ,proceedingJoinPoint.getSignature().getName() , endTime-startTime);

        return object;

    }

}
