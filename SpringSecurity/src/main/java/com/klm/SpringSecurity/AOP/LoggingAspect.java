package com.klm.SpringSecurity.AOP;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);


//    (return type  class name.method name(args) )

    @Before("execution(* com.klm.SpringSecurity.service.EmployeeService.getEmployee(..))")
    public void logMethodCalled(JoinPoint joinPoint) {

        LOGGER.info("Method Called {}", joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.klm.SpringSecurity.service.EmployeeService.getEmployee(..))")
    public void logMethod(JoinPoint joinPoint) {

        LOGGER.info("Method Returning {}", joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.klm.SpringSecurity.service.EmployeeService.getEmployee(..))")
    public void logMethodError(JoinPoint joinPoint) {

        LOGGER.info("Method Error {}", joinPoint.getSignature().getName());
    }

    @After("execution(* com.klm.SpringSecurity.service.EmployeeService.getEmployee(..))")
    public void logMethodExecuted(JoinPoint joinPoint) {

        LOGGER.info("Method Executed {}", joinPoint.getSignature().getName());
    }
}
