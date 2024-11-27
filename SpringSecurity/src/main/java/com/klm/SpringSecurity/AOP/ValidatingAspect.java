package com.klm.SpringSecurity.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidatingAspect {

    public static final Logger LOGGER= LoggerFactory.getLogger(ValidatingAspect.class);

    @Around("execution (* com.klm.SpringSecurity.service.EmployeeService.*(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint proceedingJoinPoint, int postId) throws Throwable {
        if (postId<0) {

            LOGGER.info("PostId is negative, updating it");
            postId=-postId;
            LOGGER.info("new Value {}", postId);
        }

        Object obj=proceedingJoinPoint.proceed(new Object[] {postId});

        return obj;
    }
}

